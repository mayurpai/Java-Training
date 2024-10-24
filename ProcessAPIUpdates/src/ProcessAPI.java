import java.lang.ProcessHandle.Info;

public class ProcessAPI {
	public static void main(String[] args) {
		ProcessHandle processHandle = ProcessHandle.current();
		Info info = processHandle.info();
		System.out.println("Complete Process Information: " + info);
		System.out.println("Start Instant: " + info.startInstant());
		System.out.println("User: " + info.user());
		System.out.println("Total CPU Duration: " + info.totalCpuDuration());
		System.out.println("Command: " + info.command());
		System.out.println("Command Line: " + info.commandLine());
		System.out.println("Arguments: " + info.arguments());

	}

}
