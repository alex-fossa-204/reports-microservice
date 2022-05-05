package by.andersen.laboratory.microservice.reports.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import javax.persistence.*;
import java.util.Collection;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = {"reports"})

@Entity
@Table(name = "report_status")
public class ReportStatus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "report_status_name")
    private String reportStatusName;

    @OneToMany(mappedBy = "reportStatus")
    @Fetch(FetchMode.SUBSELECT)
    private Collection<Report> reports;

}
