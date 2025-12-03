package Herancas;

import javax.swing.JOptionPane;

public class Cadastro extends Servico {
    private Animal animalCadastrado;
    private Medico medicoCadastrado;
    private String[] opcoes = {"Animal Exótico", "Animal Doméstico"};



    @Override
    public void cadastrarAnimal() {
        animalCadastrado = new Animal();

        // TIPO DO ANIMAL (EXÓTICO OU NÃO)
        boolean resultado = false;
        int exoticoAnimal = -1;
        while (exoticoAnimal != 0 && exoticoAnimal != 1) {
            exoticoAnimal = JOptionPane.showOptionDialog(
                    null,
                    "Que tipo de animal deseja cadastrar?",
                    "Cadastro de Animal",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    opcoes,
                    opcoes[1]
            );

            if (exoticoAnimal == JOptionPane.CLOSED_OPTION) {
                JOptionPane.showMessageDialog(null, "Escolha uma opção.");
            }

            animalCadastrado.setAnimalExotico(exoticoAnimal == 0);
            if (exoticoAnimal == 0) {
                int temCertificado = JOptionPane.showConfirmDialog(
                        null,
                        "Você possui o certificado do Ibama para este animal?",
                        "Certificado Animal Exótico",
                        JOptionPane.YES_NO_OPTION
                );
                if (temCertificado == JOptionPane.NO_OPTION) {
                    // Mensagem de cancelamento
                    JOptionPane.showMessageDialog(null, "Cadastro cancelado. A clínica só pode registrar animais exóticos que possuem certificado do Ibama.");

                    return;
                }

                // Se chegou aqui, o usuário disse 'Sim'
                animalCadastrado.setPossuiCertificado(true);


            } else {

                animalCadastrado.setPossuiCertificado(false);
            }
        }




        // NOME DO ANIMAL
        String animalNome = null; // Inicializa com null
        while (animalNome == null) {
            String inputNome = JOptionPane.showInputDialog("Digite o nome do seu animal: ");

            if (inputNome == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
            } else if (inputNome.equals("")) {

                JOptionPane.showMessageDialog(null, "Nome inválido! Digite novamente.");
            } else {

                animalNome = inputNome;
                animalCadastrado.setNomeAnimal(animalNome);
            }
        }


        // IDADE DO ANIMAL
        int salvarIdade = -1;
        while (salvarIdade < 0){
            String animalIdadeString = JOptionPane.showInputDialog("Digite a idade do seu animal: ");
            int idadeDigitada = Integer.parseInt(animalIdadeString);
            if (idadeDigitada < 0) {
                JOptionPane.showMessageDialog(null, "Idade não pode ser negativa! Digite novamente.");
            } else {
                salvarIdade = idadeDigitada;
                animalCadastrado.setIdadeAnimal(salvarIdade);
                break;
            }
            animalCadastrado.setIdadeAnimal(salvarIdade);

        }


        // PORTE DO ANIMAL (P, M ou G)
        String animalPorte = null;
        while (animalPorte == null) {
            String inputPorte = JOptionPane.showInputDialog("Digite o porte do seu animal (P, M ou G): ");

            if (inputPorte == null) {
                JOptionPane.showMessageDialog(null, "Operação cancelada.");
            } else {
                String porteMaiusculo = inputPorte.toUpperCase();

                if (porteMaiusculo.equals("P")) {
                    animalPorte = porteMaiusculo;
                    animalCadastrado.setPorteAnimal(animalPorte);
                } else if (porteMaiusculo.equals("M")) {
                    animalPorte = porteMaiusculo;
                    animalCadastrado.setPorteAnimal(animalPorte);
                } else if (porteMaiusculo.equals("G")) {
                    animalPorte = porteMaiusculo;
                    animalCadastrado.setPorteAnimal(animalPorte);
                } else {
                    JOptionPane.showMessageDialog(null, "Digite apenas P, M ou G.");
                    // animalPorte continua null, e o loop continua
                }
            }
        }


        // DOSES DE VACINA


        int salvarDoses = -1;
        while (salvarDoses < 0) {
            String animalDosesString = JOptionPane.showInputDialog("Quantas doses da vacina seu animal tomou: ");


            int dosesDigitadas = Integer.parseInt(animalDosesString);

            if (dosesDigitadas < 0) {
                JOptionPane.showMessageDialog(null, "Número inválido! Não pode ser negativo. Digite novamente.");
            } else {

                salvarDoses = dosesDigitadas;
                animalCadastrado.setNumeroDosesVacina(salvarDoses);
                break;
            }
        }

        GerenciarClinica.adicionarCadastro(this);

        JOptionPane.showMessageDialog(null, "Animal '" + animalCadastrado.getNomeAnimal() + "' cadastrado com sucesso!");
    }

    @Override
    public void notificar() {

    }

    @Override
    public void enviarNotificacao() {

    }

    @Override
    public void cadastrarMedico() {
        medicoCadastrado = new Medico();


        String medicoNome = null;
        while (medicoNome == null) {
            String inputNome = JOptionPane.showInputDialog("Digite o nome do Veterinário: ");

            if (inputNome == null) {
                JOptionPane.showMessageDialog(null, "Cadastro de médico cancelado.");
                return;
            } else if (inputNome.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Nome inválido! Digite novamente.");
            } else {
                medicoNome = inputNome;
                medicoCadastrado.setNomeVeterinario(inputNome);
            }
        }

        // CRM DO MÉDICO
        int salvarCRM = -1;
        while (salvarCRM < 0) {
            String crmMedico = JOptionPane.showInputDialog("Digite o CRM (Apenas 6 dígitos): ");

            if (crmMedico == null) {
                JOptionPane.showMessageDialog(null, "Cadastro de médico cancelado.");
                return;
            }

            // 1. VERIFICAÇÃO DE 6 DÍGITOS
            if (crmMedico.length() != 6) {
                JOptionPane.showMessageDialog(null, "Erro! O CRM deve ter **exatamente 6 dígitos**. Digite novamente.");
                continue;
            }

            // 2. CONVERSÃO E TRATAMENTO DE ERROS (try-catch)
            try {
                int numeroCRM = Integer.parseInt(crmMedico);

                if (numeroCRM <= 0) {
                    JOptionPane.showMessageDialog(null, "CRM Inválida. O número deve ser positivo.");
                } else {
                    salvarCRM = numeroCRM;
                    medicoCadastrado.setCrm(salvarCRM);
                    break; // Sai do loop
                }

            } catch (NumberFormatException e) {

                JOptionPane.showMessageDialog(null, "Erro! O CRM deve conter apenas **números**.");
            }
        }


        GerenciarClinica.adicionarMedico(medicoCadastrado);

        JOptionPane.showMessageDialog(null, "Veterinário '" + medicoCadastrado.getNomeVeterinario() + "' cadastrado com sucesso!");
    }



    public Animal getAnimalCadastrado() {
        return animalCadastrado;
    }
    public Medico getMedicoCadastrado() {
        return medicoCadastrado;
    }
    public void setAnimalCadastrado(Animal animalCadastrado) {
        this.animalCadastrado = animalCadastrado;
    }
    public void setMedicoCadastrado(Medico medicoCadastrado) {
        this.medicoCadastrado = medicoCadastrado;
    }
}