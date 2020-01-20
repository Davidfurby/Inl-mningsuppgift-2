package Animals;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

class Hub {

    private Scanner sc = new Scanner(System.in);
    private int year;
    private int daysInYear = 365;

    //Created three ArrayList to hold an unlimited amount of different animals
    private List<Dog> dogs = new ArrayList<>();
    private List<Elephant> elephants = new ArrayList<>();
    private List<Parrot> parrots = new ArrayList<>();
    Hub() {
        System.out.println("Start");
        menu();
    }

    private void menu() {
        Scanner sc = new Scanner(System.in);
        String menu;
        System.out.println("For new animal, press: 1. \nTo start first day, press: 2. \nTo show all animals, press 3. \nTo exit, press: 4.");
        while (true) {
            menu = sc.next();
            switch (menu) {
                case "1":
                    selectAnimal();
                    break;
                case "2":
                    startDay();
                    break;
                case "3":
                    printAllAnimals(1);
                    break;
                case "4":
                    exit();
            }
        }
    }

    private void selectAnimal() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Choose your Animal. \nFor Dog, press: 1. For Parrot, press: 2. For Elephant, press: 3");
        String animalSelect;
        while (true) {
            animalSelect = sc.next();
            switch (animalSelect) {
                case "1":
                    aDogsLife();
                    break;
                case "2":
                    aParrotsLife();
                    break;
                case "3":
                    anElephantsLife();
                    break;
            }
        }
    }

    //method called in the menu when selecting the alternative to start counting days.
    private void startDay() {
        System.out.println("What day would you like to start at ");
        int currentDay = sc.nextInt();
        someDayInLife(currentDay);
    }
    //print out all the animals in the animal arrays on command
    private void printAllAnimals(int returnToMenu) {
        for (Dog dog : dogs) {
            System.out.println("Animal type: " + dog.animal);
            System.out.println("Name: " + dog.getName());
            System.out.println("Age:" + dog.getAge());
            System.out.println("Animal sound " + dog.sound + "\n");
        }

        for (Elephant elephant : elephants) {
            System.out.println("Animal type: " + elephant.animal);
            System.out.println("Name: " + elephant.getName());
            System.out.println("Age: " + elephant.getAge());
            System.out.println("Animal sound " + elephant.sound + "\n");
        }

        for (Parrot parrot : parrots) {
            System.out.println("Animal type: " + parrot.animal);
            System.out.println("Name: " + parrot.getName());
            System.out.println("Age: " + parrot.getAge());
            System.out.println("Animal sound: " + parrot.sound + "\n");
        }
        if (returnToMenu == 1)
        {
            menu();
        }
    }

    private void exit() {
        System.out.println("Okay. Bye then");
        System.exit(0);
    }

/*tried to get the day-system to work, but we don´t know how to specify specific days during the arrays loop where the
* functions will activate on repeat*/

    private void someDayInLife(int currentDay) {
        while (true) {
            System.out.println("Day: " + currentDay);
            if (currentDay >= daysInYear) {
                year++;
            }

            System.out.println("Current year: " + year + "\n");
            printAllAnimals(0);
            System.out.println("How many days would you like to advance?");
            int howManyDays = sc.nextInt();
            currentDay += howManyDays;

            for (Dog dog : dogs) {
                if (currentDay >= daysInYear) {
                    dog.age++;
                }
                if (dog.getAge() >= 15) {
                    System.out.println(dog.getName() + " Has died by natural causes\n");
                    dogs.remove(dog);
                } else {
                    if (!dog.chewToy) {
                        dog.newChewToy();
                    }
                    dog.checkChewToy();
                }

                for (Elephant elephant : elephants) {
                    elephant.age++;
                    if (elephant.getAge() >= 70) {
                        System.out.println(elephant.getName() + " Has died by natural causes\n");
                        elephants.remove(elephant);
                    }

                    for (Parrot parrot : parrots) {
                        if (currentDay >= daysInYear) {
                            parrot.age++;
                            if (parrot.getAge() >= 95) {
                                System.out.println(parrot.getName() + " Has died by natural causes\n");

                                parrots.remove(parrot);
                            }
                        }
                    }
                    someDayInLife(currentDay);
                }
            }
        }
    }
    private void aDogsLife() {
        System.out.println("What name do you want to give the dog");
        Dog myDog = new Dog();
        System.out.println("Your " + myDog.animal + "s name is: " + myDog.name);
        System.out.println(myDog.AnimalVariables);
        addAnimals(myDog);
        menu();
    }
    private void aParrotsLife() {
        System.out.println("What name do you want to give to the parrot?");
        Parrot myParrot = new Parrot();
        System.out.println("Your " + myParrot.animal + "s name is: " + myParrot.name);
        System.out.println(myParrot.AnimalVariables);
        addAnimals(myParrot);
        menu();
    }

    //Create the animal-object and insert it into the specified ArrayList
    private void anElephantsLife() {
        System.out.println("What name do you want to give to the elephant?");
        Elephant myElephant = new Elephant();
        System.out.println("Your " + myElephant.animal + "s name is: " + myElephant.name);
        System.out.println(myElephant.AnimalVariables);
        addAnimals(myElephant);
        menu();
    }


    private void addAnimals(Animal animal) { //expects input in form of an animal
        switch (animal.animal) {
            case "Dog":
                dogs.add((Dog) animal);
                break;
            case "Elephant":
                elephants.add((Elephant) animal);
                break;
            case "Parrot":
                parrots.add((Parrot) animal);
                break;
        }
    }
}