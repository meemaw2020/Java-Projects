import java.text.NumberFormat;
import javax.swing.JOptionPane;

public class MortgageCalculatorWithJOptionPane {
    public static void main(String[] args) {

        final byte MONTHS_IN_YEAR = 12;
        final byte PERCENTAGE = 100;

        int principal = 0;
        float annualInterest = 0;
        byte period = 0;

        while (true) {
            principal = Integer.parseInt(JOptionPane.showInputDialog("Principal"));
            if (principal >= 1000 && principal <= 10_000_000)
                break;
            JOptionPane.showMessageDialog(null, "Enter amount between $1,000 and $10,000,000");
        }

        while (true) {
            annualInterest = Float.parseFloat(JOptionPane.showInputDialog("Annual Interest Rate"));
            if (annualInterest >= 1 && annualInterest <= 30)
                break;
            JOptionPane.showMessageDialog(null, "Enter amount between 1 and 30");
        }

        while (true) {
            period = Byte.parseByte(JOptionPane.showInputDialog("Period (years)"));
            if (period >=1 && period <= 30)
                break;
            JOptionPane.showMessageDialog(null, "Enter between 1 and 30 years");
        }

        float MONTHLY_INTEREST = annualInterest / MONTHS_IN_YEAR / PERCENTAGE;
        short PAYMENT_MONTHS = (short) (period * MONTHS_IN_YEAR);
        double a = Math.pow((1+MONTHLY_INTEREST), PAYMENT_MONTHS); // Constant in mortgage formula
        double mortgage = principal * ((MONTHLY_INTEREST * a)/ (a - 1)); // Mortgage formula
        String MORTGAGE = NumberFormat.getCurrencyInstance().format(mortgage);
        JOptionPane.showMessageDialog(null, "Your mortgage is " + MORTGAGE);


    }
}