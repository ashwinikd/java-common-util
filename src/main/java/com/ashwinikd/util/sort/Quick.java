package com.ashwinikd.util.sort;

import com.ashwinikd.util.common.Shuffle;

public class Quick
{

    public static <T extends Comparable<T>> void sort(T[] array)
    {
        Shuffle.shuffle(array, array.length - 1);
        qSort(array, 0, array.length - 1);
    }

    public static void sort(int[] array)
    {
        Shuffle.shuffle(array);
        qSort(array, 0, array.length - 1);
    }
    
    private static <T extends Comparable<T>> void qSort(T[] array, int lo, int hi) {
        if(lo == hi) return;
        int pivot = qPartition(array, lo, hi);
        if(pivot > lo)
            qSort(array, lo, pivot - 1);
        if(pivot < hi)
            qSort(array, pivot + 1, hi);
    }
    
    private static <T extends Comparable<T>> int qPartition(T[] array, int lo, int hi) {
        T pivot = array[lo];
        int i = lo + 1;
        int j = hi;
        
        while(i <= j) {
            if(pivot.compareTo(array[i]) > 0) {
                i++;
                continue;
            }
            
            if(pivot.compareTo(array[j]) <= 0) {
                j--;
                continue;
            }
            
            T tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
        
        T tmp = array[j];
        array[j] = array[lo];
        array[lo] = tmp;
        
        return j;
    }
    
    private static void qSort(int[] array, int lo, int hi) {
        if(lo == hi) return;
        int pivot = qPartition(array, lo, hi);
        if(pivot > lo)
            qSort(array, lo, pivot - 1);
        if(pivot < hi)
            qSort(array, pivot + 1, hi);
    }
    
    private static int qPartition(int[] array, int lo, int hi) {
        int pivot = array[lo];
        int i = lo + 1;
        int j = hi;
        
        while(i <= j) {
            if(pivot> array[i]) {
                i++;
                continue;
            }
            
            if(pivot <= array[j]) {
                j--;
                continue;
            }
            
            int tmp = array[j];
            array[j] = array[i];
            array[i] = tmp;
        }
        
        int tmp = array[j];
        array[j] = array[lo];
        array[lo] = tmp;
        
        return j;
    }

}
