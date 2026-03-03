package blackjack;

import java.util.List;

public class BlackjackApplication {

    static int calculateSum(List<String> cards) {
        int sum = 0;
        int aceCount = 0;
        for (String card : cards) {
            if (card.equals("A")) {
                sum += 11;
                aceCount++;
            } else if (card.equals("J") || card.equals("Q") || card.equals("K")) {
                sum += 10;
            } else {
                sum += Integer.parseInt(card);
            }
        }
        while (sum > 21 && aceCount > 0) {
            sum -= 10;
            aceCount--;
        }
        return sum;
    }

    public static void main(String[] args) {
        // 케이스 1: A + 9 = 20 (A가 11로)
        System.out.println(calculateSum(List.of("A", "9")) == 20);
        // 케이스 2: A + K = 21 (A가 11로)
        System.out.println(calculateSum(List.of("A", "K")) == 21);
        // 케이스 3: A + A + K + 4 = 16 (A가 1로)
        System.out.println(calculateSum(List.of("A", "A", "K", "4")) == 16);
        // 케이스 4: K + Q = 20
        System.out.println(calculateSum(List.of("K", "Q")) == 20);
        // 케이스 5: J + 1 = 11
        System.out.println(calculateSum(List.of("J", "1")) == 11);
        // 케이스 6: Ace = 11 (Ace가 11로)
        System.out.println(calculateSum(List.of("A")) == 11);
    }
}
