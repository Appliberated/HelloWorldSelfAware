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
