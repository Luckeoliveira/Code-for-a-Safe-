package Safe;

import java.util.ArrayList;

public class Cofre {

//Metodo para criar a listagem das moedas

    private ArrayList <Moeda>  coinList;

    public Cofre() {
        this.coinList = new ArrayList<>();


    }
//Metodo para Adicionar Moedas

    public void adicionar(Moeda coin) {

        this.coinList.add(coin);

    }

    //Metodo para Remover Moedas
    public boolean remover(Moeda coin) {
        return this.coinList.remove(coin);
    }

    //metodo para caso a lista estiver vazia, mostrar ao usuario que esta vazia.
    public void listedCoin() {
        if(this.coinList.isEmpty()) {
            System.out.println("**********************************");
            System.out.println("* Voce não possui nenhuma Moeda  *");
            System.out.println("**********************************");
        }

        for (Moeda coin : this.coinList) {
            coin.info();

        }
    }

//Metodo para converter os valores das moedas em Real

    public double ConvertedValue() {

        if(this.coinList.isEmpty()){
            return 0;
        }

        double convertedValue = 0;
        for (Moeda coin : this.coinList) {
            convertedValue = convertedValue + coin.converter();
        }
        return convertedValue;
    }
}
