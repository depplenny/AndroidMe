package com.example.androidme.ui;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.fragment.app.Fragment;

import com.example.androidme.R;

import java.util.ArrayList;
import java.util.List;

public class BodyPartFragment extends Fragment {
    public static final String IMAGE_IDS = "image_ids";
    public static final String INDEX = "index";

    private int mIndex;
    private List<Integer> mImageIds;



    /**
     * Mandatory empty constructor for the fragment manager to instantiate the fragment
     */
    public BodyPartFragment() {

    }

    /**
     * Inflates the fragment layout file and sets the correct resource for the image to display
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Inflate the Android Me fragment layout
        View rootView = inflater.inflate(R.layout.fragment_body_part, container, false);

        // Get a reference to the ImageView in the fragment layout
        final ImageView imageView = rootView.findViewById(R.id.body_part_image_view);

        // Check if BodyPartFragment has been instantiated
        if (savedInstanceState != null) {
            mImageIds = savedInstanceState.getIntegerArrayList(IMAGE_IDS);
            mIndex = savedInstanceState.getInt(INDEX);
        }

        if (mImageIds!=null) {
            imageView.setImageResource(mImageIds.get(mIndex));

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mIndex < mImageIds.size()-1) {
                        mIndex++;
                    } else {
                        mIndex=0;
                    }

                    imageView.setImageResource(mImageIds.get(mIndex));
                }
            });

        } else {
            Log.i("BodyPartFragment: ", "mImageIds is null");
        }

        // Return the rootView
        return rootView;
    }

    public void setIndex(int index) {
        mIndex = index;
    }

    public  void setImageIds(List<Integer> list) {
        mImageIds = list;
    }

    /**
     * Save the current state of this fragment
     */
    @Override
    public void onSaveInstanceState(Bundle currentState){
        currentState.putIntegerArrayList(IMAGE_IDS, (ArrayList<Integer>) mImageIds);
        currentState.putInt(INDEX, mIndex);

    }

}
