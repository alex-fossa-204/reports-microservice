package by.andersen.laboratory.microservice.reports.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Data
@NoArgsConstructor

@Entity
@Table(name = "report")
public class Report {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "report_title")
    private String reportTitle;

    @Column(name = "report_body")
    private String reportBody;

    @Column(name = "report_date")
    private Date reportDate;

    @Column(name = "reporter_uid")
    private Long reporterUid;

    @Column(name = "time_cost")
    private Double timeCost;

    @Column(name = "update_date")
    private Date updateDate;

    @Column(name = "uid")
    private Long uid;

    @ManyToOne(cascade = {CascadeType.MERGE})
    @JoinColumn(name = "report_status")
    private ReportStatus reportStatus;

    public Report(String reportTitle, String reportBody, Date reportDate, Long reporterUid, Double timeCost, ReportStatus reportStatus, Long uid) {
        this.reportTitle = reportTitle;
        this.reportBody = reportBody;
        this.reportDate = reportDate;
        this.reporterUid = reporterUid;
        this.timeCost = timeCost;
        this.reportStatus = reportStatus;
        this.uid = uid;
    }
}
