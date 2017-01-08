/*
 * Copyright (C) 2016-2017 wangchenyan
 * Copyright (C) 2016-2017 The MoKee Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package me.wcy.music.executor;

import android.support.annotation.Nullable;
import android.text.TextUtils;

import com.zhy.http.okhttp.OkHttpUtils;

import me.wcy.music.callback.JsonCallback;
import me.wcy.music.constants.Constants;
import me.wcy.music.model.JLrc;
import me.wcy.music.model.JSearchMusic;
import me.wcy.music.utils.FileUtils;
import okhttp3.Call;

/**
 * 如果本地歌曲没有歌词则从网络搜索歌词
 * Created by wcy on 2016/4/26.
 */
public abstract class SearchLrc {
    private String artist;
    private String title;

    public SearchLrc(String artist, String title) {
        this.artist = artist;
        this.title = title;
    }

    public void execute() {
        onPrepare();
        searchLrc();
    }

    private void searchLrc() {
        OkHttpUtils.get().url(Constants.BASE_URL)
                .addParams(Constants.PARAM_METHOD, Constants.METHOD_SEARCH_MUSIC)
                .addParams(Constants.PARAM_QUERY, title + "-" + artist)
                .build()
                .execute(new JsonCallback<JSearchMusic>(JSearchMusic.class) {
                    @Override
                    public void onResponse(JSearchMusic response) {
                        if (response == null || response.getSong() == null || response.getSong().size() == 0) {
                            onFinish(null);
                            return;
                        }
                        downloadLrc(response.getSong().get(0).getSongid());
                    }

                    @Override
                    public void onError(Call call, Exception e) {
                        onFinish(null);
                    }
                });
    }

    private void downloadLrc(String songId) {
        OkHttpUtils.get().url(Constants.BASE_URL)
                .addParams(Constants.PARAM_METHOD, Constants.METHOD_LRC)
                .addParams(Constants.PARAM_SONG_ID, songId)
                .build()
                .execute(new JsonCallback<JLrc>(JLrc.class) {
                    @Override
                    public void onResponse(JLrc response) {
                        if (response == null || TextUtils.isEmpty(response.getLrcContent())) {
                            onFinish(null);
                            return;
                        }
                        String lrcPath = FileUtils.getLrcDir() + FileUtils.getLrcFileName(artist, title);
                        FileUtils.saveLrcFile(lrcPath, response.getLrcContent());
                        onFinish(lrcPath);
                    }

                    @Override
                    public void onError(Call call, Exception e) {
                        onFinish(null);
                    }
                });
    }

    public abstract void onPrepare();

    public abstract void onFinish(@Nullable String lrcPath);
}
