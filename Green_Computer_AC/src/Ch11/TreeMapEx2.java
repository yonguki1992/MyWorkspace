package Ch11;
import java.util.TreeMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Set;

public class TreeMapEx2 {

	static TreeMap<String, TreeMap> subject = new TreeMap<String, TreeMap>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		addScore("국어", 100, "홍길동");
		addScore("국어", 94, "박길수");
		addScore("국어", 95, "홍길동");
		addScore("국어", 90, "박찬수");
		addScore("영어", 100, "홍길동");
		addScore("영어", 94, "박길수");
		addScore("영어", 95, "홍길동");
		addScore("영어", 90, "박찬수");
		printList();
	}

	static void addScore(String subjectName, int score, String name) {
		addSubject(subjectName);
		TreeMap<Integer, String> student = subject.get(subjectName);
		student.put(score, name); // 이름은 중복될 수 있으니 점수를 key로 지정
	}

	// HashMap<Key, Value>
	static void addSubject(String subjectName) {
		if (!subject.containsKey(subjectName)) { // 과목이름이 새로 등록될 때만 아래 코드를 실행
			subject.put(subjectName, new TreeMap()); // 그룹이름을 키, 새로운 해쉬맵을 값으로 활용
		}
	}

	static void printList() {
		// 프린트 리스트
		Set set = subject.entrySet();
		Iterator it = set.iterator();

		while (it.hasNext()) {
			Map.Entry e = (Map.Entry) it.next();
			TreeMap tm = (TreeMap) e.getValue();
			Set tmpSet = tm.entrySet();
			Iterator tmpIt = tmpSet.iterator();
			
			System.out.println("*과목 : " + e.getKey());
			
			while (tmpIt.hasNext()) {
				Map.Entry tmpE = (Map.Entry) tmpIt.next();
				System.out.println("이름  : " + tmpE.getValue() + ", 점수 : " + tmpE.getKey());

			}
			System.out.println();
			Map.Entry entry = null;
			entry = tm.ceilingEntry(new Integer(91));
			System.out.println("91점 이상인 사람 중 점수가 가장 낮은 사람은 "+entry.getValue()+" 으로, "+entry.getKey()+"점 입니다.");			
			entry = tm.firstEntry();
			System.out.println("제일 점수가 낮은 사람은 "+entry.getValue()+" 으로, "+entry.getKey()+"점 입니다.");
			NavigableMap dMap = tm.descendingMap();
			Set<Map.Entry> dMapEntrySet = dMap.entrySet();
			
			for(Map.Entry dmEntrySet : dMapEntrySet) {
				System.out.println(dmEntrySet.getKey() + " -  "+ dmEntrySet.getValue());
			}
		}
	}
}


