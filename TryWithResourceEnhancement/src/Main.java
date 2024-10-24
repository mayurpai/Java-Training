import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class Main {
	public static void main(String[] args) throws FileNotFoundException {

		FileOutputStream fos = new FileOutputStream("output.txt");

		try (fos) {
			fos.write("Hello, World!".getBytes());
			System.out.println("File output.txt Updated Successfully!");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
