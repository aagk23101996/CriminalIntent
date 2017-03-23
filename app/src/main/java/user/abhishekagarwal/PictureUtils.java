package user.abhishekagarwal;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Point;

/**
 * Created by user on 02-12-2016.
 */

public class PictureUtils {
    public static Bitmap getScaleBitmap(String path,int destWidth,int destHeight){
        BitmapFactory.Options options=new BitmapFactory.Options();
        options.inJustDecodeBounds=true;
        int inSampleSizes=1;
        BitmapFactory.decodeFile(path,options);
        float width=options.outWidth;
        float height=options.outHeight;
        if((width>=destWidth)||(height>=destHeight)){
            float halfwidth=width/2;
            float halfheight=height/2;
            while((halfwidth/inSampleSizes>=destWidth)&&(halfheight/inSampleSizes>=destHeight)){
                inSampleSizes*=2;
            }

        }
        inSampleSizes=inSampleSizes*2;
        options=new BitmapFactory.Options();
        options.inJustDecodeBounds=false;
        options.inSampleSize=inSampleSizes;
        return BitmapFactory.decodeFile(path,options);
    }
    public static Bitmap getScale(String path, Activity ac){
        Point size=new Point();
        ac.getWindowManager().getDefaultDisplay().getSize(size);
        return getScaleBitmap(path,size.x,size.y);
    }
}
