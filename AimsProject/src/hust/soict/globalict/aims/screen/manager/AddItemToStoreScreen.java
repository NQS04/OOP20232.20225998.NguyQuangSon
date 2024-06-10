package hust.soict.globalict.aims.screen.manager;

import hust.soict.globalict.aims.store.Store;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.*;

public abstract class AddItemToStoreScreen extends JPanel {
    protected JTextField tfTitle, tfCategory, tfCost;
    public Store store;
    public AddItemToStoreScreen(Store store) {
        this.store = store;
        setLayout(new BorderLayout());
        add(createFormPanel(), BorderLayout.CENTER);
        add(createButtonPanel(), BorderLayout.SOUTH);
        
    }

    private JPanel createFormPanel() {
        JPanel panel = new JPanel(new GridLayout(4, 2));

        panel.add(new JLabel("Enter the title:"));
        tfTitle = new JTextField();
        panel.add(tfTitle);

        panel.add(new JLabel("Enter the category:"));
        tfCategory = new JTextField();
        panel.add(tfCategory);

        panel.add(new JLabel("Enter the cost:"));
        tfCost = new JTextField();
        panel.add(tfCost);

        addSpecificFields(panel);

        return panel;
    }

    private JPanel createButtonPanel() {
        JPanel panel = new JPanel();
        JButton addButton = new JButton("Add");
        addButton.addActionListener(e -> addItemToStore());
        panel.add(addButton);
        return panel;
    }
    protected abstract void addSpecificFields(JPanel panel);

    protected abstract void addItemToStore();

}

