/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Compagnie.tests;

import Compagnie.Entities.CompagnieModel;
import Compagnie.services.CompagnieService;
import Compagnie.tools.DBConnexion;

/**
 *
 * @author Anis
 */
public class Compagnie {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
     DBConnexion mc = DBConnexion.getInstance();
        
        //CompagnieModel C1 = new CompagnieModel("DR","Tunisie", "tuni.com", "France", 1061045873, "TORONTO", "Otawa",11,12,15, "It's Air CANADA enjoy the FLy");
        CompagnieService CS = new CompagnieService();
        //CS.ajouterCompagnie2(C1);
        //CS.updateCompagnie(C1,"DR");
        CS.supprimerCompagnie("DR");
        System.out.println(CS.afficherCompagnie());;
    }
}
