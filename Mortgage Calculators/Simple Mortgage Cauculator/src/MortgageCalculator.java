import java.text.NumberFormat;
import java.util.Scanner;

public class MortgageCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        int principal;
        float annualInterest;
        byte period;

        while (true) {
            System.out.print("Principal: ");
            principal = scanner.nextInt();
            if (principal >= 1000 && principal <= 10_000_000)
                break;
            System.out.println("Enter amount between $1,000 and $10,000,000");
        }

        while (true) {
            System.out.print("Annual Interest Rate: ");
            annualInterest = scanner.nextFloat();
            if (annualInterest >= 1 && annualInterest <= 30)
                break;
            System.out.println("Enter amount between 1 and 30");
        }

        while (true) {
            System.out.print("Period (years): ");
            period = scanner.nextByte();
            if (period >=1 && period <= 30)
                break;
            System.out.println("Enter between 1 and 30 years");
        }

        float MONTHLY_INTEREST = annualInterest / MONTHS_IN_YEAR / PERCENTAGE;
        short PAYMENT_MONTHS = (short) (period * MONTHS_IN_YEAR);
        double a = Math.pow((1+MONTHLY_INTEREST), PAYMENT_MONTHS); // Constant in mortgage formula
        double mortgage = principal * ((MONTHLY_INTEREST * a)/ (a - 1)); // Mortgage formula
        String MORTGAGE = NumberFormat.getCurrencyInstance().format(mortgage);
        System.out.println("Mortgage: " + MORTGAGE);
    }
}