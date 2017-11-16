package Week02.lesson01;

/**
 * Created by ZHOUTM2 on 11/15/2017.
 */
public class Token {
    public enum TokenType {
        LPAR, RPAR,
        PLUS,
        MINUS,
        MULT,
        DIV,
        INT,
        NONE,
    }
    public TokenType tokenType;
    public Object value;

    public Token(TokenType tt, Object v) {
        this.tokenType = tt;
        this.value = v;
    }

    @Override
    public String toString() {
        return "Token{" +
                "tokenType=" + tokenType.toString() +
                ", value=" + value +
                '}';
    }
}
