package nanpasun.wod_timer;

import java.util.Timer;
import java.util.TimerTask;

public class KTimer {
    enum TimeType {
        AMRAP, FORTIME, TABATA, ETC
    }

    Timer mTimer = null;

    int count = 0;

//    KTimer() {
//
//    }

    public void AMRAP() {
        count++;
    }

    public void start(TimerTask mTask) {
        start(mTask, 0, 1000);
    }

    public void start(TimerTask mTask, int delay, int period) {
        mTimer = new Timer();
        mTimer.scheduleAtFixedRate(mTask, delay, period);
    }

    public void stop() {
        if (mTimer != null) {
            mTimer.cancel();
        }
    }

    public void reset() {
        count = 0;
    }

    public String strMinSec() {
        return strMinSec(this.count);
    }

    public String strMinSec(int count) {
        String min = "00";
        String sec = "00";

        if (count/60 < 10) {
            min = "0"+(count/60);
        } else {
            min = String.valueOf(count/60);
        }

        if ((count%60) < 10) {
            sec = "0"+(count%60);
        } else {
            sec = String.valueOf(count%60);
        }

        return min+":"+sec;
    }
    public String strHourMinSec() {
        return strHourMinSec(this.count);
    }
    public String strHourMinSec(int count) {
        String hour = "00";
        String min = "00";
        String sec = "00";

        if (count/3600 < 10) {
            hour = "0"+(count/3600);
        } else {
            hour = String.valueOf(count/3600);
        }

        if (count/60 < 10) {
            min = "0"+(count/60);
        } else {
            min = String.valueOf(count%3600/60);
        }

        if ((count%60) < 10) {
            sec = "0"+(count%60);
        } else {
            sec = String.valueOf(count%60);
        }

        return hour+":"+min+":"+sec;
    }
}
