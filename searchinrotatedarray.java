import java.io.*;

public class searchinrotatedarray {

    static int binarySearchRecursive(int[] array, int low, int high, int x){
        if(low>high) return -1;
        int middle = (low + high)/2;
        if(array[middle] == x)
            return middle;
        if(array[middle] > x){
            return binarySearchRecursive(array, low, middle - 1, x);
        }
        else{
            return binarySearchRecursive(array, middle + 1, high, x);
        }
    }
    public static void main(String[] args){
        int[] array = new int[args.length];
        for(int i =0; i<args.length; i++){
            array[i] = Integer.parseInt(args[i]);
        }
        int splitIndex = 0;
        for(int i = 0; i<array.length - 1; i++){
            if(array[i] > array[i+1]){
                splitIndex = i;
                break;
            }
        }
        int x = binarySearchRecursive(array,0, splitIndex, 10);
        int y = binarySearchRecursive(array,splitIndex+1, array.length-1,10);
        if(x != -1){
            System.out.println("x: "+ array[x]);
        }
        else if(y !=-1 ){
            System.out.println("y: "+ array[y]);
        }
        else{
            System.out.println("NOT FOUND");
        }
    }
}