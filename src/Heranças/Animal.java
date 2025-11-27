package Heranças;

public class Animal extends Servico{
    protected String raca;
    protected String pelo_cor;
    public Animal(String nomeAnimal, String raca, String pelo_cor, String porte) {
        super(nomeAnimal, porte);
        this.raca = raca;
        this.pelo_cor = pelo_cor;
    }
}
