package Ch15;

import java.io.File;
import java.util.stream.Stream;
import static java.lang.System.*;

public class IOEx1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Stream<File> fS = Stream.of(new File(System.getProperty("user.dir") + "\\etc\\test.txt")
								,new File(System.getProperty("user.dir") + "\\etc\\test.txt")
								,new File(System.getProperty("user.dir") + "\\etc\\test"));
		
		fS.map(File::getName)
		  .filter(s->s.indexOf('.') != -1)
		  .peek(s->out.println("파일명 : "+s))
		  .map(s->s.substring(s.indexOf('.')+1))
		  .peek(s->out.println("확장자 : "+s))
		  .map(String::toUpperCase)
		  .distinct()
		  .forEach(s -> out.println(s));
		
		//Stream<Long> fNS = fS.map(f -> f.length());
		//Stream<Long> fNS = fS.map(File::length);	
		//fNS.forEach(out::println);
		

	}

}
