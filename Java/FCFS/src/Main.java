import java.text.ParseException;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) throws ParseException {
        // process id's
        int process_array[] = new int[10];
        try (Scanner sc = new Scanner(System.in)) {
            FCFS fcfs = new FCFS();
            System.out.print("Enter the Total number of Process id : ");
            int n = sc.nextInt();
            System.out.println("Enter the value of Process id: ");
            for (int i = 0; i < n; i++) {
                // reading array elements from the user
                process_array[i] = sc.nextInt();
            }
            // Burst time of all process
            int burst_time[] = new int[10];
            System.out.println("Enter the Burst time of all process: ");
            for (int i = 0; i < n; i++) {
                // reading array elements from the user
                burst_time[i] = sc.nextInt();
            }
            fcfs.Averag_Time(process_array, n, burst_time);
        }

    }
}
