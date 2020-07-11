import java.io.*;

class mergesort{
    static void mergeSort(int[] array){
        int[] helper = new int[array.length];
        mergeSort(array, helper, 0, array.length - 1);
    }
    static void mergeSort(int[] array, int[] helper, int low, int high){
        if(low<high){
            int middle = (low + high)/2;
            mergeSort(array, helper, low, middle);
            mergeSort(array, helper, middle + 1, high);
            merge(array, helper, low, middle, high);
        }
    }
    static void merge(int[] array, int[] helper, int low, int middle, int high){
        //copy all elements to helper
        for(int i =low; i<=high; i++){
            helper[i] = array[i];
        }
        //helper variables
        int helperLeft = low;
        int helperRight = middle+1;
        int current = low;
        while(helperLeft <= middle && helperRight <=high){
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            }else{
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }

        //copy over the rest of the left side
        int remainder = middle - helperLeft;
        for(int i = 0; i<= remainder; i++){
            array[current + i] = helper[helperLeft + i];
        }
    }
    public static void main(String[] args){
        int[] array = new int[args.length];
        for(int i =0; i<args.length; i++){
            array[i] = Integer.parseInt(args[i]);
        }
        mergeSort(array);
        for(int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }
}