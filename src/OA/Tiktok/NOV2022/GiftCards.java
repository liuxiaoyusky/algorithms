package OA.Tiktok.NOV2022;

public class GiftCards {
    public int getGiftCards(int m, int n) {
        int total = m - 10 * n;
        int count30 = 0;
        if (total >= 0 && total % count30 == 0) {
            count30 = total/count30;
        }

        return count30 / 2  + 1;
    }
}
