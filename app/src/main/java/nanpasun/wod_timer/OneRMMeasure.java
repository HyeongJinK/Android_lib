package nanpasun.wod_timer;

public class OneRMMeasure {
    public class WarmUpData {
        int round;
        long weight;
        int repeat;
        String rest;

        WarmUpData(int round, long weight, int repeat, String rest) {
            this.round = round;
            this.weight = weight;
            this.repeat = repeat;
            this.rest = rest;
        }
    }

    public WarmUpData getWarmUpData(int round, int oneRm) {
        return new WarmUpData(round, setWeight(round, oneRm), setRepeat(round), setRest(round));
    }

    private long setWeight(int round, int oneRm) {
        if (round > 6) {
            long temp = oneRm;
            for (int i = 0; i < round - 6; i++) {
                temp = Math.round(temp * 1.02);
            }
            return temp;
        }

        switch (round) {
            case 1:
                return Math.round(oneRm * 0.5);
            case 2:
                return Math.round(oneRm * 0.6);
            case 3:
                return Math.round(oneRm * 0.7);
            case 4:
                return Math.round(oneRm * 0.8);
            case 5:
                return Math.round(oneRm * 0.9);
            case 6:
                return oneRm;
        }
        return 0;
    }

    private int setRepeat(int round) {
        switch (round) {
            case 1:
                return 8;
            case 2:
                return 5;
            case 3:
                return 3;
            default:
                return 1;
        }
    }

    private String setRest(int round) {
        switch (round) {
            case 1:
            case 2:
                return "2";
            case 3:
            case 4:
                return "3";
            case 5:
                return "5";
            default:
                return "5~15";
        }
    }
}


