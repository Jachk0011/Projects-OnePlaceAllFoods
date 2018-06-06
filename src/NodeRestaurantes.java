
public class NodeRestaurantes {
	public int id;//it's unique
	public int data;
	public String text;
	public NodeRestaurantes next;
	
	//CONSTRUCTORS 
	public NodeRestaurantes (){}
	
	public NodeRestaurantes (int data)
	{
		this.data = data;
	}
	
	// NICE VIEW DATA
	public String toString()
	{
		return "Data: " + data + "\n";
	}
	
	public NodeRestaurantes clone() 
	{
		NodeRestaurantes temp = new NodeRestaurantes(this.data);
		return temp;
	}
	
	
}
