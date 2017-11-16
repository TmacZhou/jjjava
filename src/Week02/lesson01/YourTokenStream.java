package Week02.lesson01;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by ZHOUTM2 on 11/15/2017.
 */
public class YourTokenStream implements TokenStream{

    private InputStream in;
    private Token token;

    public YourTokenStream(InputStream in) {
        this.in = in;
    }

    public Token getToken() throws IOException{
        byte[] bytes = new byte[1];
        if(in.read(bytes) == -1 || bytes[0] == '\n') return new Token(Token.TokenType.NONE,0);
        switch ((char)bytes[0]){
            case '+':
                token = new Token(Token.TokenType.PLUS, (char)bytes[0]);
                break;
            case '*':
                token = new Token(Token.TokenType.MULT, (char)bytes[0]);
                break;
            case '(':
                token = new Token(Token.TokenType.LPAR, (char)bytes[0]);
                break;
            case ')':
                token = new Token(Token.TokenType.RPAR, (char)bytes[0]);
                break;
            case '-':
                token = new Token(Token.TokenType.MINUS, (char)bytes[0]);
                break;
            case '/':
                token = new Token(Token.TokenType.DIV, (char)bytes[0]);
                break;
            default:
                token = new Token(Token.TokenType.INT,(char)bytes[0]);
        }
        return token;
    }

    public void consumeToken(){
        System.out.println(token.toString());
    }
}
