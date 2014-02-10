/*
 * Copyright (C) 2013 The Android Open Source Project
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

package caelrin.GlassGesturesInMotion;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.speech.RecognizerIntent;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

/**
 * Activity showing the options menu.
 */
public class VoiceActivity extends Activity {

    private static final int SPEECH_REQUEST = 0;
    private static final long CONNECT_TIMEOUT = 3000;
    public TextView droneView;

    private void displaySpeechRecognizer() {
        Intent intent = new Intent(RecognizerIntent.ACTION_RECOGNIZE_SPEECH);
        intent.putExtra(RecognizerIntent.EXTRA_PROMPT, "Exit, Take Off, Land, Do A Barrel Roll");
        startActivityForResult(intent, SPEECH_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode,
                                    Intent data) {
        if (requestCode == SPEECH_REQUEST && resultCode == RESULT_OK) {
            List<String> results = data.getStringArrayListExtra(
                    RecognizerIntent.EXTRA_RESULTS);
            String spokenText = results.get(0);
            // Do something with spokenText.
            if("exit".equalsIgnoreCase(spokenText)){

            } else {

            }
        }
        super.onActivityResult(requestCode, resultCode, data);

        finish();
    }
    public void setDisplayText(String s) {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        displaySpeechRecognizer();
        Log.e("Menu", "111111111111111 Started VOICE!");
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }
}
