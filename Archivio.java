/*
 * Riccardo Beniamino 244054, Simone Tacconi 248240
 */
package esame220905;
import java.util.ArrayList;
import java.io.PrintWriter;
import java.io.FileNotFoundException;
import java.io.File;
import java.util.Scanner;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Date;

/**
 * La classe concreta Archivio, aggrega oggetti di tipo OggettoAcquistato
 * @author rikyr, Simotac97
 */
public class Archivio {
    private String nome;
    private static Boolean databaseNonTrovato = false; //attributo di classe
     //COMPOSIZIONE DI DATA <--------------serve per poter effetuare dei controlli, nei metodi successivi.
    private Data dataRif;
    
    public static Boolean getErrDatabaseNonTrovato(){return databaseNonTrovato;}
    public String getNome(){return nome;}
    public void setNome(String n){nome = n;}
    
    public Archivio(String n){
        nome = n; dataRif = new Data();
        
    }
    
    private ArrayList<OggettoAcquistato> elenco = new ArrayList<>(); //<------ COMPOSIZIONE di OggettoAcquistato
    /**
     * Serve per aggiungere un oggetto di tipo acquistato al vettore elenco.
     * @param o oggetto di tipo OggettoAcquistato, passato per riferimento
     */
    public void addAcquisto(OggettoAcquistato o){elenco.add(o);}
    
    /**
     * Questo metodo restituisce il vettore contenete gli oggetti di tipo OggettoAcquistato
     * @return elenco : OggettoAcquistato
     */
    public ArrayList<OggettoAcquistato> getAcquisti(){return elenco;}
    
    /**
     * Restituisce in formato intero il numero degli oggetti contenuti nel vettore elenco
     * @return numero di elementi nell' elenco : int
     */
    public int getNumAcquisti(){return elenco.size();}
    
    /**
     * Questo metodo cancella gli elementi nel vettore di tipo OggettoAcquistato
     */
    public void cancellaElencoAcquisti(){elenco.clear();}
    
   
    
    /**
     * Questo metodo serve per impostare la data di riferimento per calcolare il prezzo 
     * totale degli oggetti di tipo OggettoAcquistato, nei metodi successivi. 
     * Viene simulata la copia del rifermento, per evitare problemi di rottura dell'incapsulamento.
     * @param dRif oggetto di tipo Data passato per riferimento
     */
    public void setDataRif(Data dRif){dataRif = new Data(dRif.getGiorno(),dRif.getMese(),dRif.getAnno());}
    
    /**
     * Questo metodo restuuisce la data di riferimento in formato Data.
     * Anche in questo caso viene simulata la copia del riferimento 
     * per evitare problemi di rottura dell' incapsulamento.
     * @return data di riferimento : Data
     */
    public Data getDataRif(){return new Data(dataRif.getGiorno(),dataRif.getMese(),dataRif.getAnno());}
    
    /**
     * Questo metodo scandisce tutti gli elementi del vettore elenco
     * Per gli oggetti che hanno come attributo interno (tipoOggetto vedi la classe OggettoAcquistato) 
     * una stringa corrispondente a "LIBRO" e una data corrispondente a dataRif fa una sommatoria
     * dei prezzi parziali, fino a raggiungere il prezzo totale.
     * @return prezzo totale libri : double
     */
     public double getPrezzoTotaleLibri(){
         double prezzo = 0;
        for(OggettoAcquistato o : elenco)
        {
            if(o.getTipoOggetto().equals("LIBRO") &  o.getData().toString().equals(dataRif.toString()))
            {
                prezzo = prezzo + o.getPrezzo();
            }
        }
       return prezzo;
    }
     
     /**
     * Questo metodo scandisce tutti gli elementi del vettore elenco
     * Per gli oggetti che hanno come attributo interno (tipoOggetto vedi la classe OggettoAcquistato) 
     * una stringa corrispondente a "DVD" e una data corrispondente a dataRif fa una sommatoria
     * dei prezzi parziali, fino a raggiungere il prezzo totale.
     * @return prezzo totale libri : double
     */
      public double getPrezzoTotaleDVD(){
         double prezzo = 0;
        for(OggettoAcquistato o : elenco)
        {
            if(o.getTipoOggetto().equals("DVD") &  o.getData().toString().equals(dataRif.toString()))
            {
                prezzo = prezzo + o.getPrezzo();
            }
        }
       return prezzo;
    }
      
     /**
     * Questo metodo scandisce tutti gli elementi del vettore elenco
     * Per gli oggetti che hanno come attributo interno (tipoOggetto vedi la classe OggettoAcquistato) 
     * una stringa corrispondente a "CD" e una data corrispondente a dataRif fa una sommatoria
     * dei prezzi parziali, fino a raggiungere il prezzo totale.
     * @return prezzo totale libri : double
     */
       public double getPrezzoTotaleCD(){
         double prezzo = 0;
        for(OggettoAcquistato o : elenco)
        {
            if(o.getTipoOggetto().equals("CD") &  o.getData().toString().equals(dataRif.toString()))
            {
                prezzo = prezzo + o.getPrezzo();
            }
        }
       return prezzo;
    }
       
        /**
        * METODO DI CLASSE (appartiene alla classe Archivio, non agli oggetti di tipo Archivio)
        * Riceve in ingresso un vettore di oggetti di tipo Archivio
        * scandisce tutti gli oggetti presenti nel vettore e per ogni elemento
        * usa il metodo getAcquisti(), dopodiché vengono scanditi e stampati su file tutti gli oggetti generati dalle classi
        * Libro,Dvd e CDmusicale che generalizzano OggettoAcquistato;
        * 
        * Vengono istanziati anche gli oggetti generati dalle classi GegorianCalendar e Calendar inculse nel Java per
        * stampare su file la data dell' ultima modifica in formato giorno/mese/anno;
        * 
        * @param elencoRif vettore di tipo Archivio, passato per riferimento.
        * Non c'è rottura di incapsulamento, dato che si tratta di una relazione
        * di aggregazione.
        * @throws FileNotFoundException eccezione generata nel caso di file non trovato.
        */
       
       public static void salvaElementiSuFile(ArrayList<Archivio> elencoRif) throws FileNotFoundException{ 
           
        GregorianCalendar gc = new GregorianCalendar();
        
        PrintWriter out = new PrintWriter( "DatabaseLocale.txt" );
        out.println("###### Database locale Archivi ######");
        out.println("Sono presenti "+elencoRif.size()+" archivi");
        out.println("Data ultima modifica [gg|mm|aaaa]:"+gc.get(Calendar.DATE)+"/"
        +(gc.get(Calendar.MONTH)+1)+"/"+gc.get(Calendar.YEAR)+"~"); //il +1 serve poiche i mesi in java partono da 0 = gennaio
        
        out.println("Ora ultima modifica [hh|mm|ss]:"+gc.get(Calendar.HOUR_OF_DAY)+','+gc.get(Calendar.MINUTE)+','+gc.get(Calendar.SECOND)+"~");
        out.println("");
        
        int i=1;
        int ca=1;
        
        for(Archivio a : elencoRif)
        {
            i = 1;
            out.println("-> ARCHIVIO n° "+ca+" [nome|n° elementi]:"+a.getNome()+','+a.getNumAcquisti()+"~");
            for(OggettoAcquistato o : a.getAcquisti()){
            out.println("N° "+i+" "+o.toString());
            ++i;
            }
            ++ca;
        }
        
        out.close();
       }
        
       /**
        * METODO DI CLASSE (appartiene alla classe Archivio, non agli oggetti di tipo Archivio)
        * Anche in questo caso viene imitato un parser, scandisce tutte le righe del file di testo
        * dopodiché grazie alle parole chiave "Data ultima modifica" e "Ora ultima modifica" vengono
        * raccolti ordinatamente i dati e trasformati nel formato corretto grazie al metodo
        * Integer.parseInt("numero in formato string"); della classe involucro (wrapper) Integer;
        * In fine i parametri in formato int anno,mese,giorno,ora,minuti e secondi vengono passati
        * al costruttore della classe GregorianCalendar e quindi viene istanziato e restituito l'oggetto di tipo 
        * GregorianCalendar 
        * 
        * @return data ultima moidifica in formato GregorianCalendar
        * @throws FileNotFoundException eccezione generata nel caso di file non trovato
        */
       public static GregorianCalendar getDataUltimaModificaDB() throws FileNotFoundException{
       
          ArrayList<String> DataString = new ArrayList<>();
          GregorianCalendar gcDatabase = new GregorianCalendar();
        try{ 
          File inputFile = new File("DatabaseLocale.txt");
           Scanner in = new Scanner(inputFile);
           int giorno = 0;
           int mese = 0;
           int anno = 0;
           int ora = 0;
           int minuti = 0;
           int secondi = 0;
           boolean erroriLettura = false;
           while(in.hasNextLine())
           {
               String rigaIn = in.nextLine();
               if(rigaIn.contains("Data ultima modifica"))
               {
                   int contatore = 0;
                   for(int i = 0; i<rigaIn.length(); i++)
                   {
                       if(rigaIn.charAt(i) == ":".charAt(0))
                       { 
                           contatore = i+1;
                       }
                           if(rigaIn.charAt(i) == "/".charAt(0) || rigaIn.charAt(i) == "~".charAt(0)) //uso "~" come carattere speciale per individurare la fine della stringa
                           {
                               DataString.add(rigaIn.substring(contatore, i)); //utilizzo il vettore per ricavare in posizione ordinata i file
                               //System.out.println("test nomearc,n: "+rigaIn.substring(contatore, i));
                               contatore = i+1;
                           }    
                    }
                   
                   if(DataString.size() == 3)
                   {
                    giorno = Integer.parseInt(DataString.get(0));
                    mese = Integer.parseInt(DataString.get(1)); //nel database i mesi partono da 1 = gennaio
                    anno = Integer.parseInt(DataString.get(2));
                   }
                    else
                   {
                       erroriLettura = true;
                   }  
                   DataString.clear();
                }//fine if data ultima modifica
              else
                if(rigaIn.contains("Ora ultima modifica"))
                {
                    int contatore = 0;
                   for(int i = 0; i<rigaIn.length(); i++)
                   {
                       if(rigaIn.charAt(i) == ":".charAt(0))
                       { 
                           contatore = i+1;
                       }
                           if(rigaIn.charAt(i) == ",".charAt(0) || rigaIn.charAt(i) == "~".charAt(0)) //uso "~" come carattere speciale per individurare la fine della stringa
                           {
                               DataString.add(rigaIn.substring(contatore, i)); //utilizzo il vettore per ricavare in posizione ordinata i file
                               //System.out.println("test nomearc,n: "+rigaIn.substring(contatore, i));
                               contatore = i+1;
                           }    
                    }//fine for
                   if(DataString.size() == 3)
                   {
                    ora = Integer.parseInt(DataString.get(0));
                    minuti = Integer.parseInt(DataString.get(1));
                    secondi = Integer.parseInt(DataString.get(2));
                   }
                    else
                   {
                       erroriLettura = true;
                   }
                   DataString.clear();
                }//fine if ora
            }//fine while
           
           if(!erroriLettura)
           {
             gcDatabase.set(anno, mese-1, giorno, ora, minuti, secondi);
           }
            //-1 perché nella classe GregorianCalendar del java i mesi partono da 0
           //return gcDatabase;
        }
            catch(FileNotFoundException fe)
            {
                databaseNonTrovato = true;
                System.out.println("\nAttenzione non è stato trovato il Database."
                        + "\nProbabilemnte stai usando questo programma per la prima volta"
                        + ", oppure\nhai forzato la chiusura dello stesso in una sessione precedente."
                        + "\nSe termini correttamente questa sessione il probelma non si ripresenterà.");
            }
        return gcDatabase;
       }
       
       /**
        * METODO DI CLASSE (appartiene alla classe Archivio, non agli oggetti di tipo Archivio)
        * Funzionamento: 
        * [In breve si imita un parser, per istanziare oggetti a partire dalle righe del file]
        * 1) Legge ogni riga del file di testo e le trasforma in stringhe;
        * 2) Garzie a delle parole chiave contenute nel file di testo come "LIBRO","CD" e "DVD"
        * riesce a distinguere il tipo di oggetto da creare;
        * 3) Scandisce tutti i caratteri della stringa derivata dalla riga 
        * del file di testo, e grazie ai caratteri contenuti nella stringa ":","," e "@"
        * individua rispettivamente: l'inizio dei parametri da trattare,la fine di 
        * ogni parametro e la fine dei parametri da trattare;
        * 4) Genera delle sottostringhe a partire da questi intervalli e le inserisce
        * ordinatamente in un vettore di stringhe;
        * 5) Una volta che questi parametri sono nel vettore di stringhe vengono 
        * prelevati e trasformati in tipi primitivi grazie ai metodi delle classi involucro 
        * "Integer.parseInt("stringa")" e "Double.ParesDouble("stringa")" se necessario;
        * 6) I parametri trasformati vengono assegnati a delle variabili locali
        * temporanee;
        * 7) Queste variabili temporanee vengono assegate ordinatamente nei campi dei costruttori
        * dei nuovi oggetti per inizializzare lo stato;
        * 8) viene importato il codiceID da una delle variabili temporanee;
        * 9) Viene resettato il vettore di stringhe "datiOrdinati" per consentire 
        * l'analisi di una nuova riga nel file di testo, finche non finiscono le righe;
        * 
        * Modifica versione 7
        * Adesso vengono analizzati anche gli archivi e i riferimenti di questi vengono
        * salvati nel vettore locale archiviDaFile; 
        * Si utilizza lo stesso modus operandi di sopra.
        * 
        * @throws FileNotFoundException eccezione generata nel caso di file non trovato
        * @return  vettore di tipo Archivio, contiene i riferimenti degli oggetti di tipo Libro,Dvd e CDmusicale.
        */
       public static ArrayList<Archivio> leggiElementiDaFile() throws FileNotFoundException{
           //ArrayList<OggettoAcquistato> elencoDaFile = new ArrayList<>(); //da modificare
           ArrayList<Archivio> archiviDaFile = new ArrayList<>();
        try{
           File inputFile = new File("DatabaseLocale.txt");
           Scanner in = new Scanner(inputFile);
           
           ArrayList<String> datiOrdinati = new ArrayList<>();
           
           int ausiliario = 0; //test
           int contatoreArchivi = -1;
           while(in.hasNextLine())
           {
               String rigaIn = in.nextLine();//nextLine();
               //System.out.println(rigaIn+" NL ");
               
               if(rigaIn.contains("ARCHIVIO"))
               {
                   ++contatoreArchivi; //incremento il contatore archivi
                   int contatore = 0;
                   for(int i = 0; i<rigaIn.length(); i++)
                   {
                       if(rigaIn.charAt(i) == ":".charAt(0))
                       { 
                           contatore = i+1;
                       }
                           if(rigaIn.charAt(i) == ",".charAt(0) || rigaIn.charAt(i) == "~".charAt(0)) //uso "~" come carattere speciale per individurare la fine della stringa
                           {
                               datiOrdinati.add(rigaIn.substring(contatore, i)); //utilizzo il vettore per ricavare in posizione ordinata i file
                               //System.out.println("test nomearc,n: "+rigaIn.substring(contatore, i));
                               contatore = i+1;
                           }    
                    }
                   archiviDaFile.add(new Archivio(datiOrdinati.get(0)));
               }
           else
               if(rigaIn.contains("LIBRO") & contatoreArchivi >= 0){
                   
                   //int virgole = 0;
                   int contatore = 0;
                   
                   
                   for(int i = 0; i<rigaIn.length(); i++)
                   {
                       if(rigaIn.charAt(i) == ":".charAt(0))
                       { 
                           contatore = i+1;
                       }
                           if(rigaIn.charAt(i) == ",".charAt(0) || rigaIn.charAt(i) == "~".charAt(0)) //uso "~" come carattere speciale per individurare la fine della stringa
                           {
                               datiOrdinati.add(rigaIn.substring(contatore, i)); //utilizzo il vettore per ricavare in posizione ordinata i file
                               contatore = i+1;
                           }    
                    }
                      if(datiOrdinati.size() == 9){
                       //System.out.println("Dati ordinati per i costruttori di Libro:"+datiOrdinati);
                       int fileID = Integer.parseInt(datiOrdinati.get(0));
                       double filePrezzo = Double.parseDouble(datiOrdinati.get(1));
                       int fileGiorno = Integer.parseInt(datiOrdinati.get(2));
                       int fileMese = Integer.parseInt(datiOrdinati.get(3));
                       int fileAnno = Integer.parseInt(datiOrdinati.get(4));
                       String fileTitolo  = datiOrdinati.get(5);
                       String fileTipo = datiOrdinati.get(6);
                       String fileAutore = datiOrdinati.get(7);
                       int fileNumeroPagine = Integer.parseInt(datiOrdinati.get(8));
                       
                       //System.out.println("Controllo elementi:"+fileID);
                       Data dataFile = new Data(fileGiorno,fileMese,fileAnno);
                       Libro libroFile = new Libro(filePrezzo,dataFile,fileTitolo,fileTipo,fileAutore,fileNumeroPagine);
                       libroFile.setCodiceID(fileID); //viene letto e sovrascritto il codiceID altrimenti viene modificato dal programma
                       //elencoDaFile.add(new Libro(filePrezzo,dataFile,fileTitolo,fileTipo,fileAutore,fileNumeroPagine));
                       archiviDaFile.get(contatoreArchivi).addAcquisto(libroFile);
                   }//fine if(dim vettore di stringhe == numero di variabili necessarie)      
                }//fine if "LIBRO" 
            else
                 if(rigaIn.contains("DVD") & contatoreArchivi >= 0){
                   
                   //int virgole = 0;
                   int contatore = 0;
                   
                   
                   for(int i = 0; i<rigaIn.length(); i++)
                   {
                       if(rigaIn.charAt(i) == ":".charAt(0))
                       { 
                           contatore = i+1;
                       }
                           if(rigaIn.charAt(i) == ",".charAt(0) || rigaIn.charAt(i) == "~".charAt(0)) //uso "~" come carattere speciale per individurare la fine della stringa
                           {
                               datiOrdinati.add(rigaIn.substring(contatore, i)); //utilizzo il vettore per ricavare in posizione ordinata i file
                               contatore = i+1;
                           }    
                    }
                      if(datiOrdinati.size() == 9){
                       //System.out.println("Dati ordinati per i costruttori di Dvd:"+datiOrdinati);
                       int fileID = Integer.parseInt(datiOrdinati.get(0)); //ok
                       double filePrezzo = Double.parseDouble(datiOrdinati.get(1)); //ok
                       int fileGiorno = Integer.parseInt(datiOrdinati.get(2)); //ok
                       int fileMese = Integer.parseInt(datiOrdinati.get(3)); //ok
                       int fileAnno = Integer.parseInt(datiOrdinati.get(4)); //ok
                       String fileTitolo  = datiOrdinati.get(5); //ok
                       String fileGenere = datiOrdinati.get(6); //genere ok
                       String fileAutore = datiOrdinati.get(7);//ok
                       int fileDurata = Integer.parseInt(datiOrdinati.get(8));//durata ok
                       
                       //System.out.println("Controllo elementi:"+fileID);
                       Data dataFile = new Data(fileGiorno,fileMese,fileAnno);
                       
                       Dvd DvdFile = new Dvd(filePrezzo,dataFile,fileTitolo,fileGenere,fileAutore,fileDurata);
                       DvdFile.setCodiceID(fileID);
                       archiviDaFile.get(contatoreArchivi).addAcquisto(DvdFile);
                   }//fine if(dim vettore di stringhe == numero di variabili necessarie)      
                }//fine if "DVD" 
            else 
                 if(rigaIn.contains("CD") & contatoreArchivi >= 0){
                   
                   //int virgole = 0;
                   int contatore = 0;
                   
                   
                   for(int i = 0; i<rigaIn.length(); i++)
                   {
                       if(rigaIn.charAt(i) == ":".charAt(0))
                       { 
                           contatore = i+1;
                       }
                           if(rigaIn.charAt(i) == ",".charAt(0) || rigaIn.charAt(i) == "~".charAt(0)) //uso "~" come carattere speciale per individurare la fine della stringa
                           {
                               datiOrdinati.add(rigaIn.substring(contatore, i)); //utilizzo il vettore per ricavare in posizione ordinata i file
                               contatore = i+1;
                           }    
                    }
                      if(datiOrdinati.size() == 11){
                       //System.out.println("Dati ordinati per i costruttori di CDmusicale:"+datiOrdinati);
                       int fileID = Integer.parseInt(datiOrdinati.get(0));//ok
                       double filePrezzo = Double.parseDouble(datiOrdinati.get(1));//ok
                       int fileGiorno = Integer.parseInt(datiOrdinati.get(2));//ok
                       int fileMese = Integer.parseInt(datiOrdinati.get(3));//ok
                       int fileAnno = Integer.parseInt(datiOrdinati.get(4));//ok
                       String fileNome  = datiOrdinati.get(5);//nome cd ok
                       String fileAutore = datiOrdinati.get(6);
                       String fileAlbum = datiOrdinati.get(7);
                       String fileGenere = datiOrdinati.get(8);
                       int fileNumeroCanzoni = Integer.parseInt(datiOrdinati.get(9));
                       int fileDurata = Integer.parseInt(datiOrdinati.get(10));
                       //System.out.println("Controllo elementi:"+fileID);
                       Data dataFile = new Data(fileGiorno,fileMese,fileAnno);
                       
                       CDmusicale CDFile = new CDmusicale(filePrezzo,dataFile,fileNome,fileAutore,fileAlbum,fileGenere,fileNumeroCanzoni,fileDurata);
                       CDFile.setCodiceID(fileID);
                       archiviDaFile.get(contatoreArchivi).addAcquisto(CDFile);
                   }//fine if(dim vettore di stringhe == numero di variabili necessarie)      
                }//fine if "CD" 
               
                   datiOrdinati.clear();
                   //++contatoreArchivi;
                   ++ausiliario;
           }// fine while prossima riga
                //System.out.println("Oggetti generati da file:"+elencoDaFile);
                //System.out.println("ausiliario: "+ausiliario+" Contatore Archivi (deve partire da 0, -1 indica database vuoto): "+ contatoreArchivi);
        }//fine try
         catch(FileNotFoundException fe)
         {
             databaseNonTrovato = true;
                System.out.println("\nAttenzione non è stato trovato il Database."
                        + "\nProbabilemnte stai usando questo programma per la prima volta"
                        + ", oppure\nhai forzato la chiusura dello stesso in una sessione precedente."
                        + "\nSe termini correttamente questa sessione il probelma non si ripresenterà.");
         }
                return archiviDaFile;
        }// fine metodo leggi da file
           
     }//fine classe
 
