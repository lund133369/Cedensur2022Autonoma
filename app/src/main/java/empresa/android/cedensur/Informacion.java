package empresa.android.cedensur;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Informacion extends Fragment implements View.OnClickListener {

    CardView cardVision, cardMision, cardObjetivo, cardLogro;
    TextView txtTitulo1, txtContenido1;
    TextView txtTitulo2, txtContenido2;
    TextView txtTitulo3, txtContenido3;
    TextView txtTitulo4, txtContenido4;
    View vista;

    public Informacion () {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_informacion, container, false);

        cardVision = vista.findViewById(R.id.cardVision);
        cardMision = vista.findViewById(R.id.cardMision);
        cardObjetivo = vista.findViewById(R.id.cardObjetivo);
        cardLogro = vista.findViewById(R.id.cardLogro);

        txtTitulo1 = vista.findViewById(R.id.txtTitulo1);
        txtTitulo2 = vista.findViewById(R.id.txtTitulo2);
        txtTitulo3 = vista.findViewById(R.id.txtTitulo3);
        txtTitulo4 = vista.findViewById(R.id.txtTitulo4);

        txtContenido1 = vista.findViewById(R.id.txtContenido1);
        txtContenido2 = vista.findViewById(R.id.txtContenido2);
        txtContenido3 = vista.findViewById(R.id.txtContenido3);
        txtContenido4 = vista.findViewById(R.id.txtContenido4);

        cardVision.setOnClickListener(this);
        cardMision.setOnClickListener(this);
        cardObjetivo.setOnClickListener(this);
        cardLogro.setOnClickListener(this);

        return vista;
    }

    public void mostrarVision() {
        String titulo = txtTitulo1.getText().toString();
        String contenido = txtContenido1.getText().toString();

        Intent intent = new Intent(getActivity(), DetalleInformacion.class);
        intent.putExtra("titulo", titulo);
        intent.putExtra("contenido", contenido);
        intent.putExtra("imagen", R.drawable.vision);
        startActivity(intent);
    }

    public void mostrarMision() {
        String titulo = txtTitulo2.getText().toString();
        String contenido = txtContenido2.getText().toString();

        Intent intent = new Intent(getActivity(), DetalleInformacion.class);
        intent.putExtra("titulo", titulo);
        intent.putExtra("contenido", contenido);
        intent.putExtra("imagen", R.drawable.mision);
        startActivity(intent);
    }

    public void mostrarObjetivo() {
        String titulo = txtTitulo3.getText().toString();
        String contenido = txtContenido3.getText().toString();

        Intent intent = new Intent(getActivity(), DetalleInformacion.class);
        intent.putExtra("titulo", titulo);
        intent.putExtra("contenido", contenido);
        intent.putExtra("imagen", R.drawable.infraestructura);
        startActivity(intent);
    }

    public void mostrarLogro() {
        String titulo = txtTitulo4.getText().toString();
        String contenido = txtContenido4.getText().toString();

        Intent intent = new Intent(getActivity(), DetalleInformacion.class);
        intent.putExtra("titulo", titulo);
        intent.putExtra("contenido", contenido);
        intent.putExtra("imagen", R.drawable.logro);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v == cardVision) {
            mostrarVision();
        }

        if (v == cardMision) {
            mostrarMision();
        }

        if (v == cardObjetivo) {
            mostrarObjetivo();
        }

        if (v == cardLogro) {
            mostrarLogro();
        }
    }
}
