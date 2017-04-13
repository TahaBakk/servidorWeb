import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * Created by taha on 13/04/2017.
 */
public class RootHandler implements HttpHandler {

    @Override
    //Lo que aqui hacemos es cargar lo que tengamos en response al navegador
    //si alguien se conecta a nuestro servidor le mostraremos este contenido
    public void handle(HttpExchange he) throws IOException {
        //per aconseguir la hora y fecha actual
        String timeStamp = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss").format(Calendar.getInstance().getTime());

        System.out.println(timeStamp + " Log: Atendre petició");//para montar el log

        String response = Main.leerFitxero("paginaWeb.html");//cargamos el html y lo mostramos en el navegado
        he.sendResponseHeaders(200, response.length());
        OutputStream os = he.getResponseBody();
        os.write(response.getBytes());
        os.close();

        System.out.println(timeStamp + " Log: Esperant petició");//para montar el log
    }
}
