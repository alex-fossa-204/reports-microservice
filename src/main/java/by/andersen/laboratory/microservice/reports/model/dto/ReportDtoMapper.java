package by.andersen.laboratory.microservice.reports.model.dto;

import by.andersen.laboratory.microservice.reports.model.Report;
import by.andersen.laboratory.microservice.reports.model.ReportStatus;
import by.andersen.laboratory.microservice.reports.repository.ReportRepository;
import by.andersen.laboratory.microservice.reports.repository.ReportStatusRepository;
import by.andersen.laboratory.microservice.reports.utils.RandomUidGenerator;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Data
@AllArgsConstructor

@Component
public class ReportDtoMapper implements EntityDtoMapper<Report, ReportDto> {

    private ReportRepository reportRepository;

    private ReportStatusRepository reportStatusRepository;

    private RandomUidGenerator randomUidGenerator;

   private static final String REPORT_STARTED = "STARTED";

    @Override
    public ReportDto entityToDto(Report entity) {
        return new ReportDto(entity.getReportTitle(), entity.getReportBody(), entity.getReportDate(), entity.getReporterUid(), entity.getTimeCost(), entity.getUpdateDate(), entity.getReportStatus().getReportStatusName(), entity.getUid());
    }

    @Override
    public List<ReportDto> convertEntityListToDtoList(List<Report> entityList) {
        List<ReportDto> reports = new ArrayList<>();
        entityList.forEach(entity -> {
            reports.add(entityToDto(entity));
        });
        return reports;
    }

    @Override
    public Report dtoToEntity(ReportDto dto) {
        Optional<Report> report = Optional.empty();
        ReportStatus reportStatus = reportStatusRepository.findByReportStatusName(REPORT_STARTED);
        if(dto.getUid() == null) {
            Report entity = new Report(dto.getReportTitle(), dto.getReportBody(), new Date(), dto.getReporterUid(), dto.getTimeCost(), reportStatus , randomUidGenerator.generateRandomTransferUid());
            report = Optional.of(entity);
        }
        if(dto.getUid() != null) {
            report = reportRepository.findByUid(dto.getUid());
        }
        return report.get();
    }

}
