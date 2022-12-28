import java.util.ArrayList;
import java.util.Scanner;

class Process {
  public String name;
  public int priority;
  public Process(String name, int priority) {
    this.name = name;
    this.priority = priority;
  }
}

public class BullyAlgorithm {
  static Process elect(ArrayList<Process> processList) {
    int max = processList.get(0).priority;
    int index = 0;
    for (int i=0; i<processList.size(); i++) {
      if(processList.get(i).priority > max) {
        max = processList.get(i).priority;
        index = i;
      }
    }

    return processList.get(index);
  }
 
  public static void main(String[] args) {
    ArrayList<Process> processList = new ArrayList<Process>();
    Scanner sc = new Scanner(System.in);

    Process p1 = new Process("P1", 1);
    Process p2 = new Process("P2", 2);
    Process p3 = new Process("P3", 3);
    Process p4 = new Process("P4", 4);
    Process p5 = new Process("P5", 5);
    processList.add(p1);
    processList.add(p2);
    processList.add(p3);
    processList.add(p4);
    processList.add(p5);

    Process coOrdinator = elect(processList);
    System.out.println("Bully Election completed..");
    System.out.println(coOrdinator.name + " is Co-ordinator Process.\n");
    
    boolean flag = true;

    while(flag) {
      System.out.println("Enter the Process name which want to make a request: ");
      String request = sc.nextLine();
      
      System.out.println(request + ", write process to request: ");
      String reply = sc.nextLine();
      if(reply.equals(coOrdinator.name)) {
        System.out.println("Resource allocation Successfull....\n");
      }
      else {
        System.out.println(reply + " is crashed.\n");
        break;
      }

      processList.remove(coOrdinator);
      coOrdinator = elect(processList);
    }


    System.out.println("Bully Election completed..");
    System.out.println(coOrdinator.name + " is Co-ordinator Process Now.");
    sc.close();

  }
}
