package logic;

public class StandardCalculatorLogic implements CalculatorLogic {
    @Override
    public String[] getButtons() {
        return new String[]{
            "7", "8", "9", "/",
            "4", "5", "6", "*",
            "1", "2", "3", "-",
            "0", ".", "=", "+"
        };
    }

    @Override
    public String evaluate(String expression) {
        // Use same logic as scientific, but restrict to basic math
        return new ScientificCalculatorLogic().evaluate(expression);
    }
}
