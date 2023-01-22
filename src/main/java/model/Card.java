/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author Carlos
 */
public class Card {
    private String name;
    private int value;
    
    public Card(String name) {
        if (name == "J" || name == "Q" || name == "K") {
            this.name = name;
            value = 10;
        } else {
            if (name == "A") {
                this.name = name;
                value = 11;
            } else {
                this.name = name;
                value = Integer.parseInt(name);
            }
        }
    }
    
    public String getName() {
        return name;
    }
    
    public int getValue() {
        return value;
    }
}
