import javax.swing.JOptionPane;

public class Linear_equation {
    public void main(String[] args) {
        String input1, input2;
        input1 = JOptionPane.showInputDialog(null, "Plese enter the value a: ");
        input2 = JOptionPane.showInputDialog(null, "Plese enter the value b: ");
        double a = Double.parseDouble(input1);
        double b = Double.parseDouble(input2);
        String message = "";
        if (a == 0) {
            if (b == 0) message += "Infinitive Solution";
            else message += "No Solution";
        }
        else message += "x = " + (-b/a);
        JOptionPane.showMessageDialog(null, message,
                              "Linear_equation", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}