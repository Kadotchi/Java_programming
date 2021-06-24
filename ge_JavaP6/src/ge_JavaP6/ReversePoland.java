package ge_JavaP6;

public class ReversePoland {
	
	private User user;
	private Calculator calcu;
	
	public ReversePoland() {
		this.user=new User();
		this.calcu=new Calculator();
	}
	
	public void start() {
		while(user.formula_entry()) {
			//式チェック
			System.out.println("計算します 。");
//			this.formula_entry();
//			this.formula_entry()
//			calcu.start(this.sArrayFormula);
		}

	}
	

}
