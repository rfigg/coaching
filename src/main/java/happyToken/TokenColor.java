package happyToken;

/**
 * Created by ryanfigg on 6/13/14.
 */
public enum TokenColor {
    BLACK("black"), WHITE("white");
	private String name;
	private TokenColor(String n) {
		name = n;
	}
	@Override
	public String toString() {
		return name;
	}
	public TokenColor opposite() {
		if (this==WHITE) {
			return BLACK;
		} else {
			return WHITE;
		}
	}
}
