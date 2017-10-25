package foutain.donald.atmproject.bettercopy.ATMFunctions;

import foutain.donald.atmproject.bettercopy.UserFunctions.UserFactory;
import foutain.donald.atmproject.bettercopy.UserFunctions.UserWarehouse;

public class ATM {

    public void startATM(int userInput){
        userInput = PromptUser.userStartATM();
        boolean terminator = true;
        while(terminator == true){
            if("1".equals(userInput)){
               // UserFactory.createNewUser();
            } else if("2".equals(userInput)){
                UserWarehouse.userLogin();
            } else {
                PromptUser.correctResponse();
            }
        }
    }

}
