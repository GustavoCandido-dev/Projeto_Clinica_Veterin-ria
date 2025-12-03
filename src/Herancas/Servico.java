package Herancas;

import Interface.Clinica;

public abstract class Servico implements Clinica {
    protected String nomeAnimal;
    protected int idadeAnimal;
    protected int numeroDosesVacina;
    protected boolean animalExotico;
    protected String porteAnimal;

    protected String nomeVeterinario;
    protected int crm;

    public String getNomeAnimal() {
        return nomeAnimal;
    }

    public void setNomeAnimal(String nomeAnimal) {
        this.nomeAnimal = nomeAnimal;
    }

    public boolean isAnimalExotico() {
        return animalExotico;
    }

    public void setAnimalExotico(boolean animalExotico) {
        this.animalExotico = animalExotico;
    }

    public int getIdadeAnimal() {
        return idadeAnimal;
    }

    public void setIdadeAnimal(int idadeAnimal) {
        this.idadeAnimal = idadeAnimal;
    }

    public int getNumeroDosesVacina() {
        return numeroDosesVacina;
    }

    public void setNumeroDosesVacina(int numeroDosesVacina) {
        this.numeroDosesVacina = numeroDosesVacina;
    }

    public String getNomeVeterinario() {
        return nomeVeterinario;
    }

    public String getPorteAnimal() {
        return porteAnimal;
    }

    public void setPorteAnimal(String porteAnimal) {
        this.porteAnimal = porteAnimal;
    }

    public void setNomeVeterinario(String nomeVeterinario) {
        this.nomeVeterinario = nomeVeterinario;
    }

    public int getCrm() {
        return crm;
    }

    public void setCrm(int crm) {
        this.crm = crm;
    }


    @Override
    public abstract void cadastrarAnimal();

    @Override
    public abstract  void cadastrarMedico();




}
