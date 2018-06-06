import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;




/***********************************************************************************
 *
 * WARNING: ALL THE METHODS IS BASED IN THE POSITION OF THE LIST NOT IN THE INDEX
 * 
 ***********************************************************************************/

public class List {
	private Node head = null;
	
	public Node binarySearch2(int value, int lowerBound, int upperBound)
	{
		int middleElement = (lowerBound+upperBound)/2;
		
		if(lowerBound == upperBound)
		{
			if(getNode(middleElement).id == value)
				return getNode(middleElement);
			else
				return null; //the element isn't in the list
		}
		else
		{
			if(getNode(middleElement).id == value)
				return getNode(middleElement);
			else
				if( value < getNode(middleElement).id)
					return binarySearch2(value, lowerBound, middleElement);
				else
					return binarySearch2(value, middleElement+1, upperBound);
		}	
	}
	
	//return the i-th  node gave a index
	public Node getNode(int index)
	{
		if(index < this.sizeList())
		{
			Node temp = this.getHead();
			for(int i=0; i<index; i++)
				temp = temp.next;
			
			return temp;
		}
		return null;
	}
	
	//get Tail
	public Node getTail()
	{
		Node temp = this.getHead();
		while(temp.next != null)
			temp = temp.next;
		
		return temp;
	}
	
	//return head
	public Node getHead()
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
			Node temp = head;
			while(temp.next != null)
			{
				temp = temp.next;
				size++;
			}				
			return size;
		}
	}
	
	// Let print all nodes in the List using Buffered
	public void printList() throws IOException
	{
		if(this.emptyList())
			System.out.println("The list is empty");
		else
		{
			Node temp = head;
			BufferedWriter br = new BufferedWriter(new OutputStreamWriter(System.out));
			
			while(temp != null)
			{
				br.write(temp.toString());
				temp = temp.next;
			} 
			br.flush();
			//br.close();
		}
		
	}

	
	
	// add at end of the list the new node get as parameter. Also check if the list is Empty 
	public void addEnd(Node n)
	{
		if(emptyList())
			this.head = n;
		else
		{
			Node temp = getHead();
			while(temp.next != null)		
				temp = temp.next;
			temp.next = n;
			n.next = null;
		}				
	}
	
	//add at begin of the list the new node get as parameter.
	public void addBegin(Node n)
	{
		if(emptyList())
			head = n;
		else
		{
			Node temp = head;
			head = n;
			n.next = temp;
		}
	}

	//add at any position of the list the new node get as parameter.  
	public void addAnyPosition(Node n, int position)
	{				
		if(this.emptyList())
			head = n;
		else if(position>sizeList()+1)		
			System.out.println("The position exceed the size of the list");
		else if(position == 1 )
			this.addBegin(n);		
		else
		{
			Node temp = head;
			
			for(int i=0; i<position-2; i++)
				temp = temp.next;
			n.next = temp.next;
			temp.next = n;
		}			
	}

	
	
	//delete head node
	public void deleteBeginList()
	{
		@SuppressWarnings("unused")
		Node temp = head;
		head = head.next;
		temp.next = null;
		System.gc();		
	}

	//delete tail node
	public void deleteEndList(){
		Node temp = head;
		while(temp.next.next != null)
			temp = temp.next;		
		temp.next = null;		
		System.gc();
	}

	//delete the node got for parameter
	public void deleteAnyPosition(int position)
	{
		if(position == 1)
			this.deleteBeginList();		
		else if(position == this.sizeList())
			this.deleteEndList();
		else if(position>this.sizeList())
			System.out.println("The position of item to delete is superior to size list");
		else{
			Node temp = head, garbage;
			for(int i=1; i<position-1; i++)
				temp = temp.next;
			garbage = temp.next;
			temp.next = temp.next.next;
			garbage.next = null;
			System.gc();
		}
		
	}


	
	//print if the data value exist or not  
	public void existDataNodeList(int data) throws IOException
	{
		if(this.emptyList())
			System.out.println("The list is empty");
		else
		{
			Node temp = head;
			int position = 1;
			BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
			while(temp.data != data && temp.next != null)
			{
				temp = temp.next;
				position++;
			}			
			if(temp.data == data)	
			{
				bw.write("The value " +"\"" +data+ "\"" + " exist and it's in the position: "+position + "\n");
				bw.flush();
				//bw.close();			
			}				
			else
			{
				bw.write("The value doesn't exist!");
				bw.flush();
				//bw.close();
				
			}				
		}		
	}

	//return 0 if the data value doesn't exist, otherwise, return the position of the value.
	public int searchDataNodeList(int data)
	{
		if(this.emptyList())
			return 0;
		else
		{
			Node temp = head;
			int position = 1;			
			while(temp.data != data && temp.next != null)
			{
				temp = temp.next;
				position++;
			}
			
			if(temp.data == data)
				return position;			
			else 
				return 0;				
		}
	}
	
	
	public List quickSort(List unsorted)
	{
		if(unsorted.sizeList() <= 1)
			return unsorted;
		else
		{
			Node pivot = unsorted.getHead();
			List lessSublist = new List(), greaterSublist = new List();
			
			Node tmp = pivot.next;
			
			while(tmp != null)
			{
				if(tmp.id < pivot.id)
					lessSublist.addEnd(tmp.clone());
				else
					greaterSublist.addEnd(tmp.clone());
				
				tmp = tmp.next;
			}
			lessSublist = quickSort(lessSublist);
			greaterSublist = quickSort(greaterSublist);
			
			pivot.next = greaterSublist.getHead();
			lessSublist.addEnd(pivot);
			
			return lessSublist;					
		}
	}
	
	
}
