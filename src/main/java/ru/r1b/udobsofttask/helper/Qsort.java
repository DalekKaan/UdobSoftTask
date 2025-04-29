package ru.r1b.udobsofttask.helper;

public class Qsort {

    // так как по условию задания использование встроенных в SDK сортировщиков запрещено, а Arrays.sort по умолчанию
    // как раз использует быструю сортировку, то напишем свою реализацию

    public static void sort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private static void sort(int[] arr, int left, int right) {
        if (left >= right) {
            return;
        }
        int baseIndex = splitAndSort(arr, left, right);


        // использован рекурсивный подход вместо итеративного так как он лучше читается;
        // на продакшене есть опасность того, что файл будет настолько большим, что это приведёт к переполнению стека
        sort(arr, left, baseIndex - 1);
        sort(arr, baseIndex + 1, right);
    }


    private static int splitAndSort(int[] nums, int left, int right) {
        // для простоты реализации в качестве опорного элемента выбран просто средний
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
        // знаю что в рамках реализации алгоритма сортировки лишний вызов метода значительно замедляет работу,
        // но для тестового задания решил его оставить для упрощения чтения кода
        var temp = nums[i1];
        nums[i1] = nums[i2];
        nums[i2] = temp;
    }
}
