package OA.XRW;

public class Candy {
    public int candy(int[] rating) {
        //corner case
        if (rating == null || rating.length  == 0) {
            return 0;
        }

        int start = 0;//start point of descending subsequence
        int cur = 0;//the current rating we check
        int [] candies = new int [rating.length];
        while (cur < rating.length) {
            //looking for descending order
            int right = cur + 1;
            //reaches the end of the rating
            if (right >= rating.length) {
                fillInValue(rating, candies, start, cur);
                cur++;
                start = cur;
                break;
            }

            //compare
            if (rating[cur] <= rating[right]) {
                fillInValue(rating, candies, start, cur);
                cur++;
                start = cur;
            } else {
                cur++;
            }
        }

        int sum = 0;
        for (int i : candies) {
            sum += i;
        }

        return sum;

    }


    private void fillInValue(int [] rating, int [] candies, int start, int cur) {
        int length = cur - start + 1;
        if (length == 1) {
            if (start == 0 || rating[start - 1] == rating [start]) {
                candies[start] = 1;
                return;
            } else {
                candies[start] = candies[start - 1] + 1;
                return;
            }
        } else {
            candies[cur] = 1;
            cur--;
            while (cur > start) {
                candies[cur] = candies[cur + 1] + 1;
                cur--;
            }
            candies[start] = candies[cur + 1] + 1;
            if(start > 0 && rating[start] > rating[start - 1] && candies[cur + 1] + 1 < candies[start - 1] + 1) {
                candies[start] = candies[start - 1] + 1;
            }
        }
    }
}