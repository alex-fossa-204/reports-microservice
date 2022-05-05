package by.andersen.laboratory.microservice.reports.model.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ReportDto {

    private String reportTitle;

    private String reportBody;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Minsk")
    private Date reportDate;

    private Long reporterUid;

    private Double timeCost;

    @JsonFormat(pattern="yyyy-MM-dd HH:mm:ss", timezone = "Europe/Minsk")
    private Date updateDate;

    private String reportStatus;

    private Long uid;

}
