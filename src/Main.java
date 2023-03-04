import java.io.FileNotFoundException;
import java.util.PriorityQueue;
import java.util.Queue;

public class Main {
    public static void main(String[] args) throws Exception {
        VendingMachine myMachine = new VendingMachine(args[0],args[1],args[2],args[3],args[4]);
        myMachine.start();
        myMachine.runTasks();
        myMachine.printOutput();
    }
}
