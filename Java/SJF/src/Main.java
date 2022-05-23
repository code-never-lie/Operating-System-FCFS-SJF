import java.util.Scanner;

class Main {

    public static void main(String[] args) {
        int number;
        int[][] arrival_time = new int[10][6];
        try (Scanner sc = new Scanner(System.in)) {
            SJF sjf = new SJF();
            System.out.println("Enter number of Process: ");
            number = sc.nextInt();

            System.out.println("...Enter the process ID...");
            for (int i = 0; i < number; i++) {
                System.out.println("...Process " + (i + 1)
                        + "...");
                System.out.println("Enter Process Id: ");
                arrival_time[i][0] = sc.nextInt();
                System.out.println("Enter Arrival Time: ");
                arrival_time[i][1] = sc.nextInt();
                System.out.println("Enter Burst Time: ");
                arrival_time[i][2] = sc.nextInt();
            }

            System.out.println("Before Arrange...");
            System.out.println("Process ID\tArrival Time\tBurst Time");
            for (int i = 0; i < number; i++) {
                System.out.printf("%d\t\t%d\t\t%d\n", arrival_time[i][0],
                        arrival_time[i][1], arrival_time[i][2]);
            }

            sjf.Arrival(number, arrival_time);
            sjf.Complete_Time(number, arrival_time);
        }
        System.out.println("Final Result...");
        System.out.println("Process ID\tArrival Time\tBurst" + " Time\tWaiting Time\tTurnaround Time");
        for (int i = 0; i < number; i++) {
            System.out.printf(
                    "%d\t\t%d\t\t%d\t\t%d\t\t%d\n", arrival_time[i][0],
                    arrival_time[i][1], arrival_time[i][2], arrival_time[i][4], arrival_time[i][5]);
        }
    }
}