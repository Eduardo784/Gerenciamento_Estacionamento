/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_estacionamento;

import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import javax.swing.JOptionPane;
import tp_estacionamento.Interface.Cadastro;
//import tp_estacionamento.Interface.Cadastro;

/**
 *
 * @author aluno
 */
public class Main_menu {

    protected ArrayList<Veiculo> veiculos = new ArrayList();

    public static void imprimeMenu() {
        Main_menu menu = new Main_menu();
    }

    public Main_menu() {
        Scanner leitor = new Scanner(System.in);
        Carro CarroAtual;
        Moto MotoAtual;
        // TODO code application logic here
        int opc;
        int opc2;
        do {
            Scanner s = new Scanner(System.in);
            System.out.println("--------ESTACIONAMENTO--------");
            System.out.println("1.)Entrar no Estacionamento");
            System.out.println("2.)Pagar");
            System.out.println("3.)Listar Estacionamento");
            System.out.println("0.) Sair");
            System.out.print("Opção Escolhida:");
            opc = s.nextInt();
            if (0 > opc || opc > 3) {
                System.out.println("!!!OPCAO_INVALIDA!!!");
            }
            switch (opc) {
                case 0:
                    Veiculo.verificaSeTemVeiculo(veiculos);
                    break;
                case 1:
                    do {
                        System.out.println("--------ENTRAR_NO_ESTACIONAMENTO--------");
                        System.out.println("1.)Entrar com Carro");
                        System.out.println("2.)Entrar com Moto");
                        System.out.println("0.)Voltar");
                        System.out.print("Opção Escolhida:");
                        opc2 = s.nextInt();
                        if (0 > opc2 || opc2 > 2) {
                            System.out.println("!!!OPCAO_INVALIDA!!!");
                        }
                        switch (opc2) {

                            case 1:
                                String placa1;

                                System.out.println("--------MENU_CARRO--------");
                                do {
                                    System.out.print("Informe a Placa do Seu Veiculo: ");
                                    placa1 = s.next();
                                } while (Veiculo.verificaSeTemPlacaIgual(veiculos, placa1) == true); // Verifica se a placa e igual

                                //ADICIONAR UM CARRO NO VETOR DE VEICULOS COM ESSA PLACA E SALVAR O HORARIO DE ENTRADA
                                Date entrada = new Date();
                                CarroAtual = new Carro(placa1, entrada);
                                veiculos.add(CarroAtual);
                                //MOSTRAR O HORARIO DE ENTRADA
                                System.out.println("Horario de Entrada:");
                                System.out.println(CarroAtual.getEntrada());

                                break;
                            case 2:
                                String placa2;
                                System.out.println("--------MENU_MOTO--------");
                                do {
                                    System.out.print("Informe a Placa do Seu Veiculo: ");
                                    placa2 = s.next();
                                } while (Veiculo.verificaSeTemPlacaIgual(veiculos, placa2) == true); // Verifica se a placa e igual
                                //Verifica Se a placa e unica
                                Veiculo.verificaSeTemPlacaIgual(veiculos, placa2);
                                //ADICIONAR UMA MOTO NO VETOR DE VEICULOS COM ESSA PLACA E SALVAR O HORARIO DE ENTRADA
                                Date entrada2 = new Date();
                                MotoAtual = new Moto(placa2, entrada2);
                                veiculos.add(MotoAtual);
                                //MOSTRAR O HORARIO DE ENTRADA
                                System.out.println("Horairo de Entrada:");
                                System.out.println(MotoAtual.getEntrada());
                                break;
                        }
                    } while (opc2 != 0);
                    break;
                case 2:
                    String placaPagar = null;
                    System.out.println("--------PAGAMENTO--------");
                    do {
                        if (veiculos.isEmpty() == true) {
                            JOptionPane.showMessageDialog(null, "Estacionamento vazio!!");
                            break;
                        }
                        System.out.println("Informe a Placa do Veiculo:");
                        placaPagar = s.next();
                    } while (Veiculo.verificaSeVeiculoExiste(veiculos, placaPagar) == false);

                    for (int x = 0; x < veiculos.size(); x++) {
                        if ((veiculos.get(x)).getPlaca().equals(placaPagar)) {
                            Veiculo veiculo = veiculos.get(x);
                            Date data_saida = new Date();
                            long minutos_permanecidos = (((data_saida.getTime() - veiculo.getEntrada().getTime()) / 1000) / 60);
                            //Horario de Entrada
                            System.out.println("Horario de Entrada: " + veiculo.getEntrada());
                            //Horario de Saida
                            System.out.println("Horario de saida: " + data_saida);
                            System.out.println("Minutos Permanecidos:" + minutos_permanecidos);

                            double preco = veiculo.TotalPagamento(minutos_permanecidos);

                            System.out.printf("Valor a Pagar: R$ %.2f\n", preco);
                            veiculos.remove(x);
                            
                            System.out.println("Digite S ou s para dar o recibo ao cliente:");
                            String sim = leitor.next();
                            if (sim.equals("s") || sim.equals("S")) {
                                int opcao;
                                do {
                                    System.out.println("[1]Para imprimir o recibo");
                                    System.out.println("Digite a opçao desejada:");
                                    opcao = leitor.nextInt();
                                    switch (opcao) {
                                        case 1:
                                            JOptionPane.showMessageDialog(null, "Horario de Entrada: " + veiculo.getEntrada() + "\n" + "Horario de saida: " + data_saida + "\n" + "Minutos Permanecidos:" + minutos_permanecidos + "\n" + "Valor a Pagar: R$" + preco, "Impressao", 1);
                                            break;
                                        default:
                                            System.out.println("Opçao Invalida!!");
                                    }
                                } while(opcao != 1);

                            } else {
                                break;
                            }

                        }
                    }
                    //PESQUIAR PELA PLACA EM TODO O ARRAY E, CASO ENTRADO, PUXAR SUAS INFORMACOES
                    //MOSTRAR O HORARIO ATUAL E O HORARIO DE ENTRADA
                    //CHAAMAR METODO DE PRECO
                    break;
                case 3:
                    System.out.println("Imprimindo Listas!!!");
                    Veiculo.retornaVeiculo(veiculos);
                    break;
            }
        } while (true);
    }

    public static void main(String args[]) {
        Cadastro.Interface();
    }
    
}
