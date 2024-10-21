import java.util.LinkedList;
import java.util.Queue;

public class RoundRobin {

    public static void main(String[] args) {
        // Create a queue of processes with their respective IDs and required CPU time
        Queue<Process> processQueue = new LinkedList<>();
        processQueue.add(new Process("P1", 10)); // Process P1 requires 10 units of CPU time
        processQueue.add(new Process("P2", 5));  // Process P2 requires 5 units of CPU time
        processQueue.add(new Process("P3", 8));  // Process P3 requires 8 units of CPU time

        // Define a fixed time slice (quantum) for Round Robin scheduling
        int timeSlice = 4;

        // Queue to store the order in which processes finish
        Queue<String> completionOrder = new LinkedList<>();

        // Round Robin scheduling simulation
        while (!processQueue.isEmpty()) {
            // Dequeue the process at the front of the queue
            Process currentProcess = processQueue.poll();

            // Check if the process needs more than one time slice to complete
            if (currentProcess.remainingTime > timeSlice) {
                // Process needs more time, allocate one full time slice (4 units)
                System.out.println("Process " + currentProcess.processId + " is allocated " + timeSlice + " units. Remaining time: " + (currentProcess.remainingTime - timeSlice));

                // Reduce the process's remaining time by the time slice
                currentProcess.remainingTime -= timeSlice;

                // Add the process back to the end of the queue with the updated remaining time
                processQueue.add(currentProcess);
            } else {
                // Process can complete within this time slice
                System.out.println("Process " + currentProcess.processId + " is allocated " + currentProcess.remainingTime + " units. Remaining time: 0 - Finished");

                // Add the process ID to the completion order queue
                completionOrder.add(currentProcess.processId);
            }
        }

        // Print the order in which the processes finished
        System.out.print("Order of completion: ");
        while (!completionOrder.isEmpty()) {
            System.out.print(completionOrder.poll());
            if (!completionOrder.isEmpty()) {
                System.out.print(", ");
            }
        }
    }
}