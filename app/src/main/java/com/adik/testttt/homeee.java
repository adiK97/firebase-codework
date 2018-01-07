package com.adik.testttt;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.security.PrivateKey;

public class homeee extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_homeee);



    FirebaseDatabase database = FirebaseDatabase.getInstance();
    DatabaseReference myRef = database.getReference();
    DatabaseReference mch= myRef.child("link");
// Read from the database
mch.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        // This method is called once with the initial value and again
        // whenever data at this location is updated.
        String link = dataSnapshot.getValue(String.class);
        if(link.equals("no"))
        {
            Log.i("msg","To be announced");
            Toast.makeText(homeee.this, link.toString(), Toast.LENGTH_SHORT).show();
        }
        else
        {
            Log.i("msg","link found!!");
            Toast.makeText(homeee.this, link.toString(), Toast.LENGTH_SHORT).show();
        }
        Log.i("Value is: ", link.toString());
    }

    @Override
    public void onCancelled(DatabaseError error) {
        // Failed to read value
    }
});


}
}