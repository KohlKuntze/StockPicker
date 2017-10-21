import java.time.DayOfWeek;
import java.time.LocalDateTime;


public class DateTime{
	
	
	static LocalDateTime now = LocalDateTime.now();
	private static int currentYear = now.getYear();
	private static int currentMonth = now.getMonthValue();
	private static int currentDay = now.getDayOfMonth();
	int currentDayOfWeek;
	int currentHour;
	int currentMinute;
		
	public boolean isMarketOpen(){
		boolean openMarket = false;
		boolean openTime = false;
		currentDayOfWeek = now.getDayOfWeek().getValue();
		currentHour = now.getHour();
		currentMinute = now.getMinute();
	
		if ((currentHour >= 9) && (currentHour <= 16)){
			if (currentHour == 9){
				if (currentMinute >= 30){
					openTime = true;
				}else{
					openTime = false;
				}
			}else if (currentHour == 16){
				if (currentMinute == 0){
					openTime = true;
				}else{
					openTime = false;
				}
			}else{
				openTime = true;
			}
		}else{
			openTime = false;
			
		}
		
		if (((currentDayOfWeek <= 5) && (currentDayOfWeek >= 1)) &&  
				(openTime))
		{
			openMarket = true;
			System.out.println("the market should say its open");
			
		}else{
			openMarket = false;
			System.out.println("the market should say its closed");
		}
		return openMarket;
	}
	
	
	
}


	
	