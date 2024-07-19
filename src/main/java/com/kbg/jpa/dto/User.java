package com.kbg.jpa.dto;

import lombok.Builder;
import lombok.Data;
import lombok.ToString;

import java.util.List;

@Builder
@Data
@ToString
public class User {
    private String userId;
    private String firstName;
    private String lastName;
    private List<String> phoneNumbers;
    private List<String> extensions;
}
