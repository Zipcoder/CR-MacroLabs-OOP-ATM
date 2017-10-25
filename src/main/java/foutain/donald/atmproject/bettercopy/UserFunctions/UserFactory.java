package foutain.donald.atmproject.bettercopy.UserFunctions;
import Fountain.Donald.ATMProject.ATMFunctions.PromptUser;

public class UserFactory {


    public void createNewUser(){
        User newUser = new User();
        newUser.setUserInfo(PromptUser.getUserPassWord(), PromptUser.getUserName());
    }
}
