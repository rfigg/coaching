package happyToken;

import java.util.*;

enum TokenColor {
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
};

public class HappyTokenBoard {
	
	public final int POSITION_COUNT = 3;
	
	private HappyTokenPosition[] positions = new HappyTokenPosition[POSITION_COUNT];

	public HappyTokenBoard() {
		positions[0] = new HappyTokenPosition() {
			public boolean addToken(TokenColor c) {
				System.out.println("Position 0 is adding a token of color " + c);
				boolean success = false;
				if (this.isEmpty() || this.getTop() != c) {
					System.out.println("Position accepts token.");
					tokens.add(new Token(c));
					success = true;
					if (tokens.size() == 10)
						emailJanelle();
				} else {
					System.out.println("Position can't accept token.");
				}
				return success;
			}
		};	

		positions[1] = new HappyTokenPosition() {
			public boolean addToken(TokenColor c) {
				System.out.println("Position 1 is adding a token of color " + c);
				if (this.isEmpty() || (this.getCount(c.opposite()) % 2 == 0)) {
					System.out.println("Position accepts token.");
					tokens.add(new Token(c));
					return true;
				} else {
					System.out.println("Position can't accept token.");
					return false;
				}
			}
		};

		positions[2] = new HappyTokenPosition() {
			public boolean addToken(TokenColor c) {
				System.out.println("Position 2 is adding a token of color " + c);
				if (this.isEmpty() || (this.getCount(c.opposite()) % 2 == 1)) {
					System.out.println("Position accepts token.");
					tokens.add(new Token(c));
					return true;
				} else {
					System.out.println("Position can't accept token.");
					return false;
				}
			}
		};
		
	}

	public boolean addTokenToPosition(TokenColor c, int p) {
		if (p >= 0 && p < POSITION_COUNT){
			// System.out.printf("Board is adding a token of color %s to position %d.\n", c, p);
			return positions[p].addToken(c);
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
			status[i*2]   = positions[i].getCount(TokenColor.BLACK);
			status[i*2+1] = positions[i].getCount(TokenColor.WHITE);	
		}
		status[POSITION_COUNT*2] = -1;
		return status;
	}

	public void reset() {
		for (HappyTokenPosition p : positions) {
			p.clear();
		}
	}

	private void emailJanelle() {
		//email code
		// System.out.println("*** Emailing Janelle. But not really. Yet. ***");
		try {
			SendMailTLS.mail("ryan.figg@gmail.com");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

abstract class HappyTokenPosition {
	//protected so anonymous subclasses can access from abstract method implementation
	protected ArrayList<Token> tokens = new ArrayList<>(); // could change to List<Token> on left

	//need constructor? think not
	
	public TokenColor getTop() {
		if (!this.isEmpty()) {
			return tokens.get(tokens.size() - 1).getColor();
		} else 
			return null;
	}

	public int getCount(TokenColor c) {
		int count = 0;
		for (Token t : tokens) {
			if (t.getColor() == c)
				count++;
		}
		return count;
	}

	public boolean isEmpty() {
		return tokens.isEmpty();
	}

	public abstract boolean addToken(TokenColor c);

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

class Token {
	// should this be a factory class?
	// public static Token makeToken(TokenColor c){return new Token(c);}?
	private TokenColor color;

	public Token(TokenColor c) { 
		color = c;
	}

	public TokenColor getColor() {
		return color;
	}
}