package empresa.android.cedensur;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

import empresa.android.cedensur.Adaptador.Adaptador;
import empresa.android.cedensur.BEAN.ReservaBean;
import empresa.android.cedensur.DAO.ReservaDAO;

public class Cita extends AppCompatActivity implements AdapterView.OnItemClickListener {
    ListView lvLista;
    ArrayList<String> listado;
    ArrayList<ReservaBean> lista;
    ReservaDAO objReservaDAO;
    String nombre, numero, servicio, fecha;
    int codigo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cita);

        lvLista = findViewById(R.id.lvLista);

        objReservaDAO = new ReservaDAO(this);
        objReservaDAO.open();

        Mostrar();

        Adaptador adaptador = new Adaptador(this, listado);
        lvLista.setAdapter(adaptador);

        lvLista.setOnItemClickListener(this);
    }

    public void Mostrar() {
        listado = new ArrayList<>();
        lista = objReservaDAO.Listar();

        if (lista.isEmpty()) {
            Toast.makeText(this, "!No tiene citas reservadas¡", Toast.LENGTH_SHORT).show();

        } else {
            for (ReservaBean obj:lista) {
                listado.add(" " + obj.getFecha() + ", " + obj.getServicio());
            }
        }
    }

    @Override
    public void onItemClick(AdapterView<?> adapterView, View v, int i, long l) {
        Mostrar();

        codigo = lista.get(i).getCodigo();
        nombre = lista.get(i).getNombre();
        numero = lista.get(i).getNumero();
        servicio = lista.get(i).getServicio();
        fecha = lista.get(i).getFecha();

        Intent intent = new Intent(this, DetalleCita.class);
        intent.putExtra("codigo", codigo);
        intent.putExtra("nombre", nombre);
        intent.putExtra("numero", numero);
        intent.putExtra("servicio", servicio);
        intent.putExtra("fecha", fecha);
        startActivity(intent);
    }
}