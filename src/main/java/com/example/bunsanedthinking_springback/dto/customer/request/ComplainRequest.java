package com.example.bunsanedthinking_springback.dto.customer.request;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class ComplainRequest {
    private int complainType;
    private String title;
    private String content;
    private int customerId;
}