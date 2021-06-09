package ecommerce;

public class Test {

	public static void main(String[] args) {
		EcommerceBD db=new EcommerceBD();
		
		System.out.println("Inserimento prodotto");
		db.insertProdotto();		
		System.out.println();
		
		System.out.println("Inserimento azienda costruttrice");
		db.insertAziendaC();
		System.out.println();
		
		System.out.println("Inserimento magazzino");
		db.insertMagazzino();
		System.out.println();
		
		System.out.println("Inserimento pagamento");
		db.insertPagamento();
		System.out.println();
		
		System.out.println("Inserimento nuovo gestore");
		db.insertGestore();
		System.out.println();
		
		System.out.println("Inserimento nuovo metodo di pagamento PayPal");
		db.InsertPayPal();
		System.out.println();
		
		System.out.println("Stampa numero prodotti in un ordine");
		db.retrieveNumPr();
		System.out.println();
		
		System.out.println("Inserimento prodotto in un ordine");
		db.insertProdottoOrd();
		System.out.println();
		
		System.out.println("Aggiornamento prezzo di un prodotto");
		db.updatePrezzo();
		System.out.println();
		
		System.out.println("Aggiornamento stato di un ordine");
		db.updateStatoOrdine();
		System.out.println();

		System.out.println("Visualizzazione importo relativo ad un pagamento");
		db.retrieveImporto();
		System.out.println();
		
		System.out.println("Tabella prodotto");
		db.printTable("prodotto");
		System.out.println();
		
		System.out.println("Cancellazione di un prodotto");
		db.deletePr();
		System.out.println();
		
		System.out.println("Ricerca prodotti avente prezzo maggiore di Ä40.00");
		db.ricercaProdotto();
		System.out.println();
		
		System.out.println("Ricerca numero carta di credito relativa ad Antonio Verdi");
		db.ricercaCartaDiCredito();
		System.out.println();
		
		System.out.println("Ricerca clienti che abitano a Salerno");
		db.ricercaCliente();
		System.out.println();
		
		System.out.println("Ricerca prodotti di genere smartphone nel magazzino 1");
		db.ricercaProdottoMagazzino();
		System.out.println();
		
		System.out.println("Ricerca prodotti avente prezzo maggiore di Ä40.00");
		db.ricercaProdotto();
		System.out.println();
		
		System.out.println("Ricerca ordini in stato in lavorazione per l'utente gabrieletuozzo@gmail.com");
		db.ricercaOrdine();
		System.out.println();
		
		System.out.println("Ricerca dei prodotti nel magazzino con relativa disponibilit‡");
		db.ricercaDisponibilit‡Pr();
		System.out.println();
		
		System.out.println("Ricerca ordine con importo maggiore");
		db.ricercaOrdineMax();
		System.out.println();
		
		System.out.println("Ricerca prodotti il cui prezzo Ë maggiore del prezzo di tutti i prodotti di genere componentistica pc");
		db.prodottoPrezzoMax();
		System.out.println();
	}

}
