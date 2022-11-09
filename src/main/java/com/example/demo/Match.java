package com.example.demo;

import lombok.Builder;
import lombok.Value;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@Builder
@Value
class Match {
    @Id
    String id;

    String date;
    String time;
    String place;
}
