package com.zipcode.macrolabs.atm;

import java.util.Random;

public class RandomUtils {

    private static final Random random = new Random();

    public static Float createFloat(float min, float max) {
        return random.nextFloat() * (max - min) + min;
    }

    public static Integer createInteger(Integer min, Integer max) {
        return createFloat(min, max).intValue();
    }

    public static Boolean createBoolean(Integer skew){
        int seed = createInteger(0, 100);
        if (skew > seed){
            return true;
        } else { return false; }
    }

    public static Character createCharacter(char min, char max) {
        return (char) createInteger((int) min, (int) max).intValue();
    }

    public static String createString(char min, char max, int stringLength) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < stringLength; i++) {
            sb.append(createCharacter(min, max));
        }
        return sb.toString();
    }

    public static String createID(int idLength){
        String id = "";
        for (int i = 0; i < idLength; i++) {
            id += i;
        }
        return id;
    }

}
