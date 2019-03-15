import java.util.Arrays;
public class KDriver{

public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio\tresult ");
  int[]MAX_LIST = {1000000000,500,10};
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 8000001; size*=2){
      long qtime=0;
      long btime=0;
      //average of 5 sorts.
      String result = "PASS!";
      for(int trial = 0 ; trial <=5; trial++){
        int []data1 = new int[size];
        int []data2 = new int[size];
        for(int i = 0; i < data1.length; i++){
          data1[i] = (int)(Math.random()*MAX);
          data2[i] = data1[i];
        }
        long t1,t2;
        t1 = System.currentTimeMillis();
        Quick.quicksort(data2);
        t2 = System.currentTimeMillis();
        qtime += t2 - t1;
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
      System.out.println(size +"\t\t"+MAX+"\t"+1.0*qtime/btime+"\t"+result);
    }
    System.out.println();
  }
}


}
