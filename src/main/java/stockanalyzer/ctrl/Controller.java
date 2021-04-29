package stockanalyzer.ctrl;

import yahooApi.YahooFinance;
import yahooApi.beans.QuoteResponse;
import yahooApi.beans.Result;
import yahooApi.beans.YahooResponse;
import yahoofinance.Stock;


import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Controller {

	public Stream<Result> process(String ticker) throws IOException {
		System.out.println("Start process");

		//TODO implement Error handling

		//TODO implement methods for
		//1) Daten laden
		//2) Daten Analyse

		stock();


		List<String> tic = Arrays.asList(ticker);
		YahooFinance yahooFinance = new YahooFinance();
		YahooResponse yahooResponse = yahooFinance.getCurrentData(tic);
		QuoteResponse quotes = yahooResponse.getQuoteResponse();
		return quotes.getResult().stream();

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
