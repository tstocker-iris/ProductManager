package dendo.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    private JPanel mainPanel;
    private JTable table1;
    private JButton btnAdd;

    public Main() {
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new JFrame("Ajouter un produit");
                ProductForm productForm = new ProductForm();
                productForm.setParent(frame);

                frame.setContentPane(productForm.getMainPanel());

                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

                frame.setSize(400,300);

                frame.setVisible(true);
            }
        });
    }

    public static void main(String[] args) {
        JFrame frame = new JFrame("Gestionnaire de produit");
        Main panel = new Main();

        //panel.getTable1().setModel(getTableMode());

        frame.setContentPane(panel.mainPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        frame.setSize(400,300);

        //frame.pack();

        frame.setVisible(true);
    }
}
