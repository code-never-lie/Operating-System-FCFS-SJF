//Java program for implementation of FCFS scheduling
class FCFS {

    // Function to find the waiting time for all the pro
    private void WaitingTime(int pro[], int n, int burst_time[], int wait_time[]) {
        wait_time[0] = 0;
        for (int i = 1; i < n; i++) {
            wait_time[i] = burst_time[i - 1] + wait_time[i - 1];
        }
    }

    // Function to calculate turn around time
    private void Aroundtime(int pro[], int n,
            int burst_time[], int wait_time[], int tat[]) {
        for (int i = 0; i < n; i++) {
            tat[i] = burst_time[i] + wait_time[i];
        }
    }

    // Function to calculate average time
    public void Averag_Time(int pro[], int n, int burst_time[]) {
        int wait_time[] = new int[n], tat[] = new int[n];
        int total_wt = 0, total_tat = 0;
        WaitingTime(pro, n, burst_time, wait_time);
        Aroundtime(pro, n, burst_time, wait_time, tat);
        System.out.printf("Process Burst time Waiting" + " time Turn around time\n");
        for (int i = 0; i < n; i++) {
            total_wt = total_wt + wait_time[i];
            total_tat = total_tat + tat[i];
            System.out.printf(" %d ", (i + 1));
            System.out.printf("     %d ", burst_time[i]);
            System.out.printf("     %d", wait_time[i]);
            System.out.printf("     %d\n", tat[i]);
        }
        float s = (float) total_wt / (float) n;
        int t = total_tat / n;
        System.out.printf("Average waiting time = %f", s); // show in table form
        System.out.printf("\n");
        System.out.printf("Average turn around time = %d ", t);
    }
}


