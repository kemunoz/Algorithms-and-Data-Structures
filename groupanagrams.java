import java.io.*;
import java.util.*;

public class groupanagrams{

    static String mergeSort(String name){
        char[] array = name.toCharArray();
        mergeSort(array,0,array.length - 1);
        String str = new String(array);
        return str;
    }
    static void mergeSort(char[] array, int low, int high){
        if(low<high){
            int middle = (low+high)/2;
            mergeSort(array, low, middle);
            mergeSort(array, middle + 1, high);
            merge(array, low, middle, high);
        }
    }

    static void merge(char[] array, int low, int middle, int high){
        char[] helper = new char[array.length];
        //copy all elements to helper array
        for(int i = 0; i<array.length; i++){
            helper[i] = array[i];
        }
        int helperLeft = low;
        int helperRight= middle + 1;
        int current = low;

        while(helperLeft <= middle && helperRight<=high){
            if(helper[helperLeft]<=helper[helperRight]){
                array[current] = helper[helperLeft];
                helperLeft++;
            }
            else{
                array[current] = helper[helperRight];
                helperRight++;
            }
            current++;
        }
        //copy all the elements on the left side
        int remainder = middle - helperLeft;
        for(int i =0; i< remainder; i++){
            array[current + i] = helper[helperLeft + i];
        }
    }


    public static void main(String[] args){
        String[] names = {"abed","abet","beat","race","bead","beta","bade","care","acre"};
        HashMap<String, String> map = new HashMap<>();
        for(int i = 0; i<names.length; i++){
            String str = mergeSort(names[i]);
            map.put(str, names[i]);   
        }
        //now we convert hashmap into an array
        //hashmap can only hold one value per key so you would have to use an ArrayList as the second value
        int current = 0;
        for(String key:map.keySet()){
            //ArrayList<String> list = map.get(key);
            for(String elem: list) {
                names[current] = elem;
                current++;
            }
        }
        for(int i = 0; i<names.length; i++){
            System.out.println(names[i]);
        }
        
    }
}