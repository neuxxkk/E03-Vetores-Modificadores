import java.text.SimpleDateFormat;
import java.util.Date;

public class Transaction {

    Date date;

    char transaction;

    double amount;

    public Transaction(char transaction, double amount) {
        this.transaction = transaction;
        this.amount = amount;
        this.date = new Date();

    }

    void statemant(){

        SimpleDateFormat formatter = new SimpleDateFormat("EEE MMM dd HH:mm:ss zzz yyyy");

        String dataFormatada = formatter.format(date);

        System.out.printf("\n%s %c %.2f",dataFormatada, this.transaction, this.amount);
    }

}