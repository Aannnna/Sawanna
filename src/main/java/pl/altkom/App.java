package pl.altkom;

import pl.altkom.animals.Animal;
import pl.altkom.animals.Herbivore;
import pl.altkom.animals.Predator;
import pl.altkom.plants.Acacia;

public class App {
    public static void main(String[] args) {
        //Cykl "trwania" sawanny
        int days = 6;
// Tworzenie sawanny
        Savanna savanna = new Savanna(7, 7, 20, 15, 15, 7);

//Pętla dnia na sawannie
        for (int i = 0; i < days; i++) {
            //Wzrost roślin
            savanna.oneDay();
            //Pozycja początkowa, ruch i jedzenie zwierząt
            for (Animal animal : savanna.getAnimals()) {
                animal.oneDay(savanna);
            }
            savanna.getAnimals().removeIf(animal -> savanna.getPreys().contains(animal));
            //Stan roślin i zwierząt w poszczególnych komórkach
            System.out.println("Podsumowanie stanu w komórkach");
            for (int k = 0; k < savanna.getRows(); k++) {
                for (int j = 0; j < savanna.getCols(); j++) {
                    System.out.println("komórka " + k + ", " + j + ":");
                    savanna.getConcreteCell(k, j).getPlant().show();
                    System.out.println(savanna.getConcreteCell(k, j).toString());
                }
            }
            //Podsumowanie ilosci zwierząt na całej sawannie po danym dniu
            System.out.println("Na sawannie żyje " + savanna.getAnimals().size() + " zwierząt");
        }

        /* Pozostałe metody mogące się do czegoś przydać

//Pozycja zwierząt

        for (Animal animal : savanna.getAnimals()) {
            animal.position();
        }

// zwierzęta jedzą
        for (Animal animal : savanna.getAnimals()) {
            animal.eat(savanna);
        }

//usuwanie zjedzonych zwierząt
        savanna.getAnimals().removeIf(animal -> savanna.getPreys().contains(animal));

// poruszanie się zwierząt
        for (Animal animal : savanna.getAnimals()) {
            animal.move(savanna);
        }

   */

    }

}
