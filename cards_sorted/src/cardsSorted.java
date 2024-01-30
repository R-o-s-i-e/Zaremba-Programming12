//package mycards;

import static java.lang.System.out;
import java.lang.*;
import java.io.*;
import java.util.*;

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


class Card implements Comparable<Card> {

	private int id;

	public Card(int i) {
		this.id = i;
	}

	@Override
	public int compareTo(Card d) {
		return this.id - d.getId();
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Card{"+this.id+"}";
	}
}

class CardDeck {
	
	private ArrayList<Card> cards = new ArrayList<Card>();
	
    private final int TOTAL_CARD_SUITS = 4;	
    private final int TOTAL_CARD_NAMES = 13;
    public static final int TOTAL_CARDS = 52;	
	
	private CardSuit [] allSuits = new CardSuit[] {CardSuit.SPADES, CardSuit.HEARTS, CardSuit.CLUBS, CardSuit.DIAMONDS};
	
	private CardName [] allNames = new CardName[] {CardName.ACE, CardName.TWO, CardName.THREE, CardName.FOUR, CardName.FIVE, 
	                                               CardName.SIX, CardName.SEVEN, CardName.EIGHT, CardName.NINE, CardName.TEN, 
	                                               CardName.JACK, CardName.QUEEN, CardName.KING};	
	
	public CardDeck() {
		Restart();
	}
	
    public CardSuit GetSuit(Integer number) {
		return allSuits[number / TOTAL_CARD_NAMES];
	}

    public CardName GetName(Integer number) {
		return allNames[number % TOTAL_CARD_NAMES];
	}
	
	public void Restart() {
		
		cards.clear();
		
		for (int i = 0; i < TOTAL_CARDS; i++) {
			cards.add(new Card(i));
		}

        Collections.shuffle(cards);		
	}
	
	public Card PickACard() {
	    // Instance of random class
        Random rand = new Random();
        int total_card = cards.size();
        int cardIndex = rand.nextInt(total_card);
        Card cardPicked = cards.get(cardIndex);	
        cards.remove(cardIndex);	// Remove the card picked this time, so that we don't pick again.	
		return cardPicked;
	}
}


public class cardsSorted {
	
    public static void main(String[] args) {
		CardDeck mydeck = new CardDeck();
	    ArrayList<Card> cardHand = new ArrayList<Card>();		
		
		Scanner myObj = new Scanner(System.in);
		int cardToPick;
		
		// Allow user to input the number of cards to pick, validate the user input
		for (;;) {
			System.out.println("Input the number of cards to pick [0-52]: ");

			cardToPick = myObj.nextInt();
			
			if (cardToPick > CardDeck.TOTAL_CARDS) {
			    System.out.println("Maximum number is 52.\n");				
			}
			else {
				break;
			}
		}
		
		System.out.printf("\n Original: \n====================\n");	
		
		// Place the cards into a list and print them
		for (int i = 0; i < cardToPick; i ++) {
			Card card = mydeck.PickACard();
			cardHand.add(card);
			int id = card.getId();
			System.out.printf("%-10s [%s]\n", mydeck.GetName(id), mydeck.GetSuit(id));
		}
		
		System.out.printf("\n Sorted: \n===================\n");	
		Collections.sort(cardHand, (d1, d2) -> {
	        return d1.getId() - d2.getId();
        });
		
		for (int i = 0; i < cardToPick; i ++) {
			int id = cardHand.get(i).getId();
			System.out.printf("%-10s [%s]\n", mydeck.GetName(id), mydeck.GetSuit(id));
		}		
		
	}
}