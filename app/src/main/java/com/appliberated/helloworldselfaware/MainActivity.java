/*
 * Copyright (C) 2017-2025 Appliberated
 * https://www.appliberated.com
 *
 * Licensed under the MIT License.
 * See LICENSE file in the project root for full license information.
 */

package com.appliberated.helloworldselfaware;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

/**
 * The main activity class.
 */
public class MainActivity extends Activity implements View.OnLongClickListener {

    /**
     * The Hello message Text View
     */
    private TextView mHelloTextView;

    /**
     * Performs required initialization when the activity is starting.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mHelloTextView = findViewById(R.id.hello_world_text_View);
        mHelloTextView.setText(getString(R.string.hello_message,
                AndroidInfo.getId(this), AndroidInfo.getVersion(), AndroidInfo.getLevel()));
        mHelloTextView.setOnLongClickListener(this);
    }

    /**
     * Copies the hello world message to the clipboard when the user long clicks the message.
     */
    @Override
    public boolean onLongClick(View view) {
        Utils.copyText(this, getString(R.string.copy_label), mHelloTextView.getText());
        Toast.makeText(getApplicationContext(), R.string.toast_copied, Toast.LENGTH_LONG).show();
        return true;
    }
}
