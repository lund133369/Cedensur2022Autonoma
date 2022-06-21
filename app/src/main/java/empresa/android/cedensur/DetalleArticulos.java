package empresa.android.cedensur;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

public class DetalleArticulos extends AppCompatActivity {
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_articulos);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        imagen = findViewById(R.id.imgArticulo);

        Bundle bundle = getIntent().getExtras();

        imagen.setImageResource(bundle.getInt("imagen"));
    }
}