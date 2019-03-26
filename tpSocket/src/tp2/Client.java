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
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author an
 */
public class Client {
    
    public static void main(String arg[]){
        
        try {
            // declaration du socket
            Socket s = new Socket("localhost",5000);
            InputStream is= s.getInputStream(); //relative a la reception de donnée depuis le serveur 
            OutputStream os= s.getOutputStream();//relative l'emission de donnée vers le serveur
            InputStreamReader isr = new InputStreamReader(is);//flux de chaine de caractere entrante
            
            //buffer pour temporiser le flux et en traiter le max possible 
            //permet de recuperer les données depuis le serveur 
            BufferedReader br = new BufferedReader(isr);
            
            //flux pour envoyer les données vers le serveur 
            PrintWriter pw = new PrintWriter(os,true);
            
            // pour la saisie depuis le terminal 
            Scanner sc = new Scanner(System.in);
            
            // premier operande 
            System.out.print("Donner la valeur 1 => ");
            Double nombre1 = sc.nextDouble();// on affecte de la valeur renseigné par l'utilisateur
            pw.println(nombre1); //on envoie la valeur 1 au niveau du serveur 
            
            // deuxieme operande 
            System.out.print("donner la valeur 2 => ");
            Double nombre2=sc.nextDouble();
            pw.println(nombre2);
            sc.nextLine(); // pour assurer le retour a la ligne apres la saisie des 2 valeurs
            
            System.out.print("choisir l'operation \n"
                    + "+ Addition "
                    + "\n*. Multiplication"
                    + "\n/. Division"
                    + "\n-. Soustraction "
                    + "\n : ");
            String  operateur = sc.nextLine();
            pw.println(operateur);                       
            
            System.out.println("le resultat de "
                                +nombre1+" "+operateur+" "
                                +" "+nombre2+" = "+br.readLine());
            s.close();//on ferme le socket
        } catch (IOException ex) {
            Logger.getLogger(Client.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }
    
}
