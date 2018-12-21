package engineer.paul.infixconverter;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class InfixConverterTest {

    private InfixConverter ic = new InfixConverter();

    @Test
    void toPostFix() {

        assertEquals("A B C * + D +", ic.toPostFix("A + B * C + D"));
        // TODO: Allow infix expression to be input without requruiring parens to be spaced out
        assertEquals("A B + C D + *", ic.toPostFix("( A + B ) * ( C + D )"));
        assertEquals("A B * C D * +", ic.toPostFix("A * B + C * D"));
        assertEquals("A B + C + D +", ic.toPostFix("A + B + C + D"));
    }

    @Test
    void toPreFix() {

        // TODO: Implment toPreFix test case

    }
}