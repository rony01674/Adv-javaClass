package bookEvent;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.SwingUtilities;

public class Sketcher implements WindowListener {

    private SketchFrame window;
    private static Sketcher theApp;

    public static void main(String[] args) {

        theApp = new Sketcher();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                theApp.createGUI();
            }
        });
    }

    private void createGUI() {
        window = new SketchFrame("Sketcher");
        Toolkit theKit = window.getToolkit();
        Dimension winSize = theKit.getScreenSize();

        window.setBounds(winSize.width / 4, winSize.height / 4, winSize.width / 2, winSize.height / 2);
        window.addWindowListener(this);
        window.setVisible(true);
    }

    @Override
    public void windowClosing(WindowEvent e) {
        window.dispose();
        System.exit(0);
    }

    public void windowOpened(WindowEvent e) {
        System.out.println("windowOpened");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.println("windowClosed");

    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.println("windowIconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.println("windowDeiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
        System.out.println("windowActivated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.println("windowDeactivated");
    }

}
