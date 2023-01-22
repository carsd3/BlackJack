package test;

import java.util.ArrayList;
import static org.junit.Assert.*;

import model.*;
public class Test {
    
    public Test() {
        given_one_card_should_calculate_value();
        given_two_cards_should_calculate_value();
        given_two_cards_should_determine_if_is_black_jack();
        given_three_cards_should_determine_that_is_not_black_jack();
        given_two_cards_should_determine_that_is_not_bust();
        given_three_cards_should_determine_that_is_bust_or_not();
        System.out.println("All tests passed succesfully!");
    }
    public void given_one_card_should_calculate_value() {
       assertEquals(5, new Hand(new ArrayList<Card>(){{add(new Card("5"));}}).getScore());
       assertEquals(6, new Hand(new ArrayList<Card>(){{add(new Card("6"));}}).getScore());
       assertEquals(10, new Hand(new ArrayList<Card>(){{add(new Card("J"));}}).getScore());
       assertEquals(10, new Hand(new ArrayList<Card>(){{add(new Card("Q"));}}).getScore());
       assertEquals(10, new Hand(new ArrayList<Card>(){{add(new Card("K"));}}).getScore());
       assertEquals(11, new Hand(new ArrayList<Card>(){{add(new Card("A"));}}).getScore());
    }
    
    public void given_two_cards_should_calculate_value() {
       assertEquals(11, new Hand(new ArrayList<Card>(){{add(new Card("5"));add(new Card("6"));}}).getScore());        
       assertEquals(12, new Hand(new ArrayList<Card>(){{add(new Card("A"));add(new Card("A"));}}).getScore());        
    }
    
    public void given_two_cards_should_determine_if_is_black_jack() {
       assertEquals(false, new Hand(new ArrayList<Card>(){{add(new Card("5"));add(new Card("6"));}}).isBlackJack());        
       assertEquals(true, new Hand(new ArrayList<Card>(){{add(new Card("A"));add(new Card("Q"));}}).isBlackJack());               
    }

    public void given_three_cards_should_determine_that_is_not_black_jack() {
       assertEquals(false, new Hand(new ArrayList<Card>(){{add(new Card("5"));add(new Card("6"));add(new Card("Q"));}}).isBlackJack());               
    }

    public void given_two_cards_should_determine_that_is_not_bust() {
       assertEquals(false, new Hand(new ArrayList<Card>(){{add(new Card("4"));add(new Card("3"));}}).isBust());               
    }

    public void given_three_cards_should_determine_that_is_bust_or_not() {
       assertEquals(true, new Hand(new ArrayList<Card>(){{add(new Card("4"));add(new Card("J"));add(new Card("K"));}}).isBust());               
       assertEquals(false, new Hand(new ArrayList<Card>(){{add(new Card("4"));add(new Card("3"));add(new Card("3"));}}).isBust());               
    }
}
