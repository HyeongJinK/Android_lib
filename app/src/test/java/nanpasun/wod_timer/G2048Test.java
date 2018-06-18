package nanpasun.wod_timer;

import org.junit.Test;

import java.util.ArrayList;

public class G2048Test {
    @Test
    public void initTest() {
        G2048 g2048 = new G2048(5);
        g2048.createNum();
        g2048.createNum();
        g2048.createNum();
        g2048.createNum();
        g2048.createNum();
        g2048.print();
        System.out.println();
        g2048.leftMove();
        g2048.print();
        System.out.println();

        g2048.createNum();
        g2048.createNum();
        g2048.createNum();
        g2048.createNum();
        g2048.print();
        System.out.println();
        g2048.leftMove();
        g2048.print();
        System.out.println();

        g2048.createNum();
        g2048.createNum();
        g2048.createNum();
        g2048.createNum();
        g2048.print();
        System.out.println();
        g2048.rightMove();
        g2048.print();
        System.out.println();
    }
}
