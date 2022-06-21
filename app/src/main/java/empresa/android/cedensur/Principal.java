package empresa.android.cedensur;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import androidx.appcompat.app.AppCompatActivity;

import empresa.android.cedensur.Interfaz.ComunicaMenu;

public class Principal extends AppCompatActivity implements ComunicaMenu {
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_principal);
    }

    @Override
    public void menu(int queboton) {
        intent = new Intent(this, Opciones.class);
        intent.putExtra("BOTONSELECCIONADO", queboton);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu (Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.item_menu, menu);
        return true;
    }

    @SuppressLint("NonConstantResourceId")
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                intent = new Intent(this, Reserva.class);
                startActivity(intent);
                return true;

            case R.id.item2:
                intent = new Intent(this, Cita.class);
                startActivity(intent);
                return true;

            case R.id.item3:
                alertSalir();

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void alertSalir() {
        AlertDialog.Builder alerta = new AlertDialog.Builder(this);
        alerta.setMessage("¿Desea salir de la aplicación?")
                .setCancelable(false)
                .setPositiveButton("Sí", (dialog, i) -> finish())

                .setNegativeButton("No", (dialog, i) -> dialog.cancel());

        AlertDialog titulo = alerta.create();
        titulo.setTitle("Salir");
        titulo.show();
    }
}