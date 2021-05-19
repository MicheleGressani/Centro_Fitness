/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centro_fitness;

import java.time.*;

/**
 *la classe CentroFitness rappresenta un centro fitness dove
 * si possono registrare nuovi accessi, eliminarne altri,
 * aggiungiere date di uscita, visualizzare tutti gli accessi di uno
 * specifico giorno. elencoUtenti è un array di Utenti e N_MAX_UTENTI
 * è una costante che rappresenta il numero massimo di utenti che 
 * si possono registrare
 * @author miche_uce8t6c
 */
    public class CentroFitness 
    {
        private Utente[] elencoUtenti;
        private final int N_MAX_UTENTI=50;
        private int nUtentiPresenti;

        /**
         * resituisce N_MAX_VOTI
         * @return N_MAX_VOTI
         */
        public int getN_MAX_VOTI()
        {
            return N_MAX_UTENTI;
        }
        /**
         * resituisce nUtentiPresenti
         * @return nUtentiPresenti
         */
        public int getnUtentiPresenti() 
        {
            return nUtentiPresenti;
        }
        /**
         * assegna nUtentiPresenti
         * @param nUtentiPresenti
         */
        public void setnUtentiPresenti(int nUtentiPresenti) 
        {
            this.nUtentiPresenti=nUtentiPresenti;
        }
    
    
    /**
     * è il costruttore della classe e istanzia l'array elencoUtenti
     * e inizializza nUtentiPresenti a zero
     */
        public CentroFitness()
        {
            elencoUtenti=new Utente[N_MAX_UTENTI];
            nUtentiPresenti=0;
        }

        /**
         * aggiungiAccesso controlla se il numero massimo di utenti non è stato superato,
         * se è così allora istanzia un nuovo utente e incrementa nUtentiPresenti
         * @param utente
         * @return 0
         */
        public int aggiungiAccesso(Utente utente)
        {
            if (nUtentiPresenti>=N_MAX_UTENTI)
                return -1;
            elencoUtenti[nUtentiPresenti]=new Utente(utente);
            nUtentiPresenti++;
            return 0;
        }
        /**
         * getPosizione controlla tutti i codici identificativi fino a trovare
         * quello che combacia con l'inserimento nel main e se combacia ritorna la
         * posizione dell'utente
         * @param codiceIdentificativo
         * @return 
         */
        public int getPosizione(int codiceIdentificativo)
        {
            Utente u;
            for (int i=0;i<nUtentiPresenti;i++)
            {
                if (elencoUtenti[i]!=null)    //per sicurezza
                {
                    u=elencoUtenti[i];
                    if (u.getCodiceIdentificativo()==codiceIdentificativo)
                    return i;
                }
            }
            return -1;
        }
        /**
         * getPosizione controlla tutti i codici identificativi fino a trovare
         * quello che combacia con l'inserimento nel main e se combacia ritorna
         * l'utente
         * getUtenteID 
         * @param codiceIdentificativo
         * @return 
         */
        public Utente getUtenteID(int codiceIdentificativo)
        {
            Utente u;
            for (int i=0;i<nUtentiPresenti;i++)
            {
                if (elencoUtenti[i]!=null)    //per sicurezza
                {
                    u=elencoUtenti[i];
                    if (u.getCodiceIdentificativo()==codiceIdentificativo)
                    return elencoUtenti[i];
                }
            }
            return null;
        }
        /**
         * assegnaData assegna la data di uscita inserita nel main all'utente
         * selezionato tramite codice identificativo
         * @param codiceIdentificativo
         * @param annoU
         * @param meseU
         * @param giornoU
         * @param oraU
         * @param minutoU 
         */
        public void assegnaData(int codiceIdentificativo,int annoU,int meseU,int giornoU,int oraU,int minutoU)
        {
            Utente u;
            u=getUtenteID(codiceIdentificativo);
            u.setUscita(annoU,meseU,giornoU,oraU,minutoU);
        }
        /**
         * getUtente controlla tutti i nomi e cognomi di tutti gli utenti
         * e quando sia uno che l'altro combaciano con quelli inseriti nel
         * main restituisce quell'utente
         * getUtente 
         * @param nome
         * @param cognome
         * @return 
         */
        public Utente getUtente(String nome, String cognome)
        {
            Utente u;
            for (int i=0;i<nUtentiPresenti;i++)
            {
                if (elencoUtenti[i]!=null)
                {
                    u=elencoUtenti[i];
                    if (nome.compareToIgnoreCase(elencoUtenti[i].getNome())==0 && cognome.compareToIgnoreCase(elencoUtenti[i].getCognome())==0)
                    {
                        return new Utente(u);
                    }
                }
            }
            return null;
        }
        /**
         * getUtente controlla tutti i nomi e cognomi di tutti gli utenti
         * e quando sia uno che l'altro combaciano con quelli inseriti nel
         * main aggiorna la posizione togliendo l'utente
         * @param nome
         * @param accesso
         * @return -1
         */
        public int eliminaAccesso(String nome, LocalDateTime accesso)
        {
            Utente u;
            for (int i=0;i<nUtentiPresenti;i++)
            {
                if (elencoUtenti[i]!=null)
                {
                    u=elencoUtenti[i];
                    if (nome.compareToIgnoreCase(elencoUtenti[i].getNome())==0 && accesso.equals(elencoUtenti[i].getAccesso()))
                    {
                        aggiornaPosizioneAccesso(i);
                        return 0; 
                    }
                }
            }
            return -1;
        }
    
    
    
        /**
         * aggiorna la posizione nell'array
         * @param posizione 
         */
        private void aggiornaPosizioneAccesso(int posizione)
        {
            for (int i=posizione;i<nUtentiPresenti-1;i++)  
            {
                elencoUtenti[i]=elencoUtenti[i+1];
            }
            elencoUtenti[nUtentiPresenti-1]=null;
            nUtentiPresenti--;
        }
    }
    
    
    
