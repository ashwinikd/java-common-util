package com.ashwinikd.util.common;

import java.util.ArrayList;

public class IntArray
{
    public static int[] toPrimitive(ArrayList<Integer> list) {
        int[] items = new int[list.size()];
        int i = 0;
        for (int item : list) {
            items[i] = item;
            i++;
        }
        return items;
    }
}
