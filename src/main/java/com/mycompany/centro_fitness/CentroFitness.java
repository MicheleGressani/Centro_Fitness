/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centro_fitness;

/**
 *
 * @author miche_uce8t6c
 */
public class CentroFitness 
{
    private Utente[] elencoUtenti;
    private final int N_MAX_UTENTI=50;
    private int nUtentiPresenti;
    
    public CentroFitness()
    {
        elencoUtenti=new Utente[N_MAX_UTENTI];
        nUtentiPresenti=0;
    }
    
    public CentroFitness(CentroFitness c)
    {
        elencoUtenti=new Utente[N_MAX_UTENTI];
        
        for(int i=0;i<getN_MAX_UTENTI();i++)
            elencoUtenti[i]=c.getUtente(i);
    }

    public int getNUtentiPresenti() 
    {
        return nUtentiPresenti;
    }
    
    public int getN_MAX_UTENTI()
    {
        return N_MAX_UTENTI;
    }
    
    public int aggiungiUtente(Utente utente)
    {
        if (nUtentiPresenti>=N_MAX_UTENTI)
            return -1;
        elencoUtenti[nUtentiPresenti]=new Utente(utente);
        nUtentiPresenti++;
        return 0;         
    }
    
    public Utente getUtente(int posizione)
    {
        if (elencoUtenti[posizione]!=null)
            return new Utente(elencoUtenti[posizione]);
        else
            return null;
    }
    
    
}
