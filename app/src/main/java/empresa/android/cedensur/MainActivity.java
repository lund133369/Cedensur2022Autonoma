package empresa.android.cedensur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        t.start();
    }

    Thread t = new Thread() {
        public void run () {
            try {
                sleep(2000);
                Intent intent = new Intent(MainActivity.this, Principal.class);
                startActivity(intent);
                finish();

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    };
}