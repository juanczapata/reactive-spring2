package com.example.reactive2.domain;

import lombok.*;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
@NoArgsConstructor
@RequiredArgsConstructor
@Data
public class Movie {
    private String id;
    @NonNull
    private String title;
}
