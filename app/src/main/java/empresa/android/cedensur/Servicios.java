package empresa.android.cedensur;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Servicios extends Fragment implements View.OnClickListener {

    CardView cardTerapiaInfantil, cardTerapiaConductual, cardTerapiaParejas, cardOrientacion;
    TextView txtInfantil, txtConductual, txtParejas, txtOrientacion;
    View vista;

    public Servicios() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_servicios, container, false);

        cardTerapiaInfantil = vista.findViewById(R.id.cardTerapiaInfantil);
        cardTerapiaConductual = vista.findViewById(R.id.cardTerapiaConductual);
        cardTerapiaParejas = vista.findViewById(R.id.cardTerapiaParejas);
        cardOrientacion = vista.findViewById(R.id.cardOrientacion);

        txtInfantil = vista.findViewById(R.id.txtInfantil);
        txtConductual = vista.findViewById(R.id.txtConductual);
        txtParejas = vista.findViewById(R.id.txtParejas);
        txtOrientacion = vista.findViewById(R.id.txtOrientacion);

        cardTerapiaInfantil.setOnClickListener(this);
        cardTerapiaConductual.setOnClickListener(this);
        cardTerapiaParejas.setOnClickListener(this);
        cardOrientacion.setOnClickListener(this);

        return vista;
    }

    public void terapiaInfantil() {
        int seleccion = 1;
        String titulo = txtInfantil.getText().toString();

        String contenido =  "Gracias a la terapia infantil los más pequeños desarrollan habilidades" +
                            " sociales y relacionales, mejoran la autoestima, aprenden a afrontar " +
                            "los problemas, liberan tensiones y, además, tienen la oportunidad " +
                            "de practicar herramientas para mejorar su bienestar " +
                            "emocional y su vida diaria.";

        Intent intent = new Intent(getActivity(), DetalleServicios.class);
        intent.putExtra("seleccion", seleccion);
        intent.putExtra("titulo", titulo);
        intent.putExtra("contenido", contenido);
        intent.putExtra("imagen", R.drawable.terapia_infantil);
        startActivity(intent);
    }

    public void terapiaConductual() {
        int seleccion = 2;
        String titulo = txtConductual.getText().toString();

        String contenido =  "Gracias a nuestra Terapia podrán aprender técnicas para lidiar" +
                            " con situaciones estresantes de la vida, identificar formas " +
                            "de controlar las emociones, solucionar conflictos en las relaciones " +
                            "y aprender mejores formas para comunicarse.";

        Intent intent = new Intent(getActivity(), DetalleServicios.class);
        intent.putExtra("seleccion", seleccion);
        intent.putExtra("titulo", titulo);
        intent.putExtra("contenido", contenido);
        intent.putExtra("imagen", R.drawable.terapia_conductual);
        startActivity(intent);
    }

    public void terapiaParejas() {
        int seleccion = 3;
        String titulo = txtParejas.getText().toString();

        String contenido =  "Gracias a la terapia de parejas se busca proporcionar a la parejas, " +
                            "claves para comunicar asertivamente sus opiniones y sentimientos, " +
                            "resolver y gestionar sus conflictos, entender su comportamiento " +
                            "en tiempos de crisis";

        Intent intent = new Intent(getActivity(), DetalleServicios.class);
        intent.putExtra("seleccion", seleccion);
        intent.putExtra("titulo", titulo);
        intent.putExtra("contenido", contenido);
        intent.putExtra("imagen", R.drawable.terapia_parejas);
        startActivity(intent);
    }

    public void orientacionVocacional() {
        int seleccion = 4;
        String titulo = txtOrientacion.getText().toString();

        String contenido =  "Con nuestra guía podrás definir qué es realmente lo que quieres " +
                            "estudiar gracias a tus capacidades y aptitudes definiremos el plan " +
                            "vocacional que debes seguir.";

        Intent intent = new Intent(getActivity(), DetalleServicios.class);
        intent.putExtra("seleccion", seleccion);
        intent.putExtra("titulo", titulo);
        intent.putExtra("contenido", contenido);
        intent.putExtra("imagen", R.drawable.orientacion);
        startActivity(intent);
    }


    @Override
    public void onClick(View v) {
        if (v == cardTerapiaInfantil) {
            terapiaInfantil();
        }

        if (v == cardTerapiaConductual) {
            terapiaConductual();
        }

        if (v == cardTerapiaParejas) {
            terapiaParejas();
        }

        if (v == cardOrientacion) {
            orientacionVocacional();
        }
    }
}
