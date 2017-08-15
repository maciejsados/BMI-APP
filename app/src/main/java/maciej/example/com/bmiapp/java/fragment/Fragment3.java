package maciej.example.com.bmiapp.java.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.ButterKnife;
import maciej.example.com.bmiapp.R;

/**
 * Created by Maciej on 2017-08-11.
 */

public class Fragment3 extends Fragment {



    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment3, container, false);
        ButterKnife.bind(this, view);


        return view;
    }


}
