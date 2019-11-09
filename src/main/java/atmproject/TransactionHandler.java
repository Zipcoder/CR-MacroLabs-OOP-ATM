package atmproject;

import java.security.InvalidParameterException;

public class TransactionHandler {

    public void withdraw(Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }

    }

    public void deposit(Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }

    }

    public void transfer(Double amount) {
        if (amount < 0) {
            throw new InvalidParameterException();
        }
    }

}
