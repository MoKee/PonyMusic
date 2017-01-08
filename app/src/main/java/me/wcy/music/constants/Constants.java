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

package me.wcy.music.constants;

/**
 * 常量
 * Created by wcy on 2015/11/28.
 */
public interface Constants {
    String FILENAME_MP3 = ".mp3";
    String FILENAME_LRC = ".lrc";
    int MUSIC_LIST_SIZE = 20;
    String BASE_URL = "http://tingapi.ting.baidu.com/v1/restserver/ting";
    String METHOD_GET_MUSIC_LIST = "baidu.ting.billboard.billList";
    String METHOD_DOWNLOAD_MUSIC = "baidu.ting.song.play";
    String METHOD_ARTIST_INFO = "baidu.ting.artist.getInfo";
    String METHOD_SEARCH_MUSIC = "baidu.ting.search.catalogSug";
    String METHOD_LRC = "baidu.ting.song.lry";
    String PARAM_METHOD = "method";
    String PARAM_TYPE = "type";
    String PARAM_SIZE = "size";
    String PARAM_OFFSET = "offset";
    String PARAM_SONG_ID = "songid";
    String PARAM_TING_UID = "tinguid";
    String PARAM_QUERY = "query";
    String SPLASH_URL = "http://news-at.zhihu.com/api/4/start-image/720*1184";
}
