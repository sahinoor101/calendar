import java.util.*;
class kalender
{
    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int k,year,d1,d2,d3,i,j,temp,day1;
        System.out.println("ENTER YEAR");
        year=sc.nextInt();
        System.out.println("                                           "+year);
        String month[]={"          JANUARY                        FEBRUARY                        MARCH "
        ,"           APRIL                           MAY                            JUNE"
        ,"           JULY                          AUGUST                        SEPTEMBER",
            "          OCTOBER                       NOVEMBER                        DECEMBER"}; 
        int maxDays[]={31,28,31,30,31,30,31,31,30,31,30,31}; // max days in a month
        kalender obj=new kalender();
        if(obj.isLeapYear(year)==true)
        {
            maxDays[1]=29;
        }
        
        int month1[]=new int[42];
        int month2[]=new int[42];
        int month3[]=new int[42];
        d1=obj.getFristDay(year);
        d2=(d1+maxDays[0])%7;
        d3=(d2+maxDays[1])%7;
        
        month1=obj.getDates(d1,maxDays[0]);
        month2=obj.getDates(d2,maxDays[1]);
        month3=obj.getDates(d3,maxDays[2]);
        obj.display(month1,month2,month3,month[0]);

        d1=(d3+maxDays[2])%7;
        d2=(d1+maxDays[3])%7;
        d3=(d2+maxDays[4])%7;
        month1=obj.getDates(d1,maxDays[3]);
        month2=obj.getDates(d2,maxDays[4]);
        month3=obj.getDates(d3,maxDays[5]);
        obj.display(month1,month2,month3,month[1]);
        
        d1=(d3+maxDays[5])%7;
        d2=(d1+maxDays[6])%7;
        d3=(d2+maxDays[7])%7;
        month1=obj.getDates(d1,maxDays[6]);
        month2=obj.getDates(d2,maxDays[7]);
        month3=obj.getDates(d3,maxDays[8]);
        obj.display(month1,month2,month3,month[2]);
        
        d1=(d3+maxDays[8])%7;
        d2=(d1+maxDays[9])%7;
        d3=(d2+maxDays[10])%7;
        month1=obj.getDates(d1,maxDays[9]);
        month2=obj.getDates(d2,maxDays[10]);
        month3=obj.getDates(d3,maxDays[11]);
        obj.display(month1,month2,month3,month[3]);
    }
    // first day 
    public int getFristDay(int year)
    {
        // YEAR 1 AD 1 JANUARY 
        int day=1;
        kalender ob=new kalender();
        for(int i=1;i<year;i++)
        {
            if(ob.isLeapYear(i))
            {
                day+=2;
            }
            else
            {
                day++;
            }
        }
        return day % 7;
    }
    public int[] getDates(int d1 , int max)
    {
        int m[]=new int[42];int i,c=1;
        for(i=0;i<max+d1;i++)
        {
            if(i<d1)
            {
                m[i]=0;
            }
            else
            {
                m[i]=c++;
            }
        }
        return m;
    }
    public void display(int[] month1 , int[] month2 , int[] month3 ,String mheader)
    {
        int i=0,j=0,k=0,count=1;
        String header="SUN MON TUE WED THU FRI SAT  | SUN MON TUE WED THU FRI SAT  | SUN MON TUE WED THU FRI SAT  |";
        System.out.println(mheader);
        System.out.println(header);
        do
        {
            if(count <= 7)
            {
                if(month1[i]==0)
                {
                    System.out.print("    " );
                }
                else if(month1[i]<=9)
                {
                    System.out.print("  "+month1[i]+" ");
                }
                else if(month1[i]>=10)
                {
                    System.out.print(" "+month1[i]+" ");
                }
                if(count%7==0)
                {
                    System.out.print(" | ");
                }
                i++;
            }
            else if(count <= 14)
            {
                if(month2[j]==0)
                {
                    System.out.print("    ");
                }
                else if(month2[j]<=9){
                    System.out.print("  "+month2[j]+" ");
                }
                else
                {
                    System.out.print(" "+month2[j]+" ");
                }
                if(count%7==0)
                {
                    System.out.print(" | ");
                }
                j++;
            }
            else if(count <= 21)
            {
                if(month3[k]==0)
                {
                    System.out.print("    ");
                }
                else if(month3[k]<=9){
                    System.out.print("  "+month3[k]+" ");
                }
                else
                {
                    System.out.print(" "+month3[k]+" ");
                }
                if(count%7==0)
                {
                    System.out.print(" | ");
                }
                k++;
            }
            else
            {
                System.out.println(" ");
                count=0;
            }
            count++;
        }while(k<42 || i<42 || j<42);
        System.out.println();
        return;
    }
    public boolean isLeapYear(int year)
    {
        return year % 4 == 0 && year % 100 != 0 || year % 400 == 0;
    }
}