/*
 * Riccardo Beniamino 244054, Simone Tacconi 248240
 */
package esame220905;

/**
 * Classe concreta Dvd sottoclasse di OggettoAcquistato, eredita e sovrascrive alcuni metodi dalla 
 * superclasse OggettoAcquistato.
 * @author rikyr, Simotac97
 */
public class Dvd extends OggettoAcquistato {
   
    private String nomeFilm;
    private String tipo;
    private String autore;
    private int durata;
    
    public Dvd()
    {
        super(0,new Data());
        nomeFilm = "-";
        tipo = "-";
        autore = "-";
        durata = 0;
        super.setTipoOggetto("DVD");
    }
    
    /**
     * Costruttore: serve per inizializzare lo stato degli oggetti
     * di tipo Dvd,da posizioni esterne alla suddetta classe.
     * @param p prezzo : double,passato per valore
     * @param dda data di acquisto : Data,passato per riferimento
     * @param tl nome del film : String,passato per riferimento
     * @param ti tipo del film : String,passato per riferimento
     * @param a autore del film : String,passato per riferimento
     * @param np durata del film : int,passato per valore
     */
    public Dvd(Double p, Data dda,String tl, String ti, String a, int np){
        super(p,dda); //richiamo il costruttore della superclasse
        nomeFilm = tl;
        tipo = ti;
        autore = a;
        durata = np;
        super.setTipoOggetto("DVD");
        //richiamo il metodo della superclasse, serve per semplificare l'identificazione
        //dell'oggetto nella classe contenitore Archivio
    }
    
     /**
     * Restituisce in formato String il nome del film.
     * @return nome del film : String
     */
    public String getNomeFilm(){return nomeFilm;}
    
     /**
     * Restituisce in formato String il tipo del film.
     * @return tipo film : String
     */
    public String getTipo(){return tipo;}
    
     /**
     * Restituisce in formato String l'autore del film.
     * @return autore film : String
     */
    public String getAutore(){return autore;}
    
     /**
     * Restituisce in formato intero la durata del film in minuti.
     * @return durata in minuti del film : int
     */
    public int getDurataFilm(){return durata;}
    
    /**
     * Metodo ereditato e sovrascritto dalla superclasse OggettoAcquistato,
     * restituisce il prezzo del Dvd.
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
     * Imposta la durata in minuti di un Dvd/Film.
     * @param d durata : int, passato per valore
     */
    public void setDurataDvd(int d){durata = d;};
    
    /**
     * Imposta il nome di un film.
     * @param nf nome film : String, passato per riferimento
     */
    public void setNomeFilm(String nf){nomeFilm = nf;};
    
    /**
     * Imposta il tipo di Dvd/Film.
     * @param ti tipo : String, passato per riferimento
     */
    public void setTipo(String ti){tipo = ti;};
    
    /**
     * Imposta l'autore di un Dvd/Film.
     * @param a autore : String, passato per riferimento
     */
    public void setAutore(String a){autore = a;};
  
    /**
     * Il metodo toString() è ereditato implicitamente dalla classe nativa Object del Java.
     * Per questo motivo, questo metodo è disponibile per tutti gli oggetti.
     * La dicitura @Override indica la sovrascittura del metodo ereditato.
     * 
     * @return restituisce tutti gli attributi dell'oggetto di tipo Dvd in formato String, 
     * risultante da concatenazione di più stringhe.
     * 
     * Da notare che c'è una conversione da tipi primitivi int,double a tipo stringa,
     * questo è possibile grazie alla classe Wrapper String. Per quanto riguarda i metodi Data
     * ivece viene richiamato il metodo toString appartenente a quella classe.
     * 
     * Possiamo infatti pensare ad una classe wrapper esattamente come un involucro (wrap) 
     * che ha l’unico scopo di contenere un valore primitivo rendendolo da un lato un oggetto 
     * e dall’altro “ornandolo” con metodi che altrimenti non avrebbero una loro naturale collocazione.
     */
    @Override
    public String toString(){
        return "DVD [ID|prezzo|dataA|Film|tipo|autore|durata]:"
            +super.getCodiceID()+','+super.getPrezzo()+','+super.getData()+','+nomeFilm+','+tipo+','+autore+','+durata+"~";
    }
    
}
