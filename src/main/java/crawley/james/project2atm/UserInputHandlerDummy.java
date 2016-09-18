package crawley.james.project2atm;

/**
 * Created by jamescrawley on 9/16/16.
 */
public class UserInputHandlerDummy extends UserInputHandler {

    private int[] userInts;
    private double[] userDoubles;
    private String[] userStrings;
    private int intIndex;
    private int doubleIndex;
    private int stringIndex;

    public UserInputHandlerDummy (int[] userInts, double[] userDoubles, String[] userStrings) {

        this.userInts = userInts;
        this.userDoubles = userDoubles;
        this.userStrings = userStrings;

    }

    @Override
    public int getUserInt () {

        return userInts[++intIndex];

    }

    @Override
    public double getUserDouble () {

        return userDoubles[++doubleIndex];

    }

    @Override
    public String getUserString() {

        return userStrings[++stringIndex];

    }
}
