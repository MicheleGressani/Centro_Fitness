/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centro_fitness;

import java.time.LocalDateTime;
import java.time.Month;
import java.util.*;
import java.util.Scanner;

/**
 *
 * @author miche_uce8t6c
 */
public class Main 
{
    public static void main(String[] args) 
    {
        String[] vociMenu=new String[2];
        int sceltaUtente=0;
        Scanner tastiera=new Scanner(System.in);
        CentroFitness c1=new CentroFitness();
        Utente utente;
        
        vociMenu[0]="Chiudi applicazione";
        vociMenu[1]="Aggiungi accesso utente";
        
        Menu menu=new Menu(vociMenu);
        
        do
        {
            try
            {
                sceltaUtente=menu.sceltaMenu();
                switch(sceltaUtente)
                {
                    case 0:
                    {
                        System.out.println("Applicazione chiusa. Arrivederci! :)");
                        break;
                    }
                    case 1:
                    {
                        utente=new Utente();
                        System.out.println("Inserisci i dati dello studente");
                        System.out.println("Nome --> ");
                        utente.setNome(tastiera.nextLine());
                        System.out.println("Cognome --> ");
                        utente.setCognome(tastiera.nextLine());
                        System.out.println("Data--> ");
                        utente.setAccesso();
                        
                    }
                }
            }
            catch(InputMismatchException | NumberFormatException el)
            {
                tastiera.nextLine();
                System.out.println("Input non corretto");
            }
        }while(sceltaUtente!=0);
        
        
        
        
        
        
    }
}
