class Account {
    String name;
    protected double balance;
    String accNo;

    public Account (String name,String accNo, double balance) {
        this.name=name;
        this.balance=balance;
        this.accNo=accNo;
    }

    void withdraw (double amount){
        if(balance-amount>=1000&&amount<this.balance){
           this.balance-=amount;
        }
        else{
            System.err.println("Insufficient funds!");
        }
    }
    void deposit(double amount){
        balance+=amount;
        System.out.println("Deposited "+amount);
    }

    void display(){
        System.out.println("Name: "+name);
        System.out.println("Balance: "+balance);
        System.out.println("Account No: "+accNo);
    }
}
class savings extends Account {
    double fixedDeposit;
    double FD_money=0.00;
    public savings(String name, String accNo, double balance) {
        super(name, accNo, balance);
    }
    void transaction(double amount){
        if(amount<=50000) {
            super.withdraw(amount);
            System.out.println("Transaction amount:"+amount+"\tBalance :"+(balance));
        }
        else{
            System.out.println("transaction limit exceeded");
        }
    }

    void FD(double fixedDeposit,int years){
        if(years>=2) {
            final float interest = 0.0825f;
            int months = years * 12;
            display();
            System.out.println(":Fixed Deposited created\nAmount:"+fixedDeposit+"\nTenure:"+years+"\nInterest per annum:"+interest*100);
            fixedDeposit += fixedDeposit * (interest / 12);
            FD_money+=fixedDeposit;
            super.withdraw(fixedDeposit);
        }
        else{
            System.out.println("minimum number of years required for an FD");
            }
    }
}
class current extends Account {
    final static double overDraftLimit=-10000;
    public current (String name, String accNo, double balance) {
        super(name, accNo, balance);
    }
    void withdraw(double amount){
        final double current_interest=0.05;
        if(balance<amount && balance>overDraftLimit){
            System.out.println("Overdraft! Applying penalty...");
            System.out.println("transaction amount:"+amount);
            System.out.println("Penalty("+current_interest*100+"%):"+amount*(current_interest));
            balance-=amount+(amount*(current_interest));
        }
        else{
            balance-=amount;
            System.out.println("transaction amount:"+amount);
        }
    }
}
