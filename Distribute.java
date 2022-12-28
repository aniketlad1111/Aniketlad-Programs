import java.util.ArrayList;
import java.util.Scanner;

class DistributedProcess {
  int netAddress;
  String name;

  public DistributedProcess(String name, int netAddress) {
    this.name = name;
    this.netAddress = netAddress;
  }
}

public class Distribute {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<DistributedProcess>  procQueue = new ArrayList<DistributedProcess>();
    ArrayList<DistributedProcess>  reqQueue = new ArrayList<DistributedProcess>();

    procQueue.add(new DistributedProcess("P1", 1));
    procQueue.add(new DistributedProcess("P2", 9));
    procQueue.add(new DistributedProcess("P3", 5));
    procQueue.add(new DistributedProcess("P4", 10));
    procQueue.add(new DistributedProcess("P5", 3));

    int count = 5;
    
    int index = 0;
    int high = procQueue.get(0).netAddress;
    for (int i = 0; i < count; i++) {
      if (high < procQueue.get(i).netAddress) {
        high = procQueue.get(i).netAddress;
        index = i;
      }
    }

    System.out.println("Coordinator is: " + procQueue.get(index).name);

    int inc = 0;
    while (true) {
      System.out.print("Enter index of process making request: ");
      int req = sc.nextInt();
      reqQueue.add(procQueue.get(req-1));

      if (inc == 2) {
        break;
      }
      inc++;
    }
    System.out.println();

    while (true) {
      System.out.println("The present Queue is: ");
      for (DistributedProcess dProcess : reqQueue) {
        System.out.print(dProcess.name + "\t");

      }
      System.out.println("\nProcess " +reqQueue.get(reqQueue.size()-1).name+" is having the token.");
      System.out.println(reqQueue.get(reqQueue.size()-1).name + " executed and the Token released.\n");
      reqQueue.remove(reqQueue.size() - 1);

      if (reqQueue.size() == 0) {
        break;
      }
    }
    System.out.println("All the Processes gets executed, Exiting....");
  }
}
