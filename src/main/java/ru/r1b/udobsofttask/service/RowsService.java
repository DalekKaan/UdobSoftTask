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
        // поставленную задачу очень просто решает структура TreeSet, но насколько я понял условие задачи,
        // её использование приравнивается к использованию алгоритма сортировки
        var nums = list.stream().mapToInt(i -> i).toArray();

        // практика показывает, что зачастую быстрая сортировка работает лучше, чем попытки составить алгоритм
        // оптимизации сортировки под условия задачи
        Qsort.sort(nums);
        return nums[n];
    }
}
