import javax.swing.JOptionPane;
public class quadratic_equation {
    public void main(String[] args) {
        String input_a, input_b, input_c;
        input_a = JOptionPane.showInputDialog(null, "Enter a: ");
        input_b = JOptionPane.showInputDialog(null, "Enter b: ");
        input_c = JOptionPane.showInputDialog(null, "Enter c: ");

        double a = Double.parseDouble(input_a);
        double b = Double.parseDouble(input_b);
        double c = Double.parseDouble(input_c);
        String message = "";
        if (a == 0) {
            if (b == 0) {
                if (c == 0) message += "Infinity Solution";
                else message += "No Solution";
            }
        }
        else {
            double delta = b*b - 4*a*c;
            if (delta < 0) message += "No Solution";
            else if (delta == 0) message += "x = " + (-b/2*a);
            else message += "x1 = " + ((-b-Math.sqrt(delta))/2*a) +
                            "x2 = " + ((-b+Math.sqrt(delta))/2*a);
        }
        JOptionPane.showMessageDialog(null, message, "Quadratic equation", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);   
    }
}