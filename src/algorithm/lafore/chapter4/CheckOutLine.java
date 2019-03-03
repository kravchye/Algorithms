package algorithm.lafore.chapter4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Random;

// Programming project 4.5
public class CheckOutLine {
    private Queue[] queues;

    public CheckOutLine(int qNums, int maxQueueLength) {
        queues = new Queue[qNums];
        for (int i=0; i< queues.length; i++)
            queues[i] = new Queue(maxQueueLength);
    }
    // put customer is minimum loaded queue
    public void addCustomer(long customerItem) {
        Queue leastLoadedQueue = queues[0];
        for (int i = 1; i < queues.length; i++) {
            if (queues[i].isEmpty()) {
                leastLoadedQueue = queues[i];
                break; // peek the empty one
            }
            if (queues[i].size() < leastLoadedQueue.size())
                leastLoadedQueue = queues[i];

        }
        leastLoadedQueue.insert(customerItem);
    }

    public void displayLines() {
        System.out.println("Displaying customer queues");
        for (int i=0; i < queues.length; i++) {
            queues[i].display();
        }
    }

    public void checkOutClient() {
        int queueNum = new Random().nextInt(queues.length);
        queues[queueNum].remove();
    }

    private static String parseInputCommand() throws IOException {
        Reader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        return br.readLine();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter 1 - to add customer to the queue, 2 - display - all queues, 3 - Check out a customer, 4 - Exit");
        CheckOutLine cl = new CheckOutLine(2,3);
        while (true) {
            switch (parseInputCommand()) {
                case "1" : cl.addCustomer(new Random().nextInt(11)); break;
                case "2" : cl.displayLines(); break;
                case "3" : cl.checkOutClient(); break;
                case "4" : return;
                default: System.out.println("Invalid input, please try again..."); continue;

            }
        }
    }
}
