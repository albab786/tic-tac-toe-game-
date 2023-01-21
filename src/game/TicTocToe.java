package game;
import java.util.Scanner;

public class TicTocToe {
	private Player player1,player2;
	private Board board;
	public static void main(String args[]) {
		 TicTocToe t=new  TicTocToe();
		 t.startGame();
	}
	
	
	
	
	
	
	
	public void startGame() {
		Scanner s=new Scanner(System.in);
		//players input
		player1=takePlayerInput(1);
		player2=takePlayerInput(2);
		while(player1.getsymbol()==player2.getsymbol()) {
			System.out.println("symbol already taken || pick another symbol||");
			 char symbol=s.next().charAt(0);
			 player2.setsymbol(symbol);
		}
		
		//create board
		board =new Board(player1.getsymbol(),player2.getsymbol());
		//conduct game
		boolean player1Turn=true;
		int status=Board.INCOMPLETE;
		while(status==Board.INCOMPLETE || status==Board.INVALID) {
			if(player1Turn){
				System.out.println("player 1-" + player1.getName() + "s turn");
				System.out.println("enter x : ");
				int x =s.nextInt();
				System.out.println("enter y : ");
				int y=s.nextInt();
			 status=board.move(player1.getsymbol(), x,y);
				if(status!=Board.INVALID) {
					
					player1Turn=false;
					board.print();
				}else {
					System.out.println("invalid move || try again ||");
				}
				}else {
					System.out.println("player 2-" + player2.getName() + "s turn");
					System.out.println("enter x : ");
					int x =s.nextInt();
					System.out.println("enter y : ");
					int y=s.nextInt();
					 status=board.move(player2.getsymbol(), x,y);
					if(status!=Board.INVALID) {
						
					
						player1Turn=true;
						board.print();
				}
					else {
						System.out.println("invalid move || try again ||");
					}
				
			}
		}
		if(status==Board.PLAYER_1_WINS) {
			System.out.println("player 1-" + player1.getName() + "wins || ");
			
		}else if(status==Board.PLAYER_2_WINS) {
			System.out.println("player 2-" + player2.getName() + "wins || ");
		}else {
			System.out.println("draw||");
		}
		
		
	}
	
	
	private Player takePlayerInput(int num) {
		Scanner s=new Scanner(System.in);
		System.out.println("enter player" + num +"name :");
		String name =s.nextLine();
		System.out.println("enter player" + num +"symbol :");
		char symbol=s.next().charAt(0);
		Player p=new Player(name, symbol);
		return p;
		
	}

}

