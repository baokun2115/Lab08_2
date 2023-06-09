package com.example.lab08_2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationManager;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity_Notification extends AppCompatActivity {

    //Initialize varialbe
    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_notification);

        textView = findViewById(R.id.text_view);

        //Init notification manager
        NotificationManager manager = (NotificationManager) getApplicationContext()
                .getSystemService(NOTIFICATION_SERVICE);
        //Clear notification
        manager.cancelAll();

        if (getIntent().hasExtra("yes")){
            textView.setText("You accepted request");
            textView.setTextColor(Color.GREEN);
        }
    }
}