package by.andersen.laboratory.microservice.reports.service;

import by.andersen.laboratory.microservice.reports.model.dto.ReportDto;
import by.andersen.laboratory.microservice.reports.service.exception.EmptyResultException;

import java.util.List;

public interface ReportService {

    ReportDto addReport(ReportDto reportDto);

    List<ReportDto> findUserReports(Long userUid) throws EmptyResultException;

    ReportDto updateReport(ReportDto reportDto) throws EmptyResultException;

    ReportDto deleteReport(ReportDto reportDto) throws EmptyResultException;

}
