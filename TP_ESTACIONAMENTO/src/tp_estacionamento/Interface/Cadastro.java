/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_estacionamento.Interface;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import tp_estacionamento.Main_menu;

/**
 *
 * @author eduardo
 */
public class Cadastro {

    private Object passwordField;

    public static void Interface() {

        final JFrame cadastro = new JFrame("Estacionamento");
        cadastro.setLayout(new FlowLayout());
        // Nome do Usuário
        final JPanel nome = new JPanel();
        nome.setLayout(new FlowLayout());
        nome.add(new JLabel("Login:"));
        final JTextField txtNome = new JTextField(10);
        nome.add(txtNome);
        cadastro.add(nome);
        //Senha Usuário
        final JPanel senha = new JPanel();
        senha.setLayout(new FlowLayout());
        senha.add(new JLabel("Senha:"));
        final JPasswordField txtSenha = new javax.swing.JPasswordField(10);
        senha.add(txtSenha);
        cadastro.add(senha);

        JButton acesso = new JButton("Acesso");
        JButton exit = new JButton("Sair");
        JButton limpa = new JButton("Limpa");

        cadastro.add(acesso);
        cadastro.add(exit);
        cadastro.add(limpa);
        final ImageIcon img = new ImageIcon("imagem.jpeg");
                //pega a altura e largura
        //container onde serão adicionados todos componentes
        Container container = cadastro.getContentPane();
        int altura = img.getIconHeight();
        int largura = img.getIconWidth();
        JLabel label = new JLabel(img);
        //adiciona a imagem em um label
        JLabel panel = new JLabel(img);
        panel.add(label, BorderLayout.SOUTH);
        //adiciona o panel no container
        container.add(panel, BorderLayout.CENTER);

        cadastro.pack();

        cadastro.setVisible(true);
        cadastro.setSize(250, 350);//350,250
        exit.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                JOptionPane.showMessageDialog(null, "Fim!");
                System.exit(0);
            }
        });
        limpa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                txtNome.setText("");
                txtSenha.setText("");

            }
        });
        acesso.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent ev) {
                if (txtNome.getText().equals("abc") && txtSenha.getText().equals("1234567")) {
                    Main_menu.imprimeMenu();
                } else {
                    JOptionPane.showMessageDialog(null, "Usuario ou senha incorreto!!");
                    System.exit(0);

                }

            }
        });
    }
}
