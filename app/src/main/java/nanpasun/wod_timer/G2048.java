package nanpasun.wod_timer;

import java.util.ArrayList;
import java.util.Random;

public class G2048 {
    int size;
    ArrayList<ArrayList<Integer>> board;
    Random random = new Random();
    int startNum = 2;

    public G2048(int size) {
        this.size = size;

        board = new ArrayList<ArrayList<Integer>> ();
        for (int i= 0; i < size; i++ ) {
            board.add(new ArrayList());
            for (int j = 0; j < size; j++ ) {
                board.get(i).add(new Integer(0));
            }
        }
    }

    public ArrayList<ArrayList<Integer>> getBoard() {
        return this.board;
    }

    public Boolean gameOverCheck() {
        return false;
    }

    public void createNum() {
        int x = random.nextInt(size);
        int y = random.nextInt(size);

        while (true) {
            if (board.get(x).get(y).equals(0)) {
                board.get(x).set(y, startNum);
                break;
            }
            x = random.nextInt(size);
            y = random.nextInt(size);
        }
    }

    public void upMove() {

    }

    public void downMove() {

    }

    private void setValueBoardValueIf0Elae(ArrayList<Integer> board, int i, Runnable _for) {
        if (!board.get(i).equals(0)) {
            _for.run();
        }
    }

    private void setValueBoardMove(ArrayList<Integer> board, int a, int b) {
        if (board.get(a).equals(0)) {
            board.set(a, board.get(b));
            board.set(b, 0);
        } else if (board.get(a).equals(board.get(b))) {
            board.set(a, board.get(a) + board.get(b));
            board.set(b, 0);
        }
    }

    public void leftMove() {
        for(final ArrayList<Integer> board1th : board) {
            for (int i = 1; i < size; i++) {
                final int finalI = i;
                setValueBoardValueIf0Elae(board1th, i, new Runnable() {
                    @Override
                    public void run() {
                        for (int j = finalI - 1; j >= 0; j--) {
                            setValueBoardMove(board1th, j , j + 1);
                        }
                    }
                });
            }
        }
    }

    public void rightMove() {
        for(ArrayList<Integer> board1th : board) {
            for (int i = size - 2; i >= 0; i--) {
                if (!board1th.get(i).equals(0)) {
                    for (int j = i + 1; j < size; j++) {
                        setValueBoardMove(board1th, j , j - 1);
                    }
                }
            }
        }
    }

    public void print() {
        for (ArrayList<Integer> list : this.board) {
            for (Integer num : list) {
                System.out.print(" " + num);
            }
            System.out.println();
        }
    }
}
