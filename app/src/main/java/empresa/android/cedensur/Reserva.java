package empresa.android.cedensur;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Calendar;

public class Reserva extends AppCompatActivity implements View.OnClickListener {

    EditText txtNombre, txtNumero, txtFecha, txtHora;
    Spinner spnServicio;
    Button btnSeguir;
    ImageButton btnFecha, btnHora;
    Calendar calendar;
    int seleccion;
    String servicio;
    ArrayList<String> array;
    ArrayAdapter<String> adapter;
    DatePickerDialog dateDialog;
    TimePickerDialog timeDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reserva);

        txtNombre = findViewById(R.id.txtNombre);
        txtNumero = findViewById(R.id.txtNumero);
        spnServicio = findViewById(R.id.spnServicio);
        txtFecha = findViewById(R.id.txtFecha);
        txtHora = findViewById(R.id.txtHora);

        btnFecha = findViewById(R.id.btnFecha);
        btnHora = findViewById(R.id.btnHora);
        btnSeguir = findViewById(R.id.btnSeguir);

        array = new ArrayList<>();
        array.add("Servicio");
        array.add("Terapia para niños");
        array.add("Terapia Dialecto Conductual");
        array.add("Terapia de parejas");
        array.add("Orientacion Vocacional");

        adapter = new ArrayAdapter<>(this, R.layout.item_spinner, array);

        spnServicio.setAdapter(adapter);


        Bundle bundle = getIntent().getExtras();

        if (bundle == null) {
            Toast.makeText(this, "¡Ingrese sus datos!", Toast.LENGTH_SHORT).show();

        } else {
            txtNombre.setText(bundle.getString("nombre"));
            txtNumero.setText(bundle.getString("numero"));
            spnServicio.setSelection(bundle.getInt("seleccion"));
        }

        btnFecha.setOnClickListener(this);
        btnHora.setOnClickListener(this);
        btnSeguir.setOnClickListener(this);
    }

    public void Seleccionar() {
        if (spnServicio != null) {
            seleccion = spnServicio.getSelectedItemPosition();
        }

        switch (seleccion) {
            case 0: {
                servicio = null;
            }
            break;

            case 1: {
                servicio = "Terapia para niños";
            }
            break;

            case 2: {
                servicio = "Terapia Dialecto Conductual";
            }
            break;

            case 3: {
                servicio = "Terapia de parejas";
            }
            break;

            case 4:{
                servicio = "Orientacion Vocacional";
            }
            break;

            default:
                throw new IllegalStateException("Unexpected value: " + seleccion);
        }
    }

    public void Seguir() {
        String nombre = txtNombre.getText().toString();
        String numero = txtNumero.getText().toString();
        String fecha = txtFecha.getText().toString();
        String hora = txtHora.getText().toString();
        String fechaElegida = fecha + " " + hora;
        Seleccionar();

        if (nombre.isEmpty() && numero.isEmpty()) {
            Toast.makeText(this, "¡Ingrese sus datos por favor!", Toast.LENGTH_SHORT).show();

        } else if (nombre.isEmpty()) {
            Toast.makeText(this, "¡Ingrese su nombre por favor!", Toast.LENGTH_SHORT).show();

        } else if (numero.isEmpty()) {
            Toast.makeText(this, "¡Ingrese su número por favor!", Toast.LENGTH_SHORT).show();

        } else if (numero.length() < 9){
            Toast.makeText(this, "¡El número debe ser de 9 dígitos!", Toast.LENGTH_SHORT).show();

        } else if (servicio == null) {
            Toast.makeText(this, "¡Opción no Valida, por favor seleccione un servicio!", Toast.LENGTH_SHORT).show();

        } else if (fecha.isEmpty() || hora.isEmpty()){
            Toast.makeText(this, "!Por favor, seleccione fecha y hora¡", Toast.LENGTH_SHORT).show();

        } else {
            Intent intent = new Intent(this, DetalleReserva.class);
            intent.putExtra("nombre", nombre);
            intent.putExtra("numero", numero);
            intent.putExtra("servicio", servicio);
            intent.putExtra("fecha", fechaElegida);
            startActivity(intent);
        }
    }

    @SuppressLint("SetTextI18n")
    public void elegirFecha() {
        calendar = Calendar.getInstance();
        int anio = calendar.get(Calendar.YEAR);
        int mes = calendar.get(Calendar.MONTH);
        int dia = calendar.get(Calendar.DAY_OF_MONTH);

        dateDialog = new DatePickerDialog(this, (view, year, month, day) -> txtFecha.setText(day + "/"+ (month + 1) + "/" + year), anio, mes, dia);

        dateDialog.getDatePicker().setMinDate(calendar.getTimeInMillis());

        dateDialog.show();
    }

    @SuppressLint("SetTextI18n")
    public void elegirHora() {
        calendar = Calendar.getInstance();
        int hora = calendar.get(Calendar.HOUR_OF_DAY);
        int minutos = calendar.get(Calendar.MINUTE);

        timeDialog = new TimePickerDialog(this, (view, hour, minute) -> txtHora.setText(hour + ":" + minute), hora, minutos, false);

        timeDialog.show();
    }

    @Override
    public void onClick(View v) {
        if (v == btnFecha) {
            elegirFecha();
        }

        if (v == btnHora) {
            elegirHora();
        }

        if (v == btnSeguir) {
            Seguir();
        }
    }
}