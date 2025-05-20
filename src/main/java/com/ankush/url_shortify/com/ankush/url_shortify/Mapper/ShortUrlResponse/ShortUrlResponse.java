package com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlResponse;

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
public class ShortUrlResponse {

	private Integer id;
	private String originalUrl;
	private String shortUrl;
	private Timestamp expirationTime;
	private Integer clickCount;
	private Timestamp createdAt;

}
