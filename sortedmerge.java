import java.io.*;
public class sortedmerge {
    static void merge(int[] array, int low, int high, int middle){
        int[] helper = new int[array.length];
        for(int i = 0 ; i<array.length; i++){
            helper[i] = array[i];
        }
        int helperLeft = low;
        int helperRight = middle;
        int current = low;
        while(helperLeft < middle && helperRight <= high){
            if(helper[helperLeft] <= helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            }
            else{
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        int remainder = middle - helperLeft;
        for(int i = 0; i< remainder; i++){
            array[current + i] = helper[helperLeft + i];
        }
    }
    public static void main(String[] args){
        int[] array = new int[args.length - 1];
        int i = 0;
        while(true){
            try{
                array[i] = Integer.parseInt(args[i]);
            }
            catch(NumberFormatException e){
                break;
            }
            i++;
        }
        int middle = i;
        i++;
        for(; i<args.length; i++){
            array[i-1] = Integer.parseInt(args[i]);
        }
        merge(array, 0, array.length - 1, middle);
        for(int j = 0; j<array.length; j++){
            System.out.println(array[j]);
        }

    }
}