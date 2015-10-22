package roulette.bets;

import roulette.Bet;
import util.ConsoleReader;

public class BetFactory {
	private Bet[] myPossibleBets = {
			new RedBlack("RedBlack", 1),
			new OddEven("OddEven", 1),
			new ThreeConsecutive("ThreeConsecutive", 11),
	};

	public Bet prompt() {
		System.out.println("You can make one of the following types of bets:");
		for (int k = 0; k < myPossibleBets.length; k++) {
			System.out.println(String.format("%d) %s", (k + 1), myPossibleBets[k]));
		}
		String response = ConsoleReader.promptString("Please type in your type of bet: ");
		return generateBet(response);
		//int response = ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length);
		//return myPossibleBets[response - 1];
	}
	
	private Bet generateBet(String s) {
		System.out.println(s);
		switch (s.trim()) {
		case ("RedBlack"):
			return new RedBlack("Red or Black", 1);
		case ("OddEven"):
			return new OddEven("Odd or Even", 1);
		case ("ThreeConsecutive"):
			return new ThreeConsecutive("Three in a Row", 11);
		default:
			return null;
		}
	}
}
