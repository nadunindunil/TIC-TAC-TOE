package my.game;


public class MinMax {
    
    public int MinMax(int[][] board){
        
        MinMax x = new MinMax();
        //System.out.println("MOVE IS  " + x.next(board));
        return x.next(board);
    }
    
        // 1 for me  2 for opponent and 0 for not played squares...
    
    int depth = 0;
    int[][] a = new int[][]{
            {-20000,-20000,-20000},
            {-20000,-20000,-20000},
            {-20000,-20000,-20000}
        };
    int loc1,loc2;
    
    public int next(int[][] x){

        //depth = 0 ::: me playing ::: enter 1 into 0
        if (depth%2==0){  
            for(int i=0 ; i<3 ; i++){
                for(int j=0 ; j<3 ; j++){
                    if(x[i][j] == 0){
                        if(depth == 0){ a[i][j] = 0 ;
                                        loc1 = i;
                                        loc2 = j;}
                        x[i][j] = 1;
                        //System.out.println(depth + " Winning rates : " + winners(x) );
                        a[loc1][loc2] += winners(x);
                        //print(x);
                             
                        if(winners(x) == 0){
                                depth++;
                                next(x);
                                depth--;
                        }
                        x[i][j] = 0;
                    }  }  }  }
        else {
             for(int i=0 ; i<3 ; i++){
                for(int j=0 ; j<3 ; j++){
                    if(x[i][j] == 0){
                        x[i][j] = 2;
                        //System.out.println(depth + " Opponent Turn : "+  winners(x));
                        a[loc1][loc2] += winners(x);
                        //print(x);
                        if(winners(x) == 0){
                                depth++;
                                next(x);
                                depth--;
                        }
                        
                        
                        x[i][j] = 0;
                    }  }  }  }
        
        return move(a);
    }
    
    
    public int winners(int[][] x){
        
        int[][] win = new int[][]{
            {x[0][0],x[0][1],x[0][2]},
            {x[1][0],x[1][1],x[1][2]},
            {x[2][0],x[2][1],x[2][2]},
            
            {x[0][0],x[1][0],x[2][0]},
            {x[0][1],x[1][1],x[2][1]},
            {x[0][2],x[1][2],x[2][2]},
            {x[0][0],x[1][1],x[2][2]},
            {x[0][2],x[1][1],x[2][0]}
        };
        
        
        for(int i=0 ; i<8 ; i++){
            //System.out.println(win[i][0] + " " + win[i][1] + "  " + win[i][2]);
            if((win[i][0] == 1) &  (win[i][1] == 1) & (win[i][2] == 1)){ return 10;}
            if((win[i][0] == 2) &  (win[i][1] == 2) & (win[i][2] == 2)){ return -10;}        
        }
        
        return 0;
    }
    
    public void print(int[][] x){
        
        for(int i=0; i<3 ; i++){
            for( int j=0 ; j<3 ; j++){
                System.out.print(x[i][j] + "  ");
            }
            System.out.println(""); 
        }
    
    
    }
    
    
    public int move(int[][] x){
        
        int count = 1;
        int move = 1;
        int value = -20000;
        
        for(int i=0; i<3 ; i++){
            for( int j=0 ; j<3 ; j++){
                if(x[i][j] > value){ value = x[i][j]; 
                                     move = count;}
                count++;
            }
        }
        
        //print(a);
        return move;
    }
      
}
