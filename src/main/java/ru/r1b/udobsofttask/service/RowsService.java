package ru.r1b.udobsofttask.service;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RowsService {
    public int findMin(List<Integer> list, int n) {
        if (n >= list.size()) {
            throw new IllegalArgumentException("Index exceeds the list size");
        }
        // поставленную задачу очень просто решает структура TreeSet, но насколько я понял условие задачи,
        // её использование приравнивается к использованию алгоритма сортировки

        // вместо этого нам поступает уже отсортированный список, поэтому мы можем просто работать с ним
        var nums = list.stream().mapToInt(i -> i).toArray();

        // практика показывает, что зачастую быстрая сортировка работает лучше, чем попытки составить
        // оптимизацию сортировки под условия задачи;
        // возможно есть смысл создать некое условие в зависимости от входных данных, по которому будет использоваться
        // либо быстрая сортировка, либо сортировка вставками

//        Qsort.sort(nums);


        return nums[n];
    }
}
