package com.example.androidme.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidme.R;

public class MainActivity extends AppCompatActivity implements MasterListFragment.OnImageClickListener {

    private int headIndex;
    private int bodyIndex;
    private int legIndex;



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast toast = Toast.makeText(this, "Please pick a head, body, and leg!", Toast.LENGTH_LONG);
        toast.setGravity(Gravity.TOP|Gravity.CENTER, 0, 0);
        toast.show();

    }

    /**
     * This is a callback in the host, which is triggered when an item in fragment is clicked
     *
     * @param position
     */
    @Override
    public void onImageSelected(int position) {

        if (position < 12) {
            headIndex = position;
        } else if (position < 24) {
            bodyIndex = position - 12;
        } else {
            legIndex = position - 24;
        }

        // Put information in a Bundle and
        Bundle b = new Bundle();
        b.putInt("headIndex",headIndex);
        b.putInt("bodyIndex",bodyIndex);
        b.putInt("legIndex",legIndex);
        // Attach it to an Intent that will launch AndroidMeActivity
        final Intent intent = new Intent(this, AndroidMeActivity.class);
        intent.putExtras(b);
        // Make a button to start the intent
        Button nextButton = findViewById(R.id.next_button);
        nextButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(intent);
            }
        });
    }
}
