package csvimportexport;

import javax.swing.JFrame;

/**
 *
 * @author Luca Mezzolla
 */
public class MainClass {
    
    public static void main(String[] args) {
        run();
    }
    
    public static void run() {
        Frame frame = new Frame();
        frame.setLocationRelativeTo(null);
        frame.setExtendedState(JFrame.MAXIMIZED_BOTH);
        frame.setVisible(true);
    }

}
