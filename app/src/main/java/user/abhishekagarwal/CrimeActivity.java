package user.abhishekagarwal;

import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.UUID;

public class CrimeActivity extends SingleFragmentActivity {
    public final String FR="crime";
    public UUID iden;



    public Fragment createFragment(){
        Intent g=getIntent();
        iden=(UUID)g.getExtras().getSerializable(FR);
return CrFragment.newInstance(iden);
    }
}
