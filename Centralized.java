import java.util.ArrayList;
import java.util.Scanner;

class CentralProcess {
  int netAddress;
  String name;

  public CentralProcess(String name, int netAddress) {
    this.name = name;
    this.netAddress = netAddress;
  }
}

public class Centralized {
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    ArrayList<CentralProcess>  procQueue = new ArrayList<CentralProcess>();
    ArrayList<CentralProcess>  reqQueue = new ArrayList<CentralProcess>();

    procQueue.add(new CentralProcess("P1", 1));
    procQueue.add(new CentralProcess("P2", 9));
    procQueue.add(new CentralProcess("P3", 5));
    procQueue.add(new CentralProcess("P4", 10));
    procQueue.add(new CentralProcess("P5", 3));

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
      for (CentralProcess cProcess : reqQueue) {
        System.out.print(cProcess.name + "\t");

      }
      System.out.println("\n" + reqQueue.get(reqQueue.size()-1).name + " executed.\n");
      reqQueue.remove(reqQueue.size() - 1);

      if (reqQueue.size() == 0) {
        break;
      }
    }
    System.out.println("All the Processes gets executed, Exiting....");

  }
}
