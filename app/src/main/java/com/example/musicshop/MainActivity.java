package com.example.musicshop;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {
    TextView countTextView;
    TextView priceTextView;
    ImageView IconImage;
    Integer count;
    Integer itemPosition;
    Spinner spinner;
    ArrayList<Item> spinnerArrayList;
    ArrayList Names;
    ArrayAdapter arrayAdapter;
    double price;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        count = 0;

        countTextView = findViewById(R.id.text_count);
        priceTextView = findViewById(R.id.price);
        IconImage = findViewById(R.id.item_image);
        spinner = findViewById(R.id.data_spinner);
        spinner.setOnItemSelectedListener(this);
        spinnerArrayList = new ArrayList();
        Names = new ArrayList();

        FillArray();
        itemPosition = spinner.getSelectedItemPosition();
        arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_spinner_item, Names);
        arrayAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(arrayAdapter);
    }
    private void FillArray(){

        spinnerArrayList.add(new Item("Guitar", 1500.0, BitmapFactory.decodeResource(getResources(), R.drawable.guitar)));
        spinnerArrayList.add(new Item("Drums", 1278.0, BitmapFactory.decodeResource(getResources(), R.drawable.drums)));
        spinnerArrayList.add(new Item("Keyboard", 1356.0, BitmapFactory.decodeResource(getResources(), R.drawable.piano)));

        for(int i = 0; i < spinnerArrayList.size(); i++){
            Item thisItem = spinnerArrayList.get(i);
            Names.add(thisItem.Name);
        }
    }

    public void AddOrderCount(View view) {
        count++;
        countTextView.setText(""+count);
        setPrice();
    }

    public void deleteOrderCount(View view) {
        if(count > 0){
            count--;
            countTextView.setText(""+count);
            setPrice();
        }
    }
    private void setPrice(){
        Item thisItem = spinnerArrayList.get(itemPosition);
        price = thisItem.Price * count;
        priceTextView.setText("" + price);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        itemPosition = spinner.getSelectedItemPosition();
        showInfo(itemPosition);
    }
    private void showInfo(Integer position){
        Item thisItem = spinnerArrayList.get(position);
        IconImage.setImageBitmap(thisItem.Image);
        setPrice();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}