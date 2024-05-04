package com.ffd.userservice.api.model;

import lombok.*;

import java.time.LocalDateTime;


@Setter
@Getter
@Builder
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Order {

    private Long index;

    private String name;

    private Long price;

    private Long stock;

    private Long user_index;

    private Long item_index;

    private String status;

    private LocalDateTime created_date;

    private LocalDateTime last_modified_date;

}