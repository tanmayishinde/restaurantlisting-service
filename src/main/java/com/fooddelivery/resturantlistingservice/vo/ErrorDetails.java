package com.fooddelivery.resturantlistingservice.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.logging.log4j.message.Message;

import java.time.LocalDateTime;
import java.util.Date;
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ErrorDetails {
    private LocalDateTime timestamp;
    private String message;
    private String path;
    private String errorCode;

    public ErrorDetails(LocalDateTime now, String message, String contextPath, String description, String userNotFound) {
    this.timestamp=getTimestamp();
    this.message=message;
    this.path=contextPath;
    this.errorCode=getErrorCode();
    }
}
