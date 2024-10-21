// Class to represent a process with an ID and required CPU time
public class Process {
    String processId;  // The unique ID of the process (e.g., "P1", "P2")
    int remainingTime; // The CPU time required by the process to complete

    // Constructor to initialize process ID and required CPU time
    public Process(String processId, int remainingTime) {
        this.processId = processId;
        this.remainingTime = remainingTime;
    }
}
