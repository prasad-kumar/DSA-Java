public class LinkedLis {
    Node head;

    class Node{
        int data;
        Node next;

        Node(int data){
            this.data = data;
            this.next = null;

        }
    }

        public void addFirst(int data){
            Node newNode = new Node(data);
            newNode.next = head;
            head = newNode;
        }

        public void addLast(int data){
            Node newNode = new Node(data);

            if(head == null){
                head = newNode;
                return;
            }

            Node currNode = head;
            while(currNode.next != null){
                currNode = currNode.next;
            }
            currNode.next = newNode;
        }

        public void deleteFirst(){
            if(head == null || head.next == null){
                head = null;
                return;
            }

            head = head.next;
        }

        public void deleteLast(){
    
            if(head == null || head.next == null){
                head = null;
                return;
            }

            Node currNode = head;
            while(currNode.next.next != null){
                currNode = currNode.next;
            }
            currNode.next = null;    
            
        }

        public void printList(){
            if(head == null){
                System.out.println("List is empty");
                return;
            }

            Node currNode = head;
            while(currNode != null){
                System.out.print(currNode.data + "-->");
                currNode = currNode.next;
            }
            System.out.println();
        }
        
        public int getSize() {
            Node currNode = head;
            int count = 0;
            while(currNode != null){
                currNode = currNode.next;
                count += 1;
            }

            return count;
        }

        public void addAtIndex(int data, int idx) {
            if(idx < 0 || idx >= getSize()){
                System.out.println("Invalid Index number");
                return;
            }

            if(idx == 0){
                addFirst(data);
            }

            Node currNode = head;
            int count = 0;
            while(currNode.next != null){
                if(count == idx - 1){
                    Node newNode = new Node(data);
                    newNode.next = currNode.next;
                    currNode.next = newNode;
                }
                currNode = currNode.next;
                count += 1;
            }

        }

        public void deleteAtIndex(int idx){
            if(idx < 0 || idx >= getSize()){
                System.out.println("Invalid Index number");
                return;
            }

            if(idx == 0){
                deleteFirst();
            }

            Node currNode = head;
            int count = 0;
            while(currNode != null){
                if(count == idx - 1){
                    currNode.next = currNode.next.next;
                }
                currNode = currNode.next;
                count += 1;
            }
        }

    public static void main(String args[]) {
        
        LinkedLis ll = new LinkedLis();

        ll.addFirst(3);
        // ll.addFirst(2);
        ll.addFirst(1);
        ll.printList();

        ll.addLast(4);
        ll.addLast(5);
        ll.printList();
        
        // ll.deleteFirst();
        // ll.printList();

        // ll.deleteLast();
        // ll.printList();

        ll.addAtIndex(2, 1);
        ll.printList();
        ll.deleteAtIndex(1);
        ll.printList();
        System.out.println(ll.getSize());
    }
}
