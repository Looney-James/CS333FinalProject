public class Sugar extends LiquorDecorator {
	public Sugar(Liquor liquor) {
		this.liquor = liquor;
	}
	
	public String getDescription() {
		return liquor.getDescription() + ", Sugar";
	}
	
	public int calories() {
		return 300 + liquor.calories();
	}
}
