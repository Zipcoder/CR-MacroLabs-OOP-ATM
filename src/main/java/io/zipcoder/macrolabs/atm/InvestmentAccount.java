package io.zipcoder.macrolabs.atm;

import java.util.ArrayList;

public class InvestmentAccount extends Account{

        private double SecuritiesTotalValue;
        private ArrayList<Security> ownedSecurities=new ArrayList<>();
        private double commissionRate=7.95;
        private double accountTotalValue;

        public InvestmentAccount(int passedOwnerUserID) {
            super(passedOwnerUserID);
        }

        public InvestmentAccount(int passedOwnerUserID, String passedAccountName){
            super(passedOwnerUserID, passedAccountName);
        }

        public InvestmentAccount(int passedOwnerUserID, String passedAccountName,
                                 double passedCommissionRate){
            super(passedOwnerUserID, passedAccountName);
            commissionRate=passedCommissionRate;
        }
/*        public InvestmentAccount(int passedOwnerUserID, String passedAccountName,
                                 double passedCommissionRate,
                                 ArrayList<Security> passedOwnedSecurities){//For loading existing
            super(passedOwnerUserID, passedAccountName, passedOwnedSecurities);

            commissionRate=passedCommissionRate;

        } May implement given time. Requires building an Account constructor that accepts
          an argument of type ArrayList<Security> to load pre-existing information (ie, from file)*/

        public ArrayList<Security> getSecurityList(){
            return (ownedSecurities);
        }

        public void tradeSecurity (String passedName, double sharesToTrade){

        }

        private void buySecurity(String passedName, double sharesToTrade){

            boolean securityExists=false;

            for (int i=0; i<this.ownedSecurities.size(); i++)
            //Go through ownedSecurities and see if a security exists with passedName
            {
                if (!securityExists && passedName.equals(this.ownedSecurities.get(i).getName()))
                {
                    securityExists = true;
                    if (isCashAvailableToBuy(ownedSecurities.get(i).getValue() * sharesToTrade))
                    //if the security exists in our account already and we can afford it...
                    {
                        ownedSecurities.get(i).changeNumberOwned(sharesToTrade);
                        this.changeBalance(-1 *
                                (commissionRate + (sharesToTrade * ownedSecurities.get(i).getValue())));
                    }//... increase shares, decrease balance
                    break;//The security exists. Affordable or not, we don't need to look for it anymore
                }
            }

            if (!securityExists)
            //Should the security not exist, we need to create it to see if we can afford it.
            {
                Security security = generateSecurityToBuy(passedName, sharesToTrade);
                if (security!=null)
                //if security!=null, then we can afford it. Add to owned securities and debit the
                    //cash from the account
                {
                    ownedSecurities.add(security);
                    this.changeBalance(-1*(
                            (security.getValue()*sharesToTrade) + commissionRate) );
                }
            }

        }
        private Security generateSecurityToBuy(String passedName, double sharesToTrade){
            Security security = SecurityFactory.createSecurity(passedName, sharesToTrade);
            if (isCashAvailableToBuy(security.getValue() * sharesToTrade))
            {
                return security;
            }
            return null;
//Will create a Security (which generates its value).
// Test if commission+(costPerShare*numberOfShares) <= this.balance
// If yes, return the security and continue. If no, return null.
        }
        private boolean isCashAvailableToBuy(double cashRequiredToBuy){
            if ( (commissionRate+cashRequiredToBuy)>this.getBalance() ) {
                return false;
            }
            return true;
        }


}
