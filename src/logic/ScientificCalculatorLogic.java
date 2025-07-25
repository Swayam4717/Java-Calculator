package logic;

public class ScientificCalculatorLogic implements CalculatorLogic {
    @Override
    public String evaluate(String expression) {
        try {
            double result = eval(expression);
            return String.valueOf(result);
        } catch (Exception e) {
            return "Error";
        }
    }

    private double eval(String expr) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < expr.length()) ? expr.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < expr.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            double parseExpression() {
                double x = parseTerm();
                while (true) {
                    if (eat('+')) x += parseTerm();
                    else if (eat('-')) x -= parseTerm();
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                while (true) {
                    if (eat('*')) x *= parseFactor();
                    else if (eat('/')) x /= parseFactor();
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return parseFactor();
                if (eat('-')) return -parseFactor();

                double x;
                int startPos = this.pos;

                if (eat('(')) {
                    x = parseExpression();
                    eat(')');
                } else if ((ch >= '0' && ch <= '9') || ch == '.') {
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(expr.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') {
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = expr.substring(startPos, this.pos);
                    x = parseFactor();
                    switch (func) {
                        case "sqrt": x = Math.sqrt(x); break;
                        case "sin": x = Math.sin(Math.toRadians(x)); break;
                        case "cos": x = Math.cos(Math.toRadians(x)); break;
                        case "tan": x = Math.tan(Math.toRadians(x)); break;
                        case "log": x = Math.log10(x); break;
                        default: throw new RuntimeException("Unknown function: " + func);
                    }
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor());

                return x;
            }
        }.parse();
    }

    @Override
    public String[] getButtons() {
        return new String[] {
        "sin", "cos", "tan", "sqrt", "log",
        "C", "DEL", "^", "(", ")",
        "7", "8", "9", "/", "*",
        "4", "5", "6", "-", "+",
        "1", "2", "3", "0", "="
        };
    }
}
