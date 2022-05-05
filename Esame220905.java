/*
 * Riccardo Beniamino 244054, Simone Tacconi 248240
 */
package esame220905;

import java.util.ArrayList;
import java.io.FileNotFoundException;
import java.util.GregorianCalendar;
import java.util.Calendar;
import java.util.Scanner;

/**
 * Nell'ambito della realizzazione di un programma per la gestione di piccoli 
 * archivi, si vuole realizzazione una classe elenco in cui siano presenti almeno 
 * tre tipi di elementi: libri, CD musicali e DVD; Questi elementi hanno in comune 
 * alcuni attributi, tra cui il prezzo, la data di acquisto e un codice di 
 * identificazione univoco assegnato dal programma stesso;
 * 1) Progettare le classi che si ritengono necessarie per modellare la situazione sopra descritta;
 * 2)Scrivere un metodo della classe elenco per calcolare la spesa totale 
 * effettuata in un mese dato (es luglio, 2005) per l'acquisto di libri;
 * 3)Scrivere due funzioni: una  funzione pubblica che, ricevendo in ingresso un elenco, 
 * scriva su un file tutti i dati relativi agli elementi e un'altra funzione pubblica che, 
 * dato il nome di un file contente elementi, restituisca il relativo elenco; 
 * 
 * Nel metodo di classe Main viene gestita tutta la parte relativa all'interfaccia
 * utente; Vengono evitati inserimenti sbagliati e casi particolari grazie alle 
 * ai vari controlli dati dalle strutture dati if e switch e alle variabili booleane
 * inserite opportunamente.
 * @author rikyr, Simotac97
 * @version 7.1 in questa ultima versione sono state aggiunte le eccezioni per 
 *  evitare errori in caso di database non presente (DatabaseLocale.txt)
 * Aggiunti ulteririori controlli per la lettura del database.
 */
public class Esame220905 {

    /**
     * @param args the command line arguments
     * @throws java.io.FileNotFoundException eccezione generata in caso di file non trovato
     */
    public static void main(String[] args) throws FileNotFoundException {
        // TODO code application logic here 
        
        Scanner in = new Scanner(System.in);
        System.out.println("##### Programma per catalogare oggetti acquistati #####");
        
        GregorianCalendar gcUltimaModifica = Archivio.getDataUltimaModificaDB();
        ArrayList<Archivio> vettoreArchivi = new ArrayList<>();
        
        int i = 0;
        
        if(!Archivio.getErrDatabaseNonTrovato())
        {
         System.out.println("\nVuoi recuperare l'ultima sessione del "+
                gcUltimaModifica.get(Calendar.DATE)+"/"+
                (gcUltimaModifica.get(Calendar.MONTH)+1)+"/"+ //i mesi in java partono da 0 = gennaio
                gcUltimaModifica.get(Calendar.YEAR)+" alle ore "
                +gcUltimaModifica.get(Calendar.HOUR_OF_DAY)+":"+gcUltimaModifica.get(Calendar.MINUTE)+
                " Oppure vuoi iniziarne una nuova?");
         System.out.print("Seleziona 1 per iniziare una nuova sessione, 2 per caricare l'ultima: ");
         i = in.nextInt();
        }
        else
        {
            System.out.println("\nNon sono presenti sessioni precedenti, stai per iniziarne una nuova.\n");
            i = 1;
        }
        
        switch(i)
        {
            case 1:
                int ca = 0;
                int n = 0;
               boolean controlloErrori = false;
               
               while(n != 2 || vettoreArchivi.isEmpty())
               {
                    System.out.print("Seleziona 1 per inserire un nuovo archivo, 2 per terminare gli inserimenti: ");
                    n = in.nextInt();
                    switch(n)
                    {
                        case 1:
                         System.out.print("Inserisci il nome dell'archivio n°"+(++ca)+" : ");
                         vettoreArchivi.add(new Archivio(in.next()));
                        break;
                   
                        case 2:
                            if(vettoreArchivi.isEmpty())
                            {
                                System.out.println("Errore! Ci deve essere almeno un'archivio.");
                            }
                            else
                            {
                                System.out.println("Inserimenti terminati! \nHai appena creato "+vettoreArchivi.size()+" archivi! "
                                + "Inserisci gli oggetti negli archivi.\n");
                            }
                         break;
                     
                        default: 
                        System.out.println("Valore immesso non valido!");
                    }
               }
                    for(int a = 0; a<vettoreArchivi.size(); ++a)
                    {
                        int b = 0;
                        System.out.println("Adesso ti trovi nell'archivio n° "+(a+1)+" "+vettoreArchivi.get(a).getNome());
                        
                        while(b != 4 || controlloErrori)
                        {
                        System.out.print("Che tipologia di oggetto desideri aggiungere?"+"\n"
                                + "Seleziona 1 per Libro, 2 per CD, 3 per DVD, 4 per terminare gli inserimenti: ");
                        //System.out.println("a: "+a);
                                   b = in.nextInt();
                           switch(b)
                           {
                               case 1:
                                   System.out.println("Hai selezionato Libro! Inserisci i dati associati.");
                                   Libro l1 = new Libro();
                                   Data d1 = new Data();
                                   System.out.print("Inserisci il prezzo di acqusito: "); 
                                   l1.setPrezzo(in.nextDouble());
                                   System.out.println("Inserisci la data di acquisto: ");
                                   System.out.print("Inserisci il giorno: "); d1.setGiorno(in.nextInt());
                                   System.out.print("Inserisci il mese: "); d1.setMese(in.nextInt());
                                   System.out.print("Inserisci l'anno: "); d1.setAnno(in.nextInt());
                                   l1.setDataDiAcquisto(d1);
                                   System.out.print("Inserisci il titolo: "); l1.setTitolo(in.next());
                                   System.out.print("Inserisci il tipo: "); l1.setTipo(in.next());
                                   System.out.print("Inserisci L'autore: "); l1.setAutore(in.next());
                                   System.out.print("Inserisci il numero di pagine: "); l1.setNumPagine(in.nextInt());
                                   System.out.println("\nDati inseriti correttamente! "
                                           + "Aggiungo il Libro nell'archivio n° "+(a+1)+" "+vettoreArchivi.get(a).getNome()+"\n");
                                   
                                   OggettoAcquistato l = l1;
                                   vettoreArchivi.get(a).addAcquisto(l);
                                   break;
                               
                               case 2:
                                   System.out.println("Hai selezionato CD! Inserisci i dati associati.");
                                   CDmusicale c1 = new CDmusicale();
                                   Data d2 = new Data();
                                   System.out.print("Inserisci il prezzo di acqusito: "); 
                                   c1.setPrezzo(in.nextDouble());
                                   System.out.println("Inserisci la data di acquisto: ");
                                   System.out.print("Inserisci il giorno: "); d2.setGiorno(in.nextInt());
                                   System.out.print("Inserisci il mese: "); d2.setMese(in.nextInt());
                                   System.out.print("Inserisci l'anno: "); d2.setAnno(in.nextInt());
                                   c1.setDataDiAcquisto(d2);
                                   System.out.print("Inserisci il nome del CD: "); c1.setNomeCD(in.next());
                                   System.out.print("Inserisci L'autore: "); c1.setAutore(in.next());
                                   System.out.print("Inserisci L'album: "); c1.setAlbum(in.next());
                                   System.out.print("Inserisci il genere musciale: "); c1.setGenere(in.next());
                                   System.out.print("Inserisci il numero di canzoni: "); c1.setNumeroCanzoni(in.nextInt());
                                   System.out.print("Inserisci la durata in minuti: "); c1.setDurataCD(in.nextInt());
                                   System.out.println("\nDati inseriti correttamente! "
                                           + "Aggiungo il CD nell'archivio "+(a+1)+" "+vettoreArchivi.get(a).getNome()+"\n");
                                   
                                   OggettoAcquistato c = c1;
                                   vettoreArchivi.get(a).addAcquisto(c);
                                   break;
                                   
                               case 3:
                                   System.out.println("Hai selezionato DVD! Inserisci i dati associati.");
                                   Dvd dvd1 = new Dvd();
                                   Data d3 = new Data();
                                   System.out.print("Inserisci il prezzo di acqusito: "); 
                                   dvd1.setPrezzo(in.nextDouble());
                                   System.out.println("Inserisci la data di acquisto: ");
                                   System.out.print("Inserisci il giorno: "); d3.setGiorno(in.nextInt());
                                   System.out.print("Inserisci il mese: "); d3.setMese(in.nextInt());
                                   System.out.print("Inserisci l'anno: "); d3.setAnno(in.nextInt());
                                   dvd1.setDataDiAcquisto(d3);
                                   System.out.print("Inserisci il nome del Film: "); dvd1.setNomeFilm(in.next());
                                   System.out.print("Inserisci il tipo di Film: "); dvd1.setTipo(in.next());
                                   System.out.print("Inserisci l'autore: "); dvd1.setAutore(in.next());
                                   System.out.print("Inserisci la durata in minuti: "); dvd1.setDurataDvd(in.nextInt());
                                   System.out.println("\nDati inseriti correttamente! "
                                           + "Aggiungo il DVD nell'archivio "+(a+1)+" "+vettoreArchivi.get(a).getNome()+"\n");
                                   
                                   OggettoAcquistato d = dvd1;
                                   vettoreArchivi.get(a).addAcquisto(d);
                                   break;
                                   
                               case 4:
                                   if(vettoreArchivi.get(a).getNumAcquisti() == 0 )
                                   {
                                       controlloErrori = true;
                                       System.out.println("\nErrore archivio: "+vettoreArchivi.get(a).getNome()+" n°"+(a+1)+" Archivio vuoto!"
                                               + " Devi inserire almeno un'elemento.\n");
                                   }
                                   else
                                   {
                                       controlloErrori = false;
                                        System.out.println("Inserimenti terminati nell'archivio "
                                           +vettoreArchivi.get(a).getNome()+" n°"+(a+1));
                                   }
                                   break;
                                   
                               default:
                                   System.out.println("Valore immesso non valido!");
                           }
                        }
                    }
                break;
                
            case 2:
                System.out.println("\nCarico l'ultima sessione del "+
                gcUltimaModifica.get(Calendar.DATE)+"/"+
                (gcUltimaModifica.get(Calendar.MONTH)+1)+"/"+ //i mesi in java partono da 0 = gennaio
                gcUltimaModifica.get(Calendar.YEAR)+" alle ore "
                +gcUltimaModifica.get(Calendar.HOUR_OF_DAY)+":"+gcUltimaModifica.get(Calendar.MINUTE));
                
                vettoreArchivi = Archivio.leggiElementiDaFile();
                break;
                
            default:
                System.out.println("Valore immesso non valido!");
        }
           
        int cFinale = 1;
        while(cFinale == 1 || cFinale == 2 || cFinale > 4)
        {
            System.out.print("\n------Menù Principale------\n"
                    + "Seleziona 1 per visualizzare lo stato corrente degli archivi,"
                + " 2 per effettuare operazioni sugli stessi,\n3 per terminare la sessione"
                + " e salvare i cambiamenti, 4 per terminare la sessione SENZA salvare i cambiamenti: ");
            
            cFinale = in.nextInt();
            
            switch(cFinale)
            {
                case 1:
                    System.out.println("\n###### Stato corrente Archivi ######\n");
                    int t=1;
                    int ca=1;
                    for(Archivio arc : vettoreArchivi)
                    {
                      t = 1;
                      System.out.println("-> ARCHIVIO n° "+ca+" [nome|n° elementi]:"+arc.getNome()+','+arc.getNumAcquisti()+"~");
                      for(OggettoAcquistato o : arc.getAcquisti())
                      {
                        System.out.println("N° "+t+" "+o.toString());
                        ++t;
                      }
                        ++ca;
                    }
                    break;
                    
                case 2:
                    int inOper = 0;
                    while(inOper != 6)
                    {
                        System.out.print("\n------Menù operazioni archvi------\nSeleziona "
                            + "1 per aggiungere un nuovo archivio, 2 per rimuoverlo, "
                            + "3 per modificare quelli presenti,\n4 per effettuare ricerche, 5 per calcolare spese,"
                                + " 6 per terminare le modifiche: ");
                        inOper = in.nextInt();
                 switch(inOper)
                {
                
                  case 1:
                      System.out.println("\n------Menù crea nuovo archivio------");
                      System.out.print("inserisici il nome del nuovo archivio n° "+(vettoreArchivi.size()+1)+": ");
                      vettoreArchivi.add(new Archivio(in.next()));
                      System.out.println("\nArchivio "+ vettoreArchivi.size()+") "+vettoreArchivi.get(vettoreArchivi.size()-1).getNome()+" aggiunto con successo!");
                  break;
                                
                case 2:
                    System.out.println("------Menù rimozione archivi------");
                          if(!vettoreArchivi.isEmpty())
                        {
                          System.out.println("\nSono presenti i seguenti archivi:");
                          for(int ka=0; ka<vettoreArchivi.size(); ka++)
                          {
                            System.out.println((ka+1)+") "+vettoreArchivi.get(ka).getNome());
                          }
                             System.out.print("Selezina quello che desideri rimuovere: ");
                             int selOper = in.nextInt();
                             if(selOper > vettoreArchivi.size() || selOper < 1 )
                             {
                               System.out.println("Valore immesso non valido!");
                             }
                              else
                                {
                                   if(vettoreArchivi.size() == 1)
                                    {
                                        System.out.print("\nStai per rimuovere l'ultimo archivio presente."
                                                + " Vuoi proseguire comunque? Seleziona 1 per si, 2 per no: ");
                                        switch(in.nextInt())
                                        {
                                            case 1:
                                                System.out.println("\nRimuvo l'ultimo archivio!");
                                                vettoreArchivi.remove(0);
                                                break;
                                            case 2:
                                                 System.out.println("\nOperazione annullata.");
                                                 break;
                                            default:
                                                System.out.println("\nValore immesso non valido!");
                                        }
                                    }
                                     else
                                         {
                                            System.out.println("\nRimuovo l'archivio "+selOper+".");
                                            vettoreArchivi.remove(selOper-1);
                                         }
                                }
                        } 
                          else
                          {
                              System.out.println("\n Non ci sono più archivi da rimuovere.");
                          }
                                
                                break;
                            
                            case 3:
                                System.out.println("\n------Menù modifica archivi------");
                                if(!vettoreArchivi.isEmpty())
                                {
                                    System.out.println("Sono presenti i seguenti archivi:");
                                    for(int ka=0; ka<vettoreArchivi.size(); ka++)
                                    {
                                        System.out.println((ka+1)+") "+vettoreArchivi.get(ka).getNome());
                                    }
                                    System.out.print("\nSu quale archvio vuoi operare? Inserisci il numero: ");
                                    int selOper = in.nextInt();
                                    if(selOper > vettoreArchivi.size() || selOper < 1 )
                                    {
                                        System.out.println("\nValore immesso non valido!");
                                    }
                                    else
                                    {
                                        System.out.println("Hai selezionato l'archvio "+selOper+") "+vettoreArchivi.get(selOper-1).getNome());
                                        int ma = 0;
                                        while(ma != 5)
                                        {   
                                            System.out.println("\n------Menù modifica archvio "+selOper+") "+vettoreArchivi.get(selOper-1).getNome()+" ------");
                                            System.out.print("Seleziona 1 per rinominare questo archivio, 2 per aggiungere un'oggetto,"
                                                + " 3 per rimuverlo, 4 per rimuovere tutti gli oggetti, 5 per uscire: ");
                                            ma = in.nextInt();
                                            switch(ma)
                                            {
                                                case 1:
                                                    System.out.print("\nStai per rinominare l'archvio "
                                                            +selOper+") "+vettoreArchivi.get(selOper-1).getNome()+
                                                            "\nInserisci il nuovo nome: ");
                                                    
                                                    String nuovoNome = in.next();
                                                    vettoreArchivi.get(selOper-1).setNome(nuovoNome);
                                                    System.out.println("Archvio rinominato correttamente!\nNuovo nome:"+nuovoNome);
                                                    break;
                                                    
                                                case 2:
                                                    System.out.println("\n------Menù inserimento oggetti------");
                                                    int addOgg = 0;
                                                    while(addOgg != 4)
                                                    {
                                                        System.out.print("Seleziona 1 per aggiungere un nuovo Libro,"
                                                                + " 2 per un nuovo CD, 3 per un nuovo DVD, 4 per uscire: ");
                                  addOgg = in.nextInt();
                                  switch(addOgg)
                                 {
                                   case 1:
                                   System.out.println("\nHai selezionato Libro! Inserisci i dati associati.");
                                   Libro l1 = new Libro();
                                   Data d1 = new Data();
                                   System.out.print("Inserisci il prezzo di acqusito: "); 
                                   l1.setPrezzo(in.nextDouble());
                                   System.out.println("Inserisci la data di acquisto: ");
                                   System.out.print("Inserisci il giorno: "); d1.setGiorno(in.nextInt());
                                   System.out.print("Inserisci il mese: "); d1.setMese(in.nextInt());
                                   System.out.print("Inserisci l'anno: "); d1.setAnno(in.nextInt());
                                   l1.setDataDiAcquisto(d1);
                                   System.out.print("Inserisci il titolo: "); l1.setTitolo(in.next());
                                   System.out.print("Inserisci il tipo: "); l1.setTipo(in.next());
                                   System.out.print("Inserisci L'autore: "); l1.setAutore(in.next());
                                   System.out.print("Inserisci il numero di pagine: "); l1.setNumPagine(in.nextInt());
                                   System.out.println("\nDati inseriti correttamente! "
                                           + "Aggiungo il Libro nell'archivio n° "+selOper+" "+vettoreArchivi.get(selOper-1).getNome()+"\n");
                                   
                                   OggettoAcquistato l = l1;
                                   vettoreArchivi.get(selOper-1).addAcquisto(l);
                                     break;
                                                                
                                   case 2:
                                   System.out.println("\nHai selezionato CD! Inserisci i dati associati.");
                                   CDmusicale c1 = new CDmusicale();
                                   Data d2 = new Data();
                                   System.out.print("Inserisci il prezzo di acqusito: "); 
                                   c1.setPrezzo(in.nextDouble());
                                   System.out.println("Inserisci la data di acquisto: ");
                                   System.out.print("Inserisci il giorno: "); d2.setGiorno(in.nextInt());
                                   System.out.print("Inserisci il mese: "); d2.setMese(in.nextInt());
                                   System.out.print("Inserisci l'anno: "); d2.setAnno(in.nextInt());
                                   c1.setDataDiAcquisto(d2);
                                   System.out.print("Inserisci il nome del CD: "); c1.setNomeCD(in.next());
                                   System.out.print("Inserisci L'autore: "); c1.setAutore(in.next());
                                   System.out.print("Inserisci L'album: "); c1.setAlbum(in.next());
                                   System.out.print("Inserisci il genere musciale: "); c1.setGenere(in.next());
                                   System.out.print("Inserisci il numero di canzoni: "); c1.setNumeroCanzoni(in.nextInt());
                                   System.out.print("Inserisci la durata in minuti: "); c1.setDurataCD(in.nextInt());
                                   System.out.println("\nDati inseriti correttamente! "
                                           + "Aggiungo il CD nell'archivio "+selOper+" "+vettoreArchivi.get(selOper-1).getNome()+"\n");
                                   
                                   OggettoAcquistato c = c1;
                                   vettoreArchivi.get(selOper-1).addAcquisto(c);
                                     break;
                                                                
                                    case 3:
                                    System.out.println("\nHai selezionato DVD! Inserisci i dati associati.");
                                   Dvd dvd1 = new Dvd();
                                   Data d3 = new Data();
                                   System.out.print("Inserisci il prezzo di acqusito: "); 
                                   dvd1.setPrezzo(in.nextDouble());
                                   System.out.println("Inserisci la data di acquisto: ");
                                   System.out.print("Inserisci il giorno: "); d3.setGiorno(in.nextInt());
                                   System.out.print("Inserisci il mese: "); d3.setMese(in.nextInt());
                                   System.out.print("Inserisci l'anno: "); d3.setAnno(in.nextInt());
                                   dvd1.setDataDiAcquisto(d3);
                                   System.out.print("Inserisci il nome del Film: "); dvd1.setNomeFilm(in.next());
                                   System.out.print("Inserisci il tipo di Film: "); dvd1.setTipo(in.next());
                                   System.out.print("Inserisci l'autore: "); dvd1.setAutore(in.next());
                                   System.out.print("Inserisci la durata in minuti: "); dvd1.setDurataDvd(in.nextInt());
                                   System.out.println("\nDati inseriti correttamente! "
                                           + "Aggiungo il DVD nell'archivio "+selOper+" "+vettoreArchivi.get(selOper-1).getNome()+"\n");
                                   
                                   OggettoAcquistato d = dvd1;
                                   vettoreArchivi.get(selOper-1).addAcquisto(d);  
                                     break;
                                  
                                    case 4:
                                        System.out.println("Inserimenti terminati.");
                                        break;
                                     
                                   default:
                                     System.out.println("Valore immesso non valido!");
                                 } //fine switch aggiungi oggetto
                                } //fine while aggiungi oggetto
                                                    break;
                                                
                                                case 3:
                                                    System.out.println("\n------Menù rimozione oggetti------");
                                                    if(!vettoreArchivi.get(selOper-1).getAcquisti().isEmpty())
                                                    {
                                                        System.out.print("Seleziona 1 per rimuovere un oggetto dall'elenco, 2 per rimuoverlo"
                                                                + " utilizzando il codice identificativo, 3 per uscire: ");
                                                        switch(in.nextInt())
                                                        {
                                                            case 1:
                                                                System.out.print("\nIn questo archivio "+selOper+") "+vettoreArchivi.get(selOper-1).getNome()+
                                                                        "\nSono presenti "+vettoreArchivi.get(selOper-1).getNumAcquisti() +" oggetti\nStampo l'elenco\n\n");
                                                                int cFor = 0;
                                                                for(OggettoAcquistato o : vettoreArchivi.get(selOper-1).getAcquisti())
                                                                {
                                                                    System.out.println((++cFor)+") "+o.toString());
                                                                }
                                                                System.out.print("\nSeleziona l'oggetto che desideri rimuovere, seleziona 0 per terminare le rimozioni: ");
                                                                cFor = in.nextInt();
                                                                if(cFor < 1 || cFor > vettoreArchivi.get(selOper-1).getNumAcquisti())
                                                                {
                                                                    if(cFor == 0)
                                                                    {System.out.println("Rimozioni terminate.");}
                                                                    else
                                                                    {System.out.println("Valore immesso non valido!"); }
                                                                }
                                                                else
                                                                { 
                                                                    System.out.println("\nRimuovo l'oggetto n°"+cFor);
                                                                    vettoreArchivi.get(selOper-1).getAcquisti().remove(cFor-1);
                                                                }
                                                                break;
                                                                
                                                            case 2:
                                                                System.out.print("\nInserisci il codice identificativo: ");
                                                                int CodID = in.nextInt();
                                                                int k2 = 1;
                                                                int ne = 0;
                                                                boolean oNonTrovato = true;
                                                                
                                                                for(OggettoAcquistato o : vettoreArchivi.get(selOper-1).getAcquisti())
                                                                {
                                                                    if(o.getCodiceID() == CodID)
                                                                    {
                                                                        oNonTrovato = false;
                                                                        System.out.println("\nEllimino l'oggetto:\n"+(k2)+") "+o.toString());
                                                                        //vettoreArchivi.get(selOper-1).getAcquisti().remove(k2-1);
                                                                        //per qualche strano motivo questo metodo richimato nel ciclo genera un'eccezione
                                                                        //per evitare questo assegno il valore che mi interessa a "ne" e uso il metodo fuori dal ciclo.
                                                                        ne = k2;
                                                                    }
                                                                    ++k2;
                                                                }
                                                                
                                                                if(oNonTrovato)
                                                                {
                                                                    System.out.println("Non è presente nessun' oggetto da elliminare corrispondente al codice identificativo "+CodID+".");
                                                                }
                                                                else
                                                                {
                                                                    //metodo richiamato fuori dal ciclo, qui funziona bene
                                                                    vettoreArchivi.get(selOper-1).getAcquisti().remove(ne-1);
                                                                    System.out.println("Elliminazione terminata.");
                                                                }
                                                                break;
                                                                
                                                            case 3:
                                                                System.out.println("Rimozione oggetti terminata.");
                                                                break;
                                                            default:
                                                                System.out.println("Valore immesso non valido!");  
                                                        }
                                                    }
                                                    else
                                                    {
                                                        System.out.println("\nNon sono presenti oggetti da rimuovere.");
                                                    }
                                                    break;
                                                    
                                                case 4:
                                                    if(!vettoreArchivi.get(selOper-1).getAcquisti().isEmpty())
                                                    {
                                                        System.out.println("\nRimuovo tutti gli oggetti dall'archivio "
                                                                +selOper+") "+vettoreArchivi.get(selOper-1).getNome());
                                                        vettoreArchivi.get(selOper-1).cancellaElencoAcquisti();
                                                    }
                                                    else
                                                    {
                                                        System.out.println("Non sono presenti oggetti da rimuovere.");
                                                    }
                                                    break;
                                                    
                                                case 5:
                                                    System.out.println("Modifiche archivio termiate.");
                                                    break;
                                                    
                                                default:
                                                    System.out.println("Valore immesso non valido!");  
                                            }
                                        }
                                        
                                    }
                                    
                                }
                                else
                                {
                                    System.out.println("Non sono presenti archivi.");
                                }
                                break;
                                
                            case 4:
                                System.out.println("\n------Menù ricerca------");
                                if(!vettoreArchivi.isEmpty())
                                {
                                  int ricerca = 0;
                                    while(ricerca != 2)
                                    {
                                        System.out.print("Seleziona 1 per fare una ricerca, 2 per uscire: ");
                                        
                                        ricerca = in.nextInt();
                                        
                                        switch(ricerca)
                                        {
                                            case 1:
                                                System.out.print("\nChe genere di oggetto cerchi?"
                                                        + "\nSeleziona 1 per Libro, 2 per CD, 3 per DVD: ");
                                                String riferimento = "";
                                                switch(in.nextInt())
                                                {
                                                    case 1:
                                                        riferimento = "LIBRO";
                                                        break;
                                                        
                                                    case 2:
                                                        riferimento = "CD";
                                                        break;
                                                        
                                                    case 3:
                                                        riferimento = "DVD";
                                                        break;
                                                        
                                                    default:
                                                        System.out.println("Valore immesso non valido!");
                                                }
                                                System.out.print("Inserisci il nome/tipo/codiceID/prezzo del "+riferimento+ " da cercare: ");
                                                String nomeOgg = in.next();
                                                boolean nonTrovato = true;
                                                int ka2 = 1;
                                                for(Archivio a : vettoreArchivi)
                                                {
                                                    for(OggettoAcquistato o : a.getAcquisti())
                                                    {
                                                        if(o.getTipoOggetto().equals(riferimento) & o.toString().contains(nomeOgg))
                                                        {
                                                            nonTrovato = false;
                                                            System.out.println("\n"+riferimento + " trovato nell'archivio "+ka2+") "+a.getNome());
                                                            System.out.println(o.toString()+"\n");
                                                        }
                                                    }
                                                    ++ka2;
                                                }
                                                if(nonTrovato)
                                                {
                                                    System.out.println("\n"+riferimento+" Non trovato!\n");
                                                }
                                                break;
                                                      
                                            case 2:
                                                System.out.println("Ricerche terminate!");
                                                break;
                                                
                                            default:
                                                System.out.println("\nValore immesso non valido!");
                                        }
                                    }
                                    
                                }
                                 else
                                {
                                    System.out.println("\n Non sono presenti Archivi.");
                                }
                                break;
                                
                            case 5:
                                System.out.println("\n------Menù calcolo spese------");
                                if(!vettoreArchivi.isEmpty())
                                {
                                    System.out.println("Sono presenti i seguenti archivi");
                                    for(int ap = 0; ap<vettoreArchivi.size(); ap++)
                                    {
                                        System.out.println((ap+1)+") "+vettoreArchivi.get(ap).getNome());
                                    }
                                    System.out.print("\nSu quale di questi desideri calolare le spese? Inserisci il numero: ");
                                    int selOper = in.nextInt();
                                    if(selOper > vettoreArchivi.size() || selOper < 1 )
                                    {
                                        System.out.println("Valore immesso non valido!");
                                    }
                                    else
                                    {
                                        System.out.println("\nInserisci la data per cui vuoi calcolare il prezzo: ");
                                        System.out.print("Inserisci il giorno: "); int gg = in.nextInt();
                                        System.out.print("Inserisci il mese: "); int mm = in.nextInt();
                                        System.out.print("Inserisci l'anno: "); int aa = in.nextInt();
                                        vettoreArchivi.get(selOper-1).setDataRif(new Data(gg,mm,aa));
                                        System.out.println("\nCosto totale Libri per la data selezionata: "+vettoreArchivi.get(selOper-1).getPrezzoTotaleLibri());
                                        System.out.println("Costo totale DVD per la data selezionata: "+vettoreArchivi.get(selOper-1).getPrezzoTotaleDVD());
                                        System.out.println("Costo totale CD per la data selezionata: "+vettoreArchivi.get(selOper-1).getPrezzoTotaleCD());
                                    }
                                }
                                else
                                {
                                    System.out.println("\nNon sono presenti archivi.");
                                }
                                break;
                                
                            case 6:
                                System.out.println("\nModifiche terminate!");
                                break;
                            
                            default:
                                System.out.println("\nValore immesso non valido!");
                        }
                    }
                    break;
                    
                case 3:
                    if(vettoreArchivi.isEmpty())
                    {
                        System.out.println("\nNon sono presenti archivi da salvare.");
                    }
                    else
                    {
                        System.out.println("\nSalvo le modifice...");
                        Archivio.salvaElementiSuFile(vettoreArchivi);
                        System.out.println("Sessione terminata!");
                    }
                    break;
                
                case 4:
                    System.out.println("\nSessione terminata!");
                    break;
                    
                default:
                    System.out.println("Valore immesso non valido!");
            }
        }
         
    } 
    
}
