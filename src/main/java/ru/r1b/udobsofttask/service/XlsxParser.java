package ru.r1b.udobsofttask.service;

import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.util.LinkedList;
import java.util.List;

@Service
public class XlsxParser {
    public List<Integer> parse(FileInputStream stream) {
        return new LinkedList<>();
    }
}
