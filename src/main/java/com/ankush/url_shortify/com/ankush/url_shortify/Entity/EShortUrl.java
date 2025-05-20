package com.ankush.url_shortify.com.ankush.url_shortify.Entity;

import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "urls")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class EShortUrl {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(nullable = false, columnDefinition = "TEXT")
	private String originalUrl;

	@Column(unique = true, nullable = false)
	private String shortUrl;

	@Column(name = "created_at")
	private Timestamp createdAt;

	@Column(name = "expiration_time")
	private Timestamp expirationTime;

	@Column(name = "click_count")
	private Integer clickCount;

//	@Column(name = "user_id")
//	private Long userId; 

}