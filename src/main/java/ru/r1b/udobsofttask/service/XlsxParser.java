package ru.r1b.udobsofttask.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

@Service
public class XlsxParser {
    public List<Integer> parse(FileInputStream stream) throws IOException {
        Workbook workbook = new XSSFWorkbook(stream);
        var sheet = workbook.getSheetAt(0);
        int[] out = new int[sheet.getLastRowNum()+1];

        // читаем файл, параллельно используя сортировку вставками

        int inserted = 0, pointer, val;
        for (Row row : sheet) {
            val = (int) row.getCell(0).getNumericCellValue();

            pointer = inserted;
            // условие `val < out[pointer-1]` можно было бы вынести в какой-нибудь компаратор, но в рамках
            // тестового задания решил этого не делать
            while(pointer > 0 && val < out[pointer-1]) {
                // swap pointer and pointer-1
                out[pointer] = out[pointer] + out[pointer-1];
                out[pointer-1] = out[pointer] - out[pointer-1];
                out[pointer] = out[pointer] - out[pointer-1];

                pointer--;
            }
            out[pointer] = val;
            inserted++;
        }

        return new ArrayList<>(Arrays.stream(out).boxed().toList());
    }
}
