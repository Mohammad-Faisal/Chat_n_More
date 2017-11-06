package com.google.firebase.udacity.friendlychat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class SetName extends AppCompatActivity {

    TextView name_text;
    Button set_button;
    private FirebaseDatabase mDatabase;
    private DatabaseReference mDatabaseRef;
    Profile profile_object;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_name);
        name_text = (TextView) findViewById(R.id.name_text);
        set_button = (Button) findViewById(R.id.button2);
        profile_object = new Profile("" , "");
        userID = getIntent().getStringExtra("userID");
        mDatabase = FirebaseDatabase.getInstance();
        mDatabaseRef = mDatabase.getReference().child("luicca").child("users").child(userID);
        set_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String p = name_text.getText().toString();
                profile_object.setUserID(userID);
                profile_object.setUserName(p);
                mDatabaseRef.setValue(profile_object).addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void aVoid) {
                        finish();
                    }
                });
            }
        });


    }
}
