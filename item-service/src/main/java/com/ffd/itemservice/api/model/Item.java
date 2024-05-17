package com.ffd.itemservice.api.model;

import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Item {

    private Long index;

    private String name;

    private Long price;

    private Long stock;

    private String status;

    private LocalDateTime created_date;

    private LocalDateTime last_modified_date;

    private String detail;

}