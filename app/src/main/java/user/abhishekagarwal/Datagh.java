package user.abhishekagarwal;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by user on 29-11-2016.
 */

public class Datagh extends SQLiteOpenHelper {

private static Datagh fr;

        private static final int VERSI=1;
        private static final String f="CrimeBase.db";
        private Datagh(Context context){
            super(context,f,null,VERSI);

        }
    public static Datagh getInstance(Context c){
        if(fr==null){
            fr=new Datagh(c);
            return fr;
        }
        else{
            return fr;
        }
    }

        @Override
        public void onCreate(SQLiteDatabase db) {
            db.execSQL("CREATE TABLE " + Stringss.Table_name + "(" + "_id INTEGER PRIMARY KEY AUTOINCREMENT," + Stringss.Table_title + "," + Stringss.UUID + ")");

        }

        @Override
        public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        }
    }


