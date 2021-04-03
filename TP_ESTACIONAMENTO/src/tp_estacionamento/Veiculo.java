/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_estacionamento;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.JOptionPane;

/**
 *
 * @author aluno
 */
public abstract class Veiculo {

    protected Date entrada;
    protected String placa, modelo;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
    protected double preco;

    public Date getEntrada() {
        return entrada;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getPlaca() {
        return placa;
    }

    public static void verificaSeTemVeiculo(ArrayList<Veiculo> veiculos) {
        if (veiculos.isEmpty() == true) {
            System.out.println("Saindo com Sucesso!!");
            System.exit(0);
        } else {
            JOptionPane.showMessageDialog(null, "Ainda o estacionamento possui veículos, por favor remova todos veículos antes de fechar o programa!!");
        }

    }

    public static boolean verificaSeVeiculoExiste(ArrayList<Veiculo> veiculos, String placa) {
        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getPlaca().equals(placa)) {
                return true;
            }

        }
        JOptionPane.showMessageDialog(null, "Veiculo nao existente, tente novamente!!");
        return false;
    }

    public static void retornaVeiculo(ArrayList<Veiculo> veiculos) {
        Date currentDate = new Date();
        long ms = currentDate.getTime();
        for (int i = 0; i < veiculos.size(); i++) {
            System.out.println(i + " - Placa: " + veiculos.get(i).getPlaca() + ", entrada:" + veiculos.get(i).getEntrada() + ", tempo(m): " + (((ms - veiculos.get(i).getEntrada().getTime()) / 1000) / 60));
        }
    }

    public static boolean verificaSeTemPlacaIgual(ArrayList<Veiculo> veiculos, String placa) {

        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getPlaca().equals(placa)) {
                JOptionPane.showMessageDialog(null, "Veiculos com Paclas iguais!!");
                return true;
            }

        }
        return false;
    }

    public abstract double TotalPagamento(long minutos);

}
