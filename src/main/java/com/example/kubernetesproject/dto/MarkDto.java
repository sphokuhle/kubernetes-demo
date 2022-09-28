package com.example.kubernetesproject.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MarkDto {

    private long streamId;

    private BigDecimal totalMark;

    private BigDecimal studentMark;

    private String assessmentType;

    private String assessmentName;

}
