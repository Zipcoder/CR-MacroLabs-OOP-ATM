import java.util.ArrayList;

public class Motherboard {

    public void runEngine(Workflow screen) {
        customerLogin(screen);
    }

    public void customerLogin(Workflow screen) {
        screen.initialWelcomeSP();
        boolean test = true;
        Integer input = screen.getInput();
        while (test)
            switch (input) {
                case 1:
                    createCustomer();
                    test = false;
                    break;
                case 2:
                    Customer currentUser = validateCredentials(screen);
                    if (currentUser == null) {
                        System.out.println("Sorry cannot log you in at this time");
                        test = false;
                        break;
                    }else if(currentUser.equals("0")){customerLogin(screen);}
                    returningCustomer(screen, currentUser);
                    test = false;
                    break;
                default:
                    input = screen.getInput();
                    System.out.println("Please choose 1 for new customer or 2 for returning customer.");
                    break;
            }
    }

    public Customer validateCredentials(Workflow screen) {
        screen.returningUserSP();
        String newUsername = screen.getUserSP();
        int counter = 0;
        int tries = 3;

        if(newUsername.equals("0")){customerLogin(screen);}

        while(Database.getCustomerByUsername(newUsername) == null) {
            System.out.println("Account not on file");
            newUsername = screen.getUserSP();
        }

        Customer currentUser = Database.getCustomerByUsername(newUsername);

        while(counter < 3) {
            String userPass = screen.getPassSP();
            if(userPass.equals("0")){customerLogin(screen);}
            if (currentUser.getPassword().equals(userPass)) {
                return currentUser;
            } else

                counter++;
                tries--;
                System.out.println(String.format("Invalid password: Tries left - %s", tries));
        }
        return null;
    }

    public void createCustomer() {
        Workflow screen = new Workflow();
        Customer newCustomer = Creator.createCustomer(null, null, null, null);

        screen.newCustomerNameSP();
        String newCustomerName = screen.getCustomerNameSP();
        newCustomer.setCustomerName(newCustomerName);
        if(newCustomerName.equals("0")){customerLogin(screen);}

        screen.newUserSP();
        String newUsername = screen.getUserSP();
        if(newUsername.equals("0")){customerLogin(screen);}
        boolean user = true;

        while (user)
            if (Database.getCustomerByUsername(newUsername) != null) {
                screen.usernameTakenSP();
                newUsername = screen.getUserSP();
            } else {
                newCustomer.setUserName(newUsername);
                user = false;
            }

        boolean pass = true;
        while (pass) {
            String newPassword = screen.getPassSP();
            String newPasswordConfirm = screen.getPassSP();
            if(newPassword.equals("0") || newPasswordConfirm.equals("0")){customerLogin(screen);}
            if (newPasswordConfirm.equals(newPassword)) {
                newCustomer.setPassword(newPassword);
                pass = false;
            }else {
                screen.passwordMismatchSP();
            }
        }

        System.out.println("Which type of account would you like to open:\nChecking\nSavings\nInvestment");
        openingAccount(screen, newCustomer);
        Database.addCustomer(newCustomer);
    }

    public void returningCustomer(Workflow screen, Customer customer){
        boolean currentlyUsing = true;

        while(currentlyUsing) {
            screen.mainMenuSP(customer);
            Integer input = screen.getInput();
            switch (input) {
                case 0:
                    checkAccountNumbers(customer);
                    break;
                case 1:
                    check(screen, customer);
                    break;
                case 2:
                    transfer(screen, customer);
                    break;
                case 3:
                    withdrawal(screen, customer);
                    break;
                case 4:
                    deposit(screen, customer);
                    break;
                case 5:
                    openingAccount(screen, customer);
                    break;
                case 6:
                    closingAccount(screen, customer);
                    break;
                case 7:
                    history(screen);
                    break;
                case 8:
                    wireTransfer(screen, customer);
                    break;
                case 9:
                    screen.logOutSP();
                    currentlyUsing = false;
                    break;
            }
        }
    }

    public void withdrawal(Workflow screen, Customer customer) {
        boolean validAmount = true;
        screen.withdrawPromptSP();

        Integer withdrawAccount = screen.enterAccount();
        while(customer.getAccount(withdrawAccount) == null) {
            System.out.println("Account not on file");
            withdrawAccount = screen.enterAccount();
        }

        while (validAmount) {
            double withdrawalAmount = screen.amountPromptSP();
            if (customer.getAccount(withdrawAccount).getBalance() > withdrawalAmount) {
                customer.getAccount(withdrawAccount).withdraw(withdrawalAmount);
                validAmount = false;
            } else System.out.println("Non sufficient funds");
        }

        screen.completeResultSP(customer.getAccount(withdrawAccount));
    }

    public void deposit(Workflow screen, Customer customer) {
        screen.depositPromptSP();

        Integer depositAccount = screen.enterAccount();
        while(customer.getAccount(depositAccount) == null) {
            System.out.println("Account not on file");
            depositAccount = screen.enterAccount();
        }

        double depositAmount = screen.amountPromptSP();

        customer.getAccount(depositAccount).deposit(depositAmount);
        screen.completeResultSP(customer.getAccount(depositAccount));
    }

    public void transfer(Workflow screen, Customer customer) {
        boolean validAmount = true;
        screen.transferPromptSP();

        Integer withdrawAccount = screen.enterAccount();
        while(customer.getAccount(withdrawAccount) == null) {
            System.out.println("Account not on file");
            withdrawAccount = screen.enterAccount();
        }

        Integer depositAccount = screen.enterAccount();
        while(customer.getAccount(depositAccount) == null) {
            System.out.println("Account not on file");
            depositAccount = screen.enterAccount();
        }

        while (validAmount) {
            double transferAmount = screen.amountPromptSP();
            if (customer.getAccount(withdrawAccount).getBalance() >= transferAmount) {
                customer.getAccount(withdrawAccount).withdraw(transferAmount);
                customer.getAccount(depositAccount).deposit(transferAmount);
                validAmount = false;
            } else System.out.println("Non sufficient funds");
        }
        screen.completeResultSP(customer.getAccount(withdrawAccount), customer.getAccount(depositAccount));
    }
    public void closingAccount(Workflow screen, Customer customer) {
        screen.closePrompt();
        Integer oldAccount=screen.enterAccount();
        Boolean validAccount=true;
        while(customer.getAccount(oldAccount)==null){
            System.out.println("Account not on file");
            oldAccount=screen.enterAccount();
        }
        while(validAccount){
            if(customer.getAccount(oldAccount).getBalance()==0) {
                customer.closeAccount(oldAccount);
                break;
            }
            else {
                System.out.println("Account balance must be ZERO.\n" +
                        "Remaining balance: $" +customer.getAccount(oldAccount).getBalance());
                break;
            }
        }
        screen.completeResultsNoHistorySP();
    }

    public void openingAccount(Workflow screen,Customer customer) {
        String uniqAccount = screen.openPrompt();
        boolean validType = true;
        while (validType) {
            if ("checking".equals(uniqAccount)) {
                double firstCheckingDeposit = screen.amountPromptSP();
                Checking uniqChecking = Creator.createChecking(firstCheckingDeposit);
                customer.addAccount(uniqChecking);
                System.out.println("User accounts: "+"\n"+customer.getAccountNumber());
                break;
            } else if ("savings".equals(uniqAccount)) {
                double firstSavingDeposit = screen.amountPromptSP();
                Checking uniqSaving = Creator.createChecking(firstSavingDeposit);
                customer.addAccount(uniqSaving);
                System.out.println("User accounts: "+"\n"+customer.getAccountNumber());
                break;
            } else if ("investment".equals(uniqAccount)) {
                double firstInvestmentDeposit = screen.amountPromptSP();
                Checking uniqInvestment = Creator.createChecking(firstInvestmentDeposit);
                customer.addAccount(uniqInvestment);
                System.out.println("User accounts: "+"\n"+customer.getAccountNumber());
                break;
            } else {
                System.out.println("Not a valid entry. Please type in checking, savings, investment");
                uniqAccount = screen.openPrompt();
            }
        }
    }

    public void checkAccountNumbers(Customer customer) {
        System.out.println(customer.getAccountNumber());
    }

    public void check(Workflow screen, Customer customer){
        screen.checkPromptSP();
        while(true) {
            try {
                Integer acctNumber = screen.enterAccount();
                screen.checkResultSP(customer.getAccount(acctNumber));
                break;
            } catch (Exception e) {
                screen.errorSP();
            }
        }
    }

    public void history(Workflow screen){
        screen.printHistory();
    }

    public void wireTransfer(Workflow screen, Customer customer) {

        Integer withdrawAccount = screen.enterAccount();
        while(customer.getAccount(withdrawAccount) == null) {
            System.out.println("Account not on file");
            withdrawAccount = screen.enterAccount();
        }

        System.out.println("please enter the username you want to transfer to");
        String toTransfer = screen.getUserSP2();

        while(Database.getCustomerByUsername(toTransfer) == null) {
            System.out.println("Account not on file");
            toTransfer= screen.getUserSP2();
        }

        Customer transferUser = Database.getCustomerByUsername(toTransfer);

        boolean validAmount = true;
        screen.transfer2UserPromptSP();

        Integer depositAccount = screen.enterAccount();
        while(transferUser.getAccount(depositAccount) == null) {
            System.out.println("Account not on file");
            depositAccount = screen.enterAccount();
        }

        while (validAmount) {
            double transferAmount = screen.amountPromptSP();
            if (customer.getAccount(withdrawAccount).getBalance() >= transferAmount) {
                customer.getAccount(withdrawAccount).withdraw(transferAmount);
                transferUser.getAccount(depositAccount).deposit(transferAmount);
                validAmount = false;
            } else System.out.println("Non sufficient funds");
        }
        screen.completeResultSP(customer.getAccount(withdrawAccount), transferUser.getAccount(depositAccount));
    }
}
