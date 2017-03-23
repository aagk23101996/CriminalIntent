package user.abhishekagarwal;

import java.util.Date;
import java.util.UUID;

/**
 * Created by user on 24-11-2016.
 */

public class Crime {
    private String mTitle;
    private UUID mId;
    private Date mdate;
    private boolean check;
    public Crime(){
        mId=UUID.randomUUID();
    }
    public void setTitle(String a){
        mTitle=a;

    }
    public void setdate(Date d){
        mdate=d;
    }
    public void isCheck(boolean s){
        check=s;
    }
    public String getTitle(){
        return mTitle;
    }
    public UUID getid(){
        return mId;
    }
    public Crime(UUID ty){mId=ty;}
    public boolean getCheck(){return check;
    }
    public Date getdate(){return mdate;}
    public String Filename(){
        return ("IMG_"+getid()+".jpg");
    }
}
