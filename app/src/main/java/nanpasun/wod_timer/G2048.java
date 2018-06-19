package nanpasun.wod_timer;

import java.util.ArrayList;
import java.util.Random;

public class G2048 {
    int size;
    ArrayList<ArrayList<Integer>> board;
    ArrayList<ArrayList<Integer>> undoBoard;
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
        if (boardFullFillCheck()) {

        }

        return false;
    }

    public Boolean gameClearCheck() {
        for (ArrayList<Integer> list : this.board) {
            for (Integer num : list) {
                if (num.equals(2048))
                    return true;
            }
        }
        return false;
    }

    public Boolean boardFullFillCheck() {
        for (ArrayList<Integer> list : this.board) {
            for (Integer num : list) {
                if (num.equals(0))
                    return false;
            }
        }
        return true;
    }

    public void createNum() {
        createNum(1);
    }

    public void createNum(int num) {
        if (num > 0 && !boardFullFillCheck()) {
            int x, y;

            while (true) {
                x = random.nextInt(size);
                y = random.nextInt(size);

                if (board.get(x).get(y).equals(0)) {
                    board.get(x).set(y, startNum);
                    break;
                }
            }
            createNum(--num);
        }
    }

    private void setValueNotEmpty(Integer num, Runnable _for) {
        if (!num.equals(0)) {
            _for.run();
        }
    }

    private void setValueMoveAnd0Fill(ArrayList<Integer> board, int currentValue, int beforeValue) {
        if (board.get(currentValue).equals(0)) {
            board.set(currentValue, board.get(beforeValue));
            board.set(beforeValue, 0);
        } else if (board.get(currentValue).equals(board.get(beforeValue))) {
            board.set(currentValue, board.get(currentValue) + board.get(beforeValue));
            board.set(beforeValue, 0);
        }
    }

    private void setValueMoveAnd0Fill(int cRowNum, int bRowNum, int currentValue, int beforeValue) {
        if (board.get(cRowNum).get(currentValue).equals(0)) {
            board.get(cRowNum).set(currentValue, board.get(bRowNum).get(beforeValue));
            board.get(bRowNum).set(beforeValue, 0);
        } else if (board.get(cRowNum).get(currentValue).equals(board.get(bRowNum).get(beforeValue))) {
            board.get(cRowNum).set(currentValue, board.get(cRowNum).get(currentValue) + board.get(bRowNum).get(beforeValue));
            board.get(bRowNum).set(beforeValue, 0);
        }
    }

    public void upMove() {
        for (int i = 1; i < size; i++) {
            for (int j = 0; j < size; j++) {
                if(!board.get(i).get(j).equals(0)) {
                    for (int z = i - 1; z >= 0; z--) {
                        setValueMoveAnd0Fill(z, z+1, j, j);
                    }
                }
            }
        }
    }

    public void downMove() {
        for (int i = size - 2; i > 0; i--) {
            for (int j = 0; j < size; j++) {
                if(!board.get(i).get(j).equals(0)) {
                    for (int z = i + 1; z < size; z++) {
                        setValueMoveAnd0Fill(z, z-1, j, j);
                    }
                }
            }
        }
    }

    public void leftMove() {
        for (final ArrayList<Integer> board1th : board) {
            for (int i = 1; i < size; i++) {
                final int finalI = i;

                setValueNotEmpty(board1th.get(i), () -> {
                    for (int j = finalI - 1; j >= 0; j--) {
                        setValueMoveAnd0Fill(board1th, j , j + 1);
                    }
                });
            }
        }
    }

    public void rightMove() {
        for (ArrayList<Integer> board1th : board) {
            for (int i = size - 2; i >= 0; i--) {
                if (!board1th.get(i).equals(0)) {
                    for (int j = i + 1; j < size; j++) {
                        setValueMoveAnd0Fill(board1th, j , j - 1);
                    }
                }
            }
        }
    }

    public void undo() {

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
