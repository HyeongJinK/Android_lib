package nanpasun.wod_timer;

import java.util.ArrayList;

public class GPoker {
    enum CardType {
        spade, diamond, heart, club
    }
    class Cards {
        CardType type;
        int num;

        Cards(CardType type, int num) {
            this.type = type;
            this.num = num;
        }
    }

    ArrayList<Cards> cards = new ArrayList<Cards>();

    public GPoker() {
        for(CardType type : CardType.values()) {
            for (int i = 1; i < 14; i++) {
                cards.add(new Cards(type, i));
            }
        }
    }
}
