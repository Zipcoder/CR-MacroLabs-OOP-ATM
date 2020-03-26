/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){
        ATMInterface atmInterface = new ATMInterface();
        atmInterface.start();
        
    }

    public static double truncateToTwoDecimalPlaces(double doubleThatNeedsTruncating) {
        return Math.floor(doubleThatNeedsTruncating * 100) / 100;
    }
}
