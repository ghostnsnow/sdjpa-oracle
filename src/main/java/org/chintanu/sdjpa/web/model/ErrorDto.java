package org.chintanu.sdjpa.web.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

import java.time.OffsetDateTime;

@AllArgsConstructor
@Data
public class ErrorDto {

    private String exceptionMsg;
    private OffsetDateTime time;

}
