public class Account {
    Client owner;

    double balance;

    int id;

    String agency;

    double limit;

    Transaction[] transaction;

    int transactionCounter;

    //Constructor
    public Account(Client owner, double balance, int id, String agency){
        this.owner = owner;
        this.balance = balance;
        this.id = id;
        this.agency = agency;
        this.limit = balance*10;
        this.transaction = new Transaction[1000];
        this.transactionCounter=0;
    }

    //Alter functions 
    boolean deposit(double amount){

        if (amount>0){
            this.balance+=amount;
            this.transaction[transactionCounter]=new Transaction('d', amount);
            this.transactionCounter++;
        }

        return amount > 0;
    }

    boolean withdraw(double amount){
        if(amount>0 && amount<this.balance){
            this.balance-=amount;
            this.transaction[transactionCounter]=new Transaction('w', amount);
            this.transactionCounter++;
        }

        return (amount > 0 && amount<this.balance);
    }

    boolean transfer(Account destinyAccount, double amount){
        if(this.withdraw(amount)){
            return destinyAccount.deposit(amount);
        }else {
            return false;
        }

    }

    //Display functions
    void print(){
        this.owner.printClient();
        System.out.printf("ID: %d\nAgency: %s\nCurrent balance: $%.2f\nLimit: $%.2f\n", this.id, this.agency, this.balance, this.limit);
    }

    void printStatemant() {
        for (int i = 0; i < transactionCounter; i++) {
                transaction[i].statemant();
        }
    }
    

}
