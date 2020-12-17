package dendo.gui;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class ProductForm {
    private JPanel mainPanel;
    private JTextField txtProductName;
    private JLabel lblProductName;
    private JTextField txtDescription;
    private JTextField txtPrice;
    private JLabel lblError;
    private JButton btnAdd;
    private JLabel lblDescription;
    private JLabel lblPrice;

    private JFrame parent;

    public JFrame getParent()
    {
        return parent;
    }

    public void setParent(JFrame pParent)
    {
        this.parent = pParent;
    }

    public ProductForm() {
        ProductForm self = this;
        btnAdd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String name = txtProductName.getText();
                String description = txtProductName.getText();
                String price = txtPrice.getText();
                try
                {
                    // create a mysql database connection
                    String myDriver = "com.mysql.cj.jdbc.Driver";
                    String myUrl = "jdbc:mysql://localhost:3390/ecommerce";
                    Class.forName(myDriver);
                    Connection conn = DriverManager.getConnection(myUrl, "root", "example");

                    // the mysql insert statement
                    String query = " insert into product (name, description, price)"
                            + " values (?, ?, ?)";

                    // create the mysql insert preparedstatement
                    PreparedStatement preparedStmt = conn.prepareStatement(query);
                    preparedStmt.setString (1, name);
                    preparedStmt.setString (2, description);
                    preparedStmt.setString(3, price);

                    // execute the preparedstatement
                    preparedStmt.execute();

                    JOptionPane.showMessageDialog(null, "Élément inséré avec succès");

                    txtProductName.setText("");
                    txtDescription.setText("");
                    txtPrice.setText("");
                    //self.getParent().dispose();

                    conn.close();
                }
                catch (Exception e)
                {
                    System.err.println("Got an exception!");
                    System.err.println(e.getMessage());
                    lblError.setText(e.getMessage());
                }

            }
        });
    }

    public JPanel getMainPanel()
    {
        return this.mainPanel;
    }
}
