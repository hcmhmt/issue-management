package com.simurg.issuemanagement.advice;

import lombok.*;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ExceptionResponse {

    private Date date;
    private String message;

}

