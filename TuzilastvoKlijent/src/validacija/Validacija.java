/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package validacija;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class Validacija {

    public static boolean validateField(JTextField f, JLabel label, String errormsg) {
        if (f == null || f.getText().equals("")) {
            return failedMessage(f, label, errormsg);
        } else {
            return true; // validation successful
        }
    }
    
    public static boolean validateTextAreaField(JTextArea f, JLabel label, String errormsg) {
        if (f == null || f.getText().equals("")) {
            return failedMessage(f, label, errormsg);
        } else {
            return true; // validation successful
        }
    }

    public static boolean validateInteger(JTextField f, JLabel label, String errormsg, int count, String vrstaProvere) {
        try {  // try to convert input to integer
            int i = Integer.parseInt(f.getText());

            // if it is, success
            if (vrstaProvere.equals("vece")) {
                if (Integer.parseInt(f.getText()) > count) {
                    return true; // success, validation succeeded
                } 
            } else {
                if (f.getText().length() == count) {
                    return true; // success, validation succeeded
                }
            }

        } catch (Exception e) {
            // if conversion failed, or input was <= 0,
            // fall-through and do final return below
        }
        return failedMessage(f, label, errormsg + " " + count);
    }

    public static boolean failedMessage(JTextField f, JLabel label, String errormsg) {
        label.setText(errormsg);
        label.setForeground(Color.red);
        f.requestFocus(); // set focus on field, so user can change
        return false; // return false, as validation has failed
    }

    public static boolean failedMessage(JTextArea jtxArea, JLabel label, String errormsg) {
        label.setText(errormsg);
        label.setForeground(Color.red);
        jtxArea.requestFocus(); // set focus on field, so user can change
        return false; // return false, as validation has failed
    }

    public static boolean validateField(JTextArea jtxArea, JLabel jLabel, String errormsg) {
        if (jtxArea == null || jtxArea.getText().equals("")) {
            return failedMessage(jtxArea, jLabel, errormsg);
        } else {
            return true; // validation successful
        }
    }

    public static boolean validateDouble(JTextField f, JLabel jlabel, String errormsg) {
        try {
            Double.parseDouble(f.getText());
            return true;
        } catch (Exception e) {
        }
        return failedMessage(f, jlabel, errormsg);

    }

}
