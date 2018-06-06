import java.io.*;
import java.util.StringTokenizer;

public class Run {

	static Users users = new Users();
	static Restaurants restaurants = new Restaurants();  
	
	
	public void loadRestaurants()
	{
		this.readFile("Restaurants.txt");
	}
	
	public void loadUsers()
	{
		this.readFile("Users.txt");
	}
	
	public void readFile(String nameFile)
	{
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;

		try 
		{			
			file = new File (nameFile);
			fr = new FileReader (file);
			br = new BufferedReader(fr);
			
			if(nameFile.equals("Users.txt"))
			{
				String line = null,
						user,
						pass;				
				
				while((line = br.readLine()) != null)
				{
					StringTokenizer st = new StringTokenizer(line);
					user = st.nextToken();
					pass = st.nextToken();
					
					this.users.addEnd(new NodeUsers(user, pass));
				}
			}
			
			else if(nameFile.equals("Restaurants.txt"))
			{
				String line = null,
						restaurant;
				int id = 0;
				
				while((line = br.readLine()) != null)
				{
					restaurant = line;
					this.restaurants.addEnd(new NodeRestaurants(++id, restaurant));
				}
				restaurants.printList2();
			}
			
			else if(nameFile.equals("menus.txt"))
			{				
				String line = null;
				int id = 0;
				while((line = br.readLine()) != null)
				{					
					String[] words = line.split(",");					
					restaurants.addEnd(new NodeRestaurants(++id, words[0], words[1], Integer.parseInt(words[2])));					
				}	
				restaurants.printList();
			}
			else
				System.out.println("WE COULDN NOT LOAD ANY EXTERNAL FILE");			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		finally
		{	         
			try{                    
				if( fr != null ){   
					fr.close();     
				}                  
			}catch (Exception e2){ 
				e2.printStackTrace();
			}
		}
	}	
	
	public void writeFileUsers()
	{
        FileWriter file = null;
        PrintWriter pw = null;
        try
        {
            file = new FileWriter("Users.txt", true);
            pw = new PrintWriter(file);         
            
        	pw.print(users.getTail().user + " " + users.getTail().pass);
        }
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        finally 
        {
           try
           {           
	           if (null != file)
	              file.close();
           } catch (Exception e2) 
           {
              e2.printStackTrace();
           }
        }
    }
	
	public void welcome()
	{
		System.out.println("****************************************************************************************************************");		
		System.out.println(" ");
		System.out.println("\t\tWELCOME TO BETA APPLICATION OF ONE PLACE ALL FOOD MODE CONSOLE");
		System.out.println(" ");		
		System.out.println("****************************************************************************************************************");
	}
	
	public int optionsSecondLevel() throws NumberFormatException, IOException
	{
		System.out.println("\nPlease choose one option or push zero to return main screen");
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		return Integer.parseInt(br.readLine());
	}
	
	public void optionsIntialMessage()
	{
		System.out.println("\nPlease choose one option");
		System.out.println("1. Restaurants");
		System.out.println("2. Menus");
		System.out.println("3. Filter");
		System.out.println("4. Search");
		System.out.println("5. Login");
		System.out.println("6. Sign up");
		System.out.println("-1. Exit");
	}
	
	public void choosing(int option) throws NumberFormatException, IOException
	{
		NodeRestaurants tmp = restaurants.searchOption(option);
		
		if(tmp != null)
		{
			//tmp.toString();
			System.out.println("Index de quantity of the product: ");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			int units = Integer.parseInt(br.readLine());
			NodeOrder n = this.order(tmp, units);
			System.out.println(n.toString());
		}			
	}


	public NodeOrder order(NodeRestaurants newNode, int q) {
		
		int quantity = q;
		String name = newNode.name;
		double total = (newNode.worth)*quantity;
	    
		return new NodeOrder (quantity,name,total);
	}
	
	
	public void runDemo() throws IOException
	{
		
		this.welcome();		
		this.loadUsers();
		
		int option;		
		this.optionsIntialMessage();
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		do
		{	
			
			
			String line = br.readLine();
			option = Integer.parseInt(line);
			
			switch(option) 
			{
			case 0: this.optionsIntialMessage();
			break;
			
			case 1: System.out.println("\tRESTAURANTS\t\n");
				this.readFile("Restaurants.txt");
				System.out.println(" ");
				this.optionsSecondLevel();
				break;
				
			case 2:System.out.println("\tMENUS\t\n");
			this.readFile("menus.txt");
			System.out.println(" ");
			option = this.optionsSecondLevel();
			this.choosing(option);
			this.optionsIntialMessage();
			
			break;
			
			case 3: System.out.println("\tFILTER\t\n");
				break;
				
			case 4: System.out.println("\tSEARCH\t\n");
				break;
				
			case 5: System.out.println("\tLOGIN\t\n");
				String user = users.login(); 
				if(!user.equalsIgnoreCase(null))
				{
					NodeUsers tmp = users.getHead();
					while(tmp != null && !tmp.user.equalsIgnoreCase(user))
						tmp = tmp.next;
					tmp.status = true;
				}
				this.optionsIntialMessage();
				break;
				
			case 6: System.out.println("\tSING UP\t\n");				
				if(users.createUser())
					this.writeFileUsers();
				this.optionsIntialMessage();
				break;			
				
			case -1: System.out.println("\tEXIT\t\n");
				break;
				
			default: System.out.println("Invalid option");
				this.optionsIntialMessage();
				break;
			}	
			
		}while(option != -1);
		
		System.out.println("\nTHANK YOU TO USE OUR APPLICATION\n");
	}
	
	public static void main(String[] args) throws IOException {
		Run r = new Run();
		
		r.runDemo();		
		//users.printList();
		
		
		

	}

}
