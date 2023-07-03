
import java.util.Scanner;

public class MemoryGame {
    
    private static Card[][] cards = new Card[4][4];
    
    public static void main(String[] args) {
        
           
        cards[0][0] = new Card('A');
        cards[0][1] = new Card('H');
        cards[0][2] = new Card('G');
        cards[0][3] = new Card('B');
        cards[1][0] = new Card('D');
        cards[1][1] = new Card('D');
        cards[1][2] = new Card('C');
        cards[1][3] = new Card('G');
        cards[2][0] = new Card('E');
        cards[2][1] = new Card('C');
        cards[2][2] = new Card('F');
        cards[2][3] = new Card('A');
        cards[3][0] = new Card('H');
        cards[3][1] = new Card('E');
        cards[3][2] = new Card('F');
        cards[3][3] = new Card('B');
        
        while(gameEnd() == false){
            gameBoard();
            predict();
        }
        System.out.println("congratulations you won !");
  
    }
    
    public static void predict(){
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("First Guess(Enter i and j values in a space): ");
        int i1 = scanner.nextInt();
        int j1 = scanner.nextInt();
        
        cards [i1][j1].setGuess(true);
        gameBoard();
        
        System.out.println("");
        int i2 = scanner.nextInt();
        int j2 = scanner.nextInt();
        System.out.println("Second Guess(Enter i and j values in a space): ");
        cards [i2][j2].setGuess(true);
        gameBoard();
        
        if (cards[i1][j1].getValue() == cards[i2][j2].getValue()){
            System.out.println("Correct !");
            cards[i2][j2].setGuess(true);
        }
        else{
            cards[i1][j1].setGuess(false);
            cards [i2][j2].setGuess(false);
            System.out.println("Incorrect !");
        }
    }
    
    public static boolean gameEnd(){
        
        for (int i = 0; i<4 ; i++){
            for (int j= 0 ; j<4 ; j++){
                if(cards[i][j].isGuess() == false){
                    return false;
                }
            }
        }
        return true;
    }
    
    public static void gameBoard(){
        for (int i = 0 ; i <4 ; i++){
            System.out.println("*******************");
            for(int j = 0; j<4; j++){
                
                if(cards[i][j].isGuess()){
                    System.out.print(" |"+ cards[i][j].getValue() + " |");
                    
                }else{
                    System.out.print(" |?| ");
                }
            }
            System.out.println("");
        
        }
        System.out.println("*******************");
    }
}
