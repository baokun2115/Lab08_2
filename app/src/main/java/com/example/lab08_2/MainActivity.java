package com.example.lab08_2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    Button btnShow;
    private static final String CHANNEL_ID = "my_channel_01";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnShow = findViewById(R.id.btnShow);
        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                NotificationManager manager = (NotificationManager)
                        getApplicationContext().getSystemService(Context.NOTIFICATION_SERVICE);

                //Initialize intent for yes button
                Intent intent = new Intent(MainActivity.this
                        , MainActivity_Notification.class);
                //Put extra
                intent.putExtra("yes", true);
                //Add flags
                intent.addFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP|Intent.FLAG_ACTIVITY_NEW_TASK);
                PendingIntent pendingIntent = PendingIntent.getActivity(
                        MainActivity.this, 0, intent, PendingIntent.FLAG_ONE_SHOT | PendingIntent.FLAG_MUTABLE
                );

                NotificationCompat.Builder builder = new NotificationCompat.Builder(
                        MainActivity.this, getString(R.string.channel_name)
                );
                //Set notification title
                builder.setContentTitle("Request");
                builder.setContentText("Are you sure you want to accept request?");
                builder.setSmallIcon(R.drawable.baseline_notifications_24);
                builder.setPriority(NotificationCompat.PRIORITY_HIGH);
                //Perform action on yes button
                builder.addAction(R.drawable.ic_launcher_foreground,"Yes", pendingIntent);
                manager.notify(1, builder.build());
            }
        });
    }
}