package ru.r1b.udobsofttask.http.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.r1b.udobsofttask.http.schema.RowsMinSchema;
import ru.r1b.udobsofttask.service.RowsService;
import ru.r1b.udobsofttask.service.XlsxParser;

import java.io.FileInputStream;

@RestController
@RequestMapping("/rows")
public class RowsController {
    private final RowsService service;
    private final XlsxParser xlsxParser;
    @Value("${filesPath}")
    private String filesPath;

    @Autowired
    public RowsController(RowsService service, XlsxParser xlsxParser) {
        this.service = service;
        this.xlsxParser = xlsxParser;
    }

    @GetMapping("/min")
    public RowsMinSchema getMin(@RequestParam("file") String path, @RequestParam("index") int n) {
        // todo:
        // здесь надо бы проверять путь к файлу на безопасность, чтобы пользователь не мог выйти за пределы filesPath;
        // не стал этого делать в рамках тестового задания
        path = filesPath + "/" +  path;
        try {
            return new RowsMinSchema(service.findMin(xlsxParser.parse(new FileInputStream(path)), n));
        } catch (Exception e) {
            // todo:
            // также надо бы написать или использовать валидаторы, которые будут проверять наличие файла и валидность n
            // тоже не стал делать в рамках тестового
            throw new RuntimeException(e);
        }
    }
}
