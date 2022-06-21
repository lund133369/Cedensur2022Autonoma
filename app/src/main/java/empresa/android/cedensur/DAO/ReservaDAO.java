package empresa.android.cedensur.DAO;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

import empresa.android.cedensur.BEAN.ReservaBean;
import empresa.android.cedensur.SQLiteHelper.MySQLiteHelper;

public class ReservaDAO {
    private SQLiteDatabase database;
    private final MySQLiteHelper dbHelper;

    public ReservaDAO(Context context) {
        dbHelper = new MySQLiteHelper(context);
    }

    public void open() throws SQLException {
        database = dbHelper.getWritableDatabase();
    }

    //Método Listar
    public ArrayList<ReservaBean> Listar() {
        Cursor c;
        ArrayList<ReservaBean> listado = new ArrayList<>();
        c = database.rawQuery("select * from reserva", null);

        while (c.moveToNext()) {
            ReservaBean objreserva = new ReservaBean();
            objreserva.setCodigo(c.getInt(0));
            objreserva.setNombre(c.getString(1));
            objreserva.setNumero(c.getString(2));
            objreserva.setServicio(c.getString(3));
            objreserva.setFecha(c.getString(4));
            listado.add(objreserva);
        }
        c.close();
        return listado;
    }

    //Método Agregar
    public long Insertar(ReservaBean objReservaBean) {
        long estado;

        try {
            ContentValues valores = new ContentValues();
            valores.put("nombre", objReservaBean.getNombre());
            valores.put("numero", objReservaBean.getNumero());
            valores.put("servicio", objReservaBean.getServicio());
            valores.put("fecha", objReservaBean.getFecha());

            estado = database.insert(MySQLiteHelper.NOMBRETABLA, null, valores);

        } catch (Exception e) {
            estado = 0;
        }
        return estado;
    }

    //Método Eliminar
    public long EliminarRegistro(int codigo) {
        long estado;

        try {
            estado = database.delete(MySQLiteHelper.NOMBRETABLA, "codigo=?",
                    new String[] {String.valueOf(codigo)});

        } catch (Exception e) {
            estado = 0;
        }
        return estado;
    }
}
