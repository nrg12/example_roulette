package roulette.bets;

import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;


import roulette.Bet;
import util.ConsoleReader;

public class BetFactory {
	private Bet[] myPossibleBets = {
			new RedBlack("RedBlack", 1),
			new OddEven("OddEven", 1),
			new ThreeConsecutive("ThreeConsecutive", 11),
	};
	private Map paramMap; // = new HashMap<String, Integer>;

	public Bet prompt() {
		setUpMap();
		System.out.println("You can make one of the following types of bets:");
		for (int k = 0; k < myPossibleBets.length; k++) {
			System.out.println(String.format("%d) %s", (k + 1), myPossibleBets[k]));
		}
		String response = ConsoleReader.promptString("Please type in your type of bet: ");
		return generateBet(response);
		//int response = ConsoleReader.promptRange("Please make a choice", 1, myPossibleBets.length);
		//return myPossibleBets[response - 1];
	}

	private void setUpMap() {
		paramMap = new HashMap<String, Integer>();
		paramMap.put("RedBlack", 1);
		paramMap.put("OddEven", 1);
		paramMap.put("ThreeConsecutive", 11);
	}

	private Bet generateBet(String s) {

		Class c;
		try {
			c = Class.forName("roulette.bets." + s);
			Class[] cArg = new Class[2]; //Our constructor has 3 arguments
			cArg[0] = String.class; //First argument is of *object* type Long
			cArg[1] = int.class; //Second argument is of *object* type String
			try {
				return (Bet) c.getDeclaredConstructor(cArg).newInstance(s, paramMap.get(s));
			} catch (InstantiationException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IllegalArgumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (InvocationTargetException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (NoSuchMethodException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SecurityException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;


		//			
		//		switch (s.trim()) {
		//		case ("RedBlack"):
		//			return new RedBlack("Red or Black", 1);
		//		case ("OddEven"):
		//			return new OddEven("Odd or Even", 1);
		//		case ("ThreeConsecutive"):
		//			return new ThreeConsecutive("Three in a Row", 11);
		//		default:
		//			return null;
		//		}
	}}

