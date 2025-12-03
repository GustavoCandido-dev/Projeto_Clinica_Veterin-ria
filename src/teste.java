import Herancas.Cadastro;
import Herancas.GerenciarClinica;

public class teste {
    static void main(String[] args){
        Cadastro c = new Cadastro();

        c.cadastrarMedico();
        GerenciarClinica.exibirCadastros();

    }
}
