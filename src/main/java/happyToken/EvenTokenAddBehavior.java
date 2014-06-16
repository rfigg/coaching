package happyToken;

/**
 * Created by ryanfigg on 6/14/14.
 */
public class EvenTokenAddBehavior implements AddBehavior {
    @Override
    public boolean canAdd(TokenColor color, TokenPosition position) {
        System.out.println("Even Token Position is adding a token of color " + color);
        if (position.isEmpty() || (position.getCount(color.opposite()) % 2 == 0)) {
            System.out.println("Position accepts token.");
            return true;
        } else {
            System.out.println("Position can't accept token.");
            return false;
        }
    }
}
