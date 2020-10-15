package com.example.cssemobileapp.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;

import android.os.Bundle;

import com.example.cssemobileapp.R;
import com.luseen.spacenavigation.SpaceItem;
import com.luseen.spacenavigation.SpaceNavigationView;
import com.luseen.spacenavigation.SpaceOnClickListener;

public class MainActivity extends AppCompatActivity {

    SpaceNavigationView spaceNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        spaceNavigationView = findViewById(R.id.space);
        spaceNavigationView.initWithSaveInstanceState(savedInstanceState);
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_baseline_add_box_24));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_baseline_call_to_action_24));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_equalizer_black_24dp));
        spaceNavigationView.addSpaceItem(new SpaceItem("", R.drawable.ic_settings_black_24dp));
        spaceNavigationView.setCentreButtonSelectable(true);
        spaceNavigationView.setCentreButtonSelected();

        //set category screen
        getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).addToBackStack(null).commit();

        spaceNavigationView.setSpaceOnClickListener(new SpaceOnClickListener() {
            @Override
            public void onCentreButtonClick() {
                //Toast.makeText(HomeActivity.this,"onCentreButtonClick", Toast.LENGTH_SHORT).show();

                getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new HomeFragment()).addToBackStack(null).commit();
            }

            @Override
            public void onItemClick(int itemIndex, String itemName) {
                //Toast.makeText(HomeActivity.this, itemIndex + " " + itemName, Toast.LENGTH_SHORT).show();

//                if(itemIndex == 0){
//                    DialogFragment newFragment = new NewSurveyPopup();
//                    assert getFragmentManager() != null;
//                    newFragment.show(getSupportFragmentManager(), "DatePicker");
//                }else if(itemIndex == 2){
//                    getSupportFragmentManager().beginTransaction().replace(R.id.fragmentContainer, new reportHome()).addToBackStack(null).commit();
//                }

            }

            @Override
            public void onItemReselected(int itemIndex, String itemName) {

            }
        });

    }
}