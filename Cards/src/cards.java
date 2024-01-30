//package mycards;

import static java.lang.System.out;
import java.lang.*;
import java.io.*;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.Scanner; 

enum CardSuit {
	SPADES,
	HEARTS,
	CLUBS, 
    DIAMONDS; 
};

enum CardName {
	ACE, 
    TWO,
	THREE,
	FOUR,
	FIVE,
	SIX,
	SEVEN,
	EIGHT,
	NINE,
	TEN, 
	JACK, 
	QUEEN, 
	KING;
};

class Card {
	
	private ArrayList<Integer> cardDeck = new ArrayList<Integer>();
	
    private final int TOTAL_CARD_SUITS = 4;	
    private final int TOTAL_CARD_NAMES = 13;
    public static final int TOTAL_CARDS = 52;	
	
	private CardSuit [] allSuits = new CardSuit[] {CardSuit.SPADES, CardSuit.HEARTS, CardSuit.CLUBS, CardSuit.DIAMONDS};
	
	private CardName [] allNames = new CardName[] {CardName.ACE, CardName.TWO, CardName.THREE, CardName.FOUR, CardName.FIVE, 
	                                               CardName.SIX, CardName.SEVEN, CardName.EIGHT, CardName.NINE, CardName.TEN, 
	                                               CardName.JACK, CardName.QUEEN, CardName.KING};	
	
	public Card() {
		Restart();
	}
	
    public CardSuit GetSuit(Integer number) {
		return allSuits[number / TOTAL_CARD_NAMES];
	}

    public CardName GetName(Integer number) {
		return allNames[number % TOTAL_CARD_NAMES];
	}
	
	public void Restart() {
		
		cardDeck.clear();
		
		for (int i = 0; i < TOTAL_CARDS; i++) {
			cardDeck.add(i);
		}

        Collections.shuffle(cardDeck);		
	}
	
	public int PickACard() {
	    // Instance of random class
        Random rand = new Random();
        int total_card = cardDeck.size();
        int cardIndex = rand.nextInt(total_card);
        int cardPicked = cardDeck.get(cardIndex);	
        cardDeck.remove(cardIndex);	// Remove the card picked this time, so that we don't pick again.	
		return cardPicked;
	}
}


public class cards {
	
    public static void main(String[] args) {
		Card mydeck = new Card();
	    ArrayList<Integer> cardHand = new ArrayList<Integer>();		
		
		Scanner myObj = new Scanner(System.in);
		Integer cardToPick;
		
		// Allow user to input the number of cards to pick, validate the user input
		for (;;) {
			System.out.println("Input the number of cards to pick [0-52]: ");

			cardToPick = myObj.nextInt();
			
			if (cardToPick > Card.TOTAL_CARDS) {
			    System.out.println("Maximum number is 52.\n");				
			}
			else {
				break;
			}
		}
		
		// Place the cards into a list and print them
		for (int i = 0; i < cardToPick; i ++) {
			int card = mydeck.PickACard();
			cardHand.add(card);
			System.out.printf("%-10s [%s]\n", mydeck.GetName(card), mydeck.GetSuit(card));
		}
		
		System.out.printf("\n");
	}
}