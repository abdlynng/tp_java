/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author an
 */
public class Serveur {
    
    public static void main(String ar[]){
        
        try {
            ServerSocket ss = new ServerSocket(5000);
            System.out.println("Demarrage du serveur \n ....attente d'un client \n......");
            Socket s= ss.accept();
            System.out.println("connexion client reussi");
            //flux qui gere les données recues depuis le client 
            InputStream is = s.getInputStream();
            InputStreamReader isr = new InputStreamReader(is);
            BufferedReader br= new BufferedReader(isr);
            
            //flux qui gere l'envoie vers le client 
            OutputStream os = s.getOutputStream();            
            PrintWriter pw = new PrintWriter(os,true);
            
            //recuperation de la valeur 1
            Double valeur1 = Double.parseDouble(br.readLine());
            //recuperation de la valeur 2
            Double valeur2 = Double.parseDouble(br.readLine());
            //recperation de l'operateur
            String operateur = br.readLine();
            
            //les cas de resultat possible en fonction de l'operateur
            //ainsi que le renvoi du resultat au client avec l'objet pw de PrintWriter
            switch (operateur){
               case "+": pw.println(valeur1+valeur2);
               case "*": pw.println(valeur1*valeur2);
               case "/": pw.println(valeur1/valeur2);
               case "-": pw.println(valeur1-valeur2);
               default : pw.println("operation impossible");
           }
                      
            System.out.println("Traitement Reussi");
            s.close(); //on ferme le socket
            
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}
