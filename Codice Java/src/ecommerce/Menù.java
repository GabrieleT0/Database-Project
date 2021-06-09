package ecommerce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Menù {

	public static void main(String[] args) throws IOException {
		EcommerceBD db= new EcommerceBD();
		InputStreamReader keyIS;
		BufferedReader keyBR;
		int i = 0;
		String scelta;

		keyIS = new InputStreamReader(System.in);
		keyBR = new BufferedReader(keyIS);

		while (i !=500) {
			System.out.println("\n Operazioni CRUD:");
			System.out.println("1, inserimento prodotto");
			System.out.println("2, inserimento azienda costruttrice");
			System.out.println("3,inserimento magazzino");
			System.out.println("4,Inserimento nuovo pagamento relativo ad un ordine");
			System.out.println("5,Inserimento nuovo gestore");
			System.out.println("6,Inserimento nuovo account PayPal");
			System.out.println("7,Stampa numero prodotti in un ordine");
			System.out.println("8,Inserimento nuovo ordine");
			System.out.println("9,Aggiorna prezzo di un prodotto");
			System.out.println("10,Aggiorna stato ordine");
			System.out.println("11,Visualizza importo relativo ad un pagamento");
			System.out.println("12,Visualizza tabella prodotto");
			System.out.println("13,Ricerca prodotto avente prezzo maggiore di €40.00");
			System.out.println("14,Ricerca numero carta di credito con intestatario Andrea Verdi");
			System.out.println("15,Ricerca clienti che abitano a Salerno");
			System.out.println("16,Ricerca prodotto di genere smartphone nel magazzino 1");
			System.out.println("17,Ricerca ordini dell'account gabrieletuozzo@gmail.com in stato di lavorazione ");
			System.out.println("18,Elenco prodotti e la loro disponibilità nel relativo magazzino");
			System.out.println("19,Ricerca dell'ordine con importo ordine maggiore");
			System.out.println("20,Ricerca nome prodotto il cui prezzo è maggiore del prezzo di tutti i prodotti di genere componentistica pc");
			System.out.println("21,Cancella un prodotto");
			System.out.println("22,Inserisci nuovo prodotto in un ordine");
			System.out.println("500,Esci");
			System.out.print("Inserisci scelta: ");
			
			scelta = keyBR.readLine();

			try {
				i = Integer.parseInt(scelta);
			} catch (NumberFormatException e) {
				i = 499;
			} 

			switch (i) {
			case 1: {
				System.out.println("Inserimento Prodotto");
				db.insertProdotto();
				break;
			}
			case 2: {
				System.out.println("Inserimento azienda costruttrice");
				db.insertAziendaC();
				break;
			}
			case 3: {
				System.out.println("Inserimento magazzino");
				db.insertMagazzino();
				break;
			}
			case 4:{
				System.out.println("Inserimento nuovo pagamento relativo ad un ordine");
				db.insertPagamento();
				break;
			}
			case 5:{
				System.out.println("Inserimento nuovo gestore");
				db.insertGestore();
				break;
			}
			case 6:{
				System.out.println("Inserimento nuovo account PayPal");
				db.InsertPayPal();
				break;
			}
			case 7:{
				System.out.println("Stampa numero di prodotti in un ordine");
				db.retrieveNumPr();
				break;
			}
			case 8:{
				System.out.println("Inserimento nuovo ordine");
				db.insertOrdine();
				break;
			}
			case 9:{
				System.out.println("Aggiornamento prezzo di un prodotto");
				db.updatePrezzo();
				break;
			}
			case 10:{
				System.out.println("Aggiornamento stato ordine");
				db.updateStatoOrdine();
				break;
			}
			case 11:{
				System.out.println("Visualizzazione importo relativo ad un pagamento");
				db.retrieveImporto();
				break;
			}
			case 12:{
				System.out.println("Visualizzazione tabella prodotto ");
				db.printTable("prodotto");
				break;
			}
			case 13:{
				System.out.println("Prodotto avente prezzo maggiore di €40.00");
				db.ricercaProdotto();
				break;
			}
			case 14:{
				System.out.println("Numero di carta corrispondente");
				db.ricercaCartaDiCredito();
				break;
			}
			case 15:{
				System.out.println("Clienti che abitano a Salerno");
				db.ricercaCliente();
				break;
			}
			case 16:{
				System.out.println("Smartphone nel magazzino 1");
				db.ricercaProdottoMagazzino();
				break;
			}
			case 17:{
				System.out.println("Ordini in stato in lavorazione dell'account gabrieletuozzo@gmail.com");
				db.ricercaOrdine();
				break;
			}
			case 18:{
				System.out.println("Prodotti in magazzino");
				db.ricercaDisponibilitàPr();
				break;
			}
			case 19:{
				System.out.println("Numero ordine con importo maggiore");
				db.ricercaOrdineMax();
				break;
			}
			case 20:{
				System.out.println("Prodotto trovato");
				db.prodottoPrezzoMax();
				break;
			}
			case 21:{
				System.out.println("Cancellazione di un prodotto");
				db.deletePr();
				break;
			}
			case 22:{
				System.out.println("Inserimento nuovo prodotto in un ordine");
				db.insertProdottoOrd();
				break;
			}
			case 500:{
				System.out.println("Uscita");
				break;
			}
			default: {
				System.out.println("Scelta non presente");
				break;
			}
			} 
		} 

	} 

	}

