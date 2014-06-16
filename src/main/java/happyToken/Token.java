package happyToken;

/**
 * Created by ryanfigg on 6/13/14.
 * Simple Token class that is created with a parameterized constructor, and
 * who's color cannot be changed.
 */
class Token {
    final TokenColor color;

    Token(TokenColor color) {
        this.color = color;
    }

    public TokenColor getColor() {
        return color;
    }
}
