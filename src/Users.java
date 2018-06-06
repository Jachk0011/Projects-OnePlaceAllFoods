import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

//he behavior like a List
public class Users 
{
	private NodeUsers head = null;
	
	public NodeUsers getTail()
	{
		NodeUsers tmp = this.getHead();
		while(tmp.next != null)
			tmp = tmp.next;
		
		return tmp;
	}
	
	//return head
	public NodeUsers getHead()
	{
		return this.head;
	}
	
	// Tell us if the list is empty
	public boolean emptyList(){
		return (head!=null) ? false : true;
	}
	
	// return the size of he list as a integer
	public int sizeList()
	{
		int size = 0;
		if(emptyList())
			return 0;
		else
		{
			NodeUsers tmp = head;
			while(tmp.next != null)
			{
				tmp = tmp.next;
				size++;
			}				
			return size;
		}
	}
	
	// Let print all NodeUserss in the List using Buffered
	public void printList() throws IOException
	{
		if(this.emptyList())
			System.out.println("The list is empty");
		else
		{
			NodeUsers tmp = head;
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
			
			while(tmp != null)
			{
				br.write(tmp.toString());
				tmp = tmp.next;
			} 
			br.flush();
			//br.close();
		}
		
	}

	
	
	// add at end of the list the new NodeUsers get as parameter. Also check if the list is Empty 
	public void addEnd(NodeUsers n)
	{
		if(emptyList())
			this.head = n;
		else
		{
			NodeUsers tmp = getHead();
			while(tmp.next != null)		
				tmp = tmp.next;
			tmp.next = n;
			n.next = null;
		}				
	}
	
	//add at begin of the list the new NodeUsers get as parameter.
	public void addBegin(NodeUsers n)
	{
		if(emptyList())
			head = n;
		else
		{
			NodeUsers tmp = head;
			head = n;
			n.next = tmp;
		}
	}

	//add at any position of the list the new NodeUsers get as parameter.  
	public void addAnyPosition(NodeUsers n, int position)
	{				
		if(this.emptyList())
			head = n;
		else if(position>sizeList()+1)		
			System.out.println("The position exceed the size of the list");
		else if(position == 1 )
			this.addBegin(n);		
		else
		{
			NodeUsers tmp = head;
			
			for(int i=0; i<position-2; i++)
				tmp = tmp.next;
			n.next = tmp.next;
			tmp.next = n;
		}			
	}

	
	
	//delete head NodeUsers
	public void deleteBeginList()
	{
		@SuppressWarnings("unused")
		NodeUsers tmp = head;
		head = head.next;
		tmp.next = null;
		System.gc();		
	}

	//delete tail NodeUsers
	public void deleteEndList()
	{
		NodeUsers tmp = head;
		while(tmp.next.next != null)
			tmp = tmp.next;		
		tmp.next = null;		
		System.gc();
	}

	//delete the NodeUsers got for parameter
	public void deleteAnyPosition(int position)
	{
		if(position == 1)
			this.deleteBeginList();		
		else if(position == this.sizeList())
			this.deleteEndList();
		else if(position>this.sizeList())
			System.out.println("The position of item to delete is superior to size list");
		else{
			NodeUsers tmp = head, garbage;
			for(int i=1; i<position-1; i++)
				tmp = tmp.next;
			garbage = tmp.next;
			tmp.next = tmp.next.next;
			garbage.next = null;
			System.gc();
		}
		
	}


	public void createUser(String user, String pass)
	{
		
		
		
	}
	
	public boolean validationUser(String user)
	{
		return false;
	}



}
