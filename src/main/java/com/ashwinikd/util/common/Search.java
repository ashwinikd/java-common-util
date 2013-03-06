package com.ashwinikd.util.common;

import java.util.ArrayList;

public class Search
{
    public static <T extends Comparable<T>> int binary(T needle, T[] haystack) {
        return bSearch(needle, haystack, 0, haystack.length - 1);
    }
    
    public static <T extends Comparable<T>> int binarySearch(T needle, ArrayList<T> haystack) {
        return bSearch(needle, haystack, 0, haystack.size() - 1);
    }
    
    private static <T extends Comparable<T>> int bSearch(T needle, ArrayList<T> haystack, int lo, int hi) {
        if(lo == hi && needle.compareTo(haystack.get(lo)) != 0) 
            return -1;
        
        if(lo == hi) 
            return lo;
        
        int mid = (lo + hi) / 2;
        
        if(needle.compareTo(haystack.get(mid)) > 0)
            return bSearch(needle, haystack, mid + 1, hi);
        else
            return bSearch(needle, haystack, lo, mid);
    }
    
    private static <T extends Comparable<T>> int bSearch(T needle, T[] haystack, int lo, int hi) {
        if(lo == hi && needle.compareTo(haystack[lo]) != 0) 
            return -1;
        
        if(lo == hi) 
            return lo;
        
        int mid = (lo + hi) / 2;
        
        if(needle.compareTo(haystack[mid]) > 0)
            return bSearch(needle, haystack, mid + 1, hi);
        else
            return bSearch(needle, haystack, lo, mid);
    }
}
