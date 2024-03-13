import javax.swing.JOptionPane;

public class run {
    public static void main(String[] args) {

        //Choose types of equation:
        String option;
        String message = "1.Linear_equation" + "\n2.Linear_system" + "\n3.Quadratic_equation" + "\n4.Exit";
        while (true) {
            int type = 0;
            try{
                option = JOptionPane.showInputDialog(null, message,
                "Choose type of equation: ", JOptionPane.INFORMATION_MESSAGE);
                type = Integer.parseInt(option);
            } catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null, "Error, pls try again!");
            }
            //Create object of optional classes
            switch (type) {
                case 1:
                    Linear_equation lfx = new Linear_equation();
                    lfx.main(args);
                    break;
                case 2:
                    Linear_system sfx = new Linear_system();
                    sfx.main(args);
                    break;
                case 3:
                    quadratic_equation qfx = new quadratic_equation();
                    qfx.main(args);
                    break;
                case 4:
                    System.exit(0);
                default:
                    break;
            }
        }
    }
}
