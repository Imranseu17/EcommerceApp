package com.kcsl.ecommerce.ui.profile;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.kcsl.ecommerce.R;
import com.kcsl.ecommerce.activities.ProfileSettingsActivity;

public class ProfileFragment extends Fragment {

    ImageView settingsIcon;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v =  inflater.inflate(R.layout.fragment_profile, container, false);
        settingsIcon = v.findViewById(R.id.action_settings);
        settingsIcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getContext(), ProfileSettingsActivity.class));
            }
        });
        return v;
    }
}