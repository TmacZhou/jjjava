package Week02.lesson01;

import java.io.IOException;

/**
 * Created by ZHOUTM2 on 11/15/2017.
 */
public interface TokenStream {
    Token getToken() throws IOException;
    void consumeToken();
}
