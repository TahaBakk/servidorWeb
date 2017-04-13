import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by taha on 13/04/2017.
 */
public class EchoHeaderHandler implements HttpHandler {

    @Override
    //Esto es para mostrar cualquier información en el header:
    public void handle(HttpExchange he) throws IOException {
        Headers headers = he.getRequestHeaders();
        Set<Map.Entry<String, List<String>>> entries = headers.entrySet();
        String response = "Taha";
        for (Map.Entry<String, List<String>> entry : entries)
            response += entry.toString() + "\n";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.toString().getBytes());
        os.close();
    }
}
