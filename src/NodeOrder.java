
public class NodeOrder {
	
	public int quantity;
	public String name;
	public double total;
	
	public NodeOrder next;
	
	//CONSTRUCTORS 
	public NodeOrder (){}
	
	public NodeOrder (int q, String n, double t)
	{
		this.quantity = q;
		this.name = n;
		this.total = t;
	}
	
	// NICE VIEW DATA
	public String toString()
	{
		return "" + this.name + "\n";
	}
	
	
	
}
