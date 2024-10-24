package com.reactor;

import java.util.List;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class Example {
	public static void main(String[] args) throws InterruptedException {

		// Mono example with logging
		Mono.just("Data Received!").log().subscribe(System.out::println);

		// Flux examples with logging
		Flux.just("1", "2", "3").log().subscribe(System.out::println);
		Flux.fromIterable(List.of("A", "B", "C")).log().subscribe(System.out::println);

		// Use the Flux directly instead of casting a Disposable to Mono
		Flux<String> firstFlux = Flux.fromIterable(List.of("Q", "W", "E", "R", "T", "Y"));
		firstFlux.subscribe();

		// Flux pipeline: Corrected doOnNext and filter operations
		Flux<String> secondFlux = Flux.fromIterable(List.of("1", "2", "3", "4", "5", "6"));
		secondFlux.doOnNext(item -> System.out.println("Item: " + item)).filter(x -> Integer.parseInt(x) % 2 == 0).log()
				.subscribe(System.out::println);

		// concatWith
		firstFlux.concatWith(Flux.fromIterable(List.of("1", "2", "3"))).log().subscribe(System.out::println,
				e -> System.out.println(e.getLocalizedMessage()), () -> System.out.println("Action Completed"));

		// FlatMap example with doOnNext
		secondFlux.doOnNext((x) -> System.out.println("Processing Item: " + x)).flatMap((x) -> Flux.just(x))
				.subscribe(System.out::println);
	}
}
