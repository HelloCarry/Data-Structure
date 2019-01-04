package drew.search;

import java.util.Stack;

class Offsets {
	public int Vert;
	public int Horiz;
	public Offsets(int vert, int horiz) {
		Vert = vert;
		Horiz = horiz;
	}
	
	
}

class Position {
	public Position(int row, int col, int dir) { Row = row; Col = col; Dir = dir; }
	public int Row;
	public int Col;
    public int Dir;
}

public class MazeProblem {

	static final int MAXMATRIXSIZE = 100;
	static final int MAXSTACKSIZE = 100;
	static final int[][] Maze = new int[][]{
		{0,1,0,0,0,1,1,0,0,0,1,1,1,1,1},
		{1,0,0,0,1,1,0,1,1,1,0,0,1,1,1},
		{0,1,0,0,0,0,0,1,1,1,1,0,0,1,1},
		{1,1,0,1,1,1,1,0,0,1,0,1,1,0,0},
		{1,1,0,1,0,0,1,0,1,1,1,1,1,1,1},
		{0,0,1,1,0,1,1,1,0,1,0,0,1,0,1},
		{0,1,1,1,1,0,0,1,1,1,1,1,0,1,1},
		{0,0,1,1,0,1,1,0,1,1,1,1,1,0,1},
		{1,1,0,0,0,1,1,0,0,1,0,0,0,0,0},
		{0,0,1,1,1,1,1,0,0,0,1,1,1,1,0},
		{0,1,0,0,0,0,1,1,1,0,1,1,1,1,0} };
		static Offsets[] Move = new Offsets[] {new Offsets(-1,0), new Offsets(-1,1), new Offsets(0,1), new Offsets(1,1),
										new Offsets(1,0), new Offsets(1,-1), new Offsets(0,-1), new Offsets(-1,-1) };
	
	public static void main(String args []) {
		Path();

	}
	
	static void Path() {
		//adjust Maze
		int[][] MazeAdj = new int [Maze.length + 2][Maze[0].length + 2];
		int[][] Mark = new int [Maze.length + 2][Maze[0].length + 2];
		int EXITROW = Maze.length + 1;
		int EXITCOL = Maze[0].length + 1;
		for(int i = 0; i< Maze.length; i++) {
			for(int j = 0; j< Maze[i].length; j++) {
				MazeAdj[i+1][j+1] = Maze[i][j];
			}
		}
		for(int i = 0; i< MazeAdj.length; i++) {
			MazeAdj[i][0] = 1;
			MazeAdj[i][MazeAdj[0].length - 1] = 1;
		}
		for(int i = 0; i< MazeAdj[0].length; i++) {
			MazeAdj[0][i] = 1;
			MazeAdj[MazeAdj.length - 1][i] = 1;
		}
		
		//starting position
		int Col, Row, Dir; 
		boolean found = false;
		Stack<Position> stack = new Stack<Position>();
		Position position = new Position(1, 1, 0);
		stack.push(position);
		
		while((stack.size()> 0) && !found) {
			position = stack.pop();
			Col = position.Col; 
			Row = position.Row;
			Dir = position.Dir;
			
			//judge a position
			while(Dir < 8 && !found) {
				/*尝试往Dir下一个方向移动*/
				int NextCol = Col + Move[Dir].Vert;
				int NextRow = Row + Move[Dir].Horiz;
				
				if(NextCol == EXITCOL && NextRow == EXITROW) {
					found = true;
				} else if(MazeAdj[NextRow][NextCol] != 1 &&(Mark[NextRow][NextCol] != 1)) {
					/*下一个位置可同，且没有找过*/
					Mark[NextRow][NextCol] = 1;
					Position positionRight = new Position(Row, Col, Dir);
					stack.push(positionRight);
					/*更新当前位置*/
					Row = NextRow; 
					Col = NextCol;
					Dir = 0;	
				} else Dir++;//在这一步中找下一个方向
			}
		}
		if(found ==  false) {
			System.out.println("not found !");
		} else {
			System.out.println("stack'size : " + stack.size());
		}
	}

}
