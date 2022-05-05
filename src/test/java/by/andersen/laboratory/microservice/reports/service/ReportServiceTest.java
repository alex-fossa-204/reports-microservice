package by.andersen.laboratory.microservice.reports.service;

import by.andersen.laboratory.microservice.reports.model.dto.ReportDto;
import by.andersen.laboratory.microservice.reports.service.exception.EmptyResultException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ServiceTest {

    @Autowired
    private ReportService reportService;

    @Test
    public void findAllReportsTest() throws EmptyResultException {
        List<ReportDto> reports = reportService.findUserReports(786486841L);
        Assertions.assertNotNull(reports);
        reports.forEach(System.out::println);
    }

}
