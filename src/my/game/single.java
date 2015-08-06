package my.game;

import javax.swing.JOptionPane;
import java.util.Random;


public class single {
    
    private String play1;
    private String play2;
    
    
            
    String[] buttons = { "Heads", "Tails" };

   // String[] players;
    
    
    public void begin(){
        String player = JOptionPane.showInputDialog("Enter Player Name : ");
        int select = JOptionPane.showOptionDialog(null, player +  "  calls the toss", "Toss",JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);
            
           
            Random rn = new Random();
            int answer = rn.nextInt(100) + 1;
            if(answer%2 == 0){
                JOptionPane.showMessageDialog(null, player + " will be starting with \" X \" ", player + " Wins ", JOptionPane.INFORMATION_MESSAGE);
                //label.setText("fw");
                //g1.player1.setText("f");
                
                play1 = player;
                play2 = "Computer"; 
            
            
            
            }
            else {
                JOptionPane.showMessageDialog(null," Computer will be starting with \" X \" ",  " Computer Wins ", JOptionPane.INFORMATION_MESSAGE);
                //g1.player1.setText("fd");
                //g1.player2.setText(player1);
                play1 = "Computer";
                play2 = player;    }
    
    }
    
    public String[] getInf(){
            return new String[]{play1, play2};
    
    }
    
}