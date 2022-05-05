package by.andersen.laboratory.microservice.reports.controller.http;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.http.HttpStatus;

import java.util.Date;

public class HttpResponse {

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss", timezone = "Europe/Minsk")
    private Date timeStamp;

    private int httpStatusCode;

    private HttpStatus httpStatus;

    private String message;

    public HttpResponse(int httpStatusCode, HttpStatus httpStatus, String message) {
        this.timeStamp = new Date();
        this.httpStatusCode = httpStatusCode;
        this.httpStatus = httpStatus;
        this.message = message;
    }

}
