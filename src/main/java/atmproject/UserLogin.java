package atmproject;

import atmproject.accounts.Account;

public class UserLogin {
    private User currentUser;
    private Console console = new Console(System.in, System.out);
    private boolean running;
    private UserRepository userRepository;

    public UserLogin() {
        userRepository = UserRepository.getUserRepository();
    }

    public void runLoginMenu() {
        running = true;
        while (running) {
            assignUser();
            if (currentUser != null) {
                startMainMenu();
            }
            exit();
        }
    }

    public void assignUser() {
        while (currentUser == null) {
            console.println("Welcome to the ATM!\n(1) - Create New Account\n(2) - Login to Existing Account\n(0) - Exit ATM");
            Integer userInput = console.getIntegerInput(":");
            Boolean exit = false;
            switch (userInput) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    getUserInfo();
                    console.println("Hello, %s! Thank you for creating an account. Your user ID is %d.", currentUser.getFirstName(),currentUser.getUserID());
                    userRepository.initialAccount(currentUser);
                    break;
                case 2:
                    getLoginInfo();
                    break;
            }
            if (exit) {
                break;
            }
        }
    }

    private String getFirstNameInput() {
    console.println("Please enter your First name :");
    return console.getStringInput(":");
    }
    private String getLastNameInput() {
        console.println("Please enter Last name :");
        return console.getStringInput(":");
    }

    private void setPin() {
        Boolean isPINSet = false;
        while(!isPINSet) {
            console.println("Please select 4 digit PIN :");
            Integer pin = console.getIntegerInput(":");
            if(pin < 10000 && pin > -1) {
                currentUser.setPinNumber(pin);
                isPINSet = true;
            }else{ console.println("Please try again.");}
        }
    }
    public void getUserInfo(){
        String firstInput = getFirstNameInput();
        String lastInput = getLastNameInput();
        currentUser = createUser(firstInput,lastInput);
        setPin();
    }

    private Integer getUserIDInput(){
        console.println("Please enter your 4 digit Account Number :");
        return console.getIntegerInput(":");

    }
    private Integer getPINInput(){
        console.println("Please enter your PIN :");
        return console.getIntegerInput(":");
    }
    private Integer tryAgainInput(){
        console.println("User Info doesn't match. Try again?\n(1) - Yes\n(2) - No\n");
        return console.getIntegerInput(":");
    }
    public void getLoginInfo(){
        Boolean exit = false;
        while (currentUser == null) {
            Integer userID = getUserIDInput();
            Integer pin = getPINInput();
            login(userID, pin);
            if(currentUser == null){
                Integer userInput = tryAgainInput();
                switch(userInput){
                    case 1:
                        break;
                    case 2:
                        exit = true;
                        break;
                }
                if(exit){break;}
            }
        }

    }
    public User createUser (String firstName, String lastName){
        Integer userID = userRepository.getIDNums();
        userRepository.saveUser(new User(firstName,lastName, userID), userID);

        return userRepository.getUser(userID);
    }

    public void login(Integer userID,Integer pinNumber ){
        User user = userRepository.getUser(userID);
        if(user != null && user.getPinNumber().equals(pinNumber)){
            currentUser = user;
        }

    }
    public void startMainMenu(){
        MainMenu mainMenu = new MainMenu();
        mainMenu.runMainMenu(currentUser);
    }
    public void exit(){
        Integer userInput = 0;
        console.println("Are you sure you want to Exit?\n(1) - Yes\n(2) - No\n");
        while (!userInput.equals(1) && !userInput.equals(2)) {
            userInput = console.getIntegerInput(":");
            switch (userInput) {
                case 1:
                    running = false;
                    break;
                case 2:
                    break;
                default:
                    console.print("Please enter (1) or (2)");
            }
        }
    }

}