import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;
import java.util.*;
import java.awt.Desktop;
import java.net.URI;



public class Compiler {
	
	private final String URL1 = "http://finance.yahoo.com/d/quotes.csv?s=";
	private final String URL2 = "&f=nspomkjm3m4va5b6a2";
	
	public ArrayList<String> stockSymbols = new ArrayList<String>();
	public ArrayList<String> URLs = new ArrayList<String>();
	int symbolCounter;
	
	public void populateStockSymbolsArrayList()
	{
		Scanner symbolScanner;
		try 
		{
			symbolScanner = new Scanner(new File("EveryStockSymbol.csv"));
			symbolScanner.useDelimiter(",");
			
			while(symbolScanner.hasNext())
			{
				stockSymbols.add(symbolScanner.next());
				
			}
			
			symbolScanner.close();
		} catch (FileNotFoundException e)
		{
			e.printStackTrace();
		}
	}
	public void URLMaker()
	{
		int finishedURLs = 0;
		int numberOfSymbols = stockSymbols.size();
		int neededURLs = (stockSymbols.size() / 200) + 1;
		int remainder = stockSymbols.size() % 200;
		String URLInWork = "";
		int symbolLocator = 0;
		int numberOfElements;
				
		while (finishedURLs < neededURLs)
		{ 
			numberOfElements = 0;
			
			while ((numberOfElements < 200) && (symbolLocator < numberOfSymbols))
			{
				if (numberOfElements == 0)
				{
					URLInWork = stockSymbols.get(symbolLocator);
					symbolLocator = symbolLocator + 1;
				}else
				{
					
					URLInWork = URLInWork + "+" + stockSymbols.get(symbolLocator);
					symbolLocator = symbolLocator + 1;
					if ((numberOfElements == 199) |
							((finishedURLs == (neededURLs - 1)) && (numberOfElements == (remainder - 1))))                  
					{
						URLs.add(URL1 + URLInWork + URL2);
						System.out.println(URLs.get(finishedURLs));
						finishedURLs = finishedURLs + 1;
					}
				}
				numberOfElements = numberOfElements + 1;
				
			}
		}
	}
	public void URLLookup() throws Exception
	{
		int numberOfURLs = URLs.size();
		int URLIndex = 0;
		Desktop desktop = Desktop.getDesktop();
		
		desktop.browse(new URI(URLs.get(1)));
	
	}

}
