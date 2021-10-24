package com.example.musicshop;

import android.graphics.Bitmap;

public class Item {
    public String Name;
    public Double Price;
    public Bitmap Image;
    public Item(String name, Double price, Bitmap image){
        Name = name;
        Price = price;
        Image = image;
    }

}
