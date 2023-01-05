class MyLinkedList {

    int length;
    Node head;
    Node tail;

    public class Node{
        
        int val;
        Node next;
        Node prev;
        
        Node(int val)
        {
            this.val = val;
            this.next = null;
            this.prev = null;
        }
    }

    public MyLinkedList() {
        this.head = null;
        this.tail = null; 
        this.length = 0;
    }
    
    public int get(int index) {
        if(index >= length || head == null)
        {
            return -1;
        }
        int idx = 0;
        Node temp = head;
        while(idx < index)
        {
            temp = temp.next;
            idx++;
        }
        return temp.val;
    }
    
    public void addAtHead(int val) {
        if(head == null)
        {
            head = new Node(val);
            tail = head;
        }
        else
        {
            Node temp = new Node(val);
            temp.next = head;
            head.prev = temp;
            head = temp;
        }
        length++;
    }
    
    public void addAtTail(int val) {
        
        Node temp = new Node(val);
        if(tail == null)
        {
            head = tail = temp;
        }
        else
        {
            tail.next = temp;
            temp.prev = tail;
            tail = temp;
        }
        length++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index == length)
        {
            addAtTail(val);
        }
        else if(index <= 0)
        {
            addAtHead(val);
        }
        else if(index > length)
        {
            return;
        }
        else
        {
            Node temp = head;
            int idx = 0;
            while(idx < index)
            {
                idx++;
                temp = temp.next;
            }
            Node toAdd = new Node(val);
            Node prevNode = temp.prev;
            prevNode.next = toAdd;
            toAdd.prev = prevNode;
            temp.prev = toAdd;
            toAdd.next = temp;
            length++;
        }
    }
    
    public void deleteAtIndex(int index) {
        if(index < 0 || index >= length)
        {
            return;
        }
        if(index == 0)
        {
            if(head == tail)
            {
                head = tail = null;
            }
            else
            {
                Node temp = head;
                head = head.next;
                head.prev = null;
                temp.next = null;
                temp = null;
            }
        }
        else if(index == (length-1))
        {
            Node temp = tail;
            tail = tail.prev;
            tail.next = null;
            temp.prev = null;
            temp = null;
        }
        else
        {
            Node temp = head;
            int idx = 0;
            while(idx < index)
            {
                idx++;
                temp = temp.next;
            }
            Node prevNode = temp.prev;
            Node nextNode = temp.next;
            prevNode.next = nextNode;
            nextNode.prev = prevNode;
            temp.next = temp.prev = null;
            temp = null;
        }
        length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */