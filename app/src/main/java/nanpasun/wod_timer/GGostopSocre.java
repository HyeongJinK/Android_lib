package nanpasun.wod_timer;

import java.util.ArrayList;

public class GGostopSocre {
    private int getGwangScore(boolean biGwang, int gwang) {
        switch (gwang) {
            case 3:
                if (biGwang)
                    return 2;
                else
                    return 3;
            case 4:
                return 4;
            case 5:
                return 15;
        }
        return 0;
    }

    private int getDdiScore(int hong, int chung, int cho, int ddi) {
        int result = 0;

        if (hong == 3)
            result += 3;

        if (chung == 3)
            result += 3;

        if (cho == 3)
            result += 3;

        if (ddi >= 5)
            result += (ddi - 4);

        return result;
    }

    private int getMongScore(int godori, int mong) {
        int result = 0;

        if (godori == 3) {
            result += 5;
        }

        if (mong >= 5) {
            result += (mong - 4);
        }

        return result;
    }

    private int getPiScore(int pi, int twopi, int threepi, int choice) {
        int result = 0, sum = 0;

        sum = pi + (twopi * 2) + (threepi * 3) + (choice * 2);


        if (sum >= 10) {
            result += (sum - 9);
        }

        return result;
    }

    public int getGoScore(int go, int score) {
        if (go == 1) {
            return score + 1;
        } else if (go == 2) {
            return score + 2;
        } else if (go >= 3) {
            return (int) Math.pow(score + 2, go -1);
        } else {
            return score;
        }
    }
    //흔들, 통령 광, 멍, 피
    public int score(ArrayList<GGostop.Card> userCards, int go) {
        int score = 0;
        boolean biGwang = false;
        int gwang = 0, hong = 0, chung = 0, cho = 0, ddi = 0, godori = 0, mung = 0, pi = 0, twopi = 0, threepi = 0, choice = 0;

        for (GGostop.Card card : userCards) {
            switch (card.type) {
                case BIGWANG:
                    biGwang = true;
                    ++gwang;
                    break;
                case GWANG:
                    ++gwang;
                    break;
                case HONG:
                    ++hong;
                    ++ddi;
                    break;
                case CHUNG:
                    ++chung;
                    ++ddi;
                    break;
                case CHO:
                    ++cho;
                    ++ddi;
                    break;
                case DDI:
                    ++ddi;
                    break;
                case GODORI:
                    ++godori;
                    ++mung;
                    break;
                case MUNG:
                    ++mung;
                    break;
                case PI:
                    ++pi;
                    break;
                case TWOPI:
                    ++twopi;
                    break;
                case THREEPI:
                    ++threepi;
                    break;
                case CHOICE:
                    ++choice;
                    break;
            }
        }

        score += getGwangScore(biGwang, gwang);
        score += getDdiScore(hong, chung, cho, ddi);
        score += getMongScore(godori, mung);
        score += getPiScore(pi, twopi, threepi, choice);
        score = getGoScore(go, score);

        return score;
    }
}
