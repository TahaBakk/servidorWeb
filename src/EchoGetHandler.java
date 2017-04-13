import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by taha on 13/04/2017.
 */
public class EchoGetHandler implements HttpHandler {

    @Override
    //montamos controlador echoGet para procesar el Get Request:
    public void handle(HttpExchange he) throws IOException {
        Map<String, Object> parameters = new HashMap<String, Object>();
        // enviar datos a la web
        String response = Main.leerFitxero("echoGet.html");
        for (String key : parameters.keySet())
            response += key + " = " + parameters.get(key) + "\n";
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.toString().getBytes());

        os.close();
    }
}
