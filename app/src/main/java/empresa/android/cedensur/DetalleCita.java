package empresa.android.cedensur;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import empresa.android.cedensur.DAO.ReservaDAO;

public class DetalleCita extends AppCompatActivity implements View.OnClickListener {
    TextView txtDetalleCita;
    Button btnEliminar;
    String nombre, numero, servicio, fecha;
    int codigo;
    ReservaDAO objReservaDAO;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_cita);

        ActionBar actionBar = getSupportActionBar();
        assert actionBar != null;
        actionBar.setDisplayHomeAsUpEnabled(true);

        txtDetalleCita = findViewById(R.id.txtDetalleCita);
        btnEliminar = findViewById(R.id.btnEliminar);

        Bundle bundle = getIntent().getExtras();

        codigo = bundle.getInt("codigo");
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

        txtDetalleCita.setText(detalle);

        btnEliminar.setOnClickListener(this);

        objReservaDAO = new ReservaDAO(this);
        objReservaDAO.open();
    }

    public void Eliminar() {

        long estado = objReservaDAO.EliminarRegistro(codigo);

        if (estado == 0) {
            Toast.makeText(this, "¡La reserva no pudo ser eliminada!", Toast.LENGTH_SHORT).show();

        } else {
            Toast.makeText(this, "¡La reserva ha sido eliminada!", Toast.LENGTH_SHORT).show();

            Intent intent = new Intent(this, Cita.class);
            startActivity(intent);
        }
    }

    public void alertConfirmar() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("¿Desea eliminar esta cita?")
                .setCancelable(false)
                .setPositiveButton("Sí", (dialog, i) -> Eliminar())

                .setNegativeButton("No", (dialog, i) -> dialog.cancel());

        AlertDialog titulo = alerta.create();
        titulo.show();
    }

    @Override
    public void onClick(View v) {
        if (v == btnEliminar) {
            alertConfirmar();
        }
    }
}