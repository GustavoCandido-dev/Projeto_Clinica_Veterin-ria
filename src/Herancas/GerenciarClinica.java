package Herancas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GerenciarClinica {
    private static ArrayList<Cadastro> listaDeCadastros = new ArrayList<>();

    public static void adicionarCadastro(Cadastro novoCadastro) {
        listaDeCadastros.add(novoCadastro);
    }

    public static ArrayList<Cadastro> getListaDeCadastros() {
        return listaDeCadastros;
    }

    public static void exibirCadastros() {
        if (listaDeCadastros.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum animal cadastrado ainda.");
            return;
        }
        String mensagem = "=== Animais Cadastrados ===\n";
        for (Cadastro cadastro : listaDeCadastros) {
            Animal animal = cadastro.getAnimalCadastrado();
            Medico medico = cadastro.getMedicoCadastrado();

            if (animal != null) {
                String mensagemAnimal = "=== Animais Cadastrados ===\n";
                mensagem = mensagem + "Nome: " + animal.getNomeAnimal() +
                        ", Idade: " + animal.getIdadeAnimal() +
                        ", Porte: " + animal.getPorteAnimal() +
                        ", Exótico: " + (animal.isAnimalExotico() ? "Sim" : "Não") +
                        ", Doses Vacina: " + animal.getNumeroDosesVacina() + "\n";
            }

            if (medico != null) {
                String mensagemMedico = "=== Médicos Cadastrados ===\n";
                mensagem = mensagem + "Veterinário: " + medico.getNomeVeterinario() +
                    " (CRM: " + medico.getCrm() + ")\n";
        }

         mensagem = mensagem + "---------------------------\n";
    }
        JOptionPane.showMessageDialog(null, mensagem);
    }

}