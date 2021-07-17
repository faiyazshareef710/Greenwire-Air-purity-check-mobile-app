package com.example.demo19;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Device_2 extends AppCompatActivity {
    TextView t1, t4,t5;
    Button b1, b2;
    DatabaseReference reff;
    double num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device_2);
        t1 = (TextView) findViewById(R.id.t1);
        b1 = (Button) findViewById(R.id.b1);


        t1 = (TextView) findViewById(R.id.t1);
        b1 = (Button) findViewById(R.id.b1);
        b2 = (Button) findViewById(R.id.button2);
        t4 = (TextView) findViewById(R.id.textView4);
        t5=(TextView)findViewById(R.id.textView5);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reff = FirebaseDatabase.getInstance().getReference().child("Device");
                reff.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        String airqual = dataSnapshot.child("airqual").getValue().toString();
                        t1.setText(airqual);
                    }

                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {

                    }
                });
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                num = Double.valueOf(t1.getText().toString());
                if (num >= 0 && num <= 50) {
                    t4.setText("Analysis:Air Quality is Good");
                    t5.setText("Action to Protect Health from Ozone \nNone");

                } else if (num >= 51 && num <= 101) {
                    t4.setText("Analysis:Air Quality is Moderate");
                    t5.setText("Action to Protect Health from Ozone:\nNone");
                } else if (num >= 101 && num <= 150) {
                    t4.setText("Analysis:Air Quality is Sensitive for Unhealthy Groups");
                    t5.setText("Action to Protect Health from Ozone: \nUnusually sensitive people should consider\n" +
                            "reducing prolonged or heavy outdoor\n" +
                            "exertion.");
                } else if (num >= 151 && num <= 200) {
                    t4.setText("Analysis:Air Quality is Sensitive for Unhealthy");
                    t5.setText("Action to Protect Health from Ozone: \nThe following groups should reduce\n" +
                            "prolonged or heavy outdoor exertion:\n" +
                            "•\tPeople with lung disease, such as asthma\n" +
                            "•\tChildren and older adults\n" +
                            "•\tPeople who are active outdoors");
                } else if (num >= 201 && num <= 300) {
                    t4.setText("Analysis:Air Quality is Sensitive for Unhealthy");
                    t5.setText("Action to Protect Health from Ozone:\nThe following groups should avoid\n" +
                            "prolonged or heavy outdoor exertion:\n" +
                            "•\tPeople with lung disease, such as asthma\n" +
                            "•\tChildren and older adults\n" +
                            "•\tPeople who are active outdoors\n" +
                            "Everyone else should limit prolonged\n" +
                            "outdoor exertion.");
                } else if (num >= 301 && num <= 500) {
                    t4.setText("Analysis:Air Quality is Hazardous");
                    t5.setText("Action to Protect Health from Ozone: \n. AQI values over 300 trigger health warnings\n" +
                            "of emergency conditions. The entire population is even\n" +
                            "more likely to be affected by serious health effects. Hence nothing can be done ");
                }
                else
                {
                    t4.setText("Please Retrieve Data from the Database first" +
                            "");
                }
            }
        });

    }
}
