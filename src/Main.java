import com.sun.net.httpserver.HttpServer;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.net.InetSocketAddress;


public class Main {
    /**
     *@server.createContext es para que dependiendo de la url que
     * le pongamos nos llamara una o otra
     * si en la url(navegador)le ponemos:
     * @localhost:9090 nos mostrara la pantalla principal
     * @localhost:9090/echoGet nos saldra como que si hicieramos un get
     * @localhost:9090/echoPost nos saldra como que si hicieramos un post
     * si montaramos un formulario lo que hariamos seria que al darle al boton
     * de enviar hacer un post y cojer los datos enviados
     *  */
    public static void main(String[] args) throws IOException {
        System.out.println("Hola");
        int port = 9090;
        HttpServer server = HttpServer.create(new InetSocketAddress(port), 0);
        //Para atender las diferentes url que se le envie
        System.out.println("server started at " + port);
        server.createContext("/", new RootHandler());
        server.createContext("/echoGet", new EchoGetHandler());
        server.createContext("/echoPost", new EchoPostHandler());
        server.setExecutor(null);
        server.start();
    }


    public static String leerFitxero(String filePath) throws IOException {
        StringBuffer datos = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            datos.append(readData);
        }
        reader.close();
        return datos.toString();
    }
}



