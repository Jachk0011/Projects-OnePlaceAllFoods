import java.io.*;
import java.util.StringTokenizer;

public class Run {

	static Users users = new Users();  
	
	public void loadUsers()
	{
		this.readFileUsers();
	}
	
	public void readFileUsers()
	{
		File file = null;
		FileReader fr = null;
		BufferedReader br = null;

		try 
		{
			file = new File ("Users.txt");
			fr = new FileReader (file);
			br = new BufferedReader(fr);
			
			String line = null,
					user,
					pass
					;
			
			
			while((line = br.readLine()) != null)
			{
				StringTokenizer st = new StringTokenizer(line);
				user = st.nextToken();
				pass = st.nextToken();
				
				this.users.addEnd(new NodeUsers(user, pass));
			}
			
			 
			
			
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
        FileWriter fichero = null;
        PrintWriter pw = null;
        try
        {
            fichero = new FileWriter("Users.txt", true);
            pw = new PrintWriter(fichero);

            /*for (int i = 10; i < 20; i++)
                pw.println("Linea " + i);*/
            
            	pw.print(users.getTail().user + " " + users.getTail().pass);
            

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
           try {
           // Nuevamente aprovechamos el finally para 
           // asegurarnos que se cierra el fichero.
           if (null != fichero)
              fichero.close();
           } catch (Exception e2) {
              e2.printStackTrace();
           }
        }
    }
	
	
	public void optionsIntialMessage()
	{
		System.out.println("1. Restaurants");
		System.out.println("2. Filter");
		System.out.println("3. Search");
		System.out.println("4. Login");
		System.out.println("5. Sign up");
		System.out.println("0. Exit");
	}
	
	public void runDemo() throws IOException
	{
		System.out.println("****************************************************************************************************************");		
		System.out.println(" ");
		System.out.println("\t\tWELCOME TO BETA APPLICATION OF ONE PLACE ALL FOOD MODE CONSOLE");
		System.out.println(" ");		
		System.out.println("****************************************************************************************************************");
		
		
		this.loadUsers();
		boolean flagCreateUsers = false;
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
			case 4: System.out.println("Login");
				break;
			case 5: System.out.println("Sign up");				
				if(users.createUser())
					this.writeFileUsers();
				this.optionsIntialMessage();
				break;
			case 0: System.out.println("Exit");
				break;
			default: System.out.println("Invalid option");
				this.optionsIntialMessage();
				break;
			}
			
			System.out.println("\nPlease choose one option");
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String line = br.readLine();
			option = Integer.parseInt(line);
			
			
			
		}while(option != 0);
		
		System.out.println("\nTHANK YOU TO USE OUR APPLICATION\n");
	}
	
	public static void main(String[] args) throws IOException {
		Run r = new Run();
		r.runDemo();
		users.printList();
		
		

	}

}
