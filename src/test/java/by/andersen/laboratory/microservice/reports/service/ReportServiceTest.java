package by.andersen.laboratory.microservice.reports.service;

import by.andersen.laboratory.microservice.reports.model.dto.ReportDto;
import by.andersen.laboratory.microservice.reports.service.exception.EmptyResultException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReportServiceTest {

    @Autowired
    private ReportService reportService;

    @Test
    public void findAllReportsTest() throws EmptyResultException {
        List<ReportDto> reports = reportService.findUserReports(786486841L);
        Assertions.assertNotNull(reports);
        reports.forEach(System.out::println);
    }

    @Test
    public void addReportTest() {
        ReportDto reportDto = new ReportDto();
        reportDto.setReportTitle("Test Report");
        reportDto.setReportBody("Testing Report sgospfh");
        reportDto.setReporterUid(786486841L);
        reportDto.setTimeCost(6.0);
        System.out.println("dto: " + reportDto);

        ReportDto reportDtoSaved = reportService.addReport(reportDto);
        System.out.println("dto saved: " + reportDtoSaved);
    }

}
