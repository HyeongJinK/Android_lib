package nanpasun.wod_timer;

import java.util.ArrayList;
import java.util.Random;

public class GGostop {
    enum CardType {
        GWANG, BIGWANG, HONG, CHUNG, CHO, DDI, GODORI, MUNG, CHOICE, PI, TWOPI, THREEPI;
    }

    enum CardMonth {
        JAN, FER, MAR, APR, MAY, JUN, JUL, AUG, SEP, OCT, NOV, DEC, ETC
    }

    class Card {
        CardType type;
        CardMonth month;

        public Card(CardType type, CardMonth month) {
            this.type = type;
            this.month = month;
        }
    }

    ArrayList<Card> cards = new ArrayList<Card>();

    GGostop () {
        cards.add(new Card(CardType.GWANG, CardMonth.JAN));
        cards.add(new Card(CardType.HONG, CardMonth.JAN));
        cards.add(new Card(CardType.PI, CardMonth.JAN));
        cards.add(new Card(CardType.PI, CardMonth.JAN));
        cards.add(new Card(CardType.GODORI, CardMonth.FER));
        cards.add(new Card(CardType.HONG, CardMonth.FER));
        cards.add(new Card(CardType.PI, CardMonth.FER));
        cards.add(new Card(CardType.PI, CardMonth.FER));
        cards.add(new Card(CardType.GWANG, CardMonth.MAR));
        cards.add(new Card(CardType.HONG, CardMonth.MAR));
        cards.add(new Card(CardType.PI, CardMonth.MAR));
        cards.add(new Card(CardType.PI, CardMonth.MAR));
        cards.add(new Card(CardType.GODORI, CardMonth.APR));
        cards.add(new Card(CardType.CHO, CardMonth.APR));
        cards.add(new Card(CardType.PI, CardMonth.APR));
        cards.add(new Card(CardType.PI, CardMonth.APR));
        cards.add(new Card(CardType.MUNG, CardMonth.MAY));
        cards.add(new Card(CardType.CHO, CardMonth.MAY));
        cards.add(new Card(CardType.PI, CardMonth.MAY));
        cards.add(new Card(CardType.PI, CardMonth.MAY));
        cards.add(new Card(CardType.MUNG, CardMonth.JUN));
        cards.add(new Card(CardType.CHUNG, CardMonth.JUN));
        cards.add(new Card(CardType.PI, CardMonth.JUN));
        cards.add(new Card(CardType.PI, CardMonth.JUN));
        cards.add(new Card(CardType.MUNG, CardMonth.JUL));
        cards.add(new Card(CardType.CHO, CardMonth.JUL));
        cards.add(new Card(CardType.PI, CardMonth.JUL));
        cards.add(new Card(CardType.PI, CardMonth.JUL));
        cards.add(new Card(CardType.GWANG, CardMonth.AUG));
        cards.add(new Card(CardType.GODORI, CardMonth.AUG));
        cards.add(new Card(CardType.PI, CardMonth.AUG));
        cards.add(new Card(CardType.PI, CardMonth.AUG));
        cards.add(new Card(CardType.CHOICE, CardMonth.SEP));
        cards.add(new Card(CardType.CHUNG, CardMonth.SEP));
        cards.add(new Card(CardType.PI, CardMonth.SEP));
        cards.add(new Card(CardType.PI, CardMonth.SEP));
        cards.add(new Card(CardType.MUNG, CardMonth.OCT));
        cards.add(new Card(CardType.CHUNG, CardMonth.OCT));
        cards.add(new Card(CardType.PI, CardMonth.OCT));
        cards.add(new Card(CardType.PI, CardMonth.OCT));
        cards.add(new Card(CardType.GWANG, CardMonth.NOV));
        cards.add(new Card(CardType.TWOPI, CardMonth.NOV));
        cards.add(new Card(CardType.PI, CardMonth.NOV));
        cards.add(new Card(CardType.PI, CardMonth.NOV));
        cards.add(new Card(CardType.BIGWANG, CardMonth.DEC));
        cards.add(new Card(CardType.MUNG, CardMonth.DEC));
        cards.add(new Card(CardType.DDI, CardMonth.DEC));
        cards.add(new Card(CardType.TWOPI, CardMonth.DEC));
        cards.add(new Card(CardType.THREEPI, CardMonth.ETC));
        cards.add(new Card(CardType.TWOPI, CardMonth.ETC));
    }

    public ArrayList<Integer> Shuffle() {
        ArrayList<Integer> tempNumArr = new ArrayList<Integer>();
        ArrayList<Integer> randomNumArr = new ArrayList<Integer>();

        for (int i = 0; i < cards.size(); i++)
            tempNumArr.add(i);

        Random random = new Random();
        int num;

        while (!tempNumArr.isEmpty()) {
            num = random.nextInt(tempNumArr.size());

            randomNumArr.add(tempNumArr.get(num));
            tempNumArr.remove(num);
        }

        return randomNumArr;
    }
//GWANG, BIGWANG, HONG, CHUNG, CHO, DDI, GODORI, MUNG, CHOICE, PI, TWOPI, THREEPI;
    class Score {
        boolean biGwang = false;
        int gwang = 0, hong = 0, chung = 0, cho = 0, ddi = 0, godori = 0, mung = 0, pi = 0, twopi = 0, threepi = 0, choice = 0;

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
                resutl ++3

            return result;
        }

        public void score(ArrayList<Card> userCards) {
            for (Card card : userCards) {
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
        }
    }
}
