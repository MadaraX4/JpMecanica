package Model;

import Model.DAO.OsDAO;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class ListaCarros {

    public List<Integer> listaPorMes() {
        OsDAO dao = new OsDAO();
        List<Integer> listaNcarros = new ArrayList<>();

        LocalDate hoje = LocalDate.now();
        int mesAtual = hoje.getMonthValue();
        int anoAtual = hoje.getYear();

        for (int i = 0; i < 6; i++) {

            int mes = mesAtual - (5 - i);
            int ano = anoAtual;

            if (mes < 1) {
                mes += 12;
                ano -= 1;
            }
            int total = dao.carrosNoMes(mes, ano);
            listaNcarros.add(total);
        }
        return listaNcarros;
    }

    public List<Integer> listaPorAno(int ano) {
        OsDAO dao = new OsDAO();
        List<Integer> lista = new ArrayList<>();

        for (int i = 1; i < 13; i++) {
            int mes = i;
            int total = dao.carrosNoMes(mes,ano);
           
            if(total != 0){
            lista.add(total);
            }else{
            lista.add(0);
            }
            

        }
        return lista;
    }

}
