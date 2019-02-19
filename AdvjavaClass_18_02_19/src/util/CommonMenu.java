package util;

import commonMenu.About;
import commonMenu.Dashboard;
import commonMenu.LogIn;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.KeyStroke;

public class CommonMenu {
    
    public static JMenuBar getCommonMenu(JFrame f) {
        JMenuBar menuBar = new JMenuBar();
        JMenu file = new JMenu("File");
        JMenuItem itemDashboard = new JMenuItem("Dashboard");
        itemDashboard.setAccelerator(KeyStroke.getKeyStroke('D', InputEvent.CTRL_DOWN_MASK));
        
        itemDashboard.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new Dashboard().setVisible(true);
            }
        });
        
        JMenuItem itemAbout = new JMenuItem("About");
        itemAbout.setAccelerator(KeyStroke.getKeyStroke('A', InputEvent.CTRL_DOWN_MASK));
        
        itemAbout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new About().setVisible(true);
            }
        });
        
        JMenuItem itemLogout = new JMenuItem("Logout");
        itemLogout.setAccelerator(KeyStroke.getKeyStroke('L', InputEvent.CTRL_DOWN_MASK));
        
        itemLogout.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                new LogIn().setVisible(true);
            }
        });
        
        JMenu help = new JMenu("Help");

        //Add 3 menu item at file menu
        file.add(itemDashboard);
        file.add(itemAbout);
        file.add(itemLogout);
        //Adding menu at menubar
        menuBar.add(file);
        menuBar.add(help);
        f.setJMenuBar(menuBar);
        f.setExtendedState(JFrame.MAXIMIZED_BOTH);
        
        return menuBar;
    }
}
