package nanpasun.wod_timer;

import org.junit.Test;


public class G2048Test {
    @Test
    public void initTest() {
        G2048 g2048 = new G2048(5);
        g2048.createNum(5);
        g2048.print();
        System.out.println();
        g2048.leftMove();
        g2048.print();
        System.out.println();

        g2048.createNum(4);
        g2048.print();
        System.out.println();
        g2048.downMove();
        g2048.print();
        System.out.println();

        g2048.createNum(4);
        g2048.print();
        System.out.println();
        g2048.rightMove();
        g2048.print();
        System.out.println();

        g2048.createNum(4);
        g2048.print();
        System.out.println();
        g2048.upMove();
        g2048.print();
        System.out.println();
    }
}
