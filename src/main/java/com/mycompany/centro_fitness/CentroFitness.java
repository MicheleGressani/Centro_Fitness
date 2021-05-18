/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centro_fitness;

import java.time.*;

/**
 *
 * @author miche_uce8t6c
 */
public class CentroFitness 
{
    private Utente[] elencoUtenti;
    private final int N_MAX_UTENTI=50;
    private int nUtentiPresenti;
    
    public int getN_MAX_VOTI()
    {
        return N_MAX_UTENTI;
    }

    public int getnUtentiPresenti() 
    {
        return nUtentiPresenti;
    }

    public void setnUtentiPresenti(int nUtentiPresenti) 
    {
        this.nUtentiPresenti=nUtentiPresenti;
    }
    
    public CentroFitness()
    {
        elencoUtenti=new Utente[N_MAX_UTENTI];
        nUtentiPresenti=0;
    }
    
        public int aggiungiAccesso(Utente utente)
    {
        if (nUtentiPresenti>=N_MAX_UTENTI)
            return -1;
        elencoUtenti[nUtentiPresenti]=new Utente(utente);
        nUtentiPresenti++;
        return 0;
    }
        
    public Utente getUtente(String nome, String cognome)
    {
        Utente u;
        for (int i=0;i<nUtentiPresenti;i++)
        {
            if (elencoUtenti[i]!=null)
            {
                u=elencoUtenti[i];
                if (u.getNome()==nome && u.getCognome()==cognome)
                {
                    return new Utente(u);
                }
            }
        }
        return null;
    }
    
    public int eliminaAccesso(String nome, LocalDateTime accesso)
    {
        Utente u;
        for (int i=0;i<nUtentiPresenti;i++)
        {
            if (elencoUtenti[i]!=null)
            {
                u=elencoUtenti[i];
                if (u.getNome()==nome && u.getAccesso()==accesso)
                {
                    aggiornaPosizioneAccesso(i);
                    return 0; 
                }
            }
        }
        return -1;
    }
    
    private void aggiornaPosizioneAccesso(int posizione)
    {
        for (int i=posizione;i<nUtentiPresenti-1;i++)  
        {
            elencoUtenti[i]=elencoUtenti[i+1];
        }
        elencoUtenti[nUtentiPresenti-1]=null;
        nUtentiPresenti--;
    }
    
    public String elencoUtenti()
    {
        String s="";
        Utente utente;
        if (nUtentiPresenti==0)
            s+="Nessun utente presente";
        else
        {
            for (int i=0;i<nUtentiPresenti;i++)
            {
                utente=elencoUtenti[i];
                s+=utente.toString()+"\n";
            }
        }
        return s;
            
    }
    
}
