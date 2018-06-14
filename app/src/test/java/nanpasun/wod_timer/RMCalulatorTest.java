package nanpasun.wod_timer;

import org.junit.Test;

import static junit.framework.Assert.assertEquals;

public class RMCalulatorTest {
    RMCalculator cal = new RMCalculator();
    int weight = 300;
    int number = 5;
    @Test
    public void defalutTest () {
        assertEquals(cal.defaultRm(weight, number), 338);
    }

    @Test
    public void EpleyTest() {
        assertEquals(cal.EpleyRm(weight, number), 350);
    }

    @Test
    public void BrzyckiTest() {
        assertEquals(cal.BrzyckiRM(weight, number), 338);
    }

    @Test
    public void BaechleTest() {
        assertEquals(cal.BaechleRM(weight, number), 350);
    }

    @Test
    public void LandersTest() {
        assertEquals(cal.LandersRM(weight, number), 341);
    }
}
