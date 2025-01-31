package com.service;

import java.util.List;

import com.domain.Review;

import lombok.var;
import reactor.core.publisher.Flux;

public class ReviewService {

	public Flux<Review> getReviews(long bookId) {
		var reviewList = List.of(new Review(1, bookId, 9.1, "Good Book"), new Review(2, bookId, 8.6, "Worth Reading"));

		return Flux.fromIterable(reviewList);
	}
}