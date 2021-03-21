package com.example.instant_messaging;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.auth.User;

import de.hdodenhof.circleimageview.CircleImageView;

public class MainActivity extends AppCompatActivity {
    TextView Username;
    Button logout;
    CircleImageView Profile_pic;
    FirebaseUser User;
    DatabaseReference ref;

    public static final String TAG = "FragmentActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate (savedInstanceState);
        setContentView (R.layout.activity_main);


        Username = findViewById (R.id.username);
        Profile_pic = findViewById (R.id.profile_image);
        Profile_pic.setImageResource(R.mipmap.ic_launcher);
        logout = findViewById (R.id.logout);

        User = FirebaseAuth.getInstance ().getCurrentUser ();
        ref = FirebaseDatabase.getInstance ().getReference ("Users").child (User.getUid());

        logout.setOnClickListener (new View.OnClickListener () {
            @Override
            public void onClick(View v) {
                FirebaseAuth.getInstance().signOut();
                // change this code beacuse your app will crash
                startActivity(new Intent(MainActivity.this, StartActivity.class).setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP));


            }
        });

       ref.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // This method is called once with the initial value and again
                // whenever data at this location is updated.
                String value = dataSnapshot.getValue(String.class);
                Users user = dataSnapshot.getValue(Users.class);
                //Username.setText(user.getUser_name());
               Log.d(TAG, "Value is: " + value);
            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
               // Log.w(TAG, "Failed to read value.", error.toException());
            }
        });


    }



}