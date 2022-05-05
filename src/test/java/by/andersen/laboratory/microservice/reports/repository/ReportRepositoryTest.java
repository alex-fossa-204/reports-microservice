package by.andersen.laboratory.microservice.reports.repository;

import by.andersen.laboratory.microservice.reports.model.Report;
import by.andersen.laboratory.microservice.reports.model.ReportStatus;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
public class ReportRepositoryTest {

    @Autowired
    private ReportRepository reportRepository;

    @Autowired
    private ReportStatusRepository reportStatusRepository;

    @Test
    public void findAllReports() {
        List<Report> reports = reportRepository.findAll();
        Assertions.assertNotNull(reports);
        reports.forEach(System.out::println);
    }

    @Test
    public void findReportByReporterUid() {
        List<Report> reports = reportRepository.findAllByReporterUid(786486841L);
        Assertions.assertNotNull(reports);
        reports.forEach(System.out::println);
    }

    @Test
    public void findReportStatusName() {
        ReportStatus reportStatus = reportStatusRepository.findByReportStatusName("STARTED");
        System.out.println(reportStatus);
    }

}
