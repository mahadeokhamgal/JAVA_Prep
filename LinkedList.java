import java.util.HashSet;

class Node {
    int val;
    Node next;

    public Node(int v) {
        this.val = v;
    }

    public Node(int v, Node n) {
        this.val = v;
        this.next = n;
    }

    public Node appendFirst(int v){
        return new Node(v, this);
    }

    public Node appendLast(int v) {
        Node temp = this;
        while(temp != null && temp.next != null){
            temp = temp.next;
        }
        temp.next = new Node(v);
        return this;
    }

    public Node getTail(){
        Node temp = this;
        while(temp != null && temp.next != null){
            temp = temp.next;
        }
        return temp;
    }

    public Node removeLoop() {
        Node slow = this;
        Node fast = this;
        Node prev;
        do {
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);

        slow = this;
        if(slow == fast){
            prev.next = null;
            return this;
        }
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;
        return this;
    }

    public void printList(){
        Node temp = this;
        HashSet <Node> seen = new HashSet<>();
        while(temp != null){
            if(seen.contains(temp)){
                System.out.println("loop found exiting");
                break;
            }
            System.out.print(temp.val + " -> ");
            seen.add(temp);
            temp = temp.next;
        }
        System.out.println("end");
    }
}

public class LinkedList {

}