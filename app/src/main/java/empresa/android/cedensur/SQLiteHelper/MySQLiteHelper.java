package empresa.android.cedensur.SQLiteHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class MySQLiteHelper extends SQLiteOpenHelper {

    public static final String NOMBRETABLA = "reserva";
    private static final String BASEDATOS = "CEDENSUR.db";
    private static final int VERSION = 1;

    private static final String SQLBD = "create table " + NOMBRETABLA +
                                        "(codigo integer primary key autoincrement, " +
                                        "nombre text not null, numero text not null, " +
                                        "servicio text not null, fecha text not null);";

    public MySQLiteHelper(Context context) {
        super(context, BASEDATOS, null, VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase database) {
        database.execSQL(SQLBD);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int antiguaVersion, int nuevaVersion) {
        Log.w(MySQLiteHelper.class.getName(),
                "Actualizando la Version de la Base de Datos Numero: " + antiguaVersion + "a" + nuevaVersion);
        db.execSQL("DROP TABLE IF EXISTS " + NOMBRETABLA);
        onCreate(db);
    }
}
