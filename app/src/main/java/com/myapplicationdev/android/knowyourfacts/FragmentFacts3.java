package com.myapplicationdev.android.knowyourfacts;


import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.Random;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentFacts3 extends Fragment {

    View v;
    Button btnColor;

    public FragmentFacts3() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        v = inflater.inflate(R.layout.fragment_facts3, container, false);

        btnColor = v.findViewById(R.id.btnColor);

        btnColor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Random r = new Random();
                v.setBackgroundColor(Color.rgb(r.nextInt(),r.nextInt(), r.nextInt()));
            }
        });
        return v;
    }

}
