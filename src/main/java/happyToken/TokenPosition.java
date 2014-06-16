package happyToken;

import java.util.ArrayList;

/**
 * Created by ryanfigg on 6/13/14.
 */
public class TokenPosition {
    protected ArrayList tokens = new ArrayList();
    AddBehavior addBehavior;

    public TokenPosition(AddBehavior addBehavior) {
        this.addBehavior = addBehavior;
    }

    public boolean addToken(TokenColor color) {
        if (addBehavior.canAdd(color, this)) {
            tokens.add(new Token(color));
            return true;
        } else {
            return false;
        }
    }

    public TokenColor getTop() {
		if (!this.isEmpty()) {
            Token token = (Token) tokens.get(tokens.size() - 1);
			return token.getColor();
		} else {
            return null;
        }
	}

	public int getCount(TokenColor color) {
		int count = 0;
        Token token;

		for (int i = 0; i < tokens.size(); i++) {
            token = (Token) tokens.get(i);
            if (token.getColor() == color) {
                count++;
            }
        }
		return count;
	}

    public int getCount() {
        return tokens.size();
    }

	public boolean isEmpty() {
		return tokens.isEmpty();
	}

	@Override
	public String toString() {
		if (tokens.isEmpty()){
			return "Empty position.";
		} else if (tokens.size() == 1) {
			return String.format("Position has one %s token.", this.getTop());
		} else {
			return String.format("Position has %d tokens, %d black and %d white, with a %s token on top.",
				tokens.size(), this.getCount(TokenColor.BLACK), this.getCount(TokenColor.WHITE),
				this.getTop());
		}
	}

	public void clear() {
		tokens.clear();
	}
}
