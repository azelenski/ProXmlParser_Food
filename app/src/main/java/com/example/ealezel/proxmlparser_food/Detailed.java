package com.example.ealezel.proxmlparser_food;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class Detailed extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detailed);


        TextView nameTextView = (TextView) findViewById(R.id.nameTextView);
        TextView priceTextView = (TextView) findViewById(R.id.priceTextView);
        Intent intent = getIntent();
        String nameMessage = intent.getStringExtra("Name");
        String priceMessage = intent.getStringExtra("Price");

        nameTextView.setText(nameMessage);
        priceTextView.setText(priceMessage);
    }


}
