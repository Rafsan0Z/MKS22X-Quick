import java.util.Random;
public class Quick{

  public static int partition(int[]data, int start, int end){
    double random = Math.random()*(end-start);
    int pivot = (int)random + start;
    exchange(start,pivot,data);
    int pivotInt = data[start];
    pivot = start;
    start++;
    while(end >= start){
      if(data[start] > pivotInt){
        exchange(start,end,data);
        end--;
      }
      else if(data[start] < pivotInt){
        exchange(pivot,start,data);
        pivot = start;
        start++;
      }
      else if(data[start] == pivotInt){
        start++;
      }
    }
    //exchange(start,pivot,data);
    return pivot;
  }

  public static int partitionDutch(int[] data, int lo, int hi){
    double random = Math.random()*(hi-lo);
    int pivot = (int)random + lo;
    exchange(lo,pivot,data);
    pivot = lo;
    lo++;
    while(hi >= lo){
      if(data[lo] > data[pivot]){
        exchange(lo,hi,data);
        hi--;
      }
      else if(data[lo] < data[pivot]){
        exchange(pivot,lo,data);
        lo++;
        pivot++;
      }
      else if(data[lo] == data[pivot]){
        Random rn = new Random();
        int chance = Math.abs(rn.nextInt())%2;
        if(chance == 1){exchange(pivot,hi,data);}
        lo++;
      }
    }
    return pivot;
  }

  public static int[] PartitionDutch(int[] data, int lo, int hi){
    int lt = 0;
    int gt = 0;
    int[] result = new int[2];
    result[0] = lt;
    result[1] = gt;
    return result;
  }

  public static int median(int num1, int num2, int num3){
    if(num1 < num2 && num2 < num3){return num2;}
    else if(num2 < num1 && num1 < num3){return num1;}
    else{return num3;}
  }

  public static int quickselect(int[] data, int k){
    int start = 0;
    int end = data.length - 1;
    int point = partition(data,start,end);
    while(k != point){
      if(k < point){point = partition(data,0,point);}
      else if( k > point){point = partition(data,point,end);}
    }
    return data[point];
  }

  public static void exchange(int num1, int num2, int[] data){ // these are indices
    int temp = data[num1];
    data[num1] = data[num2];
    data[num2] = temp;
  }

  public static String printArray(int[] ary) {
 String result = "[";
 for (int i = 0; i < ary.length ; i++) {
  result += " " + ary[i];
  if (i != ary.length - 1) {
    result += ",";
  }
}
  return result + "]";
}

public static void main(String[] args){

  int[] data = new int[] {8,6,7,5,3,0,9,10,21,2,14};
  System.out.println(printArray(data));
  int result = partitionDutch(data,0,10);
  int result2 = quickselect(data,0);
  int middle = median(14,23,15);
  System.out.println(result);
  System.out.println(printArray(data));

}

}
