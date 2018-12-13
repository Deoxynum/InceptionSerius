package com.example.sebastianlimaco.inceptionserius.Fragment.MusicActivity.PreviewActivity;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.sebastianlimaco.inceptionserius.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class DescriptionFragment extends Fragment {

    private TextView tvwDescription;
    private String svDescription;

    public DescriptionFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View vwRoot = inflater.inflate(R.layout.fragment_description, container, false);

        Bundle description = getArguments();
        svDescription = description.getString("svDescription");

        if(svDescription.isEmpty()){
            svDescription = "Sometimes the title is enough to understand the meaning of it. Enjoy it anyway!";
        }

        tvwDescription = vwRoot.findViewById(R.id.tvwDescriptionDF);
        tvwDescription.setText(svDescription);
        return vwRoot;
    }

}
