package psp_t3_55124290y_servidor;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;

public class servidor extends Thread {

    private ServerSocket socketServidor;
    private Socket socketCliente;
    private int puerto;

    private JTextArea consola;

    private BufferedReader recibir;
    private PrintWriter enviar;

    private boolean salir = false;

    public servidor(JTextArea consola, int puerto) {

        this.consola = consola;
        this.puerto = puerto;
        
        try {
            socketServidor = new ServerSocket(puerto);
            consola.append("El servidor se ha iniciado correctamente en el puerto " + puerto + System.lineSeparator());
        } catch (Exception e) {
            consola.append("Error al iniciar el servidor." + System.lineSeparator() + e.getMessage()
                    + System.lineSeparator());
        }
    }

    public void enviar(String mensaje) {
        enviar.println(mensaje);
        enviar.flush();
    }

    public void run() {

        try {
            socketCliente = socketServidor.accept();
            consola.append("Conexión realizada con el cliente" + System.lineSeparator());
            consola.append(socketCliente.toString() + System.lineSeparator());

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
