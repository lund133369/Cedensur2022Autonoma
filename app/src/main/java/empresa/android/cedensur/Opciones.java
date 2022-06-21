package empresa.android.cedensur;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import empresa.android.cedensur.Interfaz.ComunicaMenu;

public class Opciones extends AppCompatActivity implements ComunicaMenu {
    Fragment [] fragmentos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_opciones);

        fragmentos = new Fragment[3];
        fragmentos[0] = new Informacion();
        fragmentos[1] = new Servicios();
        fragmentos[2] = new Articulos();

        Bundle extras = getIntent().getExtras();
        menu(extras.getInt("BOTONSELECCIONADO"));
    }

    @Override
    public void menu(int queboton) {
        FragmentManager manejador = getSupportFragmentManager();
        FragmentTransaction transaccion = manejador.beginTransaction();

        Fragment menuContenido = new Menu();

        Bundle datos = new Bundle();
        datos.putInt("BOTONSELECCIONADO", queboton);

        menuContenido.setArguments(datos);

        transaccion.replace(R.id.menu, menuContenido);
        transaccion.replace(R.id.opciones, fragmentos[queboton]);

        transaccion.commit();
    }
}
