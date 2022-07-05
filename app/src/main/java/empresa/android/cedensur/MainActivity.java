package empresa.android.cedensur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
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