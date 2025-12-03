package Herancas;
import java.util.ArrayList;
import javax.swing.JOptionPane;

public class GerenciarClinica {
    private static ArrayList<Cadastro> listaDeCadastros = new ArrayList<>();
    private static ArrayList<Medico> listaDeMedicos = new ArrayList<>();

    public static void adicionarCadastro(Cadastro novoCadastro) {
        listaDeCadastros.add(novoCadastro);
    }

    public static void adicionarMedico(Medico novoMedico) {
        listaDeMedicos.add(novoMedico);
    }

    public static ArrayList<Cadastro> getListaDeCadastros() {
        return listaDeCadastros;
    }

    public static ArrayList<Medico> getListaDeMedicos() {
        return listaDeMedicos;
    }
        // EXIBIR ANIMAIS
    public static void exibirAnimais() {
        String mensagem = "";

        mensagem += "=== ANIMAIS CADASTRADOS ===\n";

        if (listaDeCadastros.isEmpty()) {
            mensagem += "(Nenhum animal cadastrado)\n";
        } else {
            for (Cadastro cadastro : listaDeCadastros) {
                Animal animal = cadastro.getAnimalCadastrado();

                if (animal != null) {
                    mensagem += "Nome: " + animal.getNomeAnimal() +
                            " | Idade: " + animal.getIdadeAnimal() +
                            " | Porte: " + animal.getPorteAnimal() +
                            " | Exótico: " + (animal.isAnimalExotico() ? "Sim" : "Não") +
                            "\n---------------------------\n";
                }
            }
        }
        JOptionPane.showMessageDialog(null, mensagem);
    }
    public static void exibirMedicos() {
        String mensagem = "=== MÉDICOS CADASTRADOS ===\n";

        if (listaDeMedicos.isEmpty()) {
            mensagem += "(Nenhum médico cadastrado)\n";
        } else {
            // Itera apenas sobre a nova lista de médicos
            for (Medico medico : listaDeMedicos) {
                mensagem += "Veterinário: " + medico.getNomeVeterinario() +
                        " | CRM: " + medico.getCrm() +
                        "\n---------------------------\n";
            }
        }

        JOptionPane.showMessageDialog(null, mensagem);
    }
}