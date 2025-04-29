package ru.r1b.udobsofttask.service;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class RowsServiceTest {

    public static Stream<Arguments> source() {
        return Stream.of(
                Arguments.of(List.of(4, 5, 2, 4, 6), 1, 4),
                Arguments.of(List.of(0,0,0,0,0), 3, 0)
        );
    }

    @ParameterizedTest
    @MethodSource("source")
    void findMin(List<Integer> list, int n, int expected) {
        assertEquals(expected, new RowsService().findMin(list, n));
    }
}