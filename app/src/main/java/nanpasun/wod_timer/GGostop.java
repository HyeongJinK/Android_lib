package nanpasun.wod_timer;

import java.util.ArrayList;
import java.util.Random;
import java.util.function.Function;

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

        @Override
        public boolean equals(Object obj) {
            if (obj instanceof Card) {
                if (((Card) obj).type.equals(type) && ((Card) obj).month.equals(month)) {
                    return true;
                }
            }
            return false;
        }
    }

    private ArrayList<Card> cards = new ArrayList<Card>();
    private ArrayList<Integer> randomNumArr = new ArrayList<Integer>();
    private int index = 0;
    public ArrayList<Card> backgroud = new ArrayList<Card>();

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
    //카드섞기
    public ArrayList<Integer> Shuffle() {
        index = 0;
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
    //보드 세팅
    public void backgroudSetting(int cardCount) {
        //TODO 카드가 4장일때.
        for (int i = 0; i < cardCount; i++)
            backgroud.add(cards.get(randomNumArr.get(index++)));
    }
    //카드 드로우
    public Card draw() {
        return cards.get(randomNumArr.get(index++));
    }
    //
    //private
    //카드 비교
    public ArrayList<Card> backgroudCompareCard(Card card
        , Function<ArrayList<Card>, Card> matchCardTwo
        , Runnable matchCardThree) {
        ArrayList<Card> returnCards = new ArrayList<Card> ();
        ArrayList<Card> matchCards = new ArrayList<Card>();

        if (card != null) {
            for (Card back : backgroud) {
                if (back.equals(card)) { //맞는 카드가 있을 경우
                    matchCards.add(back);
                }
            }
        }

        switch (matchCards.size()) {
            case 0: //맞는 카드가 없을 경우 보드에 추가한다.
                backgroud.add(card);
                break;
            case 1: //맞는 카드가 한장일 경우 낸 카드와 맞는 카드를 가져가고 보드에서 없앤다.
                returnCards.add(card);
                returnCards.add(matchCards.get(0));
                backgroud.remove(matchCards.get(0));
                break;
            case 2://두장 중 하나 선택
                returnCards.add(card);
                Card choiceCard = matchCardTwo.apply(matchCards);
                returnCards.add(choiceCard);
                backgroud.remove(choiceCard);
                break;
            case 3://세장일 경우 전부 가져가고 피 한장씩 받기
                returnCards.add(card);
                returnCards.addAll(matchCards);
                backgroud.removeAll(matchCards);
                matchCardThree.run();
                break;
        }

        return returnCards;
    }
    //카드 뒤집기
    public ArrayList<Card> upsideDownCard() {
        Card upsideCard = draw();
        //backgroudCompareCard(draw())


        //싹쓸이 검사
        if (backgroud.isEmpty()) {

        }

        return null;
        //return returnCards;
    }
    //폭탄




}
