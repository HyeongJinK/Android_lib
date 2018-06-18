package nanpasun.wod_timer;

import java.util.Random;

public class GSudoku {
    int[][] board = {{0,0,0,0,0,0,0,0,0}
    ,{0,0,0,0,0,0,0,0,0}
    ,{0,0,0,0,0,0,0,0,0}
    ,{0,0,0,0,0,0,0,0,0}
    ,{0,0,0,0,0,0,0,0,0}
    ,{0,0,0,0,0,0,0,0,0}
    ,{0,0,0,0,0,0,0,0,0}
    ,{0,0,0,0,0,0,0,0,0}
    ,{0,0,0,0,0,0,0,0,0}};

    Random random = new Random();

    public int radomNumber() {
        return random.nextInt(9) + 1;
    }

    public void numberCheck(int inputNum, int arrayNum, int location) {

    }
    //배열 안에 같은 값이 있을 경우 false
    public boolean arrayDuplicateValueCheck(int inputNum, int arrayNum) {
        for(int i = 0; i < 9; i++) {
            if (board[arrayNum][i] == inputNum) {
                return false;
            }
        }
        return true;
    }

    //검사할 가로배열 시작값, 배열에서 검사할 시작값 설정
    private int horizontalBeginNumberInit(int num) {
        switch(num) {
            case 0:
            case 1:
            case 2:
                return 0;
            case 3:
            case 4:
            case 5:
                return 3;
            case 6:
            case 7:
            case 8:
                return 6;
            default:
                return -1;
        }
    }
    private int verticalBeginNumberInit(int num) {
        switch (num) {
            case 0:
            case 3:
            case 6:
                return 0;
            case 1:
            case 4:
            case 7:
                return 1;
            case 2:
            case 5:
            case 8:
                return 2;
            default:
                return -1;
        }
    }

    //입력한 값에서 가로열에서 중복된 값이 있는 지 검사
    public boolean horizontalDuplicateValueCheck(int inputNum, int arrayNum, int location) {
        int arrayBegin = horizontalBeginNumberInit(arrayNum);
        int begin = horizontalBeginNumberInit(location);

        for (int arrayEnd = arrayBegin + 3; arrayBegin < arrayEnd; arrayBegin++) {
            if (arrayBegin == arrayNum) {
                continue;
            }
            for (int end = begin + 3; begin < end; begin++) {
                if (board[arrayBegin][begin] == inputNum) {
                    return false;
                }
            }
        }
        return true;
    }

    public boolean verticalDuplicateValueCheck(int inputNum, int arrayNum, int location) {
        int arrayBegin = verticalBeginNumberInit(arrayNum);
        int begin = verticalBeginNumberInit(location);

        for (; arrayBegin < 9; arrayBegin += 3) {
            if (arrayBegin == arrayNum) {
                continue;
            }
            for (; begin < 9; begin += 3) {
                if (board[arrayBegin][begin] == inputNum) {
                    return false;
                }
            }
        }
        return true;
    }
}

