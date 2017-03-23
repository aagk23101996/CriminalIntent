package user.abhishekagarwal;

import android.support.v4.app.Fragment;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

public class CrimeListActivity extends SingleFragmentActivity {

    @Override
    public Fragment createFragment(){
        return new CrimeFragment();

    }


}
