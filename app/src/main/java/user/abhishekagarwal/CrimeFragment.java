package user.abhishekagarwal;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrimeFragment extends Fragment {
private RecyclerView r;
private myAdapter f;
    private boolean state;




    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_crime, container, false);
        r=(RecyclerView)v.findViewById(R.id.recycle);
        r.setLayoutManager(new LinearLayoutManager(getActivity()));
        updateUI();
        setHasOptionsMenu(true);
        return v;

    }

    public void onCreateOptionsMenu(Menu menu, MenuInflater inflaterr){
     super.onCreateOptionsMenu(menu,inflaterr);
        inflaterr.inflate(R.menu.menusel,menu);
        MenuItem subt=menu.findItem(R.id.sub);
        if(state){
            subt.setTitle(R.string.hide_sub);
        }
        else
            subt.setTitle(R.string.show_sub);
    }
    public boolean onOptionsItemSelected(MenuItem item){
         final String FR="crime";
        switch(item.getItemId()) {
            case R.id.plus:
                Crime crime = new Crime();
                CrimeLab.get(getActivity()).addCrime(crime);
                Intent tu = new Intent(getActivity(), ViewPagerActivity.class);
                tu.putExtra(FR, crime.getid());
                startActivity(tu);
                return true;
            case R.id.sub:
                state=!state;
                getActivity().invalidateOptionsMenu();
                updateSub();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }
    }
    public class VH extends RecyclerView.ViewHolder {
        private final String FR="crime";
        TextView y;
        public VH(View itemView) {
            super(itemView);


        y=(TextView)itemView;
            y.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos=getAdapterPosition();
                    CrimeLab tr=CrimeLab.get(getActivity());
                    List<Crime>rt=tr.getcrimes();
                    Crime criminal=rt.get(pos);
                    Intent r=new Intent(getActivity(),ViewPagerActivity.class);
                    r.putExtra(FR,criminal.getid());
                    startActivity(r);
                }
            });
        }
        public void bindcrime(Crime c){
            y.setText(c.getTitle());


        }
    }
public class myAdapter extends RecyclerView.Adapter<VH>{
    private List<Crime> finalcrimes;

    public myAdapter(List<Crime> j){
        finalcrimes=j;

    }
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater inflaterf=LayoutInflater.from(getActivity());
        View b=inflaterf.inflate(android.R.layout.simple_list_item_1,parent,false);
        return new VH(b);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {
Crime x=finalcrimes.get(position);
        holder.bindcrime(x);
    }

    @Override
    public int getItemCount() {
        return finalcrimes.size();
    }

}
public void updateUI(){
    CrimeLab u=CrimeLab.get(getActivity());
    List<Crime> o=u.getcrimes();

    if(f==null){
        f=new myAdapter(o);
    }
    else{
        f.notifyDataSetChanged();
    }
    r.setAdapter(f);


}
    public void updateSub(){
        CrimeLab labd=CrimeLab.get(getActivity());
        int count=labd.getcrimes().size();
        String rr=count+""+"crimes";
        if(state==false){
            rr=null;
        }
        AppCompatActivity as=(AppCompatActivity)getActivity();
        as.getSupportActionBar().setSubtitle(rr);

    }
}
