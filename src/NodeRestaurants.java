
public class NodeRestaurants {
	public String name;	
	public String menu;
	public int worth, id;
	public NodeRestaurants next;
	
	//CONSTRUCTORS 
	public NodeRestaurants (){}
	
	public NodeRestaurants (int id, String name)
	{
		this.id = id;
		this.name = name;
	}
	
	public NodeRestaurants (int id, String name, String menu, int worth)
	{
		this.id = id;
		this.name = name;
		this.menu = menu;
		this.worth = worth;
	}
	
	// NICE VIEW DATA
	public String toString()
	{
		return  this.id + ". " + this.name + " " + this.menu + "  $" + this.worth +  "\n";
	}	
	
	public String toString2()
	{
		return  this.id + ". " + this.name +  "\n";
	}
	
}
