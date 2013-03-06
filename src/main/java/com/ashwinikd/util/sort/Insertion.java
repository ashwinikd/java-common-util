package com.ashwinikd.util.sort;

public class Insertion
{
    public static <T extends Comparable<T>> void sort(T[] array)
    {
        T tmp;
        
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j - 1].compareTo(array[j]) > 0) { 
                    //swap j and j - 1
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
    }

    public static void sort(int[] array)
    {
        int tmp;
        
        for(int i = 1; i < array.length; i++) {
            for(int j = i; j > 0; j--) {
                if(array[j - 1] > array[j] ) {
                    //swap j and j - 1
                    tmp = array[j];
                    array[j] = array[j-1];
                    array[j-1] = tmp;
                }
            }
        }
    }
}
