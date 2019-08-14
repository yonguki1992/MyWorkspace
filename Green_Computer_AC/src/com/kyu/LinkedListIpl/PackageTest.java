package com.kyu.LinkedListIpl;

public class PackageTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String[] name = { "홍길동", "이순신", "강감찬" };
		String[] phNum = { "1234", "4567", "7890" };

		MyList mlist = new MyList();
		Node node = null;

		for (int i = 0; i < name.length; ++i) {
			node = new Node();
			node.setData(name[i], phNum[i]);
			mlist.append(node);
		}

		MyIterator mi1 = mlist.customIterator();
		MyIterator mi2 = mlist.customIterator();

		System.out.println("mi1)");
		while ((node = (Node) mi1.next()) != null) {
			System.out.println(node.getName());
			System.out.println(node.getPhNum());
		}
	
		System.out.println("\nmi2)");
		while ((node = (Node) mi2.next()) != null) {
			System.out.println(node.getName());
			System.out.println(node.getPhNum());
		}
	}
	
}
