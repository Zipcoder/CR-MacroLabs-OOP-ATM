package io.zipcoder.macrolabs.atm;

import java.util.Random;

public class SecurityFactory {
    private SecurityFactory(){} //cannot instantiate. Must use class via static methods

    public static Security createRandomSecurity(){
        Random randomizer = new Random();
        String name ="";
        for (int i=0; i<3; i++)
        {
            name = name + (char) (randomizer.nextInt(26) + 65);
        }

        double numberOwned = Math.abs( (randomizer.nextDouble()*randomizer.nextInt(100)) );
        double value = Math.abs( (randomizer.nextDouble()*randomizer.nextInt(50)) );

        return (new Security(name, numberOwned, value));
    }

    public static Security createSecurity(String passedName){
        return (new Security(passedName, 0));
    }

    public static Security createSecurity(String passedName, double passedSharesOwned){
        return (new Security(passedName, passedSharesOwned));
    }

}
