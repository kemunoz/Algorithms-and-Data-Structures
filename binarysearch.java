import java.io.*;
class binarysearch{

    static int binarySearch(int[] array, int low, int high, int x){
        while(low <= high){
            int mid = (low + high) /2;
            if(array[mid] == x){
                return mid;
            }
            else if(array[mid] > x){
                high = mid - 1;
            }
            else{
                //its on the right side
                low = mid + 1;
            }
        }
        return -1; //error
    }
    static int binarySearchRecursive(int[] array, int low, int high, int x){
        if(low > high) return -1;
        int middle = (low + high) /2;
        if (array[middle] == x) {
            return middle;
        }
        else if(array[middle] < x){
            return binarySearchRecursive(array, middle + 1, high, x);
        }
        else{ 
            return binarySearchRecursive(array, low, middle - 1, x);
        }
    }
    public static void main(String[] args){
        int[] array = new int[args.length];
        for(int i = 0; i<args.length; i++){
            array[i] = Integer.parseInt(args[i]);
        }
        int x = binarySearch(array,0,array.length - 1, 10);
        System.out.println(x);
        x = binarySearchRecursive(array, 0, array.length - 1, 10);
        System.out.println(x);
    }
}