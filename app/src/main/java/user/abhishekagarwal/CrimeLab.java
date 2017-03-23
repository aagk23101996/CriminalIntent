package user.abhishekagarwal;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Environment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Created by user on 24-11-2016.
 */

public class CrimeLab {
    private static CrimeLab sCrimeLab;
    private SQLiteDatabase db;
    private Context mcontext;
    private List<Crime> list;
    public static CrimeLab get(Context context){
        if(sCrimeLab==null)
            sCrimeLab=new CrimeLab(context);
        return sCrimeLab;
    }
    private CrimeLab(Context c){
        db=Datagh.getInstance(c).getWritableDatabase();
        mcontext=c;

        }
    public void addCrime(Crime ff){
        ContentValues val=getContentValues(ff);
        db.insert(Stringss.Table_name,null,val);

    }
    public void updateCrime(Crime ff){
        ContentValues val=getContentValues(ff);
        String uuidf=ff.getid().toString();
        db.update(Stringss.Table_name,val,Stringss.UUID+"=?",new String[]{uuidf});

    }
    public static ContentValues getContentValues(Crime c){
        ContentValues val=new ContentValues();
        val.put(Stringss.UUID,c.getid().toString());
        val.put(Stringss.Table_title,c.getTitle());
        return val;
    }
    public List<Crime> getcrimes(){
list=new ArrayList<Crime>();
        Cursor gt=querycrime(null,null);
        try{
        gt.moveToFirst();
        while(gt.isAfterLast()==false){
            CrimeCursorWrapper fr=new CrimeCursorWrapper(gt);
            Crime c=fr.getCrime();
            list.add(c);

            gt.moveToNext();
        }}
        finally{
            gt.close();
        }
                return list;

        }

    public Crime getcrime(UUID y){
        Cursor c=querycrime(Stringss.UUID+"=?",new String[]{y.toString()});


            CrimeCursorWrapper f = new CrimeCursorWrapper(c);
            f.moveToFirst();



            return f.getCrime();


    }
    public Cursor querycrime(String where,String[] clause){
        Cursor t=db.query(Stringss.Table_name,null,where,clause,null,null,null);
        return t;


    }
    public File getfiledes(Crime cr){
        File t=mcontext.getExternalFilesDir(Environment.DIRECTORY_PICTURES);
        return new File(t,cr.Filename());
    }
}
