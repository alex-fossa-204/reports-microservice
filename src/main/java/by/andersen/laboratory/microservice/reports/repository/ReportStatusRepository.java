package by.andersen.laboratory.microservice.reports.repository;

import by.andersen.laboratory.microservice.reports.model.ReportStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ReportStatusRepository extends JpaRepository<ReportStatus, Long> {

    ReportStatus findByReportStatusName(String reportStatusName);

}
