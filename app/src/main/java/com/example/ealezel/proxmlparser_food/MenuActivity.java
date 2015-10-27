package com.example.ealezel.proxmlparser_food;

import android.app.ListActivity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import org.xmlpull.v1.XmlPullParser;

import java.util.ArrayList;

public class MenuActivity extends ListActivity {

    private static final String TAG = "MenuActivity";
    ArrayList<Food> foodsList = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_menu);
        try {


            String tempName = "";
            String tempPrice = "";
            XmlPullParser foodsParser = getResources().getXml(R.xml.food_list);
            int eventType = foodsParser.getEventType();
            while (eventType != XmlPullParser.END_DOCUMENT) {
                if (eventType == XmlPullParser.START_TAG && foodsParser.getName().equals("name"))
                {
                    foodsParser.next();
                    tempName = foodsParser.getText();
                }
                else if (eventType == XmlPullParser.START_TAG && foodsParser.getName().equals("price"))
                {
                    foodsParser.next();
                    tempPrice = foodsParser.getText();
                }

                if(eventType == XmlPullParser.END_TAG && foodsParser.getName().equals("food"))
                {
                    Food food = new Food(tempName, tempPrice);
                    foodsList.add(food);
                }
                eventType = foodsParser.next();
            }
        } catch (Throwable t) {
            Log.v(TAG, "Error XML-file loading: " + t.toString());
            Toast.makeText(this, "Error XML-file loading: " + t.toString(), Toast.LENGTH_LONG)
                    .show();
        }
        ArrayAdapter<Food> adapter = new ArrayAdapter<Food>(this, android.R.layout.simple_list_item_1,
                foodsList);
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {

        Log.i("Hello!", "Clicked! YAY!"); //debug

        Intent detailedActivity = new Intent(this, Detailed.class);
        Food food = (Food)l.getItemAtPosition(position);
        detailedActivity.putExtra("Name", food.Name);
        detailedActivity.putExtra("Price", food.Price);
        startActivity(detailedActivity);
    }
}
