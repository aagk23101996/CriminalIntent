package user.abhishekagarwal;


import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.File;
import java.util.UUID;


/**
 * A simple {@link Fragment} subclass.
 */
public class CrFragment extends Fragment {
private EditText t1;
    private final int REQ_CODE=2;
    private Crime cr;
    private File gt;
    private Button br;
    private ImageView im;
private static final String SRf="Hello";
    public static CrFragment newInstance(UUID g) {

        Bundle args = new Bundle();
        args.putSerializable(SRf,g);

        CrFragment fragment = new CrFragment();
        fragment.setArguments(args);
        return fragment;
    }
    public void onPause(){
        super.onPause();
        CrimeLab.get(getActivity()).updateCrime(cr);

    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        UUID u=(UUID)getArguments().getSerializable(SRf);

        cr=CrimeLab.get(getActivity()).getcrime(u);
        gt=CrimeLab.get(getActivity()).getfiledes(cr);

        View v= inflater.inflate(R.layout.fragment_cr, container, false);
        PackageManager mg=getActivity().getPackageManager();
        br=(Button)v.findViewById(R.id.img);
        im=(ImageView)v.findViewById(R.id.imgview);
        t1=(EditText)v.findViewById(R.id.text);
        t1.setText(cr.getTitle());
        t1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            cr.setTitle(s.toString());

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        final Intent gy=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        boolean a;
        a=(mg.resolveActivity(gy,PackageManager.MATCH_DEFAULT_ONLY)!=null&&gt!=null);
        br.setEnabled(a);
        Uri t=Uri.fromFile(gt);
        gy.putExtra(MediaStore.EXTRA_OUTPUT,t);
        br.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivityForResult(gy,REQ_CODE);
            }
        });
        updategi();

        return v;
    }
    public void updategi(){
        Bitmap ht=PictureUtils.getScale(gt.getPath(),getActivity());
        im.setImageBitmap(ht);
    }
    public void onActivityResult(int reqCode,int resCode,Intent data){
        if(reqCode==REQ_CODE){
            updategi();
        }
    }


}
