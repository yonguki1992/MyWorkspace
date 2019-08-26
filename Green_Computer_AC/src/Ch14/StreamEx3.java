package Ch14;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.stream.Stream;

public class StreamEx3 {

	public static void main(String[] args) {
		//파일 스트림 
		// InputStreamReader - 읽어오기
		// OutputStreamWriter - 출력하기(파일 쓰기)
		//Stream<String> fileStream = Files.lines(path);
		// 빈 스트림
		Stream emptyStream = Stream.empty();
	}

}
