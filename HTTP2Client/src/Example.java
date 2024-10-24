import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

public class Example {
	public static void main(String[] args) throws IOException, InterruptedException {
		httpclientDemo();
	}

	public static void httpclientDemo() throws IOException, InterruptedException {
		// By Default It Is Pointed At HTTP_2
		// Clients
		HttpClient client = HttpClient.newHttpClient();
//		HttpClient client_1_1 = HttpClient.newBuilder().version(Version.HTTP_1_1).build();

		// Variables
		Integer number_of_api_calls = 4;
		Boolean is_async = true;

		// URLs
		List<String> urls = url_constructor(number_of_api_calls);

		// Get Requests
		for (int i = 0; i < urls.size(); i++) {
			// Client HTTP_2
			get_request_template(client, urls.get(i), is_async);
			// Client HTTP_1_1
//			get_request_template(client_1_1, urls.get(i), is_async);
		}

	}

	public static void get_request_template(HttpClient client, String url, Boolean is_async)
			throws IOException, InterruptedException {
		System.out.println("Calling API Endpoint: " + url);
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();

		if (is_async) {
			CompletableFuture<HttpResponse<String>> responseFuture = client.sendAsync(httpRequest,
					HttpResponse.BodyHandlers.ofString());
			responseFuture.thenAccept(response -> {
				display(url, response);
			}).exceptionally(e -> {
				System.out.println("Error: " + e.getMessage());
				return null;
			}).join();

//			try {
//				Thread.sleep(500); 
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
		} else {
			HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
			display(url, httpResponse);
		}

//		httpResponse.headers().map().forEach((key, value) -> System.out.println(key + ": " + value));

	}

	public static List<String> url_constructor(Integer number_of_api_calls) {
		List<String> urls = new ArrayList<String>();
		for (int i = 1; i <= number_of_api_calls; i++) {
			String url = "https://jsonplaceholder.typicode.com/posts/" + i + "/comments";
			urls.add(url);
		}
		return urls;
	}

	public static void display(String url, HttpResponse<String> httpResponse) {
		System.out.println("---------------------------------------------------------------------");
		System.out.println("URL: " + url);
		System.out.println("Response: " + httpResponse.body());
		System.out.println("HTTP Response Version: " + httpResponse.version());
		System.out.println("Response Status Code: " + httpResponse.statusCode());
		System.out.println("---------------------------------------------------------------------");
	}

}
