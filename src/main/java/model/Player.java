/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.util.ArrayList;

/**
 *
 * @author Carlos
 */
public class Player {
    private String name;
    private Hand hand;
    
    public Player(String name) {
        this.name = name;
        this.hand = new Hand();
    }
    
    public Player(String name, ArrayList<Card> hand) {
        this.name = name;
        this.hand = new Hand(hand);
    }
    
    public String getName() {
        return name;
    }
    
    public Hand getHand() {
        return hand;
    }
    
    public void addCard(Card c) {
        hand.addCard(c);
    }
    
    public String toString(){
        return this.getName();
    }
}
