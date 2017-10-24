package io.zipcoder.macrolabs.atm;

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
