package ru.r1b.udobsofttask.service;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.stereotype.Service;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

@Service
public class XlsxParser {
    public List<Number> parse(FileInputStream stream) throws IOException {
        Workbook workbook = new XSSFWorkbook(stream);
        var sheet = workbook.getSheetAt(0);

        List<Number> out = new LinkedList<>();

        for (Row row : sheet) {
            out.add(row.getCell(0).getNumericCellValue());
        }

        return out;
    }
}
