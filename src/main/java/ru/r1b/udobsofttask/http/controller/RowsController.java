package ru.r1b.udobsofttask.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.r1b.udobsofttask.http.schema.RowsMinSchema;
import ru.r1b.udobsofttask.service.RowsService;
import ru.r1b.udobsofttask.service.XlsxParser;

import java.io.FileInputStream;
import java.io.IOException;

@Controller
@RequestMapping("/rows")
public class RowsController {
    private final RowsService service;
    private final XlsxParser xlsxParser;

    @Autowired
    public RowsController(RowsService service, XlsxParser xlsxParser) {
        this.service = service;
        this.xlsxParser = xlsxParser;
    }

    @PostMapping("/min")
    public RowsMinSchema getMin(String path, int n) {
        try {
            return new RowsMinSchema(service.findMin(xlsxParser.parse(new FileInputStream(path)), n));
        } catch (IOException e) {
            return new RowsMinSchema(0);
        }
    }
}
