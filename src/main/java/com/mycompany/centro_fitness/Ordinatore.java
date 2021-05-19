/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.centro_fitness;

/**
 *
 * @author User
 */
public class Ordinatore 
{
    
    
    
    
    public static void  scambia(Utente u[],int posizione1, int posizione2)
    {
        Utente c;
        c=u[posizione1];
        u[posizione1]=u[posizione2];
        u[posizione2]=c;
    }
    
    //Ordina un array di Libri in ordine alfabetico di autore e a parità di autore in ordine alfabetico di titolo
    public static Utente[] selectionSortAlfabeticoNomeCognome(Utente[] a)
    {
        Utente[] ordinato=new Utente[a.length];
        
        //Creo un vettore di copia
        //che sarà il vettore ordinato restituito
        for (int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        //Applico l'algoritmo 
        //selection sort al vettore di copia
        for (int i=0;i<ordinato.length-1;i++)
        {
            for (int j=i+1;j<ordinato.length;j++)
            {
                if (ordinato[j].getNome().compareToIgnoreCase(ordinato[i].getNome())<0 || (ordinato[j].getNome().compareToIgnoreCase(ordinato[i].getNome())==0 &&  ordinato[j].getCognome().compareToIgnoreCase(ordinato[i].getCognome())<0))
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    
    
    /*
    //Ordina un array di Stringhe in ordine alfabetico
    public static String[] selectionSortCrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        //Creo un vettore di copia
        //che sarà il vettore ordinato restituito
        for (int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        //Applico l'algoritmo 
        //selection sort al vettore di copia
        for (int i=0;i<ordinato.length-1;i++)
        {
            for (int j=i+1;j<ordinato.length;j++)
            {
                if (ordinato[j].compareToIgnoreCase(ordinato[i])<0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    //Ordina un array di Stringhe in ordine alfabetico inverso
    public static String[] selectionSortDecrescente(String[] a)
    {
        String[] ordinato=new String[a.length];
        
        //Creo un vettore di copia
        //che sarà il vettore ordinato restituito
        for (int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        //Applico l'algoritmo 
        //selection sort al vettore di copia
        for (int i=0;i<ordinato.length-1;i++)
        {
            for (int j=i+1;j<ordinato.length;j++)
            {
                if (ordinato[j].compareToIgnoreCase(ordinato[i])>0)
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    
    public static int[] selectionSortCrescente(int[] a)
    {
        int[] ordinato=new int[a.length];
        
        //Creo un vettore di copia
        //che sarà il vettore ordinato restituito
        for (int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        //Applico l'algoritmo 
        //selection sort al vettore di copia
        for (int i=0;i<ordinato.length-1;i++)
        {
            for (int j=i+1;j<ordinato.length;j++)
            {
                if (ordinato[j]<ordinato[i])
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
     public static int[] selectionSortDecrescente(int[] a)
    {
        int[] ordinato=new int[a.length];
        
        //Creo un vettore di copia
        //che sarà il vettore ordinato restituito
        for (int i=0;i<ordinato.length;i++)
            ordinato[i]=a[i];
        
        //Applico l'algoritmo 
        //selection sort al vettore di copia
        for (int i=0;i<ordinato.length-1;i++)
        {
            for (int j=i+1;j<ordinato.length;j++)
            {
                if (ordinato[j]>ordinato[i])
                    scambia(ordinato,i,j);
            }
        }
        return ordinato;
    }
    
    
    */
    
}
