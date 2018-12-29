package engineer.paul.rpn;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class EvaluatorTest {

    private Evaluator evaluator = new Evaluator();

    @Test
    void postFixEvaluation() {
        assertEquals(-4 ,evaluator.evaluatePostFixExpression("2 3 1 * + 9 -"));
        // @TODO: Create additional tests
    }
}