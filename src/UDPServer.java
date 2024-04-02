import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class UDPServer {
    public static void main(String a[]) throws Exception {
        DatagramSocket dsS = new DatagramSocket(9999);
        byte[] b1 = new byte[1024];

        DatagramPacket dpS = new DatagramPacket(b1,b1.length);
        dsS.receive(dpS);
        String str = new String(dpS.getData(),0, dpS.getLength());
        int num = Integer.parseInt(str.trim());
        int result = num*num;
        byte[] b2 = (result + "").getBytes();
        InetAddress ia = InetAddress.getLocalHost();
        DatagramPacket dp1 = new DatagramPacket(b2,b2.length,ia,dpS.getPort());
        dsS.send(dp1);
     }

}
