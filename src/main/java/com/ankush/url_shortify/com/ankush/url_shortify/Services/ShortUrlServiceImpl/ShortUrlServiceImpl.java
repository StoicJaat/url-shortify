package com.ankush.url_shortify.com.ankush.url_shortify.Services.ShortUrlServiceImpl;

import java.sql.Timestamp;
import java.util.Optional;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ankush.url_shortify.com.ankush.url_shortify.Entity.EShortUrl;
import com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlMapper.ShortUrlMapper;
import com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlRequest.ShortUrlRequest;
import com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlResponse.ShortUrlResponse;
import com.ankush.url_shortify.com.ankush.url_shortify.Repository.ShortUrlRepository;
import com.ankush.url_shortify.com.ankush.url_shortify.Services.ShortUrlService;

@Service
public class ShortUrlServiceImpl implements ShortUrlService {

	@Autowired
	private ShortUrlRepository shortUrlRepository;

	

    private static final String BASE_URL = "http://localhost:8080/";
    private static final int SHORT_URL_LENGTH = 6;
    
	@Override
	public ShortUrlResponse createShortUrl(ShortUrlRequest request) {
		String randomKey = generateRandomString(SHORT_URL_LENGTH);

        EShortUrl entity = ShortUrlMapper.mapRequestoEntity(request);
        entity.setShortUrl(BASE_URL + randomKey);
        entity.setCreatedAt(new Timestamp(System.currentTimeMillis()));
        entity.setClickCount(0); // start with 0

        EShortUrl saved = shortUrlRepository.save(entity);
        return ShortUrlMapper.mapEntityToModel(saved);
	}

	@Override
	public ShortUrlResponse getOriginalUrl(String shortUrl) {
		Optional<EShortUrl> optional = shortUrlRepository.findByShortUrl(shortUrl);

        if (optional.isPresent()) {
            EShortUrl url = optional.get();

            if (url.getExpirationTime() != null && url.getExpirationTime().before(new Timestamp(System.currentTimeMillis()))) {
                throw new RuntimeException("URL expired");
            }

            url.setClickCount(url.getClickCount() + 1);
            shortUrlRepository.save(url);

            return ShortUrlMapper.mapEntityToModel(url);
        } else {
            throw new RuntimeException("URL not found");
        }
	}
	private String generateRandomString(int length) {
        String characters = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789";
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < length; i++) {
            sb.append(characters.charAt(random.nextInt(characters.length())));
        }

        return sb.toString();
    }

}
