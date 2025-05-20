package com.ankush.url_shortify.com.ankush.url_shortify.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlRequest.ShortUrlRequest;
import com.ankush.url_shortify.com.ankush.url_shortify.Mapper.ShortUrlResponse.ShortUrlResponse;
import com.ankush.url_shortify.com.ankush.url_shortify.Services.ShortUrlService;

@RestController
@RequestMapping("/api/url")
public class ShortUrlController {
	@Autowired
	private ShortUrlService shortUrlService;

	@PostMapping("/create")
	public ResponseEntity<ShortUrlResponse> createShortUrl(@RequestBody ShortUrlRequest request) {
		ShortUrlResponse response = shortUrlService.createShortUrl(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping("/original")
	public ResponseEntity<ShortUrlResponse> getOriginalUrl(@RequestParam String shortUrl) {
		ShortUrlResponse response = shortUrlService.getOriginalUrl(shortUrl);
		return ResponseEntity.ok(response);
	}

}
