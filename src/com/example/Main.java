package com.example;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {

    public static void main(String[] args) {
        int[] nums = {0, 7, -4, 11, -13, 4};
        int target = -4;
        System.out.println(Arrays.toString(getSolution(nums,target)));
    }

    public static int[] getSolution(int[] nums, int target) {
        int difference = 0;
        int[] intArray = new int[2];
        List<Integer> numsList = Arrays.stream(nums).boxed().collect(Collectors.toList());
        for (int i = 0; i < nums.length; ++i) {
            intArray[0] = i;
            if(target==0){
                difference = -nums[i];
            }
            if(nums[i]==0){
                difference = target;
            }
            if(nums[i]>0 && target >0){
                difference = target - nums[i];
            }
            if(nums[i]>0 && target < 0) {
                difference = target - nums[i];
            }
            if(nums[i]<0 && target<0){
                difference = target - nums[i];
            }
            if(nums[i]<0 && target>0){
                difference = target + nums[i];
            }
            if (numsList.contains(difference)) {
                if (numsList.lastIndexOf(difference) != i) {
                    intArray[1] = numsList.lastIndexOf(difference);
                    return intArray;
                }
            }
        }
        return intArray;
    }
}
