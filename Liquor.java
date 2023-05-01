public abstract class Liquor {
	String description = "unknown liquor";

	public String getDescription() {
		return description;
	}

	public abstract int calories();
}
