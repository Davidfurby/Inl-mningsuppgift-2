package Animals;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Scanner;

//Animal class as parent
abstract class Animal {
    String animal;
    String sound;
    String name;
    private double weight;
    private double height;
    int eat;
    private int age;
    private int ageInDays;
    private String foodType;
    private int maxAge;
    int food;
    int needRefill;
    int remainingFood;
    int howManyDays;
    int currentDay;
    private DecimalFormat df = new DecimalFormat("0.00");


    //Created an ArrayList with all the variables needed to describe the animals
    ArrayList<Object> AnimalVariables;


    void printValue() {
        AnimalVariables = new ArrayList<>();
        AnimalVariables.add("Animal: " + animal + "\n");
        AnimalVariables.add("Animal sound " + sound + "\n");
        AnimalVariables.add("Weight " + df.format(weight) + " kilo\n");
        AnimalVariables.add("Height " + df.format(height) + " meters\n");
        AnimalVariables.add("total food consumption per day: " + eat + " units of " + foodType + "\n");
        AnimalVariables.add("Age in Days: " + ageInDays + "\n");
    }

    void getAnimalName(String animal) {
        this.animal = animal;
    }

    //method to create sound
    void getSound(String sound) {
        this.sound = sound;
    }

    //returns the already assigned name on command
    String getName() {
        return name;
    }

    int getAgeInDays() {
        return ageInDays;
    }

    void setFoodType(String foodType) {
        this.foodType = foodType;
    }

    String getFoodType() {
        return foodType;
    }

    //method to give name
    void giveName() {
        Scanner sc = new Scanner(System.in);
        name = sc.next();
    }

    //give the animal-age
    void randomAge(int maxAge) {
        this.maxAge = maxAge;
        int rangeAge = maxAge - 1;
        age = (int) (Math.random() * rangeAge) + 1;
        ageInDays = age * 365;
    }

    void newDay() {
        System.out.println("How many days would you like to advance for " + name + "");
        Scanner scanner = new Scanner(System.in);
        howManyDays = scanner.nextInt();
        System.out.println("advancing by " + howManyDays + " day(s) for " + name);
        ageInDays += howManyDays;
    }

    boolean hasDiedOfAge() {
        if (ageInDays >= maxAge * 356) {
            System.out.println(name + " has died due to age\n");
            return true;
        }
        return false;
    }

    void randomFoodConsumption(int maxFood, int minFood) {
        int rangeFood = maxFood - minFood;
        eat = (int) (Math.random() * rangeFood) + minFood;
    }

    void loopDays() {
         currentDay = ageInDays - howManyDays;
        for (int i = 1; i <= howManyDays; i++) {
            currentDay++;
            System.out.println("Day :" + currentDay);
            hasEaten();
            hasDiedOfAge();
        }
    }
            void hasEaten() {
            if (food < eat) {
                System.out.println(name + " needs to eat " + eat + " units of " + foodType + " but only has " + food + " units of " + foodType + " left");
                System.out.println("press 1 if you want to fill their bowl.");
                Scanner scanner = new Scanner(System.in);
                int refillFood = scanner.nextInt();
                if (refillFood == 1) {
                    needRefill = 1;
                    return;
                }
            }
            if (food >= eat) {
                remainingFood = food - eat;
                System.out.println(name + " has eaten " + eat + " units of " + foodType + ", and has " + remainingFood + " units of " + foodType + " left");
                food = remainingFood;
            }
                needRefill = 0;
            }
    void randomHeight(double maxHeight, double minHeight) {
        double rangeHeight = (maxHeight - minHeight + 1);
        height = ((Math.random() * rangeHeight) + minHeight);
    }
    void randomWeight(double maxWeight, double minWeight) {
        double rangeWeight = maxWeight - minWeight + 1;
        weight = ((Math.random() * rangeWeight) + minWeight);
    }
}