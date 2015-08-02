package my.game;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import java.util.Random;

public class multi {
    
    //private JLabel label;
    private String play1;
    private String play2;
    
    
    public  multi( ) {
        
            //game g1 = new game();
            //label = g1.player1;
            //g1.setInfo("dds");
 
            String names[];

            
            
            String player1 = JOptionPane.showInputDialog("Enter Player 1 Name : ");
            String player2 = JOptionPane.showInputDialog("Enter Player 2 Name : ");
            
            
            
            
            String[] buttons = { "Heads", "Tails" };
            int select = JOptionPane.showOptionDialog(null, player1 +  "  calls the toss", "Toss",JOptionPane.WARNING_MESSAGE, 0, null, buttons, buttons[1]);
            //Tails = 1  Heads = 0
            
            Random rn = new Random();
            int answer = rn.nextInt(100) + 1;
            if(answer%2 == 0){
                JOptionPane.showMessageDialog(null, player1 + " will be starting with \" X \" ", player1 + " Wins ", JOptionPane.INFORMATION_MESSAGE);
                //label.setText("fw");
                //g1.player1.setText("f");
                play1 = player1;
                play2 = player2;
                
            
            
            
            }
            else {
                JOptionPane.showMessageDialog(null, player2 + " will be starting with \" X \" ", player2 + " Wins ", JOptionPane.INFORMATION_MESSAGE);
                //g1.player1.setText("fd");
                //g1.player2.setText(player1);
                play1 = player2;
                play2 = player1;
                
            }
            
            
            
  }
    
    public String[] getInf(){
            return new String[]{play1, play2};
    
    }
    
    
    
}
