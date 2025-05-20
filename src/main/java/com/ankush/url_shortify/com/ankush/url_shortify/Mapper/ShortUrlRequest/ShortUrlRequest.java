package com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlRequest;

import java.sql.Timestamp;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShortUrlRequest {

    private String originalUrl;
    private Timestamp expirationTime; 
}
