package com.ankush.url_shortify.com.ankush.url_shortify.Services;

import com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlRequest.ShortUrlRequest;
import com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlResponse.ShortUrlResponse;

public interface ShortUrlService {

	ShortUrlResponse createShortUrl(ShortUrlRequest request);

	ShortUrlResponse getOriginalUrl(String shortUrl);
}
