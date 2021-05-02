package stockanalyzer.ctrl;

import yahooApi.YahooFinance;
import yahooApi.beans.QuoteResponse;
import yahooApi.beans.Result;
import yahooApi.beans.YahooResponse;
import yahoofinance.Stock;
import yahoofinance.histquotes.Interval;


import java.io.IOException;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Stream;

public class Controller {

	public Stream<Result> process(String ticker) throws IOException {
		System.out.println("Start process");

		//TODO implement Error handling

		//TODO implement methods for
		//1) Daten laden
		//2) Daten Analyse

		List<String> tic = Arrays.asList(ticker);
		YahooFinance yahooFinance = new YahooFinance();
		YahooResponse yahooResponse = yahooFinance.getCurrentData(tic);
		QuoteResponse quotes = yahooResponse.getQuoteResponse();
		return quotes.getResult().stream();

	}

	public void processStock(String ticker) throws IOException {
		System.out.println("Start process");

			Calendar calendar = Calendar.getInstance();
			calendar.add(Calendar.WEEK_OF_MONTH, -60);
			Stock stock = yahoofinance.YahooFinance.get(ticker);
			System.out.println(
					"    " + stock.getName() + System.lineSeparator() + System.lineSeparator() +
					"MAX Price: " +
					stock.getHistory(calendar, Interval.DAILY).stream()
					.mapToDouble(s -> s.getClose().doubleValue())
					.max()
					.orElse(0.0)
					+ "  "+stock.getCurrency() + System.lineSeparator() +
					"Average Price: "+
					stock.getHistory().stream()
					.mapToDouble(s -> s.getClose().doubleValue())
					.average()
					.orElse(0.0)
					+ "  "+stock.getCurrency() + System.lineSeparator() +
					"Amount: " +
					stock.getHistory().stream()
					.mapToDouble(s -> s.getClose().doubleValue())
					.count()
			);
	}



	public Object getData(String searchString) {


		return null;
	}


	public void closeConnection() {

	}
}
