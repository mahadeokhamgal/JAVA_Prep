import java.util.Arrays;
import java.util.List;

class MyClass extends Thread{
    @Override
    public void run() {
        System.out.println("Thread is running");
    }
}

class Myclass2 implements Runnable{
    @Override
    public void run() {
        System.out.println("Thread2 is running");
    }
}

public class InterviewPrep {
    public static void main(String[] args) {

        MyClass c = new MyClass();
        System.out.println("thread clas created");
        c.start();
        System.out.println("call completed to thread class");
        Myclass2 c2 = new Myclass2();
        Thread c2t = new Thread(c2);
        System.out.println("thread2 created");
        c2t.start();
        System.out.println("thread 2 done");
        // List of numbers
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);

        // Using lambda to print each number in the list
        numbers.forEach((number) -> System.out.println(number));

        // Using lambda with a functional interface
        MathOperation add = (a, b) -> a + b;
        System.out.println("Addition: " + add.operation(10, 5));

        // Using lambda to filter even numbers
        System.out.println("Even numbers: ");
        numbers.stream()
               .filter(n -> n % 2 == 0)
               .forEach(System.out::println);
    }
}

@FunctionalInterface
interface MathOperation {
    int operation(int a, int b);
}
