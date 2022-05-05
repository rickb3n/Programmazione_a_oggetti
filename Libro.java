/*
 * Riccardo Beniamino 244054, Simone Tacconi 248240
 */
package esame220905;

/**
 * Classe concreta Libro sottoclasse di OggettoAcquistato, eredita e sovrascrive alcuni metodi dalla 
 * superclasse OggettoAcquistato.
 * @author rikyr, Simotac97
 */
public class Libro extends OggettoAcquistato {
    
    
    private String titoloLibro;
    private String tipo;
    private String autore;
    private int nPagine;
    
    public Libro(){
        super(0,new Data());
        titoloLibro = "-";
        tipo = "-";
        autore = "-";
        nPagine = 0;
        super.setTipoOggetto("LIBRO");
    } 
    /**
     * Costruttore: serve per inizializzare lo stato degli oggetti
     * di tipo Libro,da posizioni esterne alla suddetta classe.
     * @param p prezzo : double,passato per valore
     * @param dda data di acquisto : Data,passato per riferimento
     * @param tl titolo del libro : String,passato per riferimento
     * @param ti tipo del libro : String,passato per riferimento
     * @param a autore : String,passato per riferimento
     * @param np numero pagine : int passato per valore
     */
    public Libro(double p, Data dda,String tl, String ti, String a, int np){
        
        super(p,dda); //richiamo il costruttore della superclasse
        titoloLibro = tl;
        tipo = ti;
        autore = a;
        nPagine = np;
        super.setTipoOggetto("LIBRO"); 
     //richiamo il metodo della superclasse, serve per semplificare l'identificazione
     //dell'oggetto nella classe contenitore Archivio
    }
    
    /**
     * Restituisce in formato String il titolo del libro.
     * @return titoloLibro : String
     */
    public String getTitolo(){return titoloLibro;}
    
    /**
     * Restitusice in formato String il tipo del libro.
     * @return tipo : Strig   
     */
    public String getTipo(){return tipo;}
    
    /**
     * Restitusice in formato String l'autore del libro.
     * @return autore : Strig   
     */
    public String getAutore(){return autore;}
    
    /**
     * Restitusice in formato primitivo intero il tipo del libro.
     * @return numero pagine : int   
     */
    public int getNumPagine(){return nPagine;}
    
    /**
     * Metodo ereditato e sovrascritto dalla superclasse OggettoAcquistato,
     * restituisce il prezzo del Libro.
     * @return prezzo : double
     */
    @Override
    public double getPrezzo(){return super.getPrezzo();}
    
    /**
     * Metodo ereditato e sovrascritto dalla superclasse OggettoAcquistato,
     * restituisce la data di acquisto del Libro.
     * @return data di acquisto : Data
     */
    @Override
    public Data getData(){return super.getData();}
    
    /**
     * Il metodo toString() è ereditato implicitamente dalla classe nativa Object del Java.
     * Per questo motivo, questo metodo è disponibile per tutti gli oggetti.
     * La dicitura @Override indica la sovrascittura del metodo ereditato.
     * 
     * @return restituisce tutti gli attributi del libro in formato String, risultante da concatenazione di più stringhe.
     * Da notare che c'è una conversione da tipi primitivi int,double a tipo stringa,
     * questo è possibile grazie alla classe Wrapper String. Per quanto riguarda i metodi Data
     * ivece viene richiamato il metodo toString appartenente a quella classe.
     * 
     * Possiamo infatti pensare ad una classe wrapper esattamente come un involucro (wrap) 
     * che ha l’unico scopo di contenere un valore primitivo rendendolo da un lato un oggetto 
     * e dall’altro “ornandolo” con metodi che altrimenti non avrebbero una loro naturale collocazione.
     */
    
    /**
     * Metodo ereditato e sovrascritto dalla superclasse 
     * per impostare la data di acquisto di un determinato oggetto tra Libro,Dvd o CD.
     * @param d parametro Data passato per riferimento
     */
    @Override
    public void setDataDiAcquisto(Data d){super.setDataDiAcquisto(d);};
    
    /**
     * Metodo ereditato e sovrascritto dalla superclasse 
     * per impostare il prezzo di un determinato oggetto tra Libro,Dvd o CD.
     * @param p parametro prezzo : int passato per valore
     */
    @Override
    public void setPrezzo(double p){super.setPrezzo(p);};
    
    /**
     * Imposta il titolo di un Libro.
     * @param t titolo : String, passato per riferimento
     */
    public void setTitolo(String t){titoloLibro = t;};
    
    /**
     * Imposta il tipo di un Libro.
     * @param ti tipo : String, passato per riferimento
     */
    public void setTipo(String ti){tipo = ti;};
    
    /**
     * Imposta l'autore di un Libro.
     * @param a autore : String, passato per riferimento
     */
    public void setAutore(String a){autore = a;};
    
    /**
     * Imposta il numero delle pagine di un libro.
     * @param np numero pagine : int, passato per valore
     */
    public void setNumPagine(int np){nPagine = np;};
  
    /**
     * Il metodo toString() è ereditato implicitamente dalla classe nativa Object del Java;
     * Per maggiori informazioni su questo metodo vedi classe concreta Archivio. 
     * @return tutti gli attributi di un oggetto libro in formato String.
     */
    @Override
    public String toString(){
        return "LIBRO [ID|prezzo|dataA|titolo|tipo|autore|n°pagine]:"
            +super.getCodiceID()+','+super.getPrezzo()+','+super.getData()+','+titoloLibro+','+tipo+','+autore+','+nPagine+"~";
    }
}
