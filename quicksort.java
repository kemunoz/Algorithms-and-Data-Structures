import java.io.*;

class quicksort{

    static void quickSort(int[] array, int left, int right){

        if(left < right){
            int index = partition(array, left, right);
            quickSort(array, left, index);
            quickSort(array, index + 1, right);
        }
    }

    static int partition(int[] array, int left, int right){
        int pivot = array[(left + right)/2];
        while(left < right){
            while(array[left] < pivot) left++;
            while(array[right]>pivot) right--;
            if(left<=right){
                swap(array, left, right);
                left++;
                right--;
            }
        }

        return left;
    }

    static void swap(int[] array, int left, int right){
        int temp = array[left];
        array[left] = array[right];
        array[right] = temp;
    }


    public static void main(String[] args){
        int[] array = new int[args.length];
        for(int i = 0; i<args.length; i++){
            array[i] = Integer.parseInt(args[i]);
        }

        quickSort(array, 0, array.length - 1);
        for(int i = 0; i<array.length; i++){
            System.out.println(array[i]);
        }
    }
}