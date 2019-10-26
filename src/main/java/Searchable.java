public interface Searchable {

    default String[] toStringArray() {
        if (this.instanceof(Account)) {

            String acctType;
            String typeSpecificProperty;
            if (this.instanceof(Checking)) {
                acctType = "Investment";
                typeSpecificProperty = this.risk.toString();
            } else if (this.instanceof(Savings)) {
                acctType = "Savings";
                typeSpecificProperty = this.interestRate;
            } else {
                acctType = "Checking";
                typeSpecificProperty = "";
            }

            String[] result = new String[] {
                    this.ID.toString(),
                    this.owner.ID.toString(),
                    this.balance.toString(),
                    acctType,
                    typeSpecificProperty
            }

            return result;


        } else if (this.instanceof(Transaction)) {

            String[] result = new String[] {
                    this.ID.toString(),
                    this.lastName,
                    this.firstName,
                    this.cardNumber.toString(),
                    this.password
            }

            return result;

        } else if (this.instanceof(User)) {

            String type;
            if (this.amount > 0) {
                type = "credit";
            } else {
                type = "debit";
            }

            String[] result = new String[] {
                    type,
                    this.accountID.toString(),
                    this.amount.toString(),
                    this.timeStamp.toString(),
                    this.description
            }

            return result;

        } else {
            return null;
        }
    }

}
