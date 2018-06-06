import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Restaurants
{
	
	private NodeRestaurants head = null;
	
		//return the i-th  NodeRestaurants gave a index
	public NodeRestaurants getNodeRestaurants(int index)
	{
		if(index < this.sizeList())
		{
			NodeRestaurants tmp = this.getHead();
			for(int i=0; i<index; i++)
				tmp = tmp.next;
			
			return tmp;
		}
		return null;
	}
	
	//get Tail
	public NodeRestaurants getTail()
	{
		NodeRestaurants tmp = this.getHead();
		while(tmp.next != null)
			tmp = tmp.next;
		
		return tmp;
	}
	
	//return head
	public NodeRestaurants getHead()
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
			NodeRestaurants tmp = head;
			while(tmp.next != null)
			{
				tmp = tmp.next;
				size++;
			}				
			return size;
		}
	}
	
	// Let print all NodeRestaurantss in the List using Buffered
	public void printList() throws IOException
	{
		if(this.emptyList())
			System.out.println("The list is empty");
		else
		{
			NodeRestaurants tmp = head;
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
	
	public void printList2() throws IOException
	{
		if(this.emptyList())
			System.out.println("The list is empty");
		else
		{
			NodeRestaurants tmp = head;
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
			
			while(tmp != null)
			{
				br.write(tmp.toString2());
				tmp = tmp.next;
			} 
			br.flush();
			//br.close();
		}
		
	}

	
	
	// add at end of the list the new NodeRestaurants get as parameter. Also check if the list is Empty 
	public void addEnd(NodeRestaurants n)
	{
		if(emptyList())
			this.head = n;
		else
		{
			NodeRestaurants tmp = getHead();
			while(tmp.next != null)		
				tmp = tmp.next;
			tmp.next = n;
			n.next = null;
		}				
	}
	
	//add at begin of the list the new NodeRestaurants get as parameter.
	public void addBegin(NodeRestaurants n)
	{
		if(emptyList())
			head = n;
		else
		{
			NodeRestaurants tmp = head;
			head = n;
			n.next = tmp;
		}
	}

	//add at any position of the list the new NodeRestaurants get as parameter.  
	public void addAnyPosition(NodeRestaurants n, int position)
	{				
		if(this.emptyList())
			head = n;
		else if(position>sizeList()+1)		
			System.out.println("The position exceed the size of the list");
		else if(position == 1 )
			this.addBegin(n);		
		else
		{
			NodeRestaurants tmp = head;
			
			for(int i=0; i<position-2; i++)
				tmp = tmp.next;
			n.next = tmp.next;
			tmp.next = n;
		}			
	}

	
	
	//delete head NodeRestaurants
	public void deleteBeginList()
	{
		@SuppressWarnings("unused")
		NodeRestaurants tmp = head;
		head = head.next;
		tmp.next = null;
		System.gc();		
	}

	//delete tail NodeRestaurants
	public void deleteEndList(){
		NodeRestaurants tmp = head;
		while(tmp.next.next != null)
			tmp = tmp.next;		
		tmp.next = null;		
		System.gc();
	}

	//delete the NodeRestaurants got for parameter
	public void deleteAnyPosition(int position)
	{
		if(position == 1)
			this.deleteBeginList();		
		else if(position == this.sizeList())
			this.deleteEndList();
		else if(position>this.sizeList())
			System.out.println("The position of item to delete is superior to size list");
		else{
			NodeRestaurants tmp = head, garbage;
			for(int i=1; i<position-1; i++)
				tmp = tmp.next;
			garbage = tmp.next;
			tmp.next = tmp.next.next;
			garbage.next = null;
			System.gc();
		}
		
	}


	//return 0 if the data value doesn't exist, otherwise, return the position of the value.
	public NodeRestaurants searchOption(int id)
	{
		NodeRestaurants tmp = this.getHead();
					
		while(tmp.id != id && tmp.next != null)		
			tmp = tmp.next;
				
		if(tmp.id == id)
			return new NodeRestaurants(tmp.id, tmp.name, tmp.menu, tmp.worth);
		else
			return null;
							
		
	}
	
}
