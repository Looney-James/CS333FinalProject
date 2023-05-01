public class Cherry extends LiquorDecorator{
	public Cherry(Liquor liquor) {
		this.liquor = liquor;
	}
	
	public String getDescription() {
		return liquor.getDescription() + ", Cherry";
	}
	
	public int calories() {
		return 40 + liquor.calories();
	}
}
