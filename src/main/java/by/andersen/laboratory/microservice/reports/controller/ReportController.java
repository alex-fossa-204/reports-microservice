package by.andersen.laboratory.microservice.reports.controller;

import by.andersen.laboratory.microservice.reports.model.dto.ReportDto;
import by.andersen.laboratory.microservice.reports.service.ReportService;
import by.andersen.laboratory.microservice.reports.service.exception.EmptyResultException;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.HttpStatus.*;

@Data
@AllArgsConstructor

@RestController
public class ReportController {

    private ReportService reportService;

    @PostMapping("/report/add")
    public ResponseEntity<ReportDto> addReport(@RequestBody ReportDto reportDto) {
        ReportDto result = reportService.addReport(reportDto);
        return new ResponseEntity<>(result, OK);
    }

    @GetMapping("/report/get/all/by/user/{userUid}")
    public ResponseEntity<List<ReportDto>> getAllUserReports(@PathVariable Long userUid) throws EmptyResultException {
        List<ReportDto> reports = reportService.findUserReports(userUid);
        return new ResponseEntity<>(reports, OK);
    }

    @PatchMapping("/report/update")
    public ResponseEntity<ReportDto> updateReport(@RequestBody ReportDto reportDto) throws EmptyResultException {
        ReportDto result = reportService.updateReport(reportDto);
        return new ResponseEntity<>(result, OK);
    }

    @DeleteMapping("/report/delete")
    public ResponseEntity<ReportDto> deleteReport(@RequestBody ReportDto reportDto) throws EmptyResultException {
        ReportDto result = reportService.deleteReport(reportDto);
        return new ResponseEntity<>(result, OK);
    }

}
