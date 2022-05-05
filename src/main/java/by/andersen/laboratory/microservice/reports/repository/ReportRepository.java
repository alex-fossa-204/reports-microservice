package by.andersen.laboratory.microservice.reports.repository;

import by.andersen.laboratory.microservice.reports.model.Report;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ReportRepository extends JpaRepository<Report, Long> {

    List<Report> findAllByReporterUid(Long reporterUid);

    Optional<Report> findByUid(Long uid);

}
