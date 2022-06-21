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

        String contenido =  "Gracias a la terapia infantil los \n" +
                            "más pequeños desarrollan habilidades\n" +
                            " sociales y relacionales, mejoran \n" +
                            "la autoestima, aprenden a afrontar \n" +
                            "los problemas, liberan tensiones y,\n" +
                            " además, tienen la oportunidad \n" +
                            "de practicar herramientas para \n" +
                            "mejorar su bienestar \n" +
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

        String contenido =  "Gracias a la terapia infantil los \n" +
                            "más pequeños desarrollan habilidades\n" +
                            " sociales y relacionales, mejoran \n" +
                            "la autoestima, aprenden a afrontar \n" +
                            "los problemas, liberan tensiones y,\n" +
                            " además, tienen la oportunidad \n" +
                            "de practicar herramientas para \n" +
                            "mejorar su bienestar \n" +
                            "emocional y su vida diaria.";

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

        String contenido =  "Gracias a la terapia infantil los \n" +
                            "más pequeños desarrollan habilidades\n" +
                            " sociales y relacionales, mejoran \n" +
                            "la autoestima, aprenden a afrontar \n" +
                            "los problemas, liberan tensiones y,\n" +
                            " además, tienen la oportunidad \n" +
                            "de practicar herramientas para \n" +
                            "mejorar su bienestar \n" +
                            "emocional y su vida diaria.";

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

        String contenido =  "Gracias a la terapia infantil los \n" +
                            "más pequeños desarrollan habilidades\n" +
                            " sociales y relacionales, mejoran \n" +
                            "la autoestima, aprenden a afrontar \n" +
                            "los problemas, liberan tensiones y,\n" +
                            " además, tienen la oportunidad \n" +
                            "de practicar herramientas para \n" +
                            "mejorar su bienestar \n" +
                            "emocional y su vida diaria.";

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
