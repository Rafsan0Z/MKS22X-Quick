import java.util.Arrays;
public class KDriver{

public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio\tresult\tArraySort Time\tInsertionSort Time ");
  int[]MAX_LIST = {5000,500,50,10};
  double count = 0;
  double count2 = 0;
  double total = 0;
  for(int MAX : MAX_LIST){
    for(int size = 20000; size < 2000001; size+=10000){
      long qtime=0;
      long btime=0;
      long Qtime = 0;
      long Itime = 0;
      //average of 5 sorts.
      String result = "";
      String check = "";
      String Iresult = "";
      for(int trial = 0 ; trial <=10; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        int []data3 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
          data3[i] = data1[i];
        }
        long t1,t2,T1,T2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
        T1 = System.currentTimeMillis();
        Quick.insertionSort(data3);
        T2 = System.currentTimeMillis();
        Itime+= T2 - T1;
        if(!Arrays.equals(data1,data2)){
          System.out.println("FAIL TO SORT!");
          System.exit(0);
        }
      }
      if(qtime/btime > 3.0){
        result = "FAIL!";
      }
      if(qtime/btime < 3.0){
        result = "PASS!";
      }
      if(btime < qtime){
        check = "WORSE!";
      }
      if(qtime <= btime){
        check = "BETTER!";
        count++;
      }
      if(Itime < qtime){Iresult = "WORSE!";}
      if(qtime <= Itime){
        Iresult = "BETTER!";
        count2++;
      }
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime+"\t"+result+"\t"+check+"\t"+Iresult);
      total++;
    }
    System.out.println("ArraySort BETTER %: " + (count/total)*100);
    System.out.println("Normal Partition BETTER %: " + (count2/total)*100);
    total = 0;
    System.out.println();
  }
}


}
