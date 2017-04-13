import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

/**
 * Created by taha on 13/04/2017.
 */
public class RootHandler implements HttpHandler {

    @Override
    //Lo que aqui hacemos es cargar lo que tengamos en response al navegador
    //si alguien se conecta a nuestro servidor le mostraremos este contenido
    public void handle(HttpExchange he) throws IOException {
        String response = Main.leerFitxero("paginaWeb.html");//cargamos el html y lo mostramos en el navegado
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();
    }
}
