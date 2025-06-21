/*
 * Copyright (C) 2017-2025 Appliberated
 * https://www.appliberated.com
 *
 * Licensed under the MIT License.
 * See LICENSE file in the project root for full license information.
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
