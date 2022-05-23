#include <stdio.h>
struct process
{
    int Process_id;
    int burst_time;
    int wait_time;
    int terminate_time;
};
int main()
{
    struct process p[10];
    int i,n,totwt,tottt,avg1,avg2;
    printf("Enter the no of process : ");
    scanf("%d",&n);
    for(i=1; i<=n; i++)
    {
        p[i].Process_id=i;
        printf("Enter the burst time of %d process : ",i);
        scanf("%d",&p[i].burst_time);
    }
    p[1].wait_time=0;
    p[1].terminate_time=p[1].burst_time+p[1].wait_time;
    i=2;
    while(i<=n)
    {
        p[i].wait_time=p[i-1].burst_time+p[i-1].wait_time;
        p[i].terminate_time=p[i].burst_time+p[i].wait_time;
        i ++;
    }
    i=1;
    totwt=tottt=0;
    printf("\nprocess id \t brust time\twait time\tterminate time\n");
    while(i<=n)
    {
        printf("\t%d \t\t%d \t\t %d\t\t\t %d\n",p[i].Process_id,p[i].burst_time,p[i].wait_time,p[i].terminate_time);
        totwt=p[i].wait_time+totwt;
        tottt=p[i].terminate_time+tottt;
        i++;
    }
    avg1=totwt/n;
    avg2=tottt/n;
    printf("\naverage time W. R. T. waiting time=%d\naverage time W. R. T.terminate time=%d\n",avg1,avg2);
    return 0;
}
