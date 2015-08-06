package my.game;

import javax.swing.*;
import java.awt.* ;
import java.awt.event.* ;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chath_000
 */
public class game extends javax.swing.JFrame {
    public JButton[] btns; 
    /**
     * Creates new form game
     */
    single program1 = new single();
    multi program2 = new multi();
    Client c1 = new Client();
    Server s1 = new Server();
    String btnn;
    public game() {
        
        
        initComponents();
        
    }
    
    public int setInfo( String[] str){
        player1.setText(str[0]);
        player2.setText(str[1]);
        
        return 0;
    } 
    
    public void playMulti(){
        int count = 0;
        while(count < 1){
        
        btn2.addActionListener((ActionEvent arg0) -> {
            btn2.setText("X");
            btn2.setEnabled(false);
        });
        
        count++;
        
        
        }
    }
      
    public int winner(){
       String one = btn1.getText();
       String two = btn2.getText();
       String three = btn3.getText();
       String four = btn4.getText();
       String five = btn5.getText();
       String six = btn6.getText();
       String seven = btn7.getText();
       String eight = btn8.getText();
       String nine = btn9.getText();
       
       
       /*
       if((one=="X")&(two=="X")&(three=="X")){
           info.setText(player1.getText() +  " WINS!!!");
           disablegame();  }
       else if((one=="O")&(two=="O")&(three=="O")){
           info.setText(player2.getText() +  " WINS!!!");
           disablegame();  }
       else if((four=="X")&(five=="X")&(six=="X")){info.setText(player1.getText() +  " WINS!!!");}
       else if((four=="O")&(five=="O")&(six=="O")){info.setText(player2.getText() +  " WINS!!!");}
       else if((seven=="X")&(eight=="X")&(nine=="X")){info.setText(player1.getText() +  " WINS!!!");}
       else if((seven=="O")&(eight=="O")&(nine=="O")){info.setText(player2.getText() +  " WINS!!!");}
       else if (count ==9){ info.setText("DRAWN!!!"); }
      */
       
       String[][] win = new String[][]{
            { one, two, three },
            { four, five, six },
            { seven, eight, nine},
            { one, four, seven },
            { two, five, eight },
            { three, six, nine },
            { one, five, nine },
            { three, five, seven}
        };
       
       int winner = 0;
       
       for(int i=0; i<8 ; i++){
            if(("X".equals(win[i][0]))&("X".equals(win[i][1]))&("X".equals(win[i][2]))){ 
               info.setText(player1.getText() +  " WINS!!!");
               disablegame();
               player13.setText("" + (Integer.parseInt(player13.getText().trim()) + 1));
               winner = 1;
               break;}
            else if(("O".equals(win[i][0]))&("O".equals(win[i][1]))&("O".equals(win[i][2]))){ 
               info.setText(player2.getText() +  " WINS!!!");
               disablegame();
               player23.setText("" + (Integer.parseInt(player23.getText().trim()) + 1));
               winner = 1;
               break;}
            else if(count ==9){
               info.setText(" DRAWN!!!");
               disablegame();
               winner = 1;
            }
       }
       
       return winner;
       
       
       
       
    
    }
    
    public void autoplay(int x, String mark){
        
        if(x==1){ btn1.setText(mark);
                  btn1.setEnabled(false);}
        if(x==2){ btn2.setText(mark);
                  btn2.setEnabled(false);}
        if(x==3){ btn3.setText(mark);
                  btn3.setEnabled(false);}
        if(x==4){ btn4.setText(mark);
                  btn4.setEnabled(false);}
        if(x==5){ btn5.setText(mark);
                  btn5.setEnabled(false);}
        if(x==6){ btn6.setText(mark);
                  btn6.setEnabled(false);}
        if(x==7){ btn7.setText(mark);
                  btn7.setEnabled(false);}
        if(x==8){ btn8.setText(mark);
                  btn8.setEnabled(false);}
        if(x==9){ btn9.setText(mark);
                  btn9.setEnabled(false);}
        
        winner();
    }
    
    public int compute(String mark){
        int[][] board = new int[][]{
            {0,0,0},
            {0,0,0},
            {0,0,0}
        };
        if(btn1.getText() == mark){ board[0][0] = 1;}
        else if (btn1.getText() != "" ){board[0][0] = 2;} 
        if(btn2.getText() == mark){ board[0][1] = 1;}
        else if (btn2.getText() != "" ){board[0][1] = 2;}
        if(btn3.getText() == mark){ board[0][2] = 1;}
        else if (btn3.getText() != "" ){board[0][2] = 2;}
        if(btn4.getText() == mark){ board[1][0] = 1;}
        else if (btn4.getText() != "" ){board[1][0] = 2;}
        if(btn5.getText() == mark){ board[1][1] = 1;}
        else if (btn5.getText() != "" ){board[1][1] = 2;}
        if(btn6.getText() == mark){ board[1][2] = 1;}
        else if (btn6.getText() != "" ){board[1][2] = 2;}
        if(btn7.getText() == mark){ board[2][0] = 1;}
        else if (btn7.getText() != "" ){board[2][0] = 2;}
        if(btn8.getText() == mark){ board[2][1] = 1;}
        else if (btn8.getText() != "" ){board[2][1] = 2;}
        if(btn9.getText() == mark){ board[2][2] = 1;}
        else if (btn9.getText() != "" ){board[2][2] = 2;}
        
        
        for(int i=0; i<3 ; i++){
            for( int j=0 ; j<3 ; j++){
                System.out.print(board[i][j] + "  ");
            }
            System.out.println(""); 
        }
        
        MinMax n = new MinMax();
        
        int x = n.MinMax(board);
        System.out.println(x);
        return x;
    }
    

    public int count = 0;
    public int single = 0;
     
     
     public String mark(){
         // changed int button part to void 
         if(count%2==0){ 
             count++;
             player1.setBackground(new Color(255,255,0));
             player2.setBackground(new Color(0,255,255));
             return "X";}
         else { 
             count++;
             player2.setBackground(new Color(255,255,0));
             player1.setBackground(new Color(0,255,255));
             return "O"; }
 
        /* 
        btn2.addActionListener((ActionEvent arg0) -> {
            //btn2.setText(s);
            btn2.setEnabled(false);
            info.setText("2");
            
            
            
        });
        btn1.addActionListener((ActionEvent arg0) -> {
            //btn1.setText(s);
            btn1.setEnabled(false);
            info.setText("1");
        });
        */
      
         
    }
    
     
     
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        PlayerGroup = new javax.swing.ButtonGroup();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        gamePanel = new javax.swing.JPanel();
        btn4 = new javax.swing.JButton();
        btn1 = new javax.swing.JButton();
        btn7 = new javax.swing.JButton();
        btn5 = new javax.swing.JButton();
        btn3 = new javax.swing.JButton();
        btn2 = new javax.swing.JButton();
        btn8 = new javax.swing.JButton();
        btn6 = new javax.swing.JButton();
        btn9 = new javax.swing.JButton();
        info = new javax.swing.JLabel();
        btnStart = new javax.swing.JButton();
        PlayersPanel = new javax.swing.JPanel();
        btnSingle = new javax.swing.JRadioButton();
        btnMulti = new javax.swing.JRadioButton();
        javax.swing.JPanel Scorecard = new javax.swing.JPanel();
        player2 = new javax.swing.JLabel();
        player22 = new javax.swing.JLabel();
        player1 = new javax.swing.JLabel();
        player12 = new javax.swing.JLabel();
        player13 = new javax.swing.JLabel();
        player23 = new javax.swing.JLabel();
        btnTry = new javax.swing.JButton();
        btnReset = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();

        jLabel2.setFont(new java.awt.Font("Tempus Sans ITC", 0, 48)); // NOI18N
        jLabel2.setText("Tic");

        jLabel3.setFont(new java.awt.Font("Tempus Sans ITC", 0, 48)); // NOI18N
        jLabel3.setText("Tic");

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        gamePanel.setBorder(javax.swing.BorderFactory.createTitledBorder(""));

        btn4.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn4.setEnabled(false);
        btn4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn4ActionPerformed(evt);
            }
        });

        btn1.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn1.setEnabled(false);
        btn1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn1ActionPerformed(evt);
            }
        });

        btn7.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn7.setEnabled(false);
        btn7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn7ActionPerformed(evt);
            }
        });

        btn5.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn5.setEnabled(false);
        btn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn5ActionPerformed(evt);
            }
        });

        btn3.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn3.setEnabled(false);
        btn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn3ActionPerformed(evt);
            }
        });

        btn2.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn2.setEnabled(false);
        btn2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn2ActionPerformed(evt);
            }
        });

        btn8.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn8.setEnabled(false);
        btn8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn8ActionPerformed(evt);
            }
        });

        btn6.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn6.setEnabled(false);
        btn6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn6ActionPerformed(evt);
            }
        });

        btn9.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        btn9.setEnabled(false);
        btn9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn9ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout gamePanelLayout = new javax.swing.GroupLayout(gamePanel);
        gamePanel.setLayout(gamePanelLayout);
        gamePanelLayout.setHorizontalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(gamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(btn1, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn2, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(gamePanelLayout.createSequentialGroup()
                        .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 104, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(15, Short.MAX_VALUE))
        );
        gamePanelLayout.setVerticalGroup(
            gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, gamePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn5, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn6, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(gamePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn7, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn8, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btn9, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(17, Short.MAX_VALUE))
        );

        info.setFont(new java.awt.Font("Tahoma", 0, 36)); // NOI18N
        info.setText("START");
        info.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                textchange(evt);
            }
        });

        btnStart.setFont(new java.awt.Font("Simplified Arabic Fixed", 0, 24)); // NOI18N
        btnStart.setText("Start");
        btnStart.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnStartActionPerformed(evt);
            }
        });

        PlayersPanel.setBackground(new java.awt.Color(255, 255, 102));

        btnSingle.setBackground(new java.awt.Color(255, 102, 0));
        PlayerGroup.add(btnSingle);
        btnSingle.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnSingle.setText("Single-Player");

        btnMulti.setBackground(new java.awt.Color(255, 102, 0));
        PlayerGroup.add(btnMulti);
        btnMulti.setFont(new java.awt.Font("DialogInput", 0, 14)); // NOI18N
        btnMulti.setText("Multi-Players");
        btnMulti.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMultiActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout PlayersPanelLayout = new javax.swing.GroupLayout(PlayersPanel);
        PlayersPanel.setLayout(PlayersPanelLayout);
        PlayersPanelLayout.setHorizontalGroup(
            PlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(PlayersPanelLayout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(PlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnSingle, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                    .addComponent(btnMulti, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        PlayersPanelLayout.setVerticalGroup(
            PlayersPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, PlayersPanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMulti, javax.swing.GroupLayout.PREFERRED_SIZE, 41, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnSingle, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        Scorecard.setBackground(new java.awt.Color(255, 255, 0));
        Scorecard.setBorder(javax.swing.BorderFactory.createTitledBorder("Scorecard"));

        player2.setBackground(new java.awt.Color(255, 255, 0));
        player2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        player2.setText("Player2");
        player2.setToolTipText("");
        player2.setOpaque(true);

        player22.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        player22.setText("O");
        player22.setToolTipText("");

        player1.setBackground(new java.awt.Color(255, 255, 0));
        player1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        player1.setText("Player1");
        player1.setOpaque(true);

        player12.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        player12.setText("X");

        player13.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        player13.setText("0");

        player23.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        player23.setText("0");

        javax.swing.GroupLayout ScorecardLayout = new javax.swing.GroupLayout(Scorecard);
        Scorecard.setLayout(ScorecardLayout);
        ScorecardLayout.setHorizontalGroup(
            ScorecardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ScorecardLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(ScorecardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ScorecardLayout.createSequentialGroup()
                        .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(player22, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(player23, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(ScorecardLayout.createSequentialGroup()
                        .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(player12, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(player13, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(26, Short.MAX_VALUE))
        );
        ScorecardLayout.setVerticalGroup(
            ScorecardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, ScorecardLayout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(ScorecardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player12, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player13, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(ScorecardLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(player2, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player22, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(player23, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );

        btnTry.setText("Try Again");
        btnTry.setEnabled(false);
        btnTry.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTryActionPerformed(evt);
            }
        });

        btnReset.setText("Reset");
        btnReset.setEnabled(false);
        btnReset.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnResetActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tempus Sans ITC", 0, 48)); // NOI18N
        jLabel1.setText("Toe");

        jLabel5.setFont(new java.awt.Font("Tempus Sans ITC", 0, 48)); // NOI18N
        jLabel5.setText("Tic");

        jLabel6.setFont(new java.awt.Font("Tempus Sans ITC", 0, 48)); // NOI18N
        jLabel6.setText("Tac");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(PlayersPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnStart, javax.swing.GroupLayout.PREFERRED_SIZE, 109, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(Scorecard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(42, 42, 42)
                                .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addComponent(info, javax.swing.GroupLayout.PREFERRED_SIZE, 386, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(27, 27, 27)
                                .addComponent(btnTry, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(PlayersPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(btnStart, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(info)
                        .addGap(18, 18, 18))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Scorecard, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(43, 43, 43)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(271, 271, 271))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(227, 227, 227))))
                        .addGroup(layout.createSequentialGroup()
                            .addComponent(gamePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addContainerGap()))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(52, 52, 52)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnTry, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnReset, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(11, 11, 11))))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn3ActionPerformed
        btn3Press();
        btnInside("three");
        
    }//GEN-LAST:event_btn3ActionPerformed

    private void btnStartActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnStartActionPerformed
        
        if(btnSingle.isSelected() == true ){single =1;}
        startgame();
        
             
        if(single ==1){
            program1.begin();
            String[] names = program1.getInf();
            setInfo(names); 
            if(player1.getText()=="Computer"){
                    String tem = mark();
                    autoplay(compute(tem),tem);
            }
        } 
        else if(single ==0 ){
            program2.begin();
            String[] names = program2.getInf();
            setInfo(names); 
            player1.setBackground(new Color(0,255,255));
        }
        
       
  
    }//GEN-LAST:event_btnStartActionPerformed

    private void btn8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn8ActionPerformed
        btn8Press();
        btnInside("eight");
    }//GEN-LAST:event_btn8ActionPerformed

    private void textchange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_textchange
        // TODO add your handling code here:
        //System.out.println("sfs");
    }//GEN-LAST:event_textchange

    private void btn9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn9ActionPerformed
        btn9Press();
        btnInside("nine");
    }//GEN-LAST:event_btn9ActionPerformed

    private void btn7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn7ActionPerformed
        btn7Press();
        btnInside("seven");
    }//GEN-LAST:event_btn7ActionPerformed

    private void btn6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn6ActionPerformed
        btn6Press();
        btnInside("six");
    }//GEN-LAST:event_btn6ActionPerformed

    private void btn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn5ActionPerformed
        btn5Press();
        btnInside("five");
    }//GEN-LAST:event_btn5ActionPerformed

    private void btn4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn4ActionPerformed
        btn4Press();
        btnInside("four");
    }//GEN-LAST:event_btn4ActionPerformed

    private void btn2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn2ActionPerformed
        btn2Press();
        btnInside("two");
    }//GEN-LAST:event_btn2ActionPerformed

    private void btn1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn1ActionPerformed
        btn1Press();
        btnInside("one");
    }//GEN-LAST:event_btn1ActionPerformed
    
    public void btn1Press(){
        btn1.setEnabled(false);
        btn1.setText(mark());
    }
    public void btn2Press(){
        btn2.setEnabled(false);
        btn2.setText(mark());
    }
    
    public void btn3Press(){
        btn3.setEnabled(false);
        btn3.setText(mark());
    }
    public void btn4Press(){
        btn4.setEnabled(false);
        btn4.setText(mark());
    }
    public void btn5Press(){
        btn5.setEnabled(false);
        btn5.setText(mark());
    }
    public void btn6Press(){
        btn6.setEnabled(false);
        btn6.setText(mark());
    }
    public void btn7Press(){
        btn7.setEnabled(false);
        btn7.setText(mark());
    }
    public void btn8Press(){
        btn8.setEnabled(false);
        btn8.setText(mark());
    }
    
    public void btn9Press(){
        btn9.setEnabled(false);
        btn9.setText(mark());
    }
    
    public void btnInside(String btn){
        
        int w = winner();
        System.out.println(w + "," + single);
        if((single==1)){  
            String tem = mark();
            autoplay(compute(tem),tem);
            
        }
        else{
        // multyplayer 
            //String vf = Integer.toString(btn);
            if (program2.getResult() == 1){
                try {
                //client
                    String ans = c1.start(btn);
                    condi(ans);
                } catch (IOException ex) {
                    Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
            else {
                //host
                try {
                    String ans = s1.start(btn);
                    condi(ans);
                } catch (IOException ex) {
                    Logger.getLogger(game.class.getName()).log(Level.SEVERE, null, ex);
                }
            
            }
        
        }
        // TODO add your handling code here:
    }
    
    public void condi(String ans){
        if(null != ans)switch (ans) {
            case "one":
                btn1Press();
                break;
            case "two":
                btn2Press();
                break;
            case "three":
                btn3Press();
                break;
            case "four":
                btn4Press();
                break;
            case "five":
                btn5Press();
                break;
            case "six":
                btn6Press();
                break;
            case "seven":
                btn7Press();
                break;
            case "eight":
                btn8Press();
                break;
            case "nine":
                btn9Press();
                break;
        }
    
    }
    private void btnResetActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnResetActionPerformed
            
        count = 0;
        single = 0;
        
        Component[] components = gamePanel.getComponents();
            for (Component component : components) {
                    JButton btn = (JButton) component;
                    btn.setText("");
                    component.setEnabled(false); }
        btnTry.setEnabled(true);
        btnReset.setEnabled(true);
        player1.setText("");
        player2.setText("");
        player13.setText("");
        player23.setText("");
        info.setText("Start");
        
        
        btnMulti.setEnabled(true);
        btnSingle.setEnabled(true);
        btnStart.setEnabled(true);
            
            
            
    }//GEN-LAST:event_btnResetActionPerformed

    private void btnTryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTryActionPerformed
            Component[] components = gamePanel.getComponents();
            for (Component component : components) {
                    component.setEnabled(true);
                    JButton btn = (JButton) component;
                    btn.setText("");
                    }
            btnTry.setEnabled(false);
            btnReset.setEnabled(false);   
            
            String tempName = player2.getText();
            String tempWins = player23.getText();
            
            player2.setText(player1.getText());
            player23.setText(player13.getText());
            
            player1.setText(tempName);
            player13.setText(tempWins);
            
            count =0;
            
            if("Computer".equals(player1.getText())){
                    String tem = mark();
                    autoplay(compute(tem),tem);
                    System.out.println(count);
            }
            
            
        // TODO add your handling code here:
    }//GEN-LAST:event_btnTryActionPerformed

    private void btnMultiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMultiActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnMultiActionPerformed

    private void disablegame(){
            Component[] components = gamePanel.getComponents();
            for (Component component : components) {
                    component.setEnabled(false); }
            btnTry.setEnabled(true);
            btnReset.setEnabled(true);   
    }
    
    private void startgame(){
            
            btnMulti.setEnabled(false);
            btnSingle.setEnabled(false);
            btnStart.setEnabled(false);

            Component[] components = gamePanel.getComponents();
            for (Component component : components) {
                    component.setEnabled(true); } 
    }
    
    
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(game.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new game().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup PlayerGroup;
    private javax.swing.JPanel PlayersPanel;
    private javax.swing.JButton btn1;
    private javax.swing.JButton btn2;
    private javax.swing.JButton btn3;
    private javax.swing.JButton btn4;
    private javax.swing.JButton btn5;
    private javax.swing.JButton btn6;
    private javax.swing.JButton btn7;
    private javax.swing.JButton btn8;
    private javax.swing.JButton btn9;
    private javax.swing.JRadioButton btnMulti;
    private javax.swing.JButton btnReset;
    private javax.swing.JRadioButton btnSingle;
    private javax.swing.JButton btnStart;
    private javax.swing.JButton btnTry;
    private javax.swing.JPanel gamePanel;
    private javax.swing.JLabel info;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JLabel player1;
    private javax.swing.JLabel player12;
    private javax.swing.JLabel player13;
    public javax.swing.JLabel player2;
    private javax.swing.JLabel player22;
    private javax.swing.JLabel player23;
    // End of variables declaration//GEN-END:variables
}
