package io.github.juntrinh.talker;

import android.speech.tts.TextToSpeech;
import android.speech.tts.TextToSpeech.OnInitListener;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements OnInitListener{

    EditText editText;
    Button buttonSpeak;
    TextToSpeech textToSpeech;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editText = (EditText)findViewById(R.id.enter_text);
        buttonSpeak = (Button)findViewById(R.id.button_speak);
        textToSpeech = new TextToSpeech(this, this);

        buttonSpeak.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String message = editText.getText().toString();
                textToSpeech.speak(message, TextToSpeech.QUEUE_FLUSH, null);
            }
        });
    }

    @Override
    public void onInit(int status) {
        if(status == TextToSpeech.SUCCESS) {
            buttonSpeak.setEnabled(true);
        }
        else {
            buttonSpeak.setEnabled(false);
            Toast.makeText(this, "Cannot talk", Toast.LENGTH_SHORT);
        }
    }
}
