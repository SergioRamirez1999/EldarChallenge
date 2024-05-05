package com.sergioramirezme.eldar.dtos;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;

@Data
@Builder
public class PurchaseResDTO {

    @JsonProperty("message")
    private String message;
}
