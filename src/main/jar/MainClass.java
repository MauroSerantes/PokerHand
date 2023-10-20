/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package main.jar;

import java.util.ArrayList;
import javax.swing.JFrame;
import pokerGui.PokerFrame;
import principalClasses.EnglishDeck;
import principalClasses.GamblingCard;
import principalClasses.PokerPlayer;
import principalClasses.PokerPlays;


public class MainClass{
    
    public static void main(String[] args) {
        
        PokerFrame frame = new PokerFrame();
        
        frame.setVisible(true);
        frame.setLocationRelativeTo(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.setSize(412,330);
        
        
        /*String[] array = {"Clubs","Spades","Hearts","Diamonds"};
        String[] pla = {"highCard","simplePair","doublePair","threeOfAKind","straight","flush","fullHouse","poker","straightFlush"};
         
        ArrayList<GamblingCard<Integer>> hand1 = new ArrayList<>();
        ArrayList<GamblingCard<Integer>> hand2 = new ArrayList<>();
        
        PokerPlays plays = new PokerPlays();
        
        PokerPlayer player1 = new PokerPlayer(200, 5);
        PokerPlayer player2 = new PokerPlayer(200, 5);
        
        EnglishDeck deck = new EnglishDeck();
        
        deck.removeCertainTypeOfCard(0,0);
        deck.shuffle();
        
        player1.fillHand(deck);
        player2.fillHand(deck);
        
        
        System.out.println("Player one hand: ");
        player1.traverseHand((c)-> System.out.println(c.getRankOfCard().toString()+" of "+array[c.getSuitOfCard()-1]));
        player1.traverseHand((c)-> hand1.add(c));
        System.out.println();
        System.out.println();
        System.out.println("Player two hand: ");
        player2.traverseHand((c)->System.out.println(c.getRankOfCard().toString()+" of "+array[c.getSuitOfCard()-1]));
        player2.traverseHand((c)->hand2.add(c));
       
        
        System.out.println();
        System.out.println();
        
        System.out.println("Player One has: " + pla[plays.getPokerPlay(hand1)]);
        System.out.println("Player Two has: " + pla[plays.getPokerPlay(hand2)]);*/
        
    }
}
