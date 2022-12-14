import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketTimeoutException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        try (DatagramSocket socket = new DatagramSocket()) {
            InetAddress address = InetAddress.getLocalHost();


            Scanner scanner = new Scanner(System.in);
            String echoString;

            do {
                System.out.println("Enter String to be echoed");
                echoString = scanner.nextLine();

                byte[] buffer = echoString.getBytes();

                DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, 5000);
                socket.send(packet);

                byte[] buffer2 = new byte[50];
                packet = new DatagramPacket(buffer2, buffer2.length);
                socket.receive(packet);

                System.out.println("Text received: " + new String(buffer2, 0, packet.getLength()));
            } while (!echoString.equalsIgnoreCase("exit"));


        } catch (SocketTimeoutException e) {
            System.out.println("Socket Timed out: " + e.getMessage());
        } catch (IOException exception) {
            System.out.println("Client error: " + exception.getMessage());
        }
    }
}