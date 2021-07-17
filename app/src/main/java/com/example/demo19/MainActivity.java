 package com.example.demo19;

         import androidx.annotation.NonNull;
         import androidx.appcompat.app.AppCompatActivity;

         import android.content.Intent;
         import android.os.Bundle;
         import android.os.Handler;
         import android.view.View;
         import android.widget.Button;
         import android.widget.TextView;

         import com.google.firebase.database.DataSnapshot;
         import com.google.firebase.database.DatabaseError;
         import com.google.firebase.database.DatabaseReference;
         import com.google.firebase.database.FirebaseDatabase;
         import com.google.firebase.database.ValueEventListener;

 public class MainActivity extends AppCompatActivity {
     private static int SPLASH_TIME_OUT=4000;
     Button b1;
     @Override
     protected void onCreate(Bundle savedInstanceState) {
         super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         b1=(Button)findViewById(R.id.b2);
         new Handler().postDelayed(new Runnable() {
             @Override
             public void run() {
                 Intent homeIntent=new Intent(MainActivity.this,HomeActivity.class);
                 startActivity(homeIntent);
                 finish();
             }
         },SPLASH_TIME_OUT);



     }


 }
