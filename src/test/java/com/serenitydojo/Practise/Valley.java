package com.serenitydojo.demo;

import java.util.Arrays;

public class Valley {
    public static int[] makeValley(int[] arr) {
        Arrays.sort(arr);
        int[] ans=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            if(i%2==0)
                ans[i/2]=arr[arr.length-1-i];
            else
                ans[arr.length-1-i/2]=arr[arr.length-1-i];
        }
        return ans;
    }
}

