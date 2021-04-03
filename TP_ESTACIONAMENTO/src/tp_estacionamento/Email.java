package tp_estacionamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.Properties;
import javax.mail.Address;
import javax.mail.AuthenticationFailedException;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.PasswordAuthentication;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeMessage;
import javax.swing.JOptionPane;

public class Email{

    public Email(String email) {
        
        Properties props = new Properties();
        /**
         * Parâmetros de conexão com servidor Gmail
         */
        props.put("mail.smtp.host", "smtp.gmail.com");
        props.put("mail.smtp.socketFactory.port", "465");
        props.put("mail.smtp.socketFactory.class", "javax.net.ssl.SSLSocketFactory");
        props.put("mail.smtp.auth", "true");
        props.put("mail.smtp.port", "465");

        Session session = Session.getDefaultInstance(props, new javax.mail.Authenticator() {
            protected PasswordAuthentication getPasswordAuthentication() {
                return new PasswordAuthentication("eduardoafonso1234567@gmail.com", "ed35232084");
            }
        });

        /**
         * Ativa Debug para sessão
         */
        session.setDebug(true);

        try {

            Message message = new MimeMessage(session);
            message.setFrom(new InternetAddress("eduardoafonso1234567@gmail.com")); //Remetente

            Address[] toUser = InternetAddress //Destinatário(s)
                    .parse(email);

            message.setRecipients(Message.RecipientType.TO, toUser);
            message.setSubject("Recibo");//Assunto
            message.setText("Testando envio de email!!");
            /**
             * Método para enviar a mensagem criada
             */
            Transport.send(message);

        } catch (AuthenticationFailedException ex) {
            JOptionPane.showMessageDialog(null, "Email/Senha Invalidos!");
        } catch (MessagingException e) {
            throw new RuntimeException(e);
        }
    }

    public static void PassaVeiculo(ArrayList<Veiculo> veiculos, String placa) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getPlaca().equals(placa)) {
                Veiculo veiculo = veiculos.get(i);
                Date data_saida = new Date();
                long minutos_permanecidos = (((data_saida.getTime() - veiculo.getEntrada().getTime()) / 1000) / 60);
                //Horario de Entrada
                System.out.println("Horario de Entrada: " + veiculo.getEntrada());
                //Horario de Saida
                System.out.println("Horario de saida: " + data_saida);
                System.out.println("Minutos Permanecidos:" + minutos_permanecidos);

                double preco = veiculo.TotalPagamento(minutos_permanecidos);

                System.out.printf("Valor a Pagar: R$ %.2f\n", preco);
            }
        }
    }
}
