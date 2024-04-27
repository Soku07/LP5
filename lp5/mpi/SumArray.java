import java.util.Scanner;
import mpi.*;

public class SumArray{
    public static void main(String[] args) throws Exception{
        MPI.Init(args);
        int rank = MPI.COMM_WORLD.Rank();  //Unique id of each process
        int size = MPI.COMM_WORLD.Size(); //No. of nodes participating in the  computing
        //Set the workload
        int unitsize = 5; //Each computing unit (processor) will handle 5 elements of the array
        int root = 0; //Master Node
        int send_buffer[] = null;
        send_buffer = new int[unitsize * size];
        int recv_buffer[] = new int[unitsize];
        int new_recv_buffer[] = new int[size] ;//to aggregate results recieved from each processor

        if(rank == root){
            int total_elements = unitsize * size;
            for(int i = 0; i <total_elements;i++){
                System.out.print(i + ", ");
                send_buffer[i] = i;

            }
        }

        MPI.COMM_WORLD.Scatter(send_buffer,0,unitsize,MPI.INT,recv_buffer,0,unitsize,MPI.INT, root);

        for(int i = 0; i < unitsize; i++){
            recv_buffer[0] += recv_buffer[i];
        }
        System.out.println("Intermediate sum at process " + rank + "is " + recv_buffer[0]);

        MPI.COMM_WORLD.Gather(recv_buffer,0,1,MPI.INT, new_recv_buffer,0,1,MPI.INT,root);
        if(rank == root){
            int total = 0;
            for(int i = 0; i < size; i ++){
                total += new_recv_buffer[i];
            }
            System.out.println("Total sum is " + total);
        }
        MPI.Finalize();
    }
}