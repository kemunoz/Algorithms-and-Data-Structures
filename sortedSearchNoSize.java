import java.io.*;
public class sortedSearchNoSize {
    static int elementAt(int[] array, int x){
        if(x > array.length - 1) return -1;
        return array[x];
    }
    static int binarySearch(int[] array, int low, int high, int target){
        if(low > high) return -1;
        int middle = (low + high) /2;
        if(array[middle] == target){
            return middle;
        }
        else if( array[middle] > target) return binarySearch(array, low, middle -1, target);
        else return binarySearch(array, middle + 1, high, target);
    }
    static int findSize(int[] array){
        int size = -1;
        int index = 1;
        while(size == -1){
            index *=2;
            size = elementAt(array, index);
        }
        while(size == -1){
            index--;
            size = elementAt(array, index);
        }
        return index;
    }

    public static void main(String[] args){
        int[] array = new int[args.length];
        for(int i = 0; i<args.length; i++){
            array[i] = Integer.parseInt(args[i]);
        }
        int high = findSize(array);
        int target = 10;
        int index = binarySearch(array, 0, high,target);
        if(index== -1){
            System.out.println("TARGET NOT FOUND");
        }
        else System.out.println("target found at index: "+index);

    }
    
}