package com.example.ealezel.proxmlparser_food;

/**
 * Created by ealezel on 27.10.2015.
 */
public class Food {
    public final String Name;
    public final String Price;

    public Food(String name, String price)
    {
        this.Name = name;
        this.Price = price;
    }


    @Override
    public String toString() {
        return Name + " " + Price;
    }


}
