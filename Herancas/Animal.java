package Herancas;

public class Animal {
    private String nomeAnimal;
    private int idadeAnimal;
    private int numeroDosesVacina;
    private boolean animalExotico;
    private String porteAnimal;

    public Animal() {} // Construtor

    public String getNomeAnimal() { return nomeAnimal; }
    public void setNomeAnimal(String nomeAnimal) { this.nomeAnimal = nomeAnimal; }
    public int getIdadeAnimal() { return idadeAnimal; }
    public void setIdadeAnimal(int idadeAnimal) { this.idadeAnimal = idadeAnimal; }
    public int getNumeroDosesVacina() { return numeroDosesVacina; }
    public void setNumeroDosesVacina(int numeroDosesVacina) { this.numeroDosesVacina = numeroDosesVacina; }
    public boolean isAnimalExotico() { return animalExotico; }
    public void setAnimalExotico(boolean animalExotico) { this.animalExotico = animalExotico; }
    public String getPorteAnimal() { return porteAnimal; }
    public void setPorteAnimal(String porteAnimal) { this.porteAnimal = porteAnimal; }
}