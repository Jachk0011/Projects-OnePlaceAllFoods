import java.io.*;


public class Run {

	
	
	public void optionsIntialMessage()
	{
		System.out.println("1. Restaurants");
		System.out.println("2. Filter");
		System.out.println("3. Search");
		System.out.println("4. Login");
		System.out.println("0. Exit");
	}
	
	public void initialMessage() throws IOException
	{
		System.out.println("****************************************************************************************************************");		
		System.out.println(" ");
		System.out.println("\t\tWELCOME TO BETA APPLICATION OF ONE PLACE ALL FOOD MODE CONSOLE");
		System.out.println(" ");		
		System.out.println("****************************************************************************************************************");
		
		
		int option = -1;
		this.optionsIntialMessage();
		
		do
		{			
			switch(option) 
			{
			case -1: ;
				break;
			case 1: System.out.println("Restaurants");
				this.optionsIntialMessage();
				break;
			case 2: System.out.println("Filter");
				break;
			case 3: System.out.println("Search");
				break;
			case 0: System.out.println("Exit");
				break;
			default: System.out.println("Invalid option");
				break;
			}
			
			System.out.println("\nPlease choose one option");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			option = Integer.parseInt(line);
			
		}while(option != 0);
		
		System.out.println("THANK YOU TO USE OUR APPLICATION");
	}
	
	public static void main(String[] args) throws IOException {
		Run r = new Run();
		r.initialMessage();
		

	}

}
