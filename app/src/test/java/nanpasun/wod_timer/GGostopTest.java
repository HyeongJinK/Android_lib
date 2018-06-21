package nanpasun.wod_timer;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;

public class GGostopTest {
    @Test
    public void ShuffleTest() {
        GGostop gostop = new GGostop();

        ArrayList<Integer> numArr = gostop.Shuffle();

        for (Integer n : numArr) {
            System.out.println(n);
        }
    }
}
