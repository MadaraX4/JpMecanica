package Model;

import Model.DAO.FluxoDeCaixaDAO;
import java.text.DecimalFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaLucro {

    public List<Double> criaLista() {
        FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
        List<Double> saldoUltimosMeses = new ArrayList<>();
        LocalDate dataAtual = LocalDate.now();

        int mesAtual = dataAtual.getMonthValue();
        int anoAtual = dataAtual.getYear();

        for (int i = 0; i < 6; i++) {
            int mes = mesAtual - (5 - i);
            int ano = anoAtual;

            if (mes < 1) {
                mes += 12;
                ano -= 1;
            }
            double saida = dao.somaSaida(mes, ano);
            double entrada = dao.somaEntrada(mes, ano);
            double saldo = entrada - saida;
            saldoUltimosMeses.add(saldo);
        }
        return saldoUltimosMeses;
    }

    public List<Double> listaPorAno(int ano) {
        FluxoDeCaixaDAO dao = new FluxoDeCaixaDAO();
        List<Double> saldoUltimosMeses = new ArrayList<>();
        LocalDate dataAtual = LocalDate.now();

        for (int i = 1; i < 13; i++) {

            double saida = dao.somaSaida(i, ano);
            double entrada = dao.somaEntrada(i, ano);
            double saldo = entrada - saida;

            saldoUltimosMeses.add(saldo);
        }
        return saldoUltimosMeses;
    }

}
