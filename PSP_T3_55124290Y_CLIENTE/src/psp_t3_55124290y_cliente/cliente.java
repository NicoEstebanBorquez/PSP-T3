package psp_t3_55124290y_cliente;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import javax.swing.JTextArea;

public class cliente extends Thread {

    private Socket socketCliente;
    private String server;
    private int puerto;
    
    private JTextArea consola;

    private BufferedReader recibir;
    private PrintWriter enviar;

    private boolean salir = false;

    public cliente(JTextArea consola, String server, int puerto) {

        this.consola = consola;
        this.server = server;
        this.puerto = puerto;

        try {
            socketCliente = new Socket(server, puerto);
            consola.append("Conexión establecida con el servidor desde el puerto " + puerto
                    + System.lineSeparator());

        } catch (Exception e) {
            consola.append("Error al conectar con el servidor desde el puerto " + puerto
                    + System.lineSeparator() + e.getMessage() + System.lineSeparator());
        }
    }

    public void enviar(String mensaje) {
        enviar.println(mensaje);
        enviar.flush();
    }

    public void run() {
        try {
            recibir = new BufferedReader(new InputStreamReader(socketCliente.getInputStream()));
            enviar = new PrintWriter(socketCliente.getOutputStream(), true);

            while (!salir) {
                String textoRecibido = recibir.readLine();
                consola.append("Servidor: " + textoRecibido + System.lineSeparator());
            }
        } catch (Exception e) {
        }
    }


}
