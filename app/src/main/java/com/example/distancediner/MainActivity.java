package com.example.distancediner;


import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

//import android.content.Intent;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class MainActivity extends AppCompatActivity {

    EditText editTextTextPersonName2;
    Button btn1;
    DatabaseReference db;

    /*Button button;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setTitle("Customer Reviews");
        //actionBar.setSubtitle("Insert your details to calculate");
        actionBar.setDisplayHomeAsUpEnabled(true);

        //btn1= findViewById(R.id.btn1);
        // button.setOnClickListener(new View.OnClickListener() {
            //@Override
           // public void onClick(View view) {
             //   btnGo();
            //}
        //});

    editTextTextPersonName2 = findViewById(R.id.editTextTextPersonName2);

    btn1 = findViewById(R.id.btn1);

    db =FirebaseDatabase.getInstance().getReference().child("customerReviews");

    btn1.setOnClickListener(new View.OnClickListener()

    {
        @Override
        public void onClick (View view){

        insertData();
    }
    });

}

    //insert customer review
    private void insertData(){

        String review = editTextTextPersonName2.getText().toString();


        customerReviews customerreviews = new customerReviews(review);

        db.push().setValue(customerreviews);
        Toast.makeText(MainActivity.this, "Data Inserted Successfully", Toast.LENGTH_SHORT).show();

    }

    /*public void btnGo(){
        Intent intent= new Intent(this, MainActivity2.class);
        startActivity(intent);
    }*/

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.main, menu);

        return super.onCreateOptionsMenu(menu);
    }

    //navigate to next page
    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();

        if (id == R.id.todayProfits){

            Intent intent = new Intent(this, MainActivity5.class);
            startActivity(intent);

            return true;

        }

        return super.onOptionsItemSelected(item);
    }

}