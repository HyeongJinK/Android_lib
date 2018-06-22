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

    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<Integer> randomNumArr = new ArrayList<Integer>();
    private int index = 0;
    public ArrayList<Integer> backgroud = new ArrayList<Integer>();

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

        Shuffle();
    }

    private ArrayList<Integer> Shuffle() {
        randomNumArr.clear();
        ArrayList<Integer> tempNumArr = new ArrayList<Integer>();

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

    public Card getCard() {
        return cards.get(randomNumArr.get(index++));
    }

    public void backgroudSetting(int cardCount) {
        for (int i = 0; i < cardCount; i++)
            backgroud.add(randomNumArr.get(index++));
    }

    //public
}
