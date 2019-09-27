package main;

public class TicTacToe {

	int[][] board=new int[3][3];
	public static final int valueX = 1;
	public static final int valueO = -valueX;
	int currentValue = valueX;

	public String move(int i,int j)

	{
		if (isEmptyPosition(i,j))
			board[i][j]=currentValue;
		else
			return "Position is already occupied.";

		currentValue=-currentValue;
		return arrayToString(board);
	}

	public String returnGameStatus()
	{
		if (getGameStatus()==1)
			return "X is the winner.";
		else if (getGameStatus()==2)
			return "O is the winner.";
		else
			return "Drawn game.";
	}

	public int getGameStatus()
	{
		int winX=1;
		int winO=2;
		int drawnGame=3;

		for (int i=0;i<3;i++)
			if ((board[i][0]==1 && board[i][1]==1 && board[i][2]==1)||(board[0][i]==1 && board[1][i]==1 && board[2][i]==1))
				return winX;
			else
				if ((board[i][0]==-1 && board[i][1]==-1 && board[i][2]==-1)||(board[0][i]==-1 && board[1][i]==-1 && board[2][i]==-1)) 
					return winO;

		if ((board[0][0]==1 && board[1][1]==1 && board[2][2]==1)||(board[0][2]==1 && board[1][1]==1 && board[2][0]==1))
			return winX;
		else
			if ((board[0][0]==-1 && board[1][1]==-1 && board[2][2]==-1)||(board[0][2]==-1 && board[1][1]==-1 && board[2][0]==-1))
				return winO;

		return drawnGame;
	}

	public boolean isEmptyPosition(int i,int j)
	{
		if (board[i][j]==0)
			return true;
		else
			return false;
	}

	public String arrayToString(int[][] boardArray)
	{
		String arrayString=new String("{");
		for (int i=0;i<3;i++)
		{
			arrayString+="{";
			for (int j=0;j<2;j++)
				arrayString+=""+boardArray[i][j]+",";
			if (i<2)
				arrayString+=""+boardArray[i][2]+"},";
			else
				arrayString+=""+boardArray[i][2]+"}";	
		}
		arrayString+="}";
		String returnString=arrayString.replaceAll("1", "X").replaceAll("-X", "O").replaceAll("0", "-");
		return returnString;

	}



}
