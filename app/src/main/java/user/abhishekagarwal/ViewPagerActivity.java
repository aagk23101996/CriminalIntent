package user.abhishekagarwal;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.List;
import java.util.UUID;

public class ViewPagerActivity extends AppCompatActivity {
    private ViewPager pagej;
    private final String FR="crime";
    private CrimeLab labs=CrimeLab.get(this);
    private List<Crime> p=labs.getcrimes();
    private Crime j;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setContentView(R.layout.activity_view_pager);
        pagej=(ViewPager)findViewById(R.id.activity_view_pager1);
        FragmentManager manager=getSupportFragmentManager();
        UUID ft=(UUID)getIntent().getExtras().getSerializable(FR);

        pagej.setAdapter(new FragmentStatePagerAdapter(manager) {
            @Override
            public Fragment getItem(int position) {

                 j=p.get(position);



                return CrFragment.newInstance(j.getid());
            }
            @Override
            public int getCount() {
                int u=p.size();
                        return u;
            }
        });


    for(int i=0;i<p.size();i++){
        if(p.get(i).getid().equals(ft)){
            pagej.setCurrentItem(i);
            break;
        }
    }
}}
