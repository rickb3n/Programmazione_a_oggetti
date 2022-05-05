/*
 * Riccardo Beniamino 244054, Simone Tacconi 248240
 */
package esame220905;

/**
 * Questa classe concreta, serve per generare e gestire tutti gli oggetti di tipo Data.
 * @author rikyr, Simotac97
 */
public class Data {
    private int giorno;
    private int mese;
    private int anno;
    
    /**
     * Costruttore di default: inizializza a 0 tutti gli attributi
     */
    public Data(){giorno = 0; mese = 0; anno = 0;}
    
    /**
     * Costruttore sovraccaricato: serve per inizializzare lo stato degli oggetti
     * di tipo Data,da posizioni esterne alla suddetta classe, 
     * riceve parametri di tipo ptimitivo interi, passati per valore.
     * @param g giorno : int
     * @param m mese : int
     * @param a anno : int
     */
    public Data(int g, int m, int a){giorno = g; mese = m; anno = a;}
    
    /**
     * Questo metodo restituisce il giorno del mese in formato primitivo intero.
     * @return giorno : int
     */
    public int getGiorno(){return giorno;} 
    
    /**
     * Questo metodo restituisce il mese dell'anno in formato primitivo intero.
     * @return mese : int
     */
    public int getMese(){return mese;}
    
    /**
     * Questo metodo restituisce l'anno in formato primitivo intero.
     * @return anno : int
     */
    public int getAnno(){return anno;}
    
    /**
     * Questo metodo serve per aggiornare l'attributo intero giorno.
     * @param g giorno : int, passato per valore
     */
    public void setGiorno(int g){giorno = g;}
    
    /**
     * Questo metodo serve per aggiornare l'attributo intero mese.
     * @param m mese : int, passato per valore
     */
    public void setMese(int m){mese = m;}
    
    /**
     * Questo metodo serve per aggiornare l'attributo intero anno.
     * @param a anno : int, passato per valore
     */
    public void setAnno(int a){anno = a;}
    
    /**
     * Il metodo toString() è ereditato implicitamente dalla classe nativa Object del Java.
     * Per questo motivo, questo metodo è disponibile per tutti gli oggetti.
     * La dicitura @Override indica la sovrascittura del metodo ereditato.
     * 
     * @return restituisce la data in un unica stringa, risultante da concatenazione di più stringhe.
     * Da notare che c'è una conversione da tipi primirivi interi a tipo stringa,
     * questo è possibile grazie alla classe Wrapper String.
     * 
     * Possiamo infatti pensare ad una classe wrapper esattamente come un involucro (wrap) 
     * che ha l’unico scopo di contenere un valore primitivo rendendolo da un lato un oggetto 
     * e dall’altro “ornandolo” con metodi che altrimenti non avrebbero una loro naturale collocazione.
     */
    @Override
    public String toString(){return ""+giorno+','+mese+','+anno;} //"[g|m|a]:"
}
