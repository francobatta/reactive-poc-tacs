package com.example.demo;

import lombok.AllArgsConstructor;
import lombok.Value;

@Value
@AllArgsConstructor
class MatchInput {
    String date;
    String time;
    String place;
}
