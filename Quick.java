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
        start++;
        pivot++;
      }
      else if(data[start] == pivotInt){
        start++;
      }
    }
    return pivot;
  }

  public static int quickselect(int[] data, int k){
    int start = partition(data,0,data.length() - 1);
    int end = data.length() - 1;
    while(k < end && k >= start){
      if( k < end){
        end--;
      }
      start = partition(data,start,end);
    }
    return data[end];
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
  int result = partition(data,0,6);
  System.out.println(result);
  System.out.println(printArray(data));

}

}
