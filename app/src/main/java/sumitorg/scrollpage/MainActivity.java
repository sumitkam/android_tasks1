package sumitorg.scrollpage;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {
   /* EditText t1;
    Button b1;
    String s1;
    TextToSpeech ts;*/
    TextToSpeech ts;
   EditText e1,e2;
    Button b1;
    String s1,s2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      /*  t1 = findViewById(R.id.text);
        b1 = findViewById(R.id.btn);
        ts= new TextToSpeech(MainActivity.this,this::onInit);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1 = t1.getText().toString();
                ts.speak(s1,TextToSpeech.QUEUE_ADD,null);
            }
        });
    }

    public void onInit(int i){
        ts.setLanguage(Locale.ENGLISH);
        ts.setSpeechRate(0.8f);

    }*/
        e1=findViewById(R.id.edit);
        e2=findViewById(R.id.edit2);
        b1=findViewById(R.id.login);
        ts= new TextToSpeech(getApplicationContext(), new TextToSpeech.OnInitListener() {
            @Override
            public void onInit(int i) {
                if(i != TextToSpeech.ERROR ){
                    ts.setLanguage(Locale.ENGLISH);
                }
            }
        });
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                s1=e1.getText().toString();
                s2=e2.getText().toString();
                if(s1.contentEquals("vishal") && s2.contentEquals("1234")){
                    Toast.makeText(MainActivity.this, "Login", Toast.LENGTH_SHORT).show();
                    ts.speak("login Successfully",TextToSpeech.QUEUE_FLUSH,null);
                }else{
                    Toast.makeText(MainActivity.this, "Not login", Toast.LENGTH_SHORT).show();
                    ts.speak("Username or password is wrong",TextToSpeech.QUEUE_FLUSH,null);
                }

            }
        });
    }
}