import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Main {
	public static void main(String[] args) throws IOException, InterruptedException {
		httpclientDemo();
	}

	public static void httpclientDemo() throws IOException, InterruptedException {
		HttpClient client = HttpClient.newHttpClient();
		String url = "https://jsonplaceholder.typicode.com/posts/1/comments";
		HttpRequest httpRequest = HttpRequest.newBuilder().uri(URI.create(url)).build();
		HttpResponse<String> httpResponse = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());

		System.out.println("Response Status Code: " + httpResponse.statusCode());
		System.out.println("Response: " + httpResponse.body());

		httpResponse.headers().map().forEach((key, value) -> System.out.println(key + ": " + value));
	}
}
