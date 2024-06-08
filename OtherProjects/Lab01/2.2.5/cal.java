import javax.swing.JOptionPane;

public class cal {
    public static void main(String[] arg) {
        String strNum1, strNum2;
        // Read in 2 numbers
        strNum1 = JOptionPane.showInputDialog(null, "Enter the first num: ");
        strNum2 = JOptionPane.showInputDialog(null, "Enter the second num: ");
        // Convert String to double
        double num1 = Double.parseDouble(strNum1);
        double num2 = Double.parseDouble(strNum2);
        String message = "Sum: " + (num1+num2) + "\nDifference: " + (num1-num2) +
                        "\nProduct: " + (num1*num2);
        if (num2 == 0) message += "\nDivision : Fail";
        else message += "\nDivision: " + (num1/num2);

        JOptionPane.showMessageDialog(null, message);
        System.exit(0);
    }
}
