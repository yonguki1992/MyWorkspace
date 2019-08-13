package Ch12;

import static java.lang.annotation.ElementType.*;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.apache.commons.lang3.StringUtils;


/*
 * 자바, 스프링 @Requred @Autowired : 자동 주입 @Resource
 */
/*
 * 이 프로그램은 성적관리 프로그램
 * @author 김용욱
 */


//필드 : 기본형 , 타입 유즈 : 참조형
@Documented
@Target({FIELD, TYPE, TYPE_USE})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
@interface TestInfo  { // 어노테이션에선 상속 허용 불가 (ex: extends DateTime)
	int count() default 1;
	String testBy();
	String[] testTools() default "JUnit";
	TestType testType() default TestType.FIRST;
	DateTime testDate();
}

@interface DateTime {
	String yymmdd();
	String hhmmss();
}

@Deprecated
@SuppressWarnings("unchecked")
@TestInfo(testBy="AAA", testDate=@DateTime(yymmdd="160101", hhmmss="235959"))
public class AnnotationEx1 {

	@Deprecated
	int oldField;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub		
		
		Class<AnnotationEx1> cls = AnnotationEx1.class;
		TestInfo anno = (TestInfo)cls.getAnnotation(TestInfo.class);
		
		if(StringUtils.equals(anno.testBy(),"AAA")) {
			System.out.println("anno.testBy()의 값은 > " + anno.testBy() +"입니다.");
		}
		System.out.println(anno.testDate().yymmdd());
		System.out.println(anno.testDate().hhmmss());
		for(String str : anno.testTools()) {
			System.out.println("testTools()="+str);
		}
		
		Annotation[] annoArr = cls.getAnnotations();
		for(Annotation str : annoArr) {
			System.out.println(str);
		}
	}

}

enum TestType {
	FIRST,
	FINAL
}