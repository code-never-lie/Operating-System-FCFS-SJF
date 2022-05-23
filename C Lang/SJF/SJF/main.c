#include<stdio.h>
struct process
{
    int Process_id;
    int burst_time;
    int wait_time;
    int terminate_time;
};
int main()
{
    struct process p[10],temp;

    int i,j,n,totwt,tottt;
    float avg1,avg2;
    printf("Enter the number of process: ");
    scanf("%d",&n);
    for(i=1; i<=n; i++)
    {
        p[i].Process_id=i;
        printf("Enter the burst time: ");
        scanf("%d",&p[i].burst_time);
    }
    for(i=1; i<n; i++)
    {
        for(j=i+1; j<=n; j++)
        {
            if(p[i].burst_time>p[j].burst_time)
            {
                temp.Process_id=p[i].Process_id;
                p[i].Process_id=p[j].Process_id;
                p[j].Process_id=temp.Process_id;
                temp.burst_time=p[i].burst_time;
                p[i].burst_time=p[j].burst_time;
                p[j].burst_time=temp.burst_time;
            }
        }
    }
    p[1].wait_time=0;
    p[1].terminate_time=p[1].burst_time+p[1].wait_time;
    i=2;
    while(i<=n)
    {
        p[i].wait_time=p[i-1].burst_time+p[i-1].wait_time;
        p[i].terminate_time=p[i].burst_time+p[i].wait_time;
        i++;
    }
    i=1;
    totwt=tottt=0;
    printf("\nProcess id \t burst_time \twt\t\ttt");
    while(i<=n)
    {
        printf("\n\t%d\t\t %d\t\t%d\t\t%d\n",p[i].Process_id,p[i].burst_time,p[i].wait_time,p[i].terminate_time);
        totwt=p[i].wait_time+totwt;
        tottt=p[i].terminate_time+tottt;
        i++;
    }
    avg1=totwt/n;
    avg2=tottt/n;
    printf("Average time W. R. T. waiting time=%f\nAverage time W. R. T.terminate time=%f\n",avg1,avg2);
    return 0;
}

