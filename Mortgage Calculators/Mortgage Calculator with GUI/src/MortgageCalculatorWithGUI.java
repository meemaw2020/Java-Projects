import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.NumberFormat;

public class MortgageCalculatorWithGUI extends JPanel implements ActionListener {

    final byte MONTHS_IN_YEAR = 12;
    final byte PERCENTAGE = 100;

    JButton calculateButton;
    JPanel panel;
    JFrame frame;
    JLabel principalLabel;
    JLabel annualInterestLabel;
    JLabel periodLabel;
    JLabel mortgageLabel;

    String principalString = "Principal: ";
    String annualInterestString = "Annual Interest: ";
    String periodString = "Years: ";
    String mortgageString = "Your mortgage is ";

    JTextField principalField;
    JTextField annualInterestField;
    JTextField periodField;
    JTextField mortgageField;

    Font myFont = new Font("Arial", Font.BOLD, 15);

    public MortgageCalculatorWithGUI() {

        frame = new JFrame("Mortgage Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,555);
        frame.setResizable(false);
        frame.setLayout(null);


        calculateButton = new JButton("Calculate");
        calculateButton.addActionListener(this);
        calculateButton.setFont(myFont);
        calculateButton.setFocusable(false);
        calculateButton.setBounds(152,430,120,50);


        principalLabel = new JLabel(principalString);
        annualInterestLabel = new JLabel(annualInterestString);
        periodLabel = new JLabel(periodString);
        mortgageLabel = new JLabel(mortgageString);

        principalField = new JTextField();
        annualInterestField = new JTextField();
        periodField = new JTextField();
        mortgageField = new JTextField();
        mortgageField.setEditable(false);


        panel = new JPanel();
        panel.setBounds(50,50,300,300);
        panel.setLayout(new GridLayout(4,2,50,50));

        panel.add(principalLabel);
        panel.add(principalField);
        panel.add(annualInterestLabel);
        panel.add(annualInterestField);
        panel.add(periodLabel);
        panel.add(periodField);
        panel.add(mortgageLabel);
        panel.add(mortgageField);

        frame.add(panel);
        frame.add(calculateButton);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new MortgageCalculatorWithGUI();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == calculateButton) {
            float annualInterest = Float.parseFloat(annualInterestField.getText());
            int principal = Integer.parseInt(principalField.getText());
            byte period = Byte.parseByte(periodField.getText());

            double MONTHLY_INTEREST = annualInterest / MONTHS_IN_YEAR / PERCENTAGE;
            short PAYMENT_MONTHS = (short) (period * MONTHS_IN_YEAR);
            double a = Math.pow((1+MONTHLY_INTEREST), PAYMENT_MONTHS); // Constant in mortgage formula
            double mortgage = principal * ((MONTHLY_INTEREST * a)/ (a - 1)); // Mortgage formula
            String MORTGAGE = NumberFormat.getCurrencyInstance().format(mortgage);
            mortgageField.setText(String.valueOf(MORTGAGE));
        }
    }
}
