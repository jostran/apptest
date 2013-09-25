/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package view.frame;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.text.MaskFormatter;

/**
 *
 * @author Tran Xuan Truong
 */
public class Test extends JFrame {

    JTextField txtfeild;
    JButton buton;
    JFormattedTextField textField;
    JFormattedTextField field;
    MaskFormatter mf;
    Matcher m;
    Pattern p;

    public Test() {
        setTitle("demo");
        setSize(400, 400);
        setDefaultCloseOperation(3);
        setLayout(new FlowLayout());
        txtfeild = new JTextField(15);
        buton = new JButton("Click");

        add(buton);
        add(txtfeild);

        String patten = "(\\d{4})-(([0-9])|(1[0-2]))-(([0-1][0-9])|(2[0-9]|(3[01])))";
//        String patten = "([0-9][0-9])|([0-9])|([0-9][0-9][0-9])";

        p = Pattern.compile(patten);


        buton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent ae) {
                m = p.matcher(txtfeild.getText());
                if (m.matches()) {
                    System.out.println("ok");
                } else {
                    JOptionPane.showMessageDialog(null, "Ban Phai nhap nam-thang-ngay");
                }
            }
        });

        setVisible(true);
    }

    void xxx() {
        try {
//            mf = new MaskFormatter("####-##-##");
//            mf.setPlaceholderCharacter('_');
            field = new JFormattedTextField(new SimpleDateFormat("MM/dd/yy"));

        } catch (Exception ex) {
            Logger.getLogger(Test.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public static void main(String[] args) {
        new Test();
    }
}
