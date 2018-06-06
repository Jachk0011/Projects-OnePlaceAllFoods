
public class NodeUsers {
	
	public String user;
	public String pass;
	public NodeUsers next;
	public boolean status = false;
	
	//CONSTRUCTORS 
	public NodeUsers (){}
	
	public NodeUsers (String user, String pass)
	{
		this.user = user;
		this.pass = pass;
	}
	
	// NICE VIEW DATA
	public String toString()
	{
		return "User: " + this.user +" " + this.status +"\n";
	}	
	
}
