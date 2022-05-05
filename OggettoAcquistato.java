/*
 * Riccardo Beniamino 244054, Simone Tacconi 248240
 */
package esame220905;
import java.util.Random;
/**
 * Classe astratta OggettoAcquistato
 * Questi elementi hanno in comune alcuni attributi, tra cui il prezzo, la data 
 * di acquisto e un codice di identificazione univoco assegnato dal programma stesso.
 * @author rikyr, Simotac97
 */
public abstract class OggettoAcquistato {
    private double prezzo;
    private Data dataDiAcquisto; //<-------- COMPOSIZIONE Data, non è tipo primitivo.
    private int codiceID = 0; 
    private String tipoOggetto;
    
    /**
     * Costruttore di tipo protected poiché deve essere richiamato solamente 
     * dagli oggetti generati dalle classi che ereditano.
     * @param p prezzo : int, passato per valore
     * @param dda dataDiAcquisto, passato per riferimento, viene simulata la copia del riferimento
     * di questo parametro per evitare rottura dell'incapsulamento.
     */
    protected OggettoAcquistato(double p, Data dda){
        prezzo = p;
        dataDiAcquisto = new Data(dda.getGiorno(),dda.getMese(),dda.getAnno()); //OK!
        calcolaID();
    }
    
    /**
     * Questo metodo privato, viene richiamato dal costruttore della superclasse 
     * OggettoAcquistato che è a sua volta richiamato dai costruttori delle sottoclassi Libro, Dvd e CDmusicale;
     * Serve a calcolare il codice identificativo associato a ogni oggetto generato dalle sottoclassi;
     * 
     * Questo metodo viene eseguito solo se vengono generati oggetti dal programma stesso;
     * 
     * Se gli oggetti vengono generati dalla classe Archivio a partire da un file di testo
     * si presume che il codice identificativo è già presente e diverso da 0 e non deve essere sovrascritto
     * da un nuvo codice identificativo generato casualmente;
     * 
     * L'attributo codiceID viene inizializzato a 0 al momento della definizione della classe OggettoAcquistato
     * se è diverso da zero vuol dire che è stato modificato dal metodo setCodiceID richiamato
     * dal metodo di classe leggiElementiDaFile presente nella classe concreta Archivio la quale NON
     * eredita dalla classe astratta OggettoAcquistato.
     */
    private void calcolaID(){
      if(codiceID == 0) //l'attributo codiceID viene inizializzato a 0 al momento della
       {
         Random casuale = new Random();
         codiceID = casuale.nextInt(10000);
       }
    }
    
    /**
     * Questo metodo pubblico restiuisce il codice identificativo in formato primitivo int
     * @return codiceID : int
     */
    public int getCodiceID(){return codiceID;}
    
    /**
     * Questo metodo pubblico serve per impostare il codice identificativo
     * viene utilizzato per scambiare messaggi imperativi
     * dal metodo di classe leggiElementiDaFile della classe concreta Archivio
     * @param id codice identificativo passato per valore
     */
    public void setCodiceID(int id){codiceID = id;} //solo per importare il codice da file
    
    /**
     * Questo metodo serve per impostare il tipo di oggetto per renderne più
     * semplice l'identificazione nella classe Archivio; 
     * Il metodo è protected per evitare rottura dell'incapsulamento e anche
     * perché deve essere accessibile solamente dagli oggetti generati dalle 
     * sottoclassi "Libro","Dvd" e "CDmusicale" che ereditano dalla classe OggettoAcquistato; 
     * @param to tipo oggetto : String
     */
    protected void setTipoOggetto(String to){tipoOggetto = to;} //protected, no rottura incapsulamento.
    
    /**
     * Questo metodo restiuisce in formato String il tipo di oggetto; Viene
     * simulata la copia del riferimento per valore per evitare rottura dell'incapsulamento;
     * in questo caso il metodo è pubblico per inviare messaggi informativi agli oggetti
     * generati dalla classe concreta "Archivio" che NON eredita dalla classe OggettoAcquistato; 
     * All'occorrenza può essere utile anche per mandare messaggi informati alla classe Client "Esame220905";
     * @return tipoOggetto : String 
     */
    //public String getTipoOggetto(){return new String(tipoOggetto);} //simulazione passaggio per valore
    public String getTipoOggetto(){return tipoOggetto;}
    
    /**
     * Metodo ereditato e sovrascritto nelle sottoclassi;
     * Restituisce in formato primitivo double il prezzo di un determinato oggetto di tipo Libro,Dvd o CDmusicale.
     * @return prezzo : double
     */
    public double getPrezzo(){return prezzo;}
    
    /**
     * Metodo ereditato e sovrascritto nelle sottoclassi;
     * Simula il passaggio per valore per evitare la rottura dell'incapsulamento,
     * dato che l'oggetto di tipo Data non è primitivo.
     * @return nuovo oggetto di tipo Data
     */
    public Data getData(){
        return new Data(dataDiAcquisto.getGiorno(),dataDiAcquisto.getMese(),dataDiAcquisto.getAnno());//OK!
    }
    
    /**
     * Metodo ereditato e sovrascritto nelle sottoclassi;
     * Serve per impostare il prezzo di un oggetto tra Libro, Dvd e CDmusicale;
     * @param p prezzo : double, passato per valore
     */
    public void setPrezzo(double p){prezzo = p;}
    
    /**
     * Metodo ereditato e sovrascritto nelle sottoclassi;
     * Serve per impostare la data di acquisto di un oggetto tra Libro, Dvd e CDmusicale;
     * Viene simulato il passaggio per valore per evitare la rottura dell'incapsulamento.
     * @param d data di acquisto : Data, passato per riferimento
     */
    public void setDataDiAcquisto(Data d){
        dataDiAcquisto = new Data(d.getGiorno(),d.getMese(),d.getAnno());
    }
}
