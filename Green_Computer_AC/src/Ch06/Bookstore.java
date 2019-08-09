package Ch06;

public class Bookstore {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Book[] bookArr = new Book[3];
		bookArr[0] = new Book();
		bookArr[0].bookName = "자바";
		bookArr[0].price = 50000;
		
		bookArr[1] = new Book();
		bookArr[1].bookName = "파이슨";
		bookArr[1].price = 50000;
		
		bookArr[2] = new Book();
		bookArr[2].bookName = "루비";
		bookArr[2].price = 50000;
		
		for(Book book : bookArr) {
			System.out.print(book.bookName);
			System.out.println(book.price);
		}
		
		System.out.println(new Book().bookName);
	}

}

class Book {
	String bookName;
	int price;
}