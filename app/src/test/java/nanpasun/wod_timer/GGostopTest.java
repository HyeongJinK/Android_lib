package nanpasun.wod_timer;

import android.util.Log;

import org.junit.BeforeClass;
import org.junit.Test;

import java.util.ArrayList;

import static junit.framework.Assert.assertEquals;

public class GGostopTest {


//    @BeforeClass
//    public void beforeClass() {
//
//    }

    @Test
    public void ShuffleTest() {
        GGostop gostop;
        gostop = new GGostop();
        ArrayList<Integer> numArr = gostop.Shuffle();

        assertEquals("카드 장수",50, numArr.size());
        for (Integer n : numArr) {
            System.out.println(n);
        }

    }

    @Test
    public void goScoreTest() {
        GGostopSocre score = new GGostopSocre();

    }
}
