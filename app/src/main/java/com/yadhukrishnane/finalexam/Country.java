package com.yadhukrishnane.finalexam;

import java.util.ArrayList;
import java.util.List;

public class Country {

    private String name;
    private String capital;
    private int resID;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getResID() {
        return resID;
    }

    public void setResID(int resID) {
        this.resID = resID;
    }

    public static List<Country> getCountries() {
        List<Country> countries = new ArrayList<>();

        Country country1 = new Country();
        country1.setName("Canada");
        country1.setCapital("Ottawa");
        country1.setResID(R.drawable.canada);
        countries.add(country1);

        Country country2 = new Country();
        country2.setName("USA");
        country2.setCapital("Washington");
        country2.setResID(R.drawable.usa);
        countries.add(country2);

        Country country3 = new Country();
        country3.setName("England");
        country3.setCapital("London");
        country3.setResID(R.drawable.england);
        countries.add(country3);

        return countries;
    }
}
