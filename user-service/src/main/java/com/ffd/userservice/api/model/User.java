package com.ffd.userservice.api.model;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;


@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class User {

    private Long index;

    private String email;

    private String pw;

    private String name;

    private String remarks;

    private String address;

    private String phone;

    private String role;

    private LocalDateTime createdDate;

    private LocalDateTime lastModifiedDate;

}