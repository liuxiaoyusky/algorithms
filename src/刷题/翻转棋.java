package 刷题;

public class 翻转棋 {
    //一维反转棋，已知输入输出，求最后输出时黑子的数量
    /*
    black as 0, white as 1
    start as: 0,1
    can only place left or right, so we have an input string as lrrl, placing in turns of black, white, black, white
    output: the num of blacks after all input
     */

    //solution 1: brute force: calculate the status after every placement
    //n inputs, each input need about n times to check every piece's status, in total O(n^2), space:O(n)


    //solution 2: record the 特征值, left and right bound of each color
    //since we will fill all pieces in the bound, no need to flip them in real-time
    //time O(n)

    //assume valid input, assume starting position as 0, 1 and place 0 first
    public int flip(String input) {
        //base case
        if (input == null || input.length() == 0) {
            return 1;
        }

        int [][] status = {{0,0},{1,1}};
        int curPiece = 0;
        int leftMost = 0;
        int rightMost = 1;
        for (char c : input.toCharArray()) {
            int curIndex = 0;
            if (c == 'l') {
                curIndex = leftMost--;
            } else {
                curIndex = rightMost++;
            }

            int [] curStatus = status[curPiece];
            int nextPiece =(curPiece + 1) % 2;
            int [] otherStatus = status[nextPiece];

            //check if current piece is the first piece,set it as the left and right bound
            if(curStatus[0] < curStatus[1]) {
                curStatus[0] = curIndex;
                curStatus[1] = curIndex;
            }

            //update the bound and update the other status if included
            else {
                //update boundary
                if (c == 'l') {
                    curStatus[0] = curIndex;
                } else {
                    curStatus[1] = curIndex;
                }

                //update the other
                if (c == 'l') {
                    otherStatus[0] = curStatus[1] + 1;
                } else {
                    otherStatus[1] = curStatus[0] - 1;
                }


            }
        }

        //no black
        if (status[0][0] > status[0][1]) {
            return 0;
        } else {
            return status[0][1] - status[0][0] + 1;
        }
    }
}
