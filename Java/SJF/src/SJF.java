import java.util.Scanner;

public class SJF {

    public void Arrival(int number, int[][] arrival_time) {
        for (int i = 0; i < number; i++) {
            for (int j = 0; j < number - i - 1; j++) {
                if (arrival_time[j][1] > arrival_time[j + 1][1]) {
                    for (int k = 0; k < 5; k++) {
                        int temp = arrival_time[j][k];
                        arrival_time[j][k] = arrival_time[j + 1][k];
                        arrival_time[j + 1][k] = temp;
                    }
                }
            }
        }
    }

    public void Complete_Time(int number, int[][] arrival_time) {
        int temp, val = -1;
        arrival_time[0][3] = arrival_time[0][1] + arrival_time[0][2];
        arrival_time[0][5] = arrival_time[0][3] - arrival_time[0][1];
        arrival_time[0][4] = arrival_time[0][5] - arrival_time[0][2];

        for (int i = 1; i < number; i++) {
            temp = arrival_time[i - 1][3];
            int low = arrival_time[i][2];
            for (int j = i; j < number; j++) {
                if (temp >= arrival_time[j][1] && low >= arrival_time[j][2]) {
                    low = arrival_time[j][2];
                    val = j;
                }
            }
            arrival_time[val][3] = temp + arrival_time[val][2];
            arrival_time[val][5] = arrival_time[val][3] - arrival_time[val][1];
            arrival_time[val][4] = arrival_time[val][5] - arrival_time[val][2];
            for (int k = 0; k < 6; k++) {
                int tem = arrival_time[val][k];
                arrival_time[val][k] = arrival_time[i][k];
                arrival_time[i][k] = tem;
            }
        }
    }

}

