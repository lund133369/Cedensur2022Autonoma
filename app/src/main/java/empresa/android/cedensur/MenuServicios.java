package empresa.android.cedensur;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.fragment.app.Fragment;

public class MenuServicios extends Fragment implements View.OnClickListener{

    View vista;
    Button btnPrincipal, btnReservarCita, btnCitas;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        vista = inflater.inflate(R.layout.fragment_menu_servicios, container, false);

        btnPrincipal = vista.findViewById(R.id.btnPrincipal);
        btnReservarCita = vista.findViewById(R.id.btnReservarCita);
        btnCitas = vista.findViewById(R.id.btnCitas);

        btnPrincipal.setOnClickListener(this);
        btnReservarCita.setOnClickListener(this);
        btnCitas.setOnClickListener(this);

        return vista;
    }

    public void Inicio() {
        Intent intent = new Intent(getActivity(), Principal.class);
        startActivity(intent);

        requireActivity().finish();
    }

    public void Reservar() {
        Intent intent = new Intent(getActivity(), Reserva.class);
        startActivity(intent);
    }

    public void Citas() {
        Intent intent = new Intent(getActivity(), Cita.class);
        startActivity(intent);
    }

    @Override
    public void onClick(View v) {
        if (v == btnPrincipal) {
            Inicio();
        }
        if (v == btnReservarCita) {
            Reservar();
        }
        if (v == btnCitas) {
            Citas();
        }
    }
}
