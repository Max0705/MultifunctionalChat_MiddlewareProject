package Test;
import Frame.LoginFrame;
import Frame.MainFrame;
import javax.jms.Connection;
import org.apache.activemq.ActiveMQConnection;

public class test {
    public static void main(String[] args){
        LoginFrame lg = new LoginFrame();
        lg.setVisible(true);
        //MainFrame a = new MainFrame();
    }
}
