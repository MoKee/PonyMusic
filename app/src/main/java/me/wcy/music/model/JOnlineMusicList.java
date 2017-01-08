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

import java.util.List;

/**
 * JavaBean
 * Created by wcy on 2015/12/20.
 */
public class JOnlineMusicList {
    @SerializedName("song_list")
    private List<JOnlineMusic> song_list;
    @SerializedName("billboard")
    private JBillboard billboard;

    public List<JOnlineMusic> getSong_list() {
        return song_list;
    }

    public void setSong_list(List<JOnlineMusic> song_list) {
        this.song_list = song_list;
    }

    public JBillboard getBillboard() {
        return billboard;
    }

    public void setBillboard(JBillboard billboard) {
        this.billboard = billboard;
    }

    public static class JBillboard {
        @SerializedName("update_date")
        private String update_date;
        @SerializedName("name")
        private String name;
        @SerializedName("comment")
        private String comment;
        @SerializedName("pic_s640")
        private String pic_s640;
        @SerializedName("pic_s444")
        private String pic_s444;
        @SerializedName("pic_s260")
        private String pic_s260;
        @SerializedName("pic_s210")
        private String pic_s210;

        public String getUpdate_date() {
            return update_date;
        }

        public void setUpdate_date(String update_date) {
            this.update_date = update_date;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getPic_s640() {
            return pic_s640;
        }

        public void setPic_s640(String pic_s640) {
            this.pic_s640 = pic_s640;
        }

        public String getPic_s444() {
            return pic_s444;
        }

        public void setPic_s444(String pic_s444) {
            this.pic_s444 = pic_s444;
        }

        public String getPic_s260() {
            return pic_s260;
        }

        public void setPic_s260(String pic_s260) {
            this.pic_s260 = pic_s260;
        }

        public String getPic_s210() {
            return pic_s210;
        }

        public void setPic_s210(String pic_s210) {
            this.pic_s210 = pic_s210;
        }
    }
}
