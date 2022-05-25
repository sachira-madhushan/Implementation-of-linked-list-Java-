public class DoublyLinkedList
{
	Node head;
	int size;
	
	public DoublyLinkedList()
	{
		head = null;
		size = 0;
	}
	
	public boolean isEmpty()
	{
		if(head==null){
			return true;
		}
		else{
			return false;
		}
	}
	
	public void insertAtStart(int nodeValue)
	{
		
		if(head==null){
			Node newNode=new Node(nodeValue);
			head=newNode;
		}
		else{
			Node newNode=new Node(null,nodeValue,head);
			head.previous =newNode;
			head=newNode;
		}
		size++;
	}
	
	public void insertLast(int nodeValue)
	{
		if(head==null){
			Node newNode=new Node(nodeValue);
			head=newNode;
		}
		else{
			Node currentNode=head;
			while(currentNode.next!=null){
				currentNode=currentNode.next;
			}
			Node lastNode=currentNode;
			Node newNode=new Node(lastNode,nodeValue,null);
			lastNode.next =newNode;
			lastNode=newNode;
		}
		size++;
	}
	
	public void insertAt(int nodeValue,int position)
	{
		Node previousNode,currentNode,nextNode,newNode;
		
		currentNode=head;
		if(position<0){
			System.out.println("[*]Error:position out of range");
		}
		else if(size-1==position){
			insertLast(nodeValue);
		}
		else{
			for(int i=0;i<position;i++){
				currentNode=currentNode.next;
			}
			previousNode=currentNode.previous;
			newNode=new Node(previousNode,nodeValue,currentNode);
			previousNode.next=newNode;
			currentNode.previous=newNode;
		}
	size++;
	}
	
	public void deleteFirst()
	{
		head=head.next;
		head.previous=null;
		size--;
	}
	
	public void deleteLast()
	{
		Node currentNode=head,previousNode;
		while(currentNode.next!=null){
			currentNode=currentNode.next;
		}
		previousNode=currentNode.previous;
		previousNode.next=null;
		size--;
	}
	
	public void deleteAt(int position)
	{
		Node currentNode=head,previousNode,nextNode;
		for(int i=0;i<position;i++){
			currentNode=currentNode.next;
		}
		previousNode=currentNode.previous;
		nextNode=currentNode.next;
		previousNode.next=nextNode;
		nextNode.previous=previousNode;
		size--;
	}
	
	public void countNodes()
	{
		int counter=0;
		Node currentNode=head;
		while(currentNode.next!=null){
			counter++;
			currentNode=currentNode.next;
		}
		System.out.println("Number Of Nodes :"+(counter+1));
	}
	
	public void show()
	{

		Node currentNode=head;
		if(head==null){

		}
		else if(head.next==null){
			System.out.println(currentNode.data());
		}
		else{
			System.out.print(currentNode.data()+" ");
			while(currentNode.next!=null){
				currentNode=currentNode.next;
				System.out.print(currentNode.data()+" ");
			}
		}
		System.out.println();
	}
}