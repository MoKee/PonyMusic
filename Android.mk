#
# Copyright (C) 2016-2017 wangchenyan
# Copyright (C) 2016-2017 The MoKee Open Source Project
#
# Licensed under the Apache License, Version 2.0 (the "License");
# you may not use this file except in compliance with the License.
# You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.
#

LOCAL_PATH := $(call my-dir)
include $(CLEAR_VARS)

LOCAL_PACKAGE_NAME := Polyhymnia
LOCAL_CERTIFICATE := platform
LOCAL_PROGUARD_ENABLED := disabled
LOCAL_MODULE_TAGS := optional

LOCAL_MANIFEST_FILE := app/src/main/AndroidManifest.xml
LOCAL_SRC_FILES := $(call all-java-files-under, app/src/main)

LOCAL_RESOURCE_DIR := \
    $(LOCAL_PATH)/app/src/main/res \
    $(LOCAL_PATH)/lrcview/res \
    frameworks/support/design/res \
    frameworks/support/v7/appcompat/res \
    frameworks/support/v7/recyclerview/res

LOCAL_AAPT_FLAGS := \
    --auto-add-overlay \
    --extra-packages android.support.v7.appcompat \
    --extra-packages android.support.v7.recyclerview \
    --extra-packages android.support.design \
    --extra-packages me.wcy.lrcview

LOCAL_AAPT_FLAGS += --rename-manifest-package com.mokee.polyhymnia
LOCAL_AAPT_INCLUDE_ALL_RESOURCES := true

LOCAL_STATIC_JAVA_LIBRARIES := \
    amap-location \
    android-support-annotations \
    android-support-v4 \
    android-support-v7-appcompat \
    android-support-v7-recyclerview \
    android-support-design \
    com-zhy-okhttp \
    gson \
    im-fir-sdk \
    me-wcy-lrcview-sdk \
    com.squareup.okhttp3 \
    com.squareup.okio \
    universal-image-loader \

include $(BUILD_PACKAGE)

include $(CLEAR_VARS)

LOCAL_PREBUILT_STATIC_JAVA_LIBRARIES := \
    amap-location:libs/amap-location/AMap_Location_1.3.3$(COMMON_JAVA_PACKAGE_SUFFIX) \
    com-zhy-okhttp:libs/com-zhy-okhttp/com-zhy-okhttp$(COMMON_JAVA_PACKAGE_SUFFIX) \
    com.squareup.okhttp3:libs/com.squareup.okhttp3/okhttp-3.4.1$(COMMON_JAVA_PACKAGE_SUFFIX) \
    com.squareup.okio:libs/com.squareup.okio/okio-1.9.0$(COMMON_JAVA_PACKAGE_SUFFIX) \
    im-fir-sdk:libs/im-fir-sdk/im-fir-sdk$(COMMON_JAVA_PACKAGE_SUFFIX) \
    universal-image-loader:libs/universal-image-loader/universal-image-loader-1.9.5$(COMMON_JAVA_PACKAGE_SUFFIX)

include $(BUILD_MULTI_PREBUILT)
include $(call all-makefiles-under,$(LOCAL_PATH))
