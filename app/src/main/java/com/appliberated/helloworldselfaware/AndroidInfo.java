/*
 * Copyright (C) 2017 Appliberated
 * http://www.appliberated.com
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

package com.appliberated.helloworldselfaware;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Build;
import android.provider.Settings;

/**
 * Information about the Android device and version.
 */
class AndroidInfo {

    /**
     * Return an AndroidInfo device hardware ID.
     */
    @SuppressLint("HardwareIds")
    static String getId(Context context) {
        // For AndroidInfo O and above, use ANDROID_ID, because Build.SERIAL has been deprecated, and the replacement
        // getSerial() method requires the READ_PHONE_STATE permission.
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            return Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        } else {
            //noinspection deprecation
            return Build.SERIAL;
        }
    }

    /**
     * Return the AndroidInfo user-visible version string.
     */
    @SuppressWarnings("SameReturnValue")
    static String getVersion() {
        return Build.VERSION.RELEASE;
    }

    /**
     * Return the AndroidInfo API Level.
     */
    @SuppressWarnings("SameReturnValue")
    static int getLevel() {
        return Build.VERSION.SDK_INT;
    }
}
