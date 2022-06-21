package empresa.android.cedensur;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.cardview.widget.CardView;
import androidx.fragment.app.Fragment;

public class Articulos extends Fragment implements View.OnClickListener {

    CardView cardArticulo1, cardArticulo2, cardArticulo3, cardArticulo4;
    View vista;

    public Articulos() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_articulos, container, false);

        cardArticulo1 = vista.findViewById(R.id.cardArticulo1);
        cardArticulo2 = vista.findViewById(R.id.cardArticulo2);
        cardArticulo3 = vista.findViewById(R.id.cardArticulo3);
        cardArticulo4 = vista.findViewById(R.id.cardArticulo4);

        cardArticulo1.setOnClickListener(this);
        cardArticulo2.setOnClickListener(this);
        cardArticulo3.setOnClickListener(this);
        cardArticulo4.setOnClickListener(this);

        return vista;
    }

    public void PrimerArticulo() {
        Intent intent = new Intent(getActivity(), DetalleArticulos.class);
        intent.putExtra("imagen", R.drawable.primer_articulo);
        startActivity(intent);
    }

    public void SegundoArticulo() {
        Intent intent = new Intent(getActivity(), DetalleArticulos.class);
        intent.putExtra("imagen", R.drawable.segundo_articulo);
        startActivity(intent);
    }

    public void TercerArticulo() {
        Intent intent = new Intent(getActivity(), DetalleArticulos.class);
        intent.putExtra("imagen", R.drawable.tercer_articulo);
        startActivity(intent);
    }

    public void CuartoArticulo() {
        Intent intent = new Intent(getActivity(), DetalleArticulos.class);
        intent.putExtra("imagen", R.drawable.cuarto_articulo);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v == cardArticulo1) {
            PrimerArticulo();
        }

        if (v == cardArticulo2) {
            SegundoArticulo();
        }

        if (v == cardArticulo3) {
            TercerArticulo();
        }

        if (v == cardArticulo4) {
            CuartoArticulo();
        }
    }
}
