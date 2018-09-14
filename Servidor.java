/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package servidor;
     
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class Servidor {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        DatagramSocket server;
        DatagramPacket pacote;
        InetAddress ender;
        byte[] dados;
        
        try{
            server = new DatagramSocket(4477);
            String msg;
            do{
                dados = new byte[1024];
                pacote = new DatagramPacket(dados, dados.length);
                System.out.println("Aguardando dados...");
                server.receive(pacote);

                msg = new String(pacote.getData());
                System.out.println("Recebido: "+msg);
                System.out.println("De: "+pacote.getAddress().getHostAddress());
                System.out.println(":"+pacote.getPort());
            }while(!msg.contains("exit"));
        }catch (Exception e){
            System.out.println("Erro: "+e.getMessage());
        }
    }
    
}
