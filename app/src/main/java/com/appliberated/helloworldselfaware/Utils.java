/*
 * Copyright (C) 2017-2025 Appliberated
 * https://www.appliberated.com
 *
 * Licensed under the MIT License.
 * See LICENSE file in the project root for full license information.
 */

package com.appliberated.helloworldselfaware;

import android.content.Context;
import android.os.Build;

/**
 * Assorted utility methods.
 */
class Utils {

    /**
     * Copies a text to the clipboard.
     */
    @SuppressWarnings("deprecation")
    static void copyText(Context context, CharSequence label, CharSequence text) {
        if (Build.VERSION.SDK_INT < Build.VERSION_CODES.HONEYCOMB) {
            final android.text.ClipboardManager clipboard = (android.text.ClipboardManager)
                    context.getSystemService(Context.CLIPBOARD_SERVICE);
            clipboard.setText(text);
        } else {
            final android.content.ClipboardManager clipboard = (android.content.ClipboardManager)
                    context.getSystemService(Context.CLIPBOARD_SERVICE);
            final android.content.ClipData clip = android.content.ClipData.newPlainText(label, text);
            clipboard.setPrimaryClip(clip);
        }
    }
}
