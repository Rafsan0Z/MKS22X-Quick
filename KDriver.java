import java.util.Arrays;
public class KDriver{

public static void main(String[]args){
  System.out.println("Size\t\tMax Value\tquick/builtin ratio\tresult");
  int[]MAX_LIST = {1000000000,5000,500,50};
  double count = 0;
  double total = 0;
  for(int MAX : MAX_LIST){
    for(int size = 31250; size < 2000001; size*=2){
      long qtime=0;
      long btime=0;
      long Qtime = 0;
      //average of 5 sorts.
      String result = "";
      String check = "";
      String Iresult = "";
      for(int trial = 0 ; trial <=10; trial++){
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
      total++;
    }
    System.out.println();
  }
}


}
