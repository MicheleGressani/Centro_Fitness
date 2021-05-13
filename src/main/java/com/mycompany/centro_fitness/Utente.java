/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centro_fitness;

import java.time.LocalDateTime;
import java.time.LocalTime;

/**
 *
 * @author miche_uce8t6c
 */
public class Utente 
{
    //attributi
    private int codiceIdentificativo;
    private String nome;
    private String cognome;
    private LocalDateTime accesso;
    private LocalDateTime uscita;
    
    //costruttore
    public Utente(int codiceIdentificativo, String nome, String cognome, int giorno, int mese, int anno, int ora, int minuto)
    {
        this.codiceIdentificativo=codiceIdentificativo;
        this.nome=nome;
        this.cognome=cognome;
        accesso=LocalDateTime.of(anno,mese,giorno,ora,minuto);
        uscita=null;
    }
    
    public Utente(Utente u)
    {
        codiceIdentificativo=u.getCodiceIdentificativo();
        nome=u.getNome();
        cognome=u.getCognome();
        accesso=u.getAccesso();
        uscita=u.getUscita();
    }
    public Utente()
    {
        codiceIdentificativo=0;
        nome="";
        cognome="";
    }

    public int getCodiceIdentificativo() 
    {
        return codiceIdentificativo;
    }

    public void setCodiceIdentificativo(int codiceIdentificativo) 
    {
        this.codiceIdentificativo=codiceIdentificativo;
    }

    public String getNome() 
    {
        return nome;
    }

    public void setNome(String nome) 
    {
        this.nome=nome;
    }

    public String getCognome() 
    {
        return cognome;
    }

    public void setCognome(String cognome) 
    {
        this.cognome=cognome;
    }

    public LocalDateTime getAccesso() 
    {
        return accesso;
    }

    public void setAccesso(LocalDateTime accesso) 
    {
        this.accesso=accesso;
    }

    public LocalDateTime getUscita() 
    {
        return uscita;
    }

    public void setUscita(LocalDateTime uscita) 
    {
        this.uscita=uscita;
    }    
}
