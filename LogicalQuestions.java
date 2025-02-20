import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class LogicalQuestions {
    public boolean isPalindrome(int num) {
        int temp = num;
        int reverse = 0;
        while (temp > 0) {
            reverse = (reverse * 10) + (temp % 10);
            temp /= 10;
        }
        return reverse == num;
    }

    public int getSecondLargest(int[] arr) {
        if (arr.length < 2) {
            return -1;
        }
        int l1 = 0;
        int l2 = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[l1] < arr[i]) {
                l2 = l1;
                l1 = i;
            } else if ((l1 != i && arr[l1] == arr[i]) || arr[l2] < arr[i]) {
                l2 = i;
            }
        }
        return arr[l2];
    }

    public String reveString(String str) {
        char[] charArray = str.toCharArray();
        for (int i = 0; i < charArray.length / 2; i++) {
            char temp = charArray[i];
            charArray[i] = charArray[charArray.length - i - 1];
            charArray[charArray.length - i - 1] = temp;
        }
        return new String(charArray);
    }

    public char firstNonRepeatingChar(String str) {
        HashMap<Character, Integer> count = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            count.put(c, count.getOrDefault(c, 0) + 1);
        }
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (count.get(c) == 1)
                return c;
        }
        return '\0';
    }

    public Node removeLoop(Node head) {
        
        Node slow = head;
        Node fast = head;
        do {
            slow = slow.next;
            fast = fast.next.next;
        } while (fast != slow);

        slow = head;
        while (slow.next != fast.next) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = null;

        return head;
    }
    
    public ArrayList<Integer> getPrimes(int num) {
        boolean[] primes = new boolean[num];
        ArrayList<Integer> ans = new ArrayList<>();
        for(int i = 2; i < Math.sqrt(num); i++){
            int multiplier = 2;
            while(multiplier*i < num && primes[multiplier*i] == false){
                primes[multiplier*i] = true;
                multiplier += 1;
            }
        }
        for (int i = 2; i < primes.length; i++) {
            if(primes[i] == false){
                ans.add(i);
            }
        }
        // System.out.println(Arrays.toString(primes) + ans);
        return ans;
    }
    public static ArrayList<Integer> fibo(ArrayList<Integer> prev, int limit) {
        int lastSec = prev.get(prev.size()-2);
        if(prev.getLast() + lastSec > limit){
            return prev;
        }
        prev.add(prev.getLast() + lastSec);
        return LogicalQuestions.fibo(prev, limit);
    }
    public ArrayList<Integer> fibonacci(int num){
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(1);
        ans.add(1);

        return fibo(ans, num);
    }
    public static void main(String[] args) {
        LogicalQuestions l = new LogicalQuestions();
        // Q1
        System.out.println(l.isPalindrome(1234321));
        System.out.println(l.isPalindrome(123432));
        // Q2
        System.out.println(l.getSecondLargest(new int[] { 1, 2, 3, 4, 8, 5, 6, 8, 7 }));
        System.out.println(l.getSecondLargest(new int[] { 1, 2, 3, 4, 5, 6, 8, 7 }));
        //Q3
        System.out.println(l.reveString("abcdefgh"));
        //Q4
        System.out.println(l.firstNonRepeatingChar("qwrteiiyyhq"));
        //Q5
        Node head = new Node(0);
        Node tail0 = head;
        head.appendLast(1);
        head.appendLast(2);
        // Node tail2 = head.getTail();
        head.appendLast(3);
        head.appendLast(4);
        head.appendLast(5);
        Node tail5 = head.getTail();
        tail5.next = tail0;
        head.printList();
        head.removeLoop();
        head.printList();

        //Q6
        System.out.println(l.getPrimes(19));

        //Q7
        System.out.println(l.fibonacci(55));
    }
}
