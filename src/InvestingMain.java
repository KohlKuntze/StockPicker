

public class InvestingMain {
	
	public static void main(String[] args) throws Exception
	{
		
		DateTime datetime = new DateTime();
		Compiler compiler = new Compiler();
		compiler.populateStockSymbolsArrayList();
		compiler.URLMaker();
		if (datetime.isMarketOpen()){
			compiler.URLLookup();
		}else{
			compiler.URLLookup();			
		}
		
		
	}

}
