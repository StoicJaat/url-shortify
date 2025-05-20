package com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlMapper;

import java.sql.Timestamp;

import com.ankush.url_shortify.com.ankush.url_shortify.Entity.EShortUrl;
import com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlRequest.ShortUrlRequest;
import com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlResponse.ShortUrlResponse;

public class ShortUrlMapper {

	public static ShortUrlResponse mapEntityToModel(EShortUrl eShortUrl) {
//		ShortUrlResponse shortUrlResponse = new ShortUrlResponse();
		return ShortUrlResponse.builder().id(eShortUrl.getId())
				.originalUrl(eShortUrl.getOriginalUrl())
				.shortUrl(eShortUrl.getShortUrl())
				.clickCount(eShortUrl.getClickCount())
				.expirationTime(eShortUrl.getExpirationTime())
				.createdAt(new Timestamp(System.currentTimeMillis())).build();
	}
	
	public static EShortUrl mapRequestoEntity(ShortUrlRequest shortUrlRequest) {
		return EShortUrl.builder()
				.originalUrl(shortUrlRequest.getOriginalUrl())
				.expirationTime(shortUrlRequest.getExpirationTime())
				.build();
	}
}
