package jp.geng.kadoshima;

public class HighGame {

	public void start() {
		//インスタンスの作成
		User user = new User();
		Dealer dealer = new Dealer();
		FileLoading.rule("Rule_explanation_p3.txt");

		dealer.deck_shuffle();//デッキシャッフル
		do {
			do {
				user.letPay(dealer);//掛け金支払い
				while (true) {
					if (user.bet()) {
						//親に判定させる
						if (dealer.judgement()) {
							dealer.now_card_print();
							dealer.divCalc();//配当金計算命令
						} else {
							break;
						}
					} else {
						dealer.divDeal(user);//配当金を渡す命令
						dealer.card_draw();
						if (dealer.getCount() == 0) {
							continue;
						} else {
							break;
						}
					}
				}
			} while (!(user.getMoney() <= 0 || Constants.END_POD_MONEY <= user.getMoney()));
			System.out.println("ゲーム終了します。所持金:" + user.getMoney());
		} while (user.revenge());
	}

}
