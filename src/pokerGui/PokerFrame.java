
package pokerGui;

import java.awt.Graphics;
import java.awt.Image;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import principalClasses.EnglishDeck;
import principalClasses.GamblingCard;
import principalClasses.PokerPlayer;
import principalClasses.PokerPlays;


public class PokerFrame extends JFrame{
    private final String[] array = {"Clubs","Spades","Hearts","Diamonds"};
    private final PokerPlays  plays = new PokerPlays();
    private EnglishDeck deck = new EnglishDeck();
    private PokerPlayer player = new PokerPlayer(200, 5);
    private PokerPlayer computer = new PokerPlayer(200, 5);
    
    public PokerFrame() {
        initComponents();
        
        deck.removeCertainTypeOfCard(0, 0);
        deck.shuffle();
        
        player.fillHand(deck);
        computer.fillHand(deck);
        
        JpanelImage image = new JpanelImage(principalPanel, "Images\\TablePlay\\tablePlay.jpg");
        principalPanel.add(image).repaint();
        ImageIcon icon = new ImageIcon(new ImageIcon("Images\\BackCard\\BackCard.png").getImage().
                getScaledInstance(deckLabel.getWidth(), deckLabel.getHeight(), Image.SCALE_DEFAULT));
        deckLabel.setIcon(icon);
        
        cCard1.setIcon(icon);
        cCard2.setIcon(icon);
        cCard3.setIcon(icon);
        cCard4.setIcon(icon);
        cCard5.setIcon(icon);
       
        ArrayList<GamblingCard<Integer>> playerHand = new ArrayList<>();
        player.traverseHand((c)-> playerHand.add( c));
        
        tCard1.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[playerHand.get(0).getSuitOfCard()-1]+"\\"
        +playerHand.get(0).getRankOfCard().toString()+".png").getImage().getScaledInstance(tCard1.getWidth(), tCard1.getHeight(), 0)));
        tCard2.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[playerHand.get(1).getSuitOfCard()-1]+"\\"
        +playerHand.get(1).getRankOfCard().toString()+".png").getImage().getScaledInstance(tCard2.getWidth(), tCard2.getHeight(), 0)));
        tCard3.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[playerHand.get(2).getSuitOfCard()-1]+"\\"
        +playerHand.get(2).getRankOfCard().toString()+".png").getImage().getScaledInstance(tCard3.getWidth(), tCard3.getHeight(), 0)));
        tCard4.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[playerHand.get(3).getSuitOfCard()-1]+"\\"
        +playerHand.get(3).getRankOfCard().toString()+".png").getImage().getScaledInstance(tCard4.getWidth(), tCard4.getHeight(), 0)));
        tCard5.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[playerHand.get(4).getSuitOfCard()-1]+"\\"
        +playerHand.get(4).getRankOfCard().toString()+".png").getImage().getScaledInstance(tCard5.getWidth(), tCard5.getHeight(), 0)));        
    }
    
    
    
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jSeparator1 = new javax.swing.JSeparator();
        principalPanel = new javax.swing.JPanel();
        cCard2 = new javax.swing.JLabel();
        cCard1 = new javax.swing.JLabel();
        cCard5 = new javax.swing.JLabel();
        cCard4 = new javax.swing.JLabel();
        cCard3 = new javax.swing.JLabel();
        tCard3 = new javax.swing.JLabel();
        tCard2 = new javax.swing.JLabel();
        tCard1 = new javax.swing.JLabel();
        tCard5 = new javax.swing.JLabel();
        tCard4 = new javax.swing.JLabel();
        deckLabel = new javax.swing.JLabel();
        checkButton = new javax.swing.JButton();
        tHand = new javax.swing.JTextField();
        cHand = new javax.swing.JTextField();
        winner = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setName("frame"); // NOI18N
        setResizable(false);

        cCard2.setText("jLabel1");
        cCard2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cCard1.setText("jLabel1");
        cCard1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cCard5.setText("jLabel1");
        cCard5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cCard4.setText("jLabel1");
        cCard4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        cCard3.setText("jLabel1");
        cCard3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tCard3.setText("jLabel1");
        tCard3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tCard2.setText("jLabel1");
        tCard2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tCard1.setText("jLabel1");
        tCard1.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tCard5.setText("jLabel1");
        tCard5.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        tCard4.setText("jLabel1");
        tCard4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));

        deckLabel.setText("jLabel1");
        deckLabel.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        deckLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                deckLabelMouseClicked(evt);
            }
        });

        checkButton.setText("Check");
        checkButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                checkButtonMouseClicked(evt);
            }
        });

        javax.swing.GroupLayout principalPanelLayout = new javax.swing.GroupLayout(principalPanel);
        principalPanel.setLayout(principalPanelLayout);
        principalPanelLayout.setHorizontalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalPanelLayout.createSequentialGroup()
                .addContainerGap(70, Short.MAX_VALUE)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addComponent(tCard1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(principalPanelLayout.createSequentialGroup()
                                .addComponent(tCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tCard3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(tCard4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(tHand))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(tCard5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addComponent(cCard1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(principalPanelLayout.createSequentialGroup()
                                .addComponent(cCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cCard3, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(cCard4, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(cHand))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cCard5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, principalPanelLayout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(checkButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(winner, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(deckLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        principalPanelLayout.setVerticalGroup(
            principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(principalPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cCard1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCard3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCard4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cCard5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addGap(27, 27, 27)
                        .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(deckLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(checkButton)))
                    .addGroup(principalPanelLayout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(cHand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(winner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(tHand, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                .addGroup(principalPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(tCard1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCard2, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCard3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCard4, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(tCard5, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(principalPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void checkButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_checkButtonMouseClicked
         String plays[] = {"High Card","Simple Pair","Double Pair","Three of a Kind","Straight","Flush","Full House",
         "Poker","Straight Flush"};
         
         
         ArrayList<GamblingCard<Integer>> playerHand = new ArrayList<>();
         ArrayList<GamblingCard<Integer>> computerHand = new ArrayList<>();
        
         
         player.traverseHand((c)->{ playerHand.add(c);});
         computer.traverseHand((c)->{ computerHand.add(c);});
         
        cCard1.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[computerHand.get(0).getSuitOfCard()-1]+"\\"
        +computerHand.get(0).getRankOfCard().toString()+".png").getImage().getScaledInstance(cCard1.getWidth(), cCard1.getHeight(), 0)));
        cCard2.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[computerHand.get(1).getSuitOfCard()-1]+"\\"
        +computerHand.get(1).getRankOfCard().toString()+".png").getImage().getScaledInstance(cCard2.getWidth(), cCard2.getHeight(), 0)));
        cCard3.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[computerHand.get(2).getSuitOfCard()-1]+"\\"
        +computerHand.get(2).getRankOfCard().toString()+".png").getImage().getScaledInstance(cCard3.getWidth(), cCard3.getHeight(), 0)));
        cCard4.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[computerHand.get(3).getSuitOfCard()-1]+"\\"
        +computerHand.get(3).getRankOfCard().toString()+".png").getImage().getScaledInstance(cCard4.getWidth(), cCard4.getHeight(), 0)));
        cCard5.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[computerHand.get(4).getSuitOfCard()-1]+"\\"+computerHand.get(4).getRankOfCard().toString()+".png").getImage().getScaledInstance(cCard5.getWidth(), cCard5.getHeight(), 0)));   
         

         Integer playerPlay = this.plays.getPokerPlay(playerHand);
         Integer computerPlay = this.plays.getPokerPlay(computerHand);
         
         cHand.setText(plays[computerPlay]);
         tHand.setText(plays[playerPlay]);
         
         Integer cmp = this.plays.comparePlays(playerHand, computerHand);
         
         if(cmp>0){
             winner.setText("Player One Wins");
         }
         else if(cmp<0){
             winner.setText("Computer Wins");
         }
         else winner.setText("Draw");

    }//GEN-LAST:event_checkButtonMouseClicked

    private void deckLabelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_deckLabelMouseClicked
        
        for(int i=1;i<=5;i++){
            computer.removeCardOfHand(1);
            player.removeCardOfHand(1);
        }
        
        deck.restoreRemovedCardsWithTheExceptionOf(0, 0);
        deck.shuffle();
       
        computer.fillHand(deck);
        player.fillHand(deck);
        
        ImageIcon icon = new ImageIcon(new ImageIcon("Images\\BackCard\\BackCard.png").getImage().
                getScaledInstance(deckLabel.getWidth(), deckLabel.getHeight(), Image.SCALE_DEFAULT));
        deckLabel.setIcon(icon);
        
        cCard1.setIcon(icon);
        cCard2.setIcon(icon);
        cCard3.setIcon(icon);
        cCard4.setIcon(icon);
        cCard5.setIcon(icon);
        
        ArrayList<GamblingCard<Integer>> playerHand = new ArrayList<>();
        player.traverseHand((c)-> playerHand.add( c));
        
        tCard1.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[playerHand.get(0).getSuitOfCard()-1]+"\\"
        +playerHand.get(0).getRankOfCard().toString()+".png").getImage().getScaledInstance(tCard1.getWidth(), tCard1.getHeight(), 0)));
        tCard2.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[playerHand.get(1).getSuitOfCard()-1]+"\\"
        +playerHand.get(1).getRankOfCard().toString()+".png").getImage().getScaledInstance(tCard2.getWidth(), tCard2.getHeight(), 0)));
        tCard3.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[playerHand.get(2).getSuitOfCard()-1]+"\\"
        +playerHand.get(2).getRankOfCard().toString()+".png").getImage().getScaledInstance(tCard3.getWidth(), tCard3.getHeight(), 0)));
        tCard4.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[playerHand.get(3).getSuitOfCard()-1]+"\\"
        +playerHand.get(3).getRankOfCard().toString()+".png").getImage().getScaledInstance(tCard4.getWidth(), tCard4.getHeight(), 0)));
        tCard5.setIcon(new ImageIcon(new ImageIcon("Images\\"+array[playerHand.get(4).getSuitOfCard()-1]+"\\"
        +playerHand.get(4).getRankOfCard().toString()+".png").getImage().getScaledInstance(tCard5.getWidth(), tCard5.getHeight(), 0)));     
        
        cHand.setText(" ");
        tHand.setText(" ");
        winner.setText(" ");
    }//GEN-LAST:event_deckLabelMouseClicked
    
     
    private class JpanelImage extends JLabel{
       private int widthP;
       private int heightP;
       private String path;

        public JpanelImage(JPanel panel,String path){
            this.widthP = panel.getWidth();
            this.heightP = panel.getHeight();
            this.path = path;
            this.setSize(widthP,heightP);
        }
       
       @Override
        public void paint(Graphics g){
            ImageIcon icon = new ImageIcon(new ImageIcon(path).getImage().
                    getScaledInstance(widthP, heightP, 0));
            g.drawImage(icon.getImage(), 0, 0, null);
        }
       
    }
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel cCard1;
    private javax.swing.JLabel cCard2;
    private javax.swing.JLabel cCard3;
    private javax.swing.JLabel cCard4;
    private javax.swing.JLabel cCard5;
    private javax.swing.JTextField cHand;
    private javax.swing.JButton checkButton;
    private javax.swing.JLabel deckLabel;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel principalPanel;
    private javax.swing.JLabel tCard1;
    private javax.swing.JLabel tCard2;
    private javax.swing.JLabel tCard3;
    private javax.swing.JLabel tCard4;
    private javax.swing.JLabel tCard5;
    private javax.swing.JTextField tHand;
    private javax.swing.JTextField winner;
    // End of variables declaration//GEN-END:variables
}
