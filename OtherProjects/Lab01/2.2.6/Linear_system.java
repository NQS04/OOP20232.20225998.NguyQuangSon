import javax.swing.JOptionPane;

public class Linear_system {
    public void main(String[] args) {
        String Input_a11, Input_a12, Input_b1, Input_a21, Input_a22, Input_b2;
        Input_a11 = JOptionPane.showInputDialog(null, "Enter a11: ");
        Input_a12 = JOptionPane.showInputDialog(null, "Enter a12: ");
        Input_b1 = JOptionPane.showInputDialog(null, "Enter b1: ");
        Input_a21 = JOptionPane.showInputDialog(null, "Enter a21: ");
        Input_a22 = JOptionPane.showInputDialog(null, "Enter a22: ");
        Input_b2 = JOptionPane.showInputDialog(null, "Enter b2: ");
        double a11 = Double.parseDouble(Input_a11);
        double a12 = Double.parseDouble(Input_a12);
        double b1 = Double.parseDouble(Input_b1);
        double a21 = Double.parseDouble(Input_a21);
        double a22 = Double.parseDouble(Input_a22);
        double b2 = Double.parseDouble(Input_b2);

        double D = a11*a22 - a21*a12, Dx = b1*a22-b2*a12, Dy = a11*b2-a21*b1;
        
        String message = "";
        if (D == 0) {
            if (a21/a11 == b2/b1) message += "Infinity Solution";
            else message += "No Solution";
        }
        else message += "x1 = " + Dx/D + "\nx2 = " + Dy/D;

        JOptionPane.showMessageDialog(null, message, "Linear System", JOptionPane.INFORMATION_MESSAGE);
        System.exit(0);
    }
}