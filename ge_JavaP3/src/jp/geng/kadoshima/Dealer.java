package jp.geng.kadoshima;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;

public class Dealer {

	private int bet_money; //掛け金
	private int div_money;
	ArrayList<Trump> deck;
	Iterator<Trump> it;
	private int count;
	private Trump now_card;
	private Trump next_card;

	public Dealer() {
		deck = new ArrayList<Trump>();
		this.bet_money = 0;
		this.div_money = 0;
		this.count = 0;
		for (int i = 0; i < Constants.TRUMP_MARK; i++) {
			for (int j = 0; j < Constants.TRUMP_STRENGTH; j++) {
				deck.add(new Trump(i, j));
			}
		}
		this.it = deck.iterator();
		this.now_card = it.next();
	}

	public void setBetMoney(int bet_money) {
		this.bet_money = bet_money;
		this.div_money=this.bet_money;
		this.count=0;
	}

	public void deck_print() {
		for (Trump deck : deck) {
			//			System.out.println(deck.getValue());
			deck.stats_print();
		}
	}

	public void deck_shuffle() {
		Collections.shuffle(deck);
		this.it = deck.iterator();
	}

	public boolean judgement() {
		while (true) {
			if (this.it.hasNext()) {
				next_card = this.it.next();
				System.out.println("現在のカード");
				this.now_card.stats_print();
				System.out.println("次のカード");
				this.next_card.stats_print();
				if (next_card.getValue() < now_card.getValue()) {
					System.out.println("負けです。");
					this.now_card = this.next_card;
					return false;
				} else {
					System.out.println("勝ちです。");
					this.count++;
					this.now_card = this.next_card;
					return true;
				}
			} else {
				deck_shuffle();
				continue;
			}
		}
	}

	public void divCalc() {
		this.div_money = this.bet_money*(int)Math.pow(2, count-1);
		System.out.println("配当金:"+this.div_money);
	}
	
	public void divDeal(User user) {
		user.getDivMoney(this.div_money);
		System.out.println("配当金:"+this.div_money);
	}
	
	public void now_card_print() {
		System.out.print("現在のカード:");
		this.now_card.stats_print();
	}
	
	public void card_draw() {
		while(true) {
			if (this.it.hasNext()) {
				next_card = this.it.next();
				this.now_card = this.next_card;
				break;
			} else {
				deck_shuffle();
				continue;
			}
		}
	}
	
	public int getCount() {
		return this.count;
	}

}
