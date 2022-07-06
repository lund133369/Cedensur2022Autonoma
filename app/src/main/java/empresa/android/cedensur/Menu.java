package empresa.android.cedensur;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

import empresa.android.cedensur.Interfaz.ComunicaMenu;

public class Menu extends Fragment implements View.OnClickListener {
    View vista;
    Button btnPrincipal;
    Button botonmenu;

    private final int[] BOTONES = {R.id.btnInformacion, R.id.btnServicios, R.id.btnArticulos};

    public Menu() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_menu, container, false);

        btnPrincipal = vista.findViewById(R.id.btnPrincipal);
        btnPrincipal.setOnClickListener(this);

        for (int i = 0; i < BOTONES.length; i++) {
            botonmenu = vista.findViewById(BOTONES[i]);

            final int queBoton = i;

            botonmenu.setOnClickListener(view -> {
                Activity actividad = getActivity();
                if (actividad != null) {
                    ((ComunicaMenu) actividad).menu(queBoton);
                }
            });
        }

        return vista;
    }

    public void Volver() {
        Intent intent = new Intent(getActivity(), Principal.class);
        startActivity(intent);
        requireActivity().finishAffinity();
    }

    @Override
    public void onClick(View v) {
        if (v == btnPrincipal) {
            Volver();
        }
    }
}
