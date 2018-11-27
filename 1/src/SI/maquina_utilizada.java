/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package SI;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
import java.util.StringTokenizer;

/**
 *
 * @author nupasd-ufpi
 */
public class maquina_utilizada {

    public static void main(String[] args) {
        Thread tsensor3 = new Thread(new Runnable() {
            @Override
            public void run() {
                try {

                    ServerSocket servidor3 = new ServerSocket(9008);
                    System.out.println("Esperando cliente se conectar ao servidor pela porta 9008");
                    while (true) {

                        Socket cliente3 = servidor3.accept();
                        System.out.println("Cliente " + cliente3.getInetAddress().getHostAddress() + "conectado...");

                        //ObjectOutputStream saida = new ObjectOutputStream(cliente3.getOutputStream());
                        //ObjectInputStream inFromClient = new ObjectInputStream(cliente3.getInputStream());
                        System.out.println("Esperando dados do cliente");
                        Scanner entrada = new Scanner(cliente3.getInputStream());

                        String recebe = entrada.nextLine();

                        System.out.println("Recebido: " + recebe);

                        cliente3.close();
                    }

                } catch (Exception a) {
                    System.out.println("Ocorreu um problema com cliente 3" + a.getMessage());

                }
            }
        });
        tsensor3.start();

    }
}
