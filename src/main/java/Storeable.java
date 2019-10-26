public interface Storeable {

    default String[] toStringArray() {
        if (this instanceof Account) {

            String acctType;
            String typeSpecificProperty;
            if (this instanceof Investment) {
                acctType = "Investment";
                typeSpecificProperty = ((Investment) this).risk.toString();
            } else if (this instanceof Savings) {
                acctType = "Savings";
                typeSpecificProperty = ((Savings) this).interestRate.toString();
            } else {
                acctType = "Checking";
                typeSpecificProperty = "";
            }

            String[] result = new String[] {
                    ((Account) this).acctNum.toString(),
                    ((Account) this).ownerID.toString(),
                    ((Account) this).balance.toString(),
                    acctType,
                    typeSpecificProperty
            };

            return result;


        } else if (this instanceof User) {

            String[] result = new String[] {
                    ((User) this).userID.toString(),
                    ((User) this).lastName,
                    ((User) this).firstName,
                    ((User) this).cardNumber.toString(),
                    ((User) this).password
            };

            return result;

        } else if (this instanceof Transaction) {

            String type;
            if (((Transaction) this).amount > 0) {
                type = "credit";
            } else {
                type = "debit";
            }

            String[] result = new String[] {
                    type,
                    ((Transaction) this).accountID.toString(),
                    ((Transaction) this).amount.toString(),
                    ((Transaction) this).timeStamp.toString(),
                    ((Transaction) this).description
            };

            return result;

        } else {
            return null;
        }
    }

    default void saveToDB() {


    }

}
