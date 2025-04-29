package ru.r1b.udobsofttask.helper;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

class QsortTest {

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(
                        new int[]{1, 3, 1, 5, 6},
                        new int[]{1, 1, 3, 5, 6}
                )
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void quickSort(int[] input, int[] expected) {
        Qsort.quickSort(input);
        assertArrayEquals(expected, input);
    }
}