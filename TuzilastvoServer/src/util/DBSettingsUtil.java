/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Properties;

/**
 *
 * @author  Aleksandar Randjelovic
 */
public class DBSettingsUtil {

    private Properties properties;
    private static DBSettingsUtil instance;

    private DBSettingsUtil() throws IOException {
        properties = new Properties();
        properties.load(new FileInputStream("dbsettings.properties"));
    }

    public static DBSettingsUtil getInstance() throws IOException {
        if (instance == null) {
            instance = new DBSettingsUtil();
        }
        return instance;
    }

    public String get(String key) {
        return properties.getProperty(key, "");
    }

    public void writeToConfigFile(String nazivBaze, String korisnickoIme, String sifra) {
        Properties prop = new Properties();
        OutputStream output = null;
        try {

            output = new FileOutputStream("dbsettings.properties");

            // set the properties value
            String driver = "com.mysql.jdbc.Driver";
            String url = "jdbc:mysql://localhost/";
            prop.setProperty("driver", driver);
            prop.setProperty("url", url+nazivBaze);
            prop.setProperty("user", korisnickoIme);
            prop.setProperty("password", sifra);

            // save properties to project root folder
            prop.store(output, null);
        } catch (IOException io) {
            io.printStackTrace();
        } finally {
            if (output != null) {
                try {
                    output.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
