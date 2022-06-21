package empresa.android.cedensur.Adaptador;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import empresa.android.cedensur.R;

public class Adaptador extends BaseAdapter {
    public Context context;
    private final List<String> listado;

    public Adaptador(Context context, List<String> listado) {
        this.context = context;
        this.listado = listado;
    }

    @Override
    public int getCount() {
        return listado.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @SuppressLint({"InflateParams", "ViewHolder"})
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View v;

        LayoutInflater layoutInflater = LayoutInflater.from(context);
        v = layoutInflater.inflate(R.layout.item_citas, null);

        String listaCitas = listado.get(position);

        TextView txtCita = v.findViewById(R.id.txtCita);

        txtCita.setText(listaCitas);

        return v;
    }
}
