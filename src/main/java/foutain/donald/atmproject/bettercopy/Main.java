package foutain.donald.atmproject.bettercopy;

import foutain.donald.atmproject.bettercopy.ATMFunctions.ATM;
import foutain.donald.atmproject.bettercopy.UserFunctions.User;
import foutain.donald.atmproject.bettercopy.UserFunctions.UserFactory;
import foutain.donald.atmproject.bettercopy.UserFunctions.UserWarehouse;

/**
 * Created by iyasuwatts on 10/17/17.
 */
public class Main {

    public static void main(String[] args){
        ATM newATM = new ATM();
        newATM.startATM();

        UserWarehouse warehouse = new UserWarehouse();
        User Logan = UserFactory.createNewUser("Logan", "Password");
        warehouse.addUserToList(Logan);
    }
}
