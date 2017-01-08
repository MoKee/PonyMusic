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

package me.wcy.music.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by wcy on 2016/4/3.
 */
public class UpdateInfo {
    @SerializedName("name")
    public String name;
    @SerializedName("version")
    public String version;
    @SerializedName("changelog")
    public String changelog;
    @SerializedName("updated_at")
    public int updated_at;
    @SerializedName("versionShort")
    public String versionShort;
    @SerializedName("build")
    public String build;
    @SerializedName("installUrl")
    public String installUrl;
    @SerializedName("install_url")
    public String install_url;
    @SerializedName("direct_install_url")
    public String direct_install_url;
    @SerializedName("update_url")
    public String update_url;
    @SerializedName("binary")
    public BinaryBean binary;

    public static class BinaryBean {
        @SerializedName("fsize")
        public int fsize;
    }
}
