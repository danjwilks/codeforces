import java.util.Scanner;

public class VasyaAndChess {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = Integer.parseInt(sc.nextLine());

        // x x 
        // x x 
        
        // whoever starts wins

        // A x B
        // x x x
        // x x x

        // A x B
        // x x x 
        // x x x

        // A can go r, rd, d
        // Ar -> B can go l ld d
        // Bl -> B wins
        
        // how does one know if either played optimally.

        // . B .
        // . x .
        // A x B

        // to play optimally, the first player must move such that it has atleast
        // 1 pawn inbetween itself and the other player.

        // to play optimally
        // once p1 moves, it should be impossible for p2 to win, 
        // as long as p1 does the right moves.
        // 


        // A x x B
        // x x x x 
        // x x x x 
        // x x x x 

        // . . x .
        // x . x . 
        // x . x . 
        // x A x B 
        
        // A x x x B
        // x x x x x
        // x x x x x
        // x x x x x
        // x x x x x

        // . . x . .
        // x . x . x
        // x . x . x
        // x . x . x
        // x A x . x

        // the way to win is to squeeze the opponent into using all their squares until there are none left

        // but this is not a simple calulcation, I should do it by using bfs. 
        // But how to know when optimal play has been found?

        if (n % 2 == 0) {
            System.out.println("white\n1 2");
        } else {
            System.out.println("black");
        }
        sc.close();
    }
    
}
