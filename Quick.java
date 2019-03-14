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
    int lower = lo;
    int between = lo+1;
    int higher = hi;
    double random = Math.random()*(hi-lo);
    int pivot = (int)random + lo;
    int pivotInt = data[pivot];
    exchange(lo,pivot,data);
    while(higher >= between){
      if(data[between] > pivotInt){
        exchange(between,higher,data);
        higher--;
      }
      else if(data[between] < pivotInt){
        exchange(lower,between,data);
        lower++;
        between++;
      }
      else if(data[between] == pivotInt){
        /*Random rn = new Random();
        int chance = Math.abs(rn.nextInt())%2;
        if(chance == 1){exchange(pivot,higher,data);}*/
        between++;
      }
    }
    return higher;
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

public static void quicksort(int[] data){
  int end = data.length-1;
  QuickSortHelper(data,0,end);
}

public static void QuickSortHelper(int[] data, int lo, int hi){
  if(lo >= hi){
    return;
  }
  int pivot = partitionDutch(data,lo,hi);
  QuickSortHelper(data,lo,pivot-1);
  QuickSortHelper(data,pivot+1,hi);
}

public static int[] createBase(int size){
  int[] result = new int[size];
  for(int i = 0; i < size; i++){
    int num = (int)Math.random()*10;
    result[i] = num;
  }
  return result;
}

public static void main(String[] args){

  int[] data = new int[] {8,6,7,5,3,0,9,10,21,2,14,4,5,2,7,9,12,6};
  System.out.println(printArray(data));
  quicksort(data);
  //int result = partition(data,0,10);
  //int result2 = quickselect(data,0);
  //int middle = median(14,23,15);
  //System.out.println(result);
  System.out.println(printArray(data));

}

}
