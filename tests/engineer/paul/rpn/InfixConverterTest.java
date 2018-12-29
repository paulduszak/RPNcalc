package engineer.paul.rpn;

import engineer.paul.rpn.InfixConverter;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfixConverterTest {

    private InfixConverter ic = new InfixConverter();

    @Test
    void toPostFix() {

        assertEquals("A B C * + D +", ic.toPostFix("A + B * C + D"));
        assertEquals("A B + C D + *", ic.toPostFix("(A + B) * (C + D)"));
        assertEquals("A B * C D * +", ic.toPostFix("A * B + C * D"));
        assertEquals("A B + C + D +", ic.toPostFix("A + B + C + D"));
    }

    @Test
    void toPreFix() {

        // TODO: Implment toPreFix test case

    }
}