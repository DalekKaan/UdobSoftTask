package ru.r1b.udobsofttask.service;

import org.springframework.stereotype.Service;
import ru.r1b.udobsofttask.helper.Qsort;

import java.util.List;

@Service
public class RowsService {
    public int findMin(List<Integer> list, int n) {
        if (n >= list.size()) {
            throw new IllegalArgumentException("Index exceeds the list size");
        }
        var nums = list.stream().mapToInt(i -> i).toArray();
        Qsort.quickSort(nums);
        return nums[n];
    }
}
