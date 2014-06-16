package happyToken;

/**
 * Created by ryanfigg on 6/14/14.
 */
public class TopTokenAddBehavior implements AddBehavior {
    @Override
    public boolean canAdd(TokenColor color, TokenPosition position) {
        System.out.println("Top Token Position is adding a token of color " + color);
        boolean success = false;
        if (position.isEmpty() || position.getTop() != color) {
            System.out.println("Position accepts token.");
            success = true;
        } else {
            System.out.println("Position can't accept token.");
        }
        return success;
    }
}
