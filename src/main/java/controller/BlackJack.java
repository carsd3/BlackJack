/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package controller;
import java.util.ArrayList;
import java.util.List;
import model.*;
import test.*;
/**
 *
 * @author Carlos
 */
public class BlackJack {
    public static void main(String[] args) {
        new Test();
        
        List<Card> deck1 = new ArrayList<>(){{
            add(new Card("5"));
            add(new Card("4"));
            add(new Card("K"));
            add(new Card("2"));
        }};
        List<Card> deck2 = new ArrayList<>(){{
            add(new Card("A"));
            add(new Card("3"));
            add(new Card("K"));
            add(new Card("2"));
        }};
        
        Player p1 = new Player("Player1", 
                                    new ArrayList<>(){{
                                        add(new Card("J"));
                                        add(new Card("A"));
                                    }}
                              );
        Player p2 = new Player("Player2", 
                                    new ArrayList<>(){{
                                        add(new Card("10"));
                                        add(new Card("5"));
                                        add(new Card("6"));
                                    }}
                              );

        Player p3 = new Player("Player3", 
                                    new ArrayList<>(){{
                                        add(new Card("3"));
                                        add(new Card("6"));
                                        add(new Card("A"));
                                        add(new Card("3"));
                                        add(new Card("A"));
                                        add(new Card("K"));
                                    }}
                              );

        Player croupier = new Player("Croupier", 
                                    new ArrayList<>(){{
                                        add(new Card("9"));
                                        add(new Card("7"));
                                     }}
                              );
        
        ArrayList<Player> result = getWinners(p1, p2, p3, croupier, deck1);
        System.out.println(result);
        
       p1 = new Player("Player1", 
                                    new ArrayList<>(){{
                                        add(new Card("10"));
                                        add(new Card("K"));
                                    }}
                              );
        p2 = new Player("Player2", 
                                    new ArrayList<>(){{
                                        add(new Card("10"));
                                        add(new Card("2"));
                                        add(new Card("6"));
                                    }}
                              );

        p3 = new Player("Player3", 
                                    new ArrayList<>(){{
                                        add(new Card("8"));
                                        add(new Card("8"));
                                        add(new Card("5"));
                                    }}
                              );

        croupier = new Player("Croupier", 
                                    new ArrayList<>(){{
                                        add(new Card("5"));
                                        add(new Card("10"));
                                     }}
                              );
        
        result = getWinners(p1, p2, p3, croupier, deck2);
        System.out.println(result);
    }
    
    public static ArrayList<Player> getWinners(Player p1, Player p2, Player p3, Player croupier, List<Card> deck) {
        ArrayList<Player> result = new ArrayList<>();
        if (croupier.getHand().isBlackJack()) {
            result = new ArrayList<>(){{add(croupier);}};
            return result;
        }
        
        if (p1.getHand().isBlackJack()) {
            result.add(p1);
            return result;
        } else if (p1.getHand().getScore() > croupier.getHand().getScore() && !p1.getHand().isBust()) {
            result.add(p1);
        }
        
        if (p1.getHand().isBlackJack()) {
            result.add(p2);
            return result;
        } else if (p2.getHand().getScore() > croupier.getHand().getScore() && !p2.getHand().isBust()) {
            result.add(p2);
        }
        
        if (p3.getHand().isBlackJack()) {
            result.add(p3);
            return result;
        } else if (p3.getHand().getScore() > croupier.getHand().getScore() && !p3.getHand().isBust()) {
            result.add(p3);
        }
        
        if (result.isEmpty()) {
            result.add(croupier);
        }
        
        return result;
    }
}
