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
        String[] vociMenu=new String[4];
        int sceltaUtente=0;
        Scanner tastiera=new Scanner(System.in);
        CentroFitness c1=new CentroFitness();
        Utente utente;
        CentroFitness CF;
        String nome;
        String cognome;
        LocalDateTime accesso=null;
        int minuto,ora,giorno,mese,anno;
        int esitoOperazione;
        int codiceIdentificativo=1;
        
        
        vociMenu[0]="Chiudi applicazione";
        vociMenu[1]="Aggiungi accesso utente";
        vociMenu[2]="Elimina accesso";
        vociMenu[3]="Visualizza tutti gli accessi inserendo nome e cognome";
        
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
                        System.out.println("Inserisci i dati dello studente");
                        System.out.println("Cognome --> ");
                        cognome=tastiera.nextLine();
                        System.out.println("Nome --> ");
                        nome=tastiera.nextLine();
                        System.out.println("DATA\n");                        
                        System.out.println("Giorno--> ");
                        giorno=tastiera.nextInt();
                        System.out.println("Mese--> ");
                        mese=tastiera.nextInt();                      
                        System.out.println("Anno--> ");
                        anno=tastiera.nextInt();
                        System.out.println("\nORARIO\n");
                        System.out.println("Ora--> ");
                        ora=tastiera.nextInt();
                        System.out.println("Minuto--> ");
                        minuto=tastiera.nextInt();
                        accesso=LocalDateTime.of(anno, mese, giorno, ora, minuto);
                        
                        utente=new Utente(codiceIdentificativo, nome, cognome, giorno, mese, anno, ora, minuto);
                        codiceIdentificativo++;
                        esitoOperazione=c1.aggiungiAccesso(utente);
                        if (esitoOperazione==-1)
                            System.out.println("Massimo numero di utenti raggiunto. Impossibile aggiungere l'utente");
                        else
                            System.out.println("Utente aggiunto correttamente");
                        
                        break;
                    }
                    case 2:
                    {
                        System.out.println("Inserisci il nome dell'utente");
                        nome=tastiera.nextLine();
                        nome=tastiera.nextLine();
                        System.out.println("\nInserisci la data di accesso");
                        System.out.println("Data: ");
                        System.out.println("Minuto--> ");
                        minuto=tastiera.nextInt();
                        System.out.println("Ora--> ");
                        ora=tastiera.nextInt();
                        System.out.println("Giorno--> ");
                        giorno=tastiera.nextInt();
                        System.out.println("Mese--> ");
                        mese=tastiera.nextInt();
                        System.out.println("Anno--> ");
                        anno=tastiera.nextInt();
                        accesso=LocalDateTime.of(anno, mese, giorno, ora, minuto);
                        esitoOperazione=c1.eliminaAccesso(nome,accesso);
                        if(esitoOperazione==-1)
                            System.out.println("Studente non presente");
                        else
                            System.out.println("Accesso rimosso correttamente");
                        break;
                    }
                    
                    case 3:
                    {
                        /*
                        System.out.println("Inserisci il nome dell'Utente");
                        nome=tastiera.nextLine();
                        nome=tastiera.nextLine();
                        System.out.println("Inserisci il cognome dell'Utente");
                        cognome=tastiera.nextLine();
                        utente=c1.getUtente(nome, cognome);
                        if (utente==null)
                            System.out.println("Utente non presente");
                        else
                        {
                            System.out.println("Utente: "+utente.toString());
                            tastiera.nextLine();
                            System.out.println(utente.getAccesso().toString());
                        }*/
                        System.out.println(c1.elencoUtenti());
                        
                        break;
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
