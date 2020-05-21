import java.util.Stack;

public class CraneStack {
    public static void main(String[] args) {
        System.out.println("dd");
        int[][] board = { {0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
        int[] moves = {1,5,3,5,1,2,1,4};

        int answer  = solution(board, moves);
        System.out.println(answer);
    }

    public static int solution(int[][] board, int[] moves) {
        int answer = 0;

        Stack<Integer> stack = new Stack<>();


        for (int i=0; i< moves.length; i++) {
            if (board[board.length-1][moves[i]-1] == 0) {
                continue;
            }
            for (int j=0; j<board[0].length; j++) {
                if (board[j][moves[i]-1] != 0) {
                    if (!stack.empty() && stack.peek() == board[j][moves[i]-1]) {
                        stack.pop();
                        answer += 2;
                    } else {
                        stack.push(board[j][moves[i]-1]);
                    }
                    board[j][moves[i]-1] = 0;
                    j = board[0].length;
                }
            }
        }
            return answer;
    }
}
