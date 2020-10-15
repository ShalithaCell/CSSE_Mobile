package com.example.simplesurveycreator.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import com.example.simplesurveycreator.R;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class HomeAppActivity extends AppCompatActivity {

    SpaceNavigationView spaceNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_app);



        spaceNavigationView = findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_baseline_add_box_24));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_baseline_call_to_action_24));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_equalizer_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_settings_black_24dp));
        spaceNavigationView.setCentreButtonSelectable(true);
        spaceNavigationView.setCentreButtonSelected();

        //set category screen
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MainScreen()).addToBackStack(null).commit();

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                //Toast.makeText(HomeActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new MainScreen()).addToBackStack(null).commit();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }


        });

    }
}