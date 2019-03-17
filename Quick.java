import java.util.Random;
public class Quick{

// Original Partition
  public static int partition(int[]data, int start, int end){
    if(start == end){return start;}
    Random rn = new Random();
    int pivot = (start+end)/2;
    exchange(start,pivot,data);
    pivot = start;
    start++;
    int pivotInt = data[pivot];
    while(end != start){
      if(data[start] > pivotInt){
        exchange(start,end,data);
        end--;
      }
      else if(data[start] < pivotInt){
        start++;
      }
      else if(data[start] == pivotInt){
        int chance = Math.abs(rn.nextInt()) % 2;
        if(chance == 0){
          start++;
        }
        else{
          exchange(start,end,data);
          end--;
        }
      }
    }
    if(data[start] >= pivotInt){start--;}
    exchange(start,pivot,data);
    return start;
  }

  private static int middle(int[] data){
    if(data.length % 2 == 0){
      return data[data.length%2];
    }
    else{
      return data[(data.length-1)%2];
    }
  }

  public static void insertionSort(int[] ary){
    insertionSort(ary,0,ary.length-1);
  }

  public static void insertionSort(int[] ary, int lo, int hi) {
    for(int i = lo; i < hi+1; i++) {
      int current = ary[i];
      int place = i;
      while(place != 0 && ary[place - 1] > current) {
        ary[place] = ary[place - 1];
        ary[place - 1] = current;
        place--;
      }
    }
  }

// partitionDutch
  /*public static int partitionDutch(int[] data, int lo, int hi){
    if(lo == hi){
      return lo;
    }
    Random rn = new Random();
    int pivot = (lo+hi)/2;
    exchange(lo,pivot,data);
    int pivotInt = data[pivot];
    int index = lo;
    while(index <= hi){
      if(data[index] > pivotInt){
        exchange(index,hi,data);
        hi--;
      }
      else if(data[index] < pivotInt){
        exchange(lo,index,data);
        lo++;
        index++;
      }
      else if(data[index] == pivotInt){
      //  int chance = Math.abs(rn.nextInt()) % 2;
      //  if(chance == 0){exchange(hi,index,data);}
        index++;
      }
    }
    //exchange(start,pivot,data);
    return hi;
  }*/

  public static int[] PartitionDutch(int[] data, int lo, int hi){
    Random rn = new Random();
    int less = lo;
    int greater = hi;
    int num = (int)Math.random()*(hi-lo);
    int pivot = num+lo;
    exchange(lo,pivot,data);
    int pivotInt = data[pivot];
    int index = lo;
    while(index <= greater){
      if(data[index] > pivotInt){
        exchange(index,greater,data);
        greater--;
      }
      else if(data[index] < pivotInt){
        exchange(index,less,data);
        less++;
        index++;
      }
      else if(data[index] == pivotInt){
        int chance = Math.abs(rn.nextInt()) % 2;
        if(chance == 0){
          exchange(index,greater,data);
          greater--;
        }
        else{
          exchange(index,less,data);
          less++;
          index++;
        }
      }
    }
    int[] result = new int[2];
    result[0] = less;
    result[1] = greater;
    return result;
  }

  public static int median(int[] data, int lo, int hi){
    int num = hi - lo;
    if(num % 2 == 0){
      return (hi+lo)/2;
    }
    else{
      return (hi+lo+1)/2;
    }
  }

  public static int quickselect(int[] data, int k){
    int start = 0;
    int end = data.length - 1;
    int point = partition(data,start,end);
    while(k != point){
      if(k < point){
        point = partition(data,start,point);
      }
      else if( k > point){
        point = partition(data,point,end);
      }
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
  if(hi - lo <= 50){
    insertionSort(data,lo,hi);
    return;
  }
  int[] pivot = PartitionDutch(data,lo,hi);
  QuickSortHelper(data,lo,pivot[0]-1);
  QuickSortHelper(data,pivot[1]+1,hi);
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
  //quicksort(data);
  //int result = partition(data,0,10);
  for(int i = 0; i < data.length; i++){
  int result2 = quickselect(data,i);
  System.out.println(result2);
}
  //int middle = median(14,23,15);
  //System.out.println(result);
}

}
