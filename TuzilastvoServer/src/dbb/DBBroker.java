/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbb;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import model.OpstiDomenskiObjekat;

import util.DBSettingsUtil;

/**
 *
 * @author Aleksandar Randjelovic
 */
public class DBBroker {

    private static DBBroker instance;
    private Connection conn;

    private DBBroker() {
    }

    public static DBBroker getInstance() {
        if (instance == null) {
            instance = new DBBroker();
        }
        return instance;
    }

    public void ucitajDriver() throws Exception {
        try {
            String className = DBSettingsUtil.getInstance().get("driver");
            Class.forName(className);
        } catch (ClassNotFoundException ex) {
            throw new Exception("Neuspesno ucitavanje drivera!", ex);
        }
    }

    public void otvoriKonekciju() throws Exception {
        try {
            conn = DriverManager.getConnection(DBSettingsUtil.getInstance().get("url"), DBSettingsUtil.getInstance().get("user"), DBSettingsUtil.getInstance().get("password"));
            conn.setAutoCommit(false);
        } catch (SQLException ex) {
            throw new Exception("Neuspesno otvaranje konekcije!", ex);
        }
    }

    public void commitTransakcije() throws Exception {
        try {
            conn.commit();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan commit transakcije!", ex);
        }
    }

    public void rollbackTransakcije() throws Exception {
        try {
            conn.rollback();
        } catch (SQLException ex) {
            throw new Exception("Neuspesan rollback transakcije!", ex);
        }
    }

    public void zatvoriKonekciju() throws Exception {
        try {
            conn.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno zatvaranje konekcije!", ex);
        }
    }

    public void sacuvaj(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "INSERT INTO " + odo.vratiNazivTabele() + " VALUES (" + odo.vratiVrednostiZaInsert() + ")";
            System.out.println(sql);
            Statement sqlStatement = conn.createStatement();
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } catch (SQLException ex) {
            throw new Exception("Neuspesno cuvanje objekta!", ex);
        }
    }

    public List<OpstiDomenskiObjekat> vratiSve(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele() + odo.vratiUslovZaSortiranje();
            System.out.println(sql);
            Statement sqlStatement = conn.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return odo.ucitaj(rs);
        } catch (Exception ex) {
            throw new Exception("Neuspesno ucitavanje objekata!", ex);
        }
    }
    
    public List<OpstiDomenskiObjekat> vratiSveJoin(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele() + " " + odo.vratiVrednostiZaJoin();
            System.out.println(sql);
            Statement sqlStatement = conn.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return odo.ucitaj(rs);
        } catch (Exception ex) {
            throw new Exception("Neuspesno ucitavanje objekata sa JOIN uslovom!", ex);
        }
    }

    public boolean logovanje(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele() + " WHERE " + odo.vratiUslovZaLogin();
            System.out.println(sql);
            Statement sqlStatement = conn.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return rs.next();
        } catch (Exception ex) {
            throw new Exception("Neuspesan login!", ex);
        }
    }

    public void obrisi(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "DELETE FROM " + odo.vratiNazivTabele() + " WHERE" + odo.vratiUslovZaBrisanje();
            System.out.println(sql);
            Statement sqlStatement = conn.createStatement();
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } catch (Exception ex) {
            throw new Exception("Neuspesno brisanje objekta!", ex);
        }
    }

    public void izmeni(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "UPDATE " + odo.vratiNazivTabele() + " SET " + odo.vratiVrednostiZaUpdate();
            System.out.println(sql);
            Statement sqlStatement = conn.createStatement();
            sqlStatement.executeUpdate(sql);
            sqlStatement.close();
        } catch (Exception ex) {
            throw new Exception("Neuspesna izmena objekta! ", ex);
        }
    }
    
     public void proveriUslov(OpstiDomenskiObjekat odo) throws Exception {
        try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele() + " " + odo.vratiUslovZaProveru();
            System.out.println(sql);
            Statement sqlStatement = conn.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            if(rs.next()) {
                throw new Exception("Objekat ne moze da se obrise!");
            }
        } catch (Exception ex) {
            throw ex;
        }
    }
     
     public boolean proveriDaLiPostoji(OpstiDomenskiObjekat odo) throws Exception {
       try {
            String sql = "SELECT * FROM " + odo.vratiNazivTabele() + " " + odo.vratiUslovZaProveru();
            System.out.println(sql);
            Statement sqlStatement = conn.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            return rs.next();
        } catch (Exception ex) {
            throw new Exception("Ne postoji u bazi!", ex);
        }
    }
}
