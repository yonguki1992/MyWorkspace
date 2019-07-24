package Homework;

public class Sixthweek {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		exercise7_1();

	}

	static void exercise7_1() {
		SutdaDeck deck = new SutdaDeck();
		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");
		deck.shuffle();
		System.out.println();
		for (int i = 0; i < deck.cards.length; i++)
			System.out.print(deck.cards[i] + ",");
	}
}

class SutdaDeck {
	final int CARD_NUM = 20;
	NewSutdaCard[] cards = new NewSutdaCard[CARD_NUM];

	SutdaDeck() {
		// (1)
		for (int i = 0; i < cards.length; ++i) {
			cards[i] = new NewSutdaCard(i % 10 + 1, i + 1 == 1 || i + 1 == 3 || i + 1 == 8 ? true : false);
		}
	}

	void shuffle() {
		NewSutdaCard temp = new NewSutdaCard();
		for (int k = 0; k < 20; ++k) {
			int i = (int) (Math.random() * (cards.length));
			int j = (int) (Math.random() * (cards.length));
			temp = cards[j];
			cards[j] = cards[i];
			cards[i] = temp;
		}
	}

	NewSutdaCard pick(int index) {
		return cards[index];
	}

	NewSutdaCard pick() {
		return cards[(int) (Math.random() * (cards.length))];
	}
}

class NewSutdaCard {
	
	final int num;
	final boolean isKwang;

	
	NewSutdaCard() {
		this(1, true);

	}

	NewSutdaCard(int num, boolean isKwang) {
		this.num = num;
		this.isKwang = isKwang;
	}

	public String toString() {
		return num + (isKwang ? "K" : "");
	}
}

class MyTv2 {
	private int channel;
	private int prevChannel = channel;
	private int volume;
	
	final int MAX_VOLUME = 100;
	final int MIN_VOLUME = 0;
	final int MAX_CHANNEL = 100;
	final int MIN_CHANNEL = 1;
	
	public int getChannel() {
		return channel;
	}

	public void setChannel(int channel) {
		this.prevChannel = this.channel;
		this.channel = channel;
	}

	public void gotoPrevChannel() {
		int temp = channel;
		channel = prevChannel;
		prevChannel = temp;
	}

	public int getVolume() {
		return volume;
	}

	public void setVolume(int volume) {
		this.volume = volume;
	}

}