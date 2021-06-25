package com.jt.cloud.gateway.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import reactor.core.publisher.Mono;

@RestController
public class FallbackController {

	@RequestMapping("/orderFallback")
	public ResponseEntity<Mono<String>> orderServiceFallback() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Mono.just("Order service is taking too long to response. Please try again later"));
	}

	@RequestMapping("/paymentFallback")
	public ResponseEntity<Mono<String>> paymentServiceFallback() {
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.body(Mono.just("Payment service is taking too long to response. Please try again later"));
	}
}
