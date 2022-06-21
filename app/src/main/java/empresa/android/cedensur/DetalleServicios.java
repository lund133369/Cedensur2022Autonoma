package empresa.android.cedensur;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class DetalleServicios extends AppCompatActivity implements View.OnClickListener {

    int seleccion;
    TextView tituloServicio, contenidoServicio;
    ImageView imagenServicio;
    Button btnReservar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_detalle_servicios);

        tituloServicio = findViewById(R.id.tituloServicio);
        contenidoServicio = findViewById(R.id.contenidoServicio);
        imagenServicio = findViewById(R.id.imagenServicio);
        btnReservar = findViewById(R.id.btnReservar);

        Bundle bundle = getIntent().getExtras();

        seleccion = bundle.getInt("seleccion");
        imagenServicio.setImageResource(bundle.getInt("imagen"));
        tituloServicio.setText(bundle.getString("titulo"));
        contenidoServicio.setText(bundle.getString("contenido"));

        btnReservar.setOnClickListener(this);
    }

    public void reservarCita() {
        Intent intent = new Intent(this, Reserva.class);
        intent.putExtra("seleccion", seleccion);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v == btnReservar) {
            reservarCita();
        }
    }
}