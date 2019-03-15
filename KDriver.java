import java.util.Arrays;
public class KDriver{

public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio\tresult\tOptimization ");
  int num = Integer.parseInt(args[0]);
  int[]MAX_LIST = {1000000000,500,10};
  int count = 0;
  int total = 0;
  for(int MAX : MAX_LIST){
    for(int size = 15625; size < 32000001; size*=2){
      long qtime=0;
      long btime=0;
      long Qtime = 0;
      //average of 5 sorts.
      String result = "";
      String check = "";
      for(int trial = 0 ; trial <=5; trial++){
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
        Quick.quicksort(data2,num);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
        //optimazation comparison
        T1 = System.currentTimeMillis();
        Quick.quicksort(data3,num-1);
        T2 = System.currentTimeMillis();
        Qtime += T2 - T1;
        //
        t1 = System.currentTimeMillis();
        Arrays.sort(data1);
        t2 = System.currentTimeMillis();
        btime+= t2 - t1;
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
      if(Qtime > qtime){
        check = "WORSE!";
      }
      if(qtime >= Qtime){
        check = "BETTER!";
        count++;
      }
      total++;
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime+"\t"+result+"\t"+check);
    }
    System.out.println("OPTIMIZATION %: " + (count/total)*100);
    System.out.println();
  }
}


}
