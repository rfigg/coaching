package happyToken;

/**
 * Created by ryanfigg on 6/15/14.
 */
public class OddTokenAddBehavior implements AddBehavior {
    @Override
    public boolean canAdd(TokenColor color, TokenPosition position) {
        System.out.println("Odd Token Position is adding a token of color " + color);
        if (position.isEmpty() || (position.getCount(color.opposite()) % 2 == 1)) {
            System.out.println("Position accepts token.");
            return true;
        } else {
            System.out.println("Position can't accept token.");
            return false;
        }
    }
}
