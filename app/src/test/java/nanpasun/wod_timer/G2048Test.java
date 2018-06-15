package nanpasun.wod_timer;

import org.junit.Test;

import java.util.ArrayList;

public class G2048Test {
    @Test
    public void initTest() {
        G2048 g2048 = new G2048(5);
        g2048.createNum();
        g2048.createNum();
        for (ArrayList<Integer> list : g2048.board) {
            for (Integer num : list) {
                System.out.print(" " + num);
            }
            System.out.println();
        }
    }
}
