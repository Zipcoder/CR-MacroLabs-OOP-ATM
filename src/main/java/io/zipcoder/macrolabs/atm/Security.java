package io.zipcoder.macrolabs.atm;

import java.util.Random;

public class Security
{
    private final String name;
    private double numberOwned=0;
    private double value=0;

    public Security(String passedName, double passedNumberOwned, double passedValue){
        name=passedName;
        numberOwned=passedNumberOwned;
        value=passedValue;
    }

    public Security(String passedName, double passedNumberOwned){
        Random randomizer = new Random();
        name = passedName;
        numberOwned = passedNumberOwned;
        value = Math.abs( (randomizer.nextDouble()*randomizer.nextInt(50)) );
    }

    public String getName(){
        return name;
    }

    public double getNumberOwned(){
        return numberOwned;
    }

    public void changeNumberOwned(double numberDifference){
        numberOwned+=numberDifference;
    }

    public double getValue(){
        return value;
    }

}
