/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tp_estacionamento;

import java.util.Date;

/**
 *
 * @author aluno
 */
public class Moto extends Veiculo {

    public Moto(String placa,  Date entrada) {
        this.placa = placa;
        this.preco = 0.040;
        this.entrada = entrada;
    }
    public Moto(String placa,  Date entrada, String modelo) {
        this.placa = placa;
        this.preco = 0.040;
        this.entrada = entrada;
        this.modelo = modelo;
    }
    @Override
    public double TotalPagamento(long minutos) {
       return (minutos) * 0.040;
    }

   
}
