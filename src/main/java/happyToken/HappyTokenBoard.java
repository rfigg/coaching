package happyToken;

public class HappyTokenBoard {
	
	public final int POSITION_COUNT = 3;
	
	private TokenPosition[] positions = new TokenPosition[POSITION_COUNT];

	public HappyTokenBoard() {
        positions[0] = new TokenPosition(new TopTokenAddBehavior());
        positions[1] = new TokenPosition(new EvenTokenAddBehavior());
        positions[2] = new TokenPosition(new OddTokenAddBehavior());
	}

	public boolean addTokenToPosition(TokenColor c, int p) {
        boolean success = false;
		if (p >= 0 && p < POSITION_COUNT){
			// System.out.printf("Board is adding a token of color %s to position %d.\n", c, p);
			success = positions[p].addToken(c);
            if (success && (p == 0) && (positions[p].getCount() == 10)) { //ugly conditional to see if we email
                emailJanelle();
            }
            return success;
			} else {
			// System.out.printf("Oh, %d? That's not a position.\n", p);
			return false;
		}
	}

	@Override
	public String toString() {
		//return ("EVERYTHING IS WORKING GREAT!!!!!!!!!!!\nLY.");
		String status = "";
		for (int i = 0; i < positions.length; i++) {
			status += String.format("Position %d: %s\n", i, positions[i]);
		}
		return status;
	}

	public int[] viewStatus() {
		// returning an array of token color counts, black then white for each position, -1 terminated
		// receiver can infer number of positions or look for -1
		int[] status = new int[POSITION_COUNT * 2 + 1];
		for (int i = 0; i < POSITION_COUNT; i++) {
            System.out.format("Getting counts for %d position BLACK\n",i);
			status[i*2]   = positions[i].getCount(TokenColor.BLACK);
            System.out.format("Getting counts for %d position WHITE\n",i);
            status[i*2+1] = positions[i].getCount(TokenColor.WHITE);
		}
		status[POSITION_COUNT*2] = -1;
		return status;
	}

	public void reset() {
        TokenPosition position;
        for (int i = 0; i < POSITION_COUNT; i++) {
            position = positions[i];
            position.clear();
        }

	}

    private void emailJanelle() {
        //email code
        try {
//			SendMailTLS.mail("ryan.figg@gmail.com");
            System.out.println("***** Would now be emailing, were it activated *****");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}