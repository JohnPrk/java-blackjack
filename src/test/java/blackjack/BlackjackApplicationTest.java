package blackjack;

import org.junit.jupiter.api.Test;

import java.util.List;

import static blackjack.BlackjackApplication.calculateSum;
import static org.assertj.core.api.Assertions.assertThat;

public class BlackjackApplicationTest {

    @Test
    void A와_9의_합이_21이하이므로_A는_11로_계산되어_20이_된다() {
        assertThat(calculateSum(List.of("A", "9"))).isEqualTo(20);
    }

    @Test
    void A와_K의_합이_21이므로_A는_11로_계산된다() {
        assertThat(calculateSum(List.of("A", "K"))).isEqualTo(21);
    }

    @Test
    void A_두장과_K와_4에서_합이_21을_넘으므로_A는_모두_1로_계산되어_16이_된다() {
        assertThat(calculateSum(List.of("A", "A", "K", "4"))).isEqualTo(16);
    }

    @Test
    void K와_Q는_각각_10으로_계산되어_합이_20이_된다() {
        assertThat(calculateSum(List.of("K", "Q"))).isEqualTo(20);
    }

    @Test
    void J는_10으로_계산되어_1과_합하면_11이_된다() {
        assertThat(calculateSum(List.of("J", "1"))).isEqualTo(11);
    }

    @Test
    void A는_21이하이므로_A는_11로_계산되어_11이_된다() {
        assertThat(calculateSum(List.of("A"))).isEqualTo(11);
    }
}
