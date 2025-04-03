package org.problems.leetcode.backtrack;

// using backtracking we can find the word in the board
public class WordSearch {
    public boolean search(char[][] board, String word){
        if(word.length() == 0)
            return false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[0].length; j++){
                if(helperDfs(i, j, 0, board, word))
                    return true;
            }
        }
        return false;
    }
    public boolean helperDfs(int i, int j, int index, char[][] board, String word){
        // edge case index equals the size of word then word is found
        if(index >= word.length())
            return true;
        if(i < 0 || i >= board.length || j < 0 || j >= board[i].length ||
                board[i][j] != word.charAt(index) || board[i][j] == '*')
            return false;
        // mark cell visited
        board[i][j] = '*';
        boolean exists = helperDfs(i + 1, j, index + 1, board, word) || // down
                helperDfs(i - 1, j, index + 1, board, word) || // up
                helperDfs(i, j + 1, index + 1, board, word) || // right
                helperDfs(i, j - 1, index + 1, board, word); // left
        board[i][j] = word.charAt(index);
        return exists;
    }
    // discomfort is the growth
    public static void main(String[] args) {
        char [][] board = {
                {'A', 'B', 'C', 'D'},
                {'S', 'A', 'A', 'T'},
                {'A', 'C', 'A', 'E'}
        };
        WordSearch ws = new WordSearch();
        System.out.println("Is word CAT present " + ws.search(board, "CAT"));
    }
}
