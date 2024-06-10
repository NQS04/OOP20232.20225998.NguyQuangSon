package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuBarUtil {

    public static JMenuBar createMenuBar(JFrame frame, Store store) {
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Options");

        JMenuItem viewStoreItem = new JMenuItem("View Store");
        viewStoreItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPanel(frame, new StoreManagerScreen(store));
            }
        });
        menu.add(viewStoreItem);

        JMenu updateStoreMenu = new JMenu("Update Store");

        JMenuItem addBookItem = new JMenuItem("Add Book");
        addBookItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPanel(frame, new AddBookToStoreScreen(store));
            }
        });
        updateStoreMenu.add(addBookItem);

        JMenuItem addCDItem = new JMenuItem("Add CD");
        addCDItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPanel(frame, new AddCDToStoreScreen(store));
            }
        });
        updateStoreMenu.add(addCDItem);

        JMenuItem addDVDItem = new JMenuItem("Add DVD");
        addDVDItem.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                setPanel(frame, new AddDVDToStoreScreen(store));
            }
        });
        updateStoreMenu.add(addDVDItem);

        menu.add(updateStoreMenu);
        menuBar.add(menu);

        return menuBar;
    }

    private static void setPanel(JFrame frame, JPanel panel) {
        frame.getContentPane().removeAll();
        frame.getContentPane().add(panel);
        frame.revalidate();
        frame.repaint();
    }
}
