package com.acctmq.activemqexample;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.jms.*;
import org.apache.activemq.*;

public class ObjectProducer extends Thread {

    public static final Logger LOG = Logger.getLogger(ObjectProducer.class.getName());

    private static String url = ActiveMQConnection.DEFAULT_BROKER_URL;

    private static String subject = "TESTQUEUE-object";

    @Override
    public void run() {
        while (true) {
            try {
                ConnectionFactory connectionFactory = new ActiveMQConnectionFactory(url);
                Connection connection = connectionFactory.createConnection();
                connection.start();

                Session session = connection.createSession(false,Session.AUTO_ACKNOWLEDGE);

                Destination destination = session.createQueue(subject);

                MessageProducer producer = session.createProducer(destination);

                Veiculo veic = new Veiculo();
                veic.setAno(2000);
                veic.setNomeCliente("Sales");
                veic.setMarcaVeiculo("Monza");
                veic.setValorVenda(200.00);
                javax.jms.ObjectMessage message;
                message = session.createObjectMessage(veic);

                producer.send(message);
                System.out.println("" + ((Veiculo)message.getObject()).getNomeCliente()+ "\n" + ((Veiculo)message.getObject()).getMarcaVeiculo()+ "\n" + ((Veiculo)message.getObject()).getAno()+ "\n" + ((Veiculo)message.getObject()).getValorVenda());

                connection.close();
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
