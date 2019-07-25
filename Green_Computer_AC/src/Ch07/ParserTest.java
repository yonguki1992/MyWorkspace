package Ch07;

public class ParserTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Parseable parser = ParserManager.getParser("XML");
		parser.parse("document.xml");
		parser = ParserManager.getParser("HTML");
		parser.parse("document2.html");
	}

}

interface Parseable {
	public abstract void parse(String filname);
}

class ParserManager {
	public static Parseable getParser(String type) {
		if(type.equals("XML")) {
			return new XMLParser();
		} else {
			return new HTMLParser();
		}
	}
}

class XMLParser implements Parseable {
	public void parse(String filename) {
		System.out.println(filename + "- XML parsing completed.");
	}
}

class HTMLParser implements Parseable {
	public void parse(String filename) {
		System.out.println(filename + "- XML parsing completed.");
	}
}