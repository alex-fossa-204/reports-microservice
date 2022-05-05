package by.andersen.laboratory.microservice.reports.service.impl;

import by.andersen.laboratory.microservice.reports.model.Report;
import by.andersen.laboratory.microservice.reports.model.dto.ReportDto;
import by.andersen.laboratory.microservice.reports.model.dto.ReportDtoMapper;
import by.andersen.laboratory.microservice.reports.repository.ReportRepository;
import by.andersen.laboratory.microservice.reports.service.ReportService;
import by.andersen.laboratory.microservice.reports.service.exception.EmptyResultException;
import com.fasterxml.jackson.annotation.OptBoolean;
import lombok.AllArgsConstructor;
import lombok.Data;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.Optional;

import static by.andersen.laboratory.microservice.reports.service.constant.ReportServiceConstant.*;

@Data
@AllArgsConstructor

@Service
@Qualifier("reportService")
public class ReportServiceImpl implements ReportService {

    private ReportRepository reportRepository;

    private ReportDtoMapper reportDtoMapper;

    @Override
    public ReportDto addReport(ReportDto reportDto) {
        Report reportEntity = reportDtoMapper.dtoToEntity(reportDto);
        Report report = reportRepository.save(reportEntity);
        return reportDtoMapper.entityToDto(report);
    }

    @Transactional(isolation = Isolation.READ_COMMITTED)
    @Override
    public List<ReportDto> findUserReports(Long userUid) throws EmptyResultException {
        List<Report> reports = reportRepository.findAllByReporterUid(userUid);
        if(reports == null) {
            throw new EmptyResultException(NO_REPORT_FOUND_FOR_USER_UID);
        }
        return reportDtoMapper.convertEntityListToDtoList(reports);
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public ReportDto updateReport(ReportDto reportDto) throws EmptyResultException {
        Optional<Report> reportToUpdateOptional = reportRepository.findByUid(reportDto.getUid());
        if(reportToUpdateOptional.isEmpty()) {
            throw new EmptyResultException(String.format(NO_REPORT_FOUND_BY_UID, reportDto.getUid()));
        }
        Report reportToUpdate = reportToUpdateOptional.get();
        if(reportDto.getReportTitle() != null) {
            reportToUpdate.setReportTitle(reportDto.getReportTitle());
        }
        if(reportDto.getReportBody() != null) {
            reportToUpdate.setReportBody(reportDto.getReportBody());
        }
        if(reportDto.getReportDate()!= null) {
            reportToUpdate.setReportDate(reportDto.getReportDate());
        }
        if(reportDto.getReporterUid() != null) {
            reportToUpdate.setReporterUid(reportDto.getReporterUid());
        }
        if (reportDto.getTimeCost() != null) {
            reportToUpdate.setTimeCost(reportDto.getTimeCost());
        }
        reportToUpdate.setUpdateDate(new Date());
        return reportDtoMapper.entityToDto(reportRepository.save(reportToUpdate));
    }

    @Transactional(isolation = Isolation.REPEATABLE_READ)
    @Override
    public ReportDto deleteReport(ReportDto reportDto) throws EmptyResultException {
        Optional<Report> reportToDeleteOptional = reportRepository.findByUid(reportDto.getUid());
        if (reportToDeleteOptional.isEmpty()) {
            throw new EmptyResultException(String.format(NO_REPORT_FOUND_FOR_USER_UID, reportDto.getUid()));
        }
        Report reportToDelete = reportToDeleteOptional.get();
        reportRepository.deleteById(reportToDelete.getId());
        return reportDtoMapper.entityToDto(reportToDelete);
    }
}
