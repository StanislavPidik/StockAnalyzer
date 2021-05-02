package stockanalyzer.ui;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.util.stream.Stream;

import stockanalyzer.ctrl.Controller;
import yahooApi.beans.Result;

public class UserInterface
{

	private Controller ctrl = new Controller();

	public void getDataFromCtrl1(){
		try {
			Stream<Result> stream = ctrl.process( "BABA");
			stream.forEach(quote -> System.out.println(quote.getShortName() + " ask: " + quote.getAsk() + " " + quote.getCurrency()));
		} catch (MalformedURLException e) {
			System.out.println("wrong URL");
		} catch (IOException e) {
			System.out.println("Connections error");
		}
	}

	public void getDataFromCtrl2(){
		try {
			Stream<Result> stream = ctrl.process( "GOOG");
			stream.forEach(quote -> System.out.println(quote.getShortName() + " ask: " + quote.getAsk() + " " + quote.getCurrency()));
		} catch (MalformedURLException e) {
			System.out.println("wrong URL");
		} catch (IOException e) {
			System.out.println("Connections error");
		}

	}

	public void getDataFromCtrl3(){
		try {
			Stream<Result> stream = ctrl.process( "VOE.VI");
			stream.forEach(quote -> System.out.println(quote.getShortName() + " ask: " + quote.getAsk() + " " + quote.getCurrency()));
		} catch (MalformedURLException e) {
			System.out.println("wrong URL");
		} catch (IOException e) {
			System.out.println("Connections error");
		}

	}
	public void getDataFromCtrl4(){
		try {
			ctrl.processStock("SIE.DE");
		} catch (MalformedURLException e) {
			System.out.println("wrong URL");
		} catch (IOException e) {
			System.out.println("Connections error");
		}

	}

	public void getDataFromCtrl5(){
		try {
			ctrl.processStock("^DJI");
		} catch (MalformedURLException e) {
			System.out.println("wrong URL");
		} catch (IOException e) {
			System.out.println("Connections error");
		}

	}

	public void getDataForCustomInput() {

	}


	public void start() {
		Menu<Runnable> menu = new Menu<>("User Interfacx");
		menu.setTitel("Wählen Sie aus:");
		menu.insert("a", "Alibaba actual:", this::getDataFromCtrl1);
		menu.insert("b", "Google Alphabet actual:", this::getDataFromCtrl2);
		menu.insert("c", "Voestalpine actual:", this::getDataFromCtrl3);
		menu.insert("d", "Siemens last days:",this::getDataFromCtrl4);
		menu.insert("e", "Dow Jones last days:",this::getDataFromCtrl5);
		menu.insert("q", "Quit", null);
		Runnable choice;
		while ((choice = menu.exec()) != null) {
			choice.run();
		}
		ctrl.closeConnection();
		System.out.println("Program finished");
	}


	protected String readLine()
	{
		String value = "\0";
		BufferedReader inReader = new BufferedReader(new InputStreamReader(System.in));
		try {
			value = inReader.readLine();
		} catch (IOException e) {
		}
		return value.trim();
	}

	protected Double readDouble(int lowerlimit, int upperlimit)
	{
		Double number = null;
		while(number == null) {
			String str = this.readLine();
			try {
				number = Double.parseDouble(str);
			}catch(NumberFormatException e) {
				number=null;
				System.out.println("Please enter a valid number:");
				continue;
			}
			if(number<lowerlimit) {
				System.out.println("Please enter a higher number:");
				number=null;
			}else if(number>upperlimit) {
				System.out.println("Please enter a lower number:");
				number=null;
			}
		}
		return number;
	}
}
