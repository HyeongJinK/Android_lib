package nanpasun.wod_timer;

import java.util.ArrayList;
import java.util.Random;

public class G2048 {
    int size;
    ArrayList<ArrayList> board;
    Random random = new Random();
    int startNum = 2;

    public G2048(int size) {
        this.size = size;

        board = new ArrayList<ArrayList> ();
        for (int i= 0; i < size; i++ ) {
            board.add(new ArrayList());
            for (int j = 0; j < size; j++) {
                board.get(i).add(new Integer(0));
            }
        }
    }

    public ArrayList<ArrayList> getBoard() {
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

    public void leftMove() {

    }

    public void rightMove() {

    }
}
