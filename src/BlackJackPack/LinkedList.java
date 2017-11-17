package BlackJackPack;



public class LinkedList<E> {
    private Node<E> head;
    private int size;
    //private Node tail;

    LinkedList() {
      head = null;
      size = 0;
    }
    
    public int getSize() {
    	return size;
    }

    public E get(int index) {
        return null;
    }
    
    private Node<E> find(int position) {
    	int count = 0;
        for (Node<E> curr = head; curr != null; curr = curr.next) {
            if (count == position) {
            	return curr;
            }
            count++;
        }
        return null;
    }
    
    public E remove(int position) throws IndexOutOfBoundsException {
    	Node<E> deleted = null;
    	if (position < 0 || position >= size ) {
    		throw new IndexOutOfBoundsException("Your position " + position + " is not correct");
    	}
    	else if (position == size - 1) {
    		Node<E> prev = find(position - 1);
    		deleted = prev.next;
    		prev.next = null;
    	}
    	else if (position == 0) {
    		Node<E> first = head;
    		deleted = head;
    		head = first.next;
    		first.next = null;
    	}
    	else {
    		Node<E> prev = find(position - 1);
    		Node<E> curr = prev.next;
    		deleted = prev.next;
    		prev.next = curr.next;
    		curr.next = null;
    	}
    	size--;
    	return deleted.item;
    }
    
    public void add(E input, int position) throws IndexOutOfBoundsException {
    	if (position < 0 || position > size ) {
    		throw new IndexOutOfBoundsException("Your position " + position + " is not correct");
    	}
    	else if (position == 0) {
    		Node<E> first = head;
    		Node<E> newNode = new Node<E>(input);
    		head = newNode;
    		newNode.next = first;
    	}
    	else if (position == size) {
    		add(input);
    		return;
    	}
    	else {
    		Node<E> prev = find(position - 1);
    		Node<E> newNode = new Node<E>(input);
    		Node<E> curr = prev.next;
    		prev.next = newNode;
    		newNode.next = curr;
    	}
    	size++;
    }

    public void add(E input) {
    	size++;
    	Node<E> newNode = new Node<E>(input);
    	Node<E> curr = head;
    	if (head == null) {
    		head = newNode;
    		return;
    	}
        while (curr.next != null) { // while not end
          curr = curr.next;
        }
        curr.next = newNode;
    }

    public void display() {
        for (Node<E> curr = head; curr != null; curr = curr.next) {
            System.out.print(curr.item + ", ");
        }
        System.out.println("");
    }

	public void clear() {
		head=null;
		//tail=null;
		size=0;
	}
		
	}


