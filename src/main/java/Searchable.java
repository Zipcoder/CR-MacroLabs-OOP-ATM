public interface Searchable {

//    default String[] toStringArray() {
//        if (this instanceof Account) {
//
//            String acctType;
//            String typeSpecificProperty;
//            if (this instanceof Investment) {
//                acctType = "Investment";
//                typeSpecificProperty = ((Investment) this).risk.toString();
//            } else if (this instanceof Savings) {
//                acctType = "Savings";
//                typeSpecificProperty = ((Savings) this).interestRate;
//            } else {
//                acctType = "Checking";
//                typeSpecificProperty = "";
//            }
//
//            String[] result = new String[] {
//                    ((Account) this).ID.toString(),
//                    ((Account) this).owner.getID().toString(),
//                    ((Account) this).balance.toString(),
//                    acctType,
//                    typeSpecificProperty
//            };
//
//            return result;
//
//
//        } else if (this instanceof Transaction) {
//
//            String[] result = new String[] {
//                    this.ID.toString(),
//                    this.lastName,
//                    this.firstName,
//                    this.cardNumber.toString(),
//                    this.password
//            };
//
//            return result;
//
//        } else if (this instanceof User) {
//
//            String type;
//            if (this.amount > 0) {
//                type = "credit";
//            } else {
//                type = "debit";
//            }
//
//            String[] result = new String[] {
//                    type,
//                    this.accountID.toString(),
//                    this.amount.toString(),
//                    this.timeStamp.toString(),
//                    this.description
//            };
//
//            return result;
//
//        } else {
//            return null;
//        }
//    }
//
//    default void saveToDB() {
//
//
//    }

}
