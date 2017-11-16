package Week02.lesson01;

import java.io.IOException;

/**
 * Created by ZHOUTM2 on 11/15/2017.
 */
public class Lesson01 {

    public static void main(String[] args) throws IOException {
        TokenStream ts = new YourTokenStream(System.in);
        while (ts.getToken().tokenType != Token.TokenType.NONE) {
            ts.consumeToken();
        }
    }
}
