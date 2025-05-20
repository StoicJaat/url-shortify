package com.ankush.url_shortify.com.ankush.url_shortify.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ankush.url_shortify.com.ankush.url_shortify.Entity.EShortUrl;

@Repository
public interface ShortUrlRepository extends JpaRepository<EShortUrl, Integer> {
	
	Optional<EShortUrl> findByShortUrl(String shortUrl);
	
}
