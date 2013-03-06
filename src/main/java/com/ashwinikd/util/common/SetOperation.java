package com.ashwinikd.util.common;

import java.util.ArrayList;
import java.util.Arrays;

import com.ashwinikd.util.sort.Quick;

public class SetOperation
{
    public static <T extends Comparable<T>> void intersect(T[] A, T[] B, ArrayList<T> result) {
        ArrayList<T> sorted;
        T[] notSorted;
        
        if(A.length < B.length) {
            sorted = (ArrayList<T>) Arrays.asList(A);
            Quick.sort(sorted);
            notSorted = B;
        } else {
            sorted = (ArrayList<T>) Arrays.asList(B);
            Quick.sort(sorted);
            notSorted = A;
        }
        
        for(int i = 0; i < notSorted.length; i++) {
            if(Search.binarySearch(notSorted[i], sorted) >= 0) {
                result.add(notSorted[i]);
            }
        }
    }
    
    public static <T extends Comparable<T>> void subtract(T[] A, T[] B, ArrayList<T> result) {
        ArrayList<T> sorted;
        T[] notSorted;

        sorted = (ArrayList<T>) Arrays.asList(B);
        Quick.sort(sorted);
        notSorted = A;
        
        for(int i = 0; i < notSorted.length; i++) {
            if(Search.binarySearch(notSorted[i], sorted) < 0) {
                result.add(notSorted[i]);
            }
        }
    }
    
    public static <T extends Comparable<T>> void union(T[] A, T[] B, ArrayList<T> result) {
        subtract(A, B, result);
        
        for(int i = 0; i < B.length; i++) {
            result.add(B[i]);
        }
    }
}
