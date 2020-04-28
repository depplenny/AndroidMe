package com.example.androidme.ui;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import com.example.androidme.R;
import com.example.androidme.data.AndroidImageAssets;

// This activity will display a custom Android image composed of three body parts: head, body, and legs
public class AndroidMeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_me);

        Intent intent = getIntent();
        Bundle b = intent.getExtras();

        // Only crate new fragments when there is no previously saved state (instantiated first time)
        if (savedInstanceState == null) {
            // Create a new head BodyPartFragment
            BodyPartFragment headFragment = new BodyPartFragment();

            // Set the list of image id's for the head fragment and set the position to the second image in the list
            headFragment.setImageIds(AndroidImageAssets.getHeads());
            headFragment.setIndex(b.getInt("headIndex"));

            // Create a new body BodyPartFragment
            BodyPartFragment bodyFragment = new BodyPartFragment();

            // Set the list of image id's for the body fragment and set the position to the second image in the list
            bodyFragment.setImageIds(AndroidImageAssets.getBodies());
            bodyFragment.setIndex(b.getInt("bodyIndex"));

            // Create a new leg BodyPartFragment
            BodyPartFragment legFragment = new BodyPartFragment();

            // Set the list of image id's for the leg fragment and set the position to the second image in the list
            legFragment.setImageIds(AndroidImageAssets.getLegs());
            legFragment.setIndex(b.getInt("legIndex"));


            // Add the fragment to its container using a FragmentManager and a Transaction
            FragmentManager fragmentManager = getSupportFragmentManager();

            fragmentManager.beginTransaction()
                    .add(R.id.head_container, headFragment)
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.body_container, bodyFragment)
                    .commit();

            fragmentManager.beginTransaction()
                    .add(R.id.leg_container, legFragment)
                    .commit();
        }

    }
}
