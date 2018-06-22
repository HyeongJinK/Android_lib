package nanpasun.wod_timer;

import android.util.Log;

import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class GGostopTest {
    @Test
    public void ShuffleTest() {
        GGostop gostop = new GGostop();

        ArrayList<Integer> numArr = gostop.Shuffle();

        for (Integer n : numArr) {
            System.out.println(n);
        }

    }

    @Test
    public void goScoreTest() {
        GGostopSocre score = new GGostopSocre();

    }
}
