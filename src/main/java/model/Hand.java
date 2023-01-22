/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Carlos
 */
public class Hand {
    private List<Card> list;
    private int score;
    
    public Hand() {
        list = new ArrayList<>();
        score = 0;
    }
    
    public Hand(ArrayList<Card> hand) {
        this.setHand(hand);
    }
    
    public void setHand(ArrayList<Card> hand) {
        score = 0;
        list = new ArrayList<>();
        for (Card c : hand) {
            this.addCard(c);
        }
    }
    
    public void addCard(Card card) {
        if (card.getName() == "A" && score + card.getValue() > 21){
            list.add(card);
            score += 1;
        } else {
            list.add(card);
            if (score + card.getValue() > 21) {    
                for(Card c : list) {
                    if (c.getName() == "A") {
                        score -= 10;
                        break;
                    }
                }
            }
            score += card.getValue();
        }
    }
    
    public List<Card> getHand() {
        return this.list;
    }
    
    public int getScore() {
        return score;
    }
    
    public boolean isBlackJack() {
        if (score == 21 && list.size() == 2) {
            int face = 0;
            int ace = 0;
            for(Card c : list) {
                if (c.getName() == "J" | c.getName() == "Q" | c.getName() == "K") {
                    face += 1;
                }
                if (c.getName() == "A"){
                    ace += 1;
                }
            }
            if (face == ace) {
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    
    public boolean isBust() {
        return score > 21 ? true : false;
    }
}
