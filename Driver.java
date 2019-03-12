import java.util.Arrays;
import java.util.ArrayList;
import java.util.Random;
import java.lang.Math;

public class Driver {
    public static boolean test(int[] data, int k, int start, int end) {
        for (int i = start; i < end; i++) {
            if (i < k) {
                if (data[i] > data[k]) {
                    return false;
                }
            } else if (i > k) {
                if (data[i] < data[k]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static ArrayList<Integer> createBase(int limitSize){
      ArrayList<Integer> result = new ArrayList<Integer>();
      for(int i = 10; i < limitSize+10; i++){
        int num = i*2 + i - 18;
        result.add(num);
      }
      return result;
    }

    public static int[] generateArry(ArrayList<Integer> data){
      int[] result = new int[data.size()];
      int counter = 0;
      while(data.size() > 0){
        Random rn = new Random();
        int index = rn.nextInt(data.size());
        result[counter] = data.get(index);
        counter++;
        data.remove(index);
      }
      return result;
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
    public static void main(String[] args) {
        int[] data1 = {10, 80, 30, 90, 40, 50, 70};
        //System.out.println(Arrays.toString(data1));
        int index1a = Quick.partition(data1, 0, 6);
        System.out.println("1a: " + test(data1, index1a,0,6));
        //System.out.println(Arrays.toString(data1) + " "+index1a+"\n");
        //System.out.println(Arrays.toString(data1));
        int index1b = Quick.partition(data1, 2, 5);
        System.out.println("1b: " + test(data1, index1b,2,5));
        //System.out.println(Arrays.toString(data1) + " "+index1b+"\n");

        int[] data2 = {6, 3, 7, -1, 7, 4, 10, -21};
        //System.out.println(Arrays.toString(data2));
        int index2a = Quick.partition(data2, 2, 7);
        System.out.println("2a: " + test(data2, index2a,2,7));
        //System.out.println(Arrays.toString(data2) + " " + index2a+"\n");
        //System.out.println(Arrays.toString(data2));
        int index2b = Quick.partition(data2, 1, 4);
        System.out.println("2b: " + test(data2, index2b,1,4));
        //System.out.println(Arrays.toString(data2) + "\n");

        int[] data3 = {78};
        //System.out.println(Arrays.toString(data3));
        int index3 = Quick.partition(data3, 0, 0);
        System.out.println("3: " + test(data3, index3,0,0));
        //System.out.println(Arrays.toString(data3) + "\n");

        int[] data4 = {3, 1};
        int index4 = Quick.partition(data4, 0, 1);
        //System.out.println(Arrays.toString(data4));
        System.out.println("4: " + test(data4, index4,0,1));
        //System.out.println(Arrays.toString(data4) + "\n");

        for (int i = 0; i < 100; i++) {
            try {
                Random gen = new Random();
                int[] test = new int[i * 1000 + 1];
                for (int j = 0; j < test.length; j++) {
                    test[j] = gen.nextInt();
                }
                int start = Math.abs(gen.nextInt()) % test.length;
                int end = start + Math.abs(gen.nextInt()) % (test.length - start);
                //System.out.println(start + ", " + end);
                //System.out.println(Arrays.toString(test));
                int index = Quick.partition(test, start, end);
                if (!test(test, index,start,end)) {
                    System.out.print("FAILURE ON LENGTH " + (i * 1000 + 1));
                    System.exit(1);
                }
            } catch (Exception e) {
                e.printStackTrace();
                System.out.print("FAILURE ON LENGTH " + (i * 1000 + 1));
                System.exit(1);
            }
            //System.out.println("PASS ON LENGTH" + (i*1000 + 1));
        }
        ArrayList<Integer> base = createBase(10);
        ArrayList<Integer> copy = new ArrayList<Integer>();
        for(int j = 0; j < base.size(); j++){
          copy.add(base.get(j));
        }
        int[] tester = new int[10];
        tester = generateArry(base);
        System.out.println(base);
        System.out.println(copy);
        for(int i = 0; i< 10; i++){
          int k = Quick.quickselect(tester,i);
          if(k != copy.get(i+1)){System.out.println("fail!");}
        }
        System.out.println("R: SUCCESS"); //R for random
    }
}
