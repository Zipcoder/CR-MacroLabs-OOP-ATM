package atmproject;

import com.sun.org.apache.xpath.internal.operations.Bool;

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
            console.println("Welcome to the ATM!\n Enter 1 for new account, 2 for login, 0 to exit");
            Integer userInput = console.getIntegerInput(":");
            Boolean exit = false;
            switch (userInput) {
                case 0:
                    exit = true;
                    break;
                case 1:
                    getUserInfo();
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
    public void getUserInfo(){
        String firstInput = getFirstNameInput();
        String lastInput = getLastNameInput();
        createUser(firstInput,lastInput);
    }

    private Integer getAccountNumberInput(){
        console.println("Please enter your 4 digit Account Number :");
        return console.getIntegerInput(":");

    }
    private Integer getPINInput(){
        console.println("Please enter your PIN :");
        return console.getIntegerInput(":");
    }
    private Integer tryAgainInput(){
        console.println("User Info doesn't match. Try again?\n 1 - Yes  2 - No");
        return console.getIntegerInput(":");
    }
    public void getLoginInfo(){
        Boolean exit = false;
        while (currentUser == null) {
            Integer accountNumber = getAccountNumberInput();
            Integer pin = getPINInput();
            login(accountNumber, pin);
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
        Integer accountNum = userRepository.getAccountNums();
        userRepository.saveUser(new User(firstName,lastName, accountNum), accountNum);

        return userRepository.getUser(accountNum);
    }

    public void login(Integer accountNum,Integer pinNumber ){
        User user = userRepository.getUser(accountNum);
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
        console.println("Are you sure you want to Exit?\n 1 - Yes  2 - No");
        while (!userInput.equals(1) && !userInput.equals(2)) {
            userInput = console.getIntegerInput(":");
            switch (userInput) {
                case 1:
                    running = false;
                    break;
                case 2:
                    break;
                default:
                    console.print("Please enter 1 or 2");
            }
        }
    }

}