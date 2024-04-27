import java.util.*;
public class Bully {
    int coordinator;
    int max_processes;
    boolean processes[];
    Bully(int max){
        max_processes = max;
        coordinator = max;
        processes = new boolean[max_processes];

        for(int i = 0; i < max_processes; i+=1){
            processes[i] = true;
            System.out.println("Process [" + i + "] created");
        }
        System.out.println("Process [" + coordinator + "] is the coordinator");

    }

    void displayProcesses(){
        for(int i = 0; i < max_processes; i+=1){
            if(processes[i]){
                System.out.println("Process [" + i + "] is UP" );
            }
            else{
                System.out.println("Process [" + i + "] is DOWN" );

            }
        }
        System.out.println("Process [" + coordinator + "] is the coordinator");
    }

    void upProcess(int pid){
        if(pid < max_processes && processes[pid] != true){
            processes[pid] = true;
        }
        else{
            System.out.println("Process [" + pid + "] already UP or does not exist" );
        }

    }

    void downProcess(int pid){
        if(pid < max_processes && processes[pid] != false){
            processes[pid] = false;
        }
        else{
            System.out.println("Process [" + pid + "] already DOWN or does not exist" );
        }
        
        
    }

    void runElection(int pid){
        coordinator = pid;
        boolean keepGoing = true;
        for(int i = pid; i < max_processes; i+=1){
            System.out.println("Election message sent from Process[" + i +"] to Process[" + (i+1 )+ "]"  );
            if(i+1 < max_processes && processes[i+1]){
                keepGoing = false;
                runElection(i+1);
            }
        }
    }

    public static void main(String[] args) {
        Bully bully = null;
        int max_processes  = 0, pid = 0;
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        while(true){
            System.out.println("Bully Algorithm");
            System.out.println("1. Create processes");
            System.out.println("2. Display processes");
            System.out.println("3. Up a process");
            System.out.println("4. Down a process");
            System.out.println("5. Run election algorithm");
            System.out.println("6. Exit Program");
            System.out.print("Enter your choice:- ");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("Enter no. of Processes : ");
                    max_processes = sc.nextInt();
                    bully = new Bully(max_processes);
                    break;
                
                case 2 :
                    bully.displayProcesses();
                    break;
                case 3 :
                    System.out.println("Enter Process to UP"); 
                    pid = sc.nextInt();
                    bully.upProcess(pid);
                    break;

                case 4 :
                    System.out.println("Enter Process to DOWN"); 
                    pid = sc.nextInt();
                    bully.downProcess(pid);
                    break;
                
                case 5:
                    System.out.println("Enter Process id that will run the election");
                    pid = sc.nextInt();
                    bully.runElection(pid);
                    bully.displayProcesses();
                    break;

                case 6:
                    System.exit(0);
                default:
                    break;
            }
        }

    }
}
