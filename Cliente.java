package servidor;

import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.util.Scanner;

public class Cliente {
    
    public static void main(String []args){
        DatagramSocket server;
        DatagramPacket pacote;
        InetAddress ender;
        byte[] dados;
        
        try{
            ender = InetAddress.getByName("127.0.0.1");
            Scanner entrada = new Scanner(System.in);
            
            String msg = "Hello server";
           do{
                msg = entrada.nextLine();
                dados = msg.getBytes();
                pacote = new DatagramPacket(dados, dados.length, ender, 4477);

                server = new DatagramSocket();
                server.send(pacote);

                System.out.println(":"+pacote.getPort());
            }while(!msg.equals("exit"));

        }catch (Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
}
