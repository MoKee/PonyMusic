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

package me.wcy.music.receiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.KeyEvent;

import me.wcy.music.service.PlayService;
import me.wcy.music.constants.Actions;

/**
 * 耳机线控
 * Created by hzwangchenyan on 2016/1/21.
 */
public class RemoteControlReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        KeyEvent event = intent.getParcelableExtra(Intent.EXTRA_KEY_EVENT);
        if (event == null || event.getAction() != KeyEvent.ACTION_UP) {
            return;
        }
        Intent serviceIntent;
        switch (event.getKeyCode()) {
            case KeyEvent.KEYCODE_MEDIA_PLAY:
            case KeyEvent.KEYCODE_MEDIA_PAUSE:
            case KeyEvent.KEYCODE_MEDIA_PLAY_PAUSE:
            case KeyEvent.KEYCODE_HEADSETHOOK:
                serviceIntent = new Intent(context, PlayService.class);
                serviceIntent.setAction(Actions.ACTION_MEDIA_PLAY_PAUSE);
                context.startService(serviceIntent);
                break;
            case KeyEvent.KEYCODE_MEDIA_NEXT:
                serviceIntent = new Intent(context, PlayService.class);
                serviceIntent.setAction(Actions.ACTION_MEDIA_NEXT);
                context.startService(serviceIntent);
                break;
            case KeyEvent.KEYCODE_MEDIA_PREVIOUS:
                serviceIntent = new Intent(context, PlayService.class);
                serviceIntent.setAction(Actions.ACTION_MEDIA_PREVIOUS);
                context.startService(serviceIntent);
                break;
        }
    }
}
