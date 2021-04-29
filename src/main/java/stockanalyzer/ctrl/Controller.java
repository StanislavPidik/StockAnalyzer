package stockanalyzer.ctrl;

import yahoofinance.Stock;

import java.io.IOException;

public class Controller {
		
	public void process(String ticker) {
		System.out.println("Start process");

		//TODO implement Error handling 

		//TODO implement methods for
		//1) Daten laden
		//2) Daten Analyse

	}

	public void stock() {

		Stock stock = null;
		try {
			stock = yahoofinance.YahooFinance.get("AAPL");
			stock.getHistory().forEach(System.out::println);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}
	

	public Object getData(String searchString) {

		
		return null;
	}


	public void closeConnection() {
		
	}
}
