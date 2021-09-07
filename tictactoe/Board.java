package marks.tictactoe;

public class Board {

    public static final char[][] STARTING_BOARD = { 
    	{ ' ', ' ', ' ' },
        { ' ', ' ', ' ' },
        { ' ', ' ', ' ' }
    };
    
    public char[][] b;

    public Board(char[][] board) {
    	this.b = board;
    }
    
    public Board(Board board) {
    	b = new char[3][3];
    	for (int i = 0; i < 3; i++)
    		for (int j = 0; j < 3; j++)
    			b[i][j] = board.b[i][j];
    }
    
    /**
     * @author Mark Sturtevant
     */
    public void doBestMove() {
    	int id = -1, best = -1001;
    	for (int i = 0; i < 9; i++) {
    		Board newBoard = new Board(this);
			int cur = newBoard.placeNext(true, i / 3, i % 3);
			if (cur > best) {
				id = i;
				if (cur == 100)
					break;
				best = cur;
			}
    	}
    	
    	if (id == -1)
    		System.out.println("No ID found! :(");
    	b[id / 3][id % 3] = 'O';
    }
    
    /**
     * @author Mark Sturtevant
     */
    private int placeNext(boolean o, int y, int x) {
    	if (getCharAt(x, y) != ' ')
    		return -1001;
    	move(o ? 'O' : 'X', x, y);
    	int state = getState();
    	if (state != 0)
    		return 100 * state;
    	if (!hasMovesLeft())
    		return 0;
    	
    	if (!o) {
    		
    		int best = -1001;
    		for (int i = 0; i < 9; i++) {
    			Board newBoard = new Board(this);
    			int cur = newBoard.placeNext(!o, i / 3, i % 3);
    			if (cur > best) {
    				if (cur == 100)
    					return 100;
    				best = cur;
    			}
    		}
    		return best;
    		
    	} else {
    		
    		int count1 = 0, count2 = 0;
    		for (int i = 0; i < 9; i++) {
    			Board newBoard = new Board(this);
    			int cur = newBoard.placeNext(!o, i / 3, i % 3);
    			switch(cur) {
    			case -1001:
    				continue;
    			case -100:
    				return -100;
    			case 100:
    				count2++;
    			default:
    				count1++;
    			}
    		}
    		if (count1 == count2 && count2 > 0) {
				return 100;
			}
			return count2;
			
    	}
    }
    
    //find if win for x or o (-1 for x) (1 for o) (0 draw)
    public int getState(){
    	for(int r = -1; r<=1; r+=2){
    		char c = (r==-1) ? 'X' : 'O';
	     	for(int i = 0; i<3; i++){
		    	if(b[i][0] == c && b[i][1] == c && b[i][2] == c)
		    		return r;
		    	if(b[0][i] == c && b[1][i] == c && b[2][i] == c)
		    		return r;
	    	}
	    	if(b[0][0] == c && b[1][1] == c && b[2][2] == c)
	    		return r;
	    	if(b[2][0] == c && b[1][1] == c && b[0][2] == c)
	    		return r;   		
    	}   
	    return 0;
    }
    
    //places either an 'x' or an 'o' at the position (x,y)
    public boolean move(char side, int x, int y){
    	if(side=='X'||side=='O'||side==' '){
    		if( x < 3 && y < 3 ){
	    		b[y][x] = side;
	    		return true;
    		}
    	}
    	return false;
    }
    
    //returns either an 'x' or an 'o' at a position
    public char getCharAt(int x, int y){
    	if( x<3 && y<3 )
    		return b[y][x];
    	else
    		return ' ';
    }
    
    //returns true if theres an empty space on the board
    public boolean hasMovesLeft(){
    	for(int i = 0; i<3; i++)
    		for(int j = 0; j<3; j++)
    			if (b[i][j] == ' ')
    				return true;
    	return false;
    }
    
}
