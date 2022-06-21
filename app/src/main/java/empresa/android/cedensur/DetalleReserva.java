package empresa.android.cedensur;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import empresa.android.cedensur.BEAN.ReservaBean;
import empresa.android.cedensur.DAO.ReservaDAO;

public class DetalleReserva extends AppCompatActivity implements View.OnClickListener {
    TextView txtDetalle;
    Button btnConfirmar, btnEditar, btnSalir;
    String nombre, numero, servicio, fecha;
    ReservaBean objReservaBean;
    ReservaDAO objReservaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_reserva);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        txtDetalle = findViewById(R.id.txtDetalle);
        btnConfirmar = findViewById(R.id.btnConfirmar);
        btnEditar = findViewById(R.id.btnEditar);
        btnSalir = findViewById(R.id.btnSalir);

        Bundle bundle = getIntent().getExtras();

        nombre = bundle.getString("nombre");
        numero = bundle.getString("numero");
        servicio = bundle.getString("servicio");
        fecha = bundle.getString("fecha");

        String detalle =    "  Nombre: " + nombre + "\n" +
                            " \n" +
                            "  Número: " + numero + "\n" +
                            " \n" +
                            "  Servicio: " + servicio + "\n" +
                            " \n" +
                            "  Fecha: " + fecha;

        txtDetalle.setText(detalle);

        btnConfirmar.setOnClickListener(this);
        btnEditar.setOnClickListener(this);
        btnSalir.setOnClickListener(this);

        objReservaDAO = new ReservaDAO(this);
        objReservaDAO.open();
    }

    public void Confirmar() {
        objReservaBean = new ReservaBean();
        objReservaBean.setNombre(nombre);
        objReservaBean.setNumero(numero);
        objReservaBean.setServicio(servicio);
        objReservaBean.setFecha(fecha);

        long estado = objReservaDAO.Insertar(objReservaBean);

        if (estado == 0) {
            Toast.makeText(getApplicationContext(), "Reserva no registrada", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(getApplicationContext(), "Reserva registrada!", Toast.LENGTH_SHORT).show();
            misCitas();
        }
    }

    public void Editar() {
        Intent intent = new Intent(this, Reserva.class);
        intent.putExtra("nombre",  nombre);
        intent.putExtra("numero",  numero);
        intent.putExtra("servicio",  servicio);
        startActivity(intent);
    }

    public void Salir() {
        Intent intent = new Intent(this, Principal.class);
        startActivity(intent);
    }

    public void misCitas() {
        Intent intent = new Intent(this, Cita.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v == btnEditar) {
            Editar();
        }

        if (v == btnSalir) {
            Salir();
        }

        if (v == btnConfirmar) {
            Confirmar();
        }
    }
}