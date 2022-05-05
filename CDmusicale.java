/*
 * Riccardo Beniamino 244054, Simone Tacconi 248240
 */
package esame220905;

/**
 * Classe concreta CDmusicale sottoclasse di OggettoAcquistato, eredita e sovrascrive alcuni metodi dalla 
 * superclasse OggettoAcquistato.
 * @author rikyr, Simotac97
 */
public class CDmusicale extends OggettoAcquistato {
    
    private String nome;
    private String autore;
    private String album;
    private String genere;
    private int numCanzoni;
    private int durata;
    
    public CDmusicale(){
        super(0,new Data()); //richiamo il costruttore della superclasse
        nome = "-";
        autore = "-";
        album = "-";
        genere = "-";
        numCanzoni = 0;
        durata = 0;
        super.setTipoOggetto("CD");
        //richiamo il metodo della superclasse, serve per semplificare l'identificazione
        //dell'oggetto nella classe contenitore Archivio
    }
    
    /**
     * Costruttore: serve per inizializzare lo stato degli oggetti
     * di tipo CDmusicale,da posizioni esterne alla suddetta classe.
     * @param p prezzo : double,passato per valore
     * @param dda data di acquisto : Data,passato per riferimento
     * @param n nome del cd : String,passato per riferimento
     * @param a autore del cd : String,passato per riferimento
     * @param al album musicale: String,passato per riferimento
     * @param g genere musicale : String,passato per riferimento 
     * @param nc numero canzoni contenute nel cd : int,passato per valore
     * @param d durata del cd in minuti : int,passato per valore
     */
    public CDmusicale(double p, Data dda,String n, String a, String al, String g, int nc, int d){
        super(p,dda); //richiamo il costruttore della superclasse
        nome = n;
        autore = a;
        album = al;
        genere = g;
        numCanzoni = nc;
        durata = d;
        super.setTipoOggetto("CD");
        //richiamo il metodo della superclasse, serve per semplificare l'identificazione
        //dell'oggetto nella classe contenitore Archivio
    }
    
    /**
     * Restituisce in formato String il nome del cd.
     * @return nome del film : String
     */
    public String getNome(){return nome;}
    
    /**
     * Restituisce in formato String l'autore del cd.
     * @return nome dell'autore : String
     */
    public String getAutore(){return autore;}
    
    /**
     * Restituisce in formato String l'album contenuto nel cd.
     * @return album del cd : String
     */
    public String getAlbum(){return album;}
    
    /**
     * Restituisce in formato String il genere musicale del cd.
     * @return genere musicale cd : String
     */
    public String getGenere(){return genere;}
    
    /**
     * Restituisce in formato intero il numero delle canzoni contenute nel cd.
     * @return numero canzoni : int
     */
    public int getNumeroCanzoni(){return numCanzoni;}
    
    /**
     * Restituisce in formato intero la durata del cd musicale in minuti.
     * @return durata in minuti del cd musicale : int
     */
    public int getDurataCD(){return durata;}
    
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
     * Imposta la durata in minuti di un CD.
     * @param d durata : int, passato per valore
     */
    public void setDurataCD(int d){durata = d;};
    
    /**
     * Imposta il nome di un CD.
     * @param nc nome cd : String, passato per riferimento
     */
    public void setNomeCD(String nc){nome = nc;};
    
    /**
     * Imposta il genere di un CD.
     * @param gc genere cd : String, passato per riferimento
     */
    public void setGenere(String gc){genere = gc;};
    
    /**
     * Imposta l'autore di un CD.
     * @param a autore : String, passato per riferimento
     */
    public void setAutore(String a){autore = a;};
    
    /**
     * Imposta l'album contenuto nel CD;
     * @param al album : String, passato per riferimento
     */
    public void setAlbum(String al){album = al;}
    
    public void setNumeroCanzoni(int nc){numCanzoni = nc;}
    
    /**
     * Il metodo toString() è ereditato implicitamente dalla classe nativa Object del Java.
     * Per questo motivo, questo metodo è disponibile per tutti gli oggetti.
     * La dicitura @Override indica la sovrascittura del metodo ereditato.
     * 
     * @return restituisce tutti gli attributi dell'oggetto di tipo CDmsuciale in formato String, 
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
        return "CD [ID|prezzo|dataA|NomeCD|autore|album|genere|NumCanzoni|durata]:"
            +super.getCodiceID()+','+super.getPrezzo()+
                ','+super.getData()+','+nome+','+autore+','+album+','+genere+','+numCanzoni+','+durata+"~";
    }
}
