package MainProject;


import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class CORSwingApp {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            try { UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName()); }
            catch (Exception ignored) { }
            new CORInputFrame().setVisible(true);
        });
    }
}
