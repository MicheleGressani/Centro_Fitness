/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centro_fitness;

import java.util.Scanner;

/**
 *
 * @author User
 */
public class Menu 
{
    private String[] elencoVoci;
    private int numeroVoci;
    
    public Menu(String[] elencoVoci)
    {
        numeroVoci=elencoVoci.length;
        this.elencoVoci=new String[numeroVoci];
        for (int i=0;i<numeroVoci;i++)
            this.elencoVoci[i]=elencoVoci[i];
    }
    
    public void visualizzaMenu()
    {
        System.out.println("MENU:");
        for (int i=0;i<numeroVoci;i++)
            System.out.println(i+" --> "+this.elencoVoci[i]);
    }
    
    public int sceltaMenu()
    {
        String inputUtente;
        boolean inputUtenteOK=true;
        int sceltaUtente=0;
        
        
        
        do
        {   
            visualizzaMenu();
            Scanner tastiera=new Scanner(System.in);
            System.out.println("Scelta -->");
            inputUtente=tastiera.nextLine();


            //verifico se l'inputUtente è un numero
            inputUtenteOK=true;
            for (int i=0;i<inputUtente.length();i++)
            {
                if (inputUtente.charAt(i)>='0' && inputUtente.charAt(i)<='9')
                    i++;
                else
                {
                    inputUtenteOK=false;
                    break; 
                }     
            }

            //verifico se il numero inserito è compreso fra 0 e il numero di voci del menu -1
            if (inputUtenteOK)
            {
                sceltaUtente=Integer.parseInt(inputUtente);
                if (sceltaUtente<0 || sceltaUtente>numeroVoci-1)
                    inputUtenteOK=false;
            }
            
            if (!inputUtenteOK)
            {
                System.out.println("Valore inserito non valido. Premi invio ed effettua nuovamente la scelta");
                tastiera.nextLine();
            }
  
        }while(!inputUtenteOK);
        
        return sceltaUtente;
    }
}

