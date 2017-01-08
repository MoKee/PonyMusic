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

package me.wcy.music.utils;

import android.app.Activity;
import android.app.DownloadManager;
import android.content.Context;
import android.content.DialogInterface;
import android.net.Uri;
import android.support.v7.app.AlertDialog;
import android.webkit.MimeTypeMap;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;

import im.fir.sdk.FIR;
import im.fir.sdk.VersionCheckCallback;
import me.wcy.music.R;
import me.wcy.music.activity.AboutActivity;
import me.wcy.music.api.Key;
import me.wcy.music.model.UpdateInfo;

/**
 * Created by wcy on 2016/4/3.
 */
public class UpdateUtils {
    public static long sDownloadId = 0;

    public static void checkUpdate(final Activity activity) {
        FIR.checkForUpdateInFIR(Key.get(activity, Key.FIR_KEY), new VersionCheckCallback() {
            @Override
            public void onStart() {
                if (activity instanceof AboutActivity) {
                    ToastUtils.show("正在检查更新");
                }
            }

            @Override
            public void onSuccess(String versionJson) {
                if (activity.isFinishing()) {
                    return;
                }
                Gson gson = new Gson();
                UpdateInfo updateInfo;
                try {
                    updateInfo = gson.fromJson(versionJson, UpdateInfo.class);
                } catch (JsonSyntaxException e) {
                    return;
                }
                int version = Integer.valueOf(updateInfo.version);
                if (version > Integer.valueOf(activity.getString(R.string.version_name))) {
                    updateDialog(activity, updateInfo);
                } else {
                    if (activity instanceof AboutActivity) {
                        ToastUtils.show("已是最新版本");
                    }
                }
            }

            @Override
            public void onFail(Exception exception) {
            }

            @Override
            public void onFinish() {
            }
        });
    }

    private static void updateDialog(final Activity activity, final UpdateInfo updateInfo) {
        String message = String.format("v %1$s(%2$sMB)\n\n%3$s", updateInfo.versionShort,
                FileUtils.b2mb(updateInfo.binary.fsize), updateInfo.changelog);
        new AlertDialog.Builder(activity)
                .setTitle("发现新版本")
                .setMessage(message)
                .setPositiveButton("立即更新", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        download(activity, updateInfo);
                    }
                })
                .setNegativeButton("稍后提醒", null)
                .show();
    }

    private static void download(Activity activity, UpdateInfo updateInfo) {
        DownloadManager downloadManager = (DownloadManager) activity.getSystemService(Context.DOWNLOAD_SERVICE);
        Uri uri = Uri.parse(updateInfo.installUrl);
        DownloadManager.Request request = new DownloadManager.Request(uri);
        String fileName = String.format("PonyMusic_%s.apk", updateInfo.versionShort);
        request.setDestinationInExternalPublicDir("Download", fileName);
        request.setMimeType(MimeTypeMap.getFileExtensionFromUrl(updateInfo.installUrl));
        request.allowScanningByMediaScanner();
        request.setAllowedNetworkTypes(DownloadManager.Request.NETWORK_MOBILE | DownloadManager.Request.NETWORK_WIFI);
        request.setAllowedOverRoaming(false);// 不允许漫游
        sDownloadId = downloadManager.enqueue(request);
        ToastUtils.show("正在后台下载");
    }
}
