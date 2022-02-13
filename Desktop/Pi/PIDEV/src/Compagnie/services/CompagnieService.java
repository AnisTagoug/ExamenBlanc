/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie.services;

import Compagnie.Entities.CompagnieModel;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import Compagnie.tools.DBConnexion;
/**
 *
 * @author Anis
 */
public class CompagnieService {
    Connection cnx;

    public CompagnieService() {
        cnx=DBConnexion.getInstance().getCnx();
    }
    public void ajouterCompagnie(CompagnieModel C){
        String sql="INSERT INTO `compagnie`(`Code_IATA`, `NomCom`, `Link`,`Pays`, `Number`, `Siege`, `AeBase`, `PassagerNum`, `PoidsM`, `PoidsS`, `Description`) VALUES ('"+C.getCode_IATA()+"','"+C.getNomCom()+"','"+C.getLink()+"','"+C.getPays()+"','"+C.getNumber()+"','"+C.getSiege()+"','"+C.getAeBase()+"','"+C.getPassagerNum()+"','"+C.getPoidsM()+"','"+C.getPoidsS()+"','"+C.getDescription()+"')";
        try {
            Statement ste = cnx.createStatement();
            ste.executeUpdate(sql);
            System.out.println("Compagnie Ajoutee");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        
    }
    public void ajouterCompagnie2(CompagnieModel C){
        String sql="insert into compagnie(Code_IATA,NomCom,Link,Pays,Number,Siege,AeBase,PassagerNum,PoidsM,PoidsS,Description) values(?,?,?,?,?,?,?,?,?,?,?)";
        try {
            PreparedStatement ste= cnx.prepareStatement(sql);
            ste.setString(1, C.getCode_IATA());
            ste.setString(2, C.getNomCom());
            ste.setString(3, C.getLink());
            ste.setString(4, C.getPays());
            ste.setInt(5, C.getNumber());
            ste.setString(6, C.getSiege());
            ste.setString(7, C.getAeBase());
            ste.setFloat(8, C.getPassagerNum());
            ste.setFloat(9, C.getPoidsM());
            ste.setFloat(10, C.getPoidsS());
            ste.setString(11, C.getDescription());
            ste.executeUpdate();
            System.out.println("Compagnie Ajoutée");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void updateCompagnie(CompagnieModel C,String Code_IATA){
        String sql="update compagnie set Code_IATA=?,NomCom=?,Link=?,Pays=?,Number=?,Siege=?,AeBase=?,PassagerNum=?,PoidsM=?,PoidsS=?,Description=?  where Code_IATA=?";
        try {
            PreparedStatement ste= cnx.prepareStatement(sql);
            ste.setString(1, C.getCode_IATA());
            ste.setString(2, C.getNomCom());
            ste.setString(3, C.getLink());
            ste.setString(4, C.getPays());
            ste.setInt(5, C.getNumber());
            ste.setString(6, C.getSiege());
            ste.setString(7, C.getAeBase());
            ste.setFloat(8, C.getPassagerNum());
            ste.setFloat(9, C.getPoidsM());
            ste.setFloat(10, C.getPoidsS());
            ste.setString(11, C.getDescription());
            ste.setString(12, Code_IATA);
            ste.executeUpdate();
            System.out.println("Compagnie updated");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
    }
    public void supprimerCompagnie(String Code_IATA) {
        try {
          String sql = "DELETE FROM compagnie WHERE Code_IATA=?";
          PreparedStatement ste  = cnx.prepareStatement(sql);
          ste.setString(1,Code_IATA);
          ste.executeUpdate();
          System.out.println("Compagnie Supprimée ");} 
        catch(SQLException ex) {
         System.out.println(ex.getMessage());
        }                       
    }
    public List<CompagnieModel> afficherCompagnie(){
        List<CompagnieModel> Compagnies = new ArrayList<>();
        String query="select * from compagnie";
        try {
            PreparedStatement ste = cnx.prepareStatement(query);
            ResultSet rs= ste.executeQuery();
            while(rs.next()){
                CompagnieModel C = new CompagnieModel();               
                C.setCode_IATA(rs.getString("Code_IATA"));
                C.setNomCom(rs.getString("NomCom"));
                C.setLink(rs.getString("Link"));
                C.setPays(rs.getString("Pays"));
                C.setNumber(rs.getInt("Number"));
                C.setSiege(rs.getString("Siege"));
                C.setAeBase(rs.getString("AeBase"));
                C.setPassagerNum(rs.getFloat("PassagerNum"));
                C.setPoidsM(rs.getFloat("PoidsM"));
                C.setPoidsS(rs.getFloat("PoidsS"));
                C.setDescription(rs.getString("Description"));
                Compagnies.add(C);
                
            }
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return Compagnies;
        
    }
}
