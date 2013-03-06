package com.ashwinikd.util.common;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.Random;

public class Shuffle
{
    
    public static void shuffle(int[] array) {
        shuffle(array, array.length - 1);
    }
    
    public static void shuffle(int[] array, int lim)
    {
        int k = 0;
        int tmp;
        Random rand = new Random();
        
        for(int i = 0; i < lim && i < array.length - 1; i++) {
            k = rand.nextInt(array.length - i) + i;
            tmp = array[k];
            array[k] = array[i];
            array[i] = tmp;
        }
    }
    
    public static <T> void shuffle(T[] array) {
        shuffle(array, array.length - 1);
    }
    
    public static <T> void shuffle(T[] array, int lim) {
        int k = 0;
        T tmp;
        Random rand = new Random();
        
        for(int i = 0; i < lim && i < array.length - 1; i++) {
            k = rand.nextInt(array.length - i) + i;
            tmp = array[k];
            array[k] = array[i];
            array[i] = tmp;
        }
    }
    
    public static <T> void shuffle(ArrayList<T> array) {
        shuffle(array, array.size() - 1);
    }
    
    public static <T> void shuffle(ArrayList<T> array, int lim) {
        int k = 0;
        T tmp;
        Random rand = new Random();
        
        for(int i = 0; i < lim && i < array.size() - 1; i++) {
            k = rand.nextInt(array.size() - i) + i;
            tmp = array.get(k);
            array.set(k, array.get(i));
            array.set(i, tmp);
        }
    }
    
    public static <T> T random(T[] array) {
        Random rand = new Random();
        return array[rand.nextInt(array.length)];
    }
    
    public static <T> Iterable<T> iterable(T[] set) {
        return new RandomIterable<T>(set);
    }
    
    private static class RandomIterable<T> implements Iterable<T> {
        
        private T[] set;
        
        public RandomIterable(T[] s) {
            this.set = s;
        }

        public Iterator<T> iterator()
        {
            return new RandomIterator(this.set);
        }
        
        private class RandomIterator implements Iterator<T> {

            private int currentIndex;
            
            private ArrayList<T> array;
            
            public RandomIterator(T[] arr) {
                this.currentIndex = 0;
                Shuffle.shuffle(arr);
                this.array = new ArrayList<T>(Arrays.asList(arr));
            }
            
            public boolean hasNext()
            {
                return (this.currentIndex == this.array.size());
            }

            public T next()
            {
                int cur = this.currentIndex;
                this.currentIndex++;
                return this.array.get(cur);
            }

            public void remove()
            {
                throw new UnsupportedOperationException("Remove is not supported");
            }
            
        }
        
    }
}
