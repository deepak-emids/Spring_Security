package com.emids.spring.security.api.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.http.HttpStatus;
@Data
@Getter
@Setter
@ToString
public class ResponseDto {

    private Integer status;
    private Object data;
    private Object error;
    private Object message;

    public ResponseDto() {
        this.status = HttpStatus.OK.value();
        this.data = data;
        this.error = error;
        this.message = message;

    }
}
