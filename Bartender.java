public class Bartender {

	public static void main(String[] args) {
		Liquor OldFashioned = new Bourban();
		OldFashioned = new Bitters(OldFashioned);
		OldFashioned = new Bitters(OldFashioned);
		OldFashioned = new Cherry(OldFashioned);
		OldFashioned = new Lime(OldFashioned);
		System.out.println(OldFashioned.getDescription() + " " + OldFashioned.calories() + " calories");

		Liquor VodkaGimlet = new Vodka();
		VodkaGimlet = new LimeJuice(VodkaGimlet);
		VodkaGimlet = new Lime(VodkaGimlet);
		System.out.println(VodkaGimlet.getDescription() + " " + VodkaGimlet.calories() + " calories");

		Liquor Manhattan = new Bourban();
		Manhattan = new Vermouth(Manhattan);
		Manhattan = new Vermouth(Manhattan);
		Manhattan = new Cherry(Manhattan);
		Manhattan = new Bitters(Manhattan);
		System.out.println(Manhattan.getDescription() + " " + Manhattan.calories() + " calories");

		Liquor TomCollins = new Gin();
		TomCollins = new LimeJuice(TomCollins);
		TomCollins = new LimeJuice(TomCollins);
		TomCollins = new Sugar(TomCollins);
		TomCollins = new Sugar(TomCollins);
		TomCollins = new Lime(TomCollins);
		System.out.println(TomCollins.getDescription() + " " + TomCollins.calories() + " calories");

		int OldFashionedCalories = OldFashioned.calories();
		int VodkaGimletCalories = VodkaGimlet.calories();
		int ManhattanCalories = Manhattan.calories();
		int TomCollinsCalories = TomCollins.calories();
		String highestCDrink = "";
		String lowestCDrink = "";

		int maxCalories = 0;
		int minCalories = Integer.MAX_VALUE;

		if (OldFashionedCalories > maxCalories) {
			highestCDrink = "Old Fashioned";
			maxCalories = OldFashionedCalories;
		}
		if (VodkaGimletCalories > maxCalories) {
			highestCDrink = "Vodka Gimlet";
			maxCalories = VodkaGimletCalories;
		}
		if (ManhattanCalories > maxCalories) {
			highestCDrink = "Manhattan";
			maxCalories = ManhattanCalories;
		}
		if (TomCollinsCalories > maxCalories) {
			highestCDrink = "Tom Collins";
			maxCalories = TomCollinsCalories;
		}

		if (OldFashionedCalories < minCalories) {
			lowestCDrink = "Old Fashioned";
			minCalories = OldFashionedCalories;
		}
		if (VodkaGimletCalories < minCalories) {
			lowestCDrink = "Vodka Gimlet";
			minCalories = VodkaGimletCalories;
		}
		if (ManhattanCalories < minCalories) {
			lowestCDrink = "Manhattan";
			minCalories = ManhattanCalories;
		}
		if (TomCollinsCalories < minCalories) {
			lowestCDrink = "Tom Collins";
			minCalories = TomCollinsCalories;
		}

		System.out
				.println("Highest calorie drink: " + highestCDrink + " - " + maxCalories + " calories.");
		System.out.println("Lowest calorie drink: " + lowestCDrink + " - " + minCalories + " calories.");

	}

}
