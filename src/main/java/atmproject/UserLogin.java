package atmproject;

public class UserLogin {
    private User currentUser;
    private Console console = new Console(System.in, System.out);
    private boolean running;
    private UserRepository userRepository;

    public UserLogin(){
        userRepository = UserRepository.getUserRepository();
    }

    public void runLoginMenu(User currentUser) {
        this.currentUser = currentUser;
        while (running) {
            console.println("Welcome to the ATM!\n Enter 1 for new account, 2 for login");
            Integer userInput = console.getIntegerInput(":");
//            userLoginLogic(userInput);
        }
    }


    /*public void userLoginLogic(User currentUser) {
        Switch(userInput){
            case 1:
                // this will lead to the create userMethod

            case 2:
                // this will lead to the login in method (which if passed will lead to account menu?)
        }
    }*/

    /**
     * Creating a user with a First name, Last name. Also an ID
     */
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
    }
    public void exit(){}

}