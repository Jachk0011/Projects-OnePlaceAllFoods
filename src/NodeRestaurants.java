
public class NodeRestaurants {
	public String name;	
	public NodeRestaurants next;
	
	//CONSTRUCTORS 
	public NodeRestaurants (){}
	
	public NodeRestaurants (String name)
	{
		this.name = name;
	}
	
	// NICE VIEW DATA
	public String toString()
	{
		return "Restaurante name: " + this.name + "\n";
	}	
	
	
	
}
