package empresa.android.cedensur;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.Window;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleInformacion extends AppCompatActivity {
    TextView titulo, contenido;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detalle_informacion);


        titulo = findViewById(R.id.titulo);
        contenido = findViewById(R.id.contenido);
        imagen = findViewById(R.id.imagen);

        Bundle bundle = getIntent().getExtras();

        imagen.setImageResource(bundle.getInt("imagen"));
        titulo.setText(bundle.getString("titulo"));
        contenido.setText(bundle.getString("contenido"));
    }
}