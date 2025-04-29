package ru.r1b.udobsofttask.helper;

public class Qsort {

    public static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int baseIndex = splitAndSort(arr, left, right);


        quickSort(arr, left, baseIndex - 1);
        quickSort(arr, baseIndex + 1, right);
    }


    private static int splitAndSort(int[] nums, int left, int right) {
        int baseIdx = left + (right - left) / 2;
        int baseVal = nums[baseIdx];

        swap(nums, baseIdx, right);

        int i = (left - 1);
        for (int j = left; j < right; j++) {
            if (nums[j] >= baseVal) {
                continue;
            }
            i++;

            swap(nums, i, j);
        }

        swap(nums, i + 1, right);

        return i + 1;
    }

    private static void swap(int[] nums, int i1, int i2) {
        var temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
