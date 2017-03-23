package user.abhishekagarwal;

import android.database.Cursor;
import android.database.CursorWrapper;

import java.util.UUID;

/**
 * Created by user on 29-11-2016.
 */

public class CrimeCursorWrapper extends CursorWrapper {

    public CrimeCursorWrapper(Cursor cursor) {
        super(cursor);
    }
    public Crime getCrime(){
        String uuid=getString(getColumnIndex(Stringss.UUID));
        String title=getString(getColumnIndex(Stringss.Table_title));
        Crime r=new Crime(UUID.fromString(uuid));
        r.setTitle(title);
        return r;
    }
}
