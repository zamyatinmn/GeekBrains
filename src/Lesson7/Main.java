package Lesson7;

public class Main {
    public static void main(String[] args) {
        Plate plate = new Plate();
        Cat[] cats = {
                new Cat ("Murzik"),
                new Cat ("Pushok"),
                new Cat ("Goga"),
                new Cat ("Faza"),
                new Cat ("Shiza")
        };

        plate.info();
        for (Cat kitty: cats) {
            kitty.eat(plate);
            plate.info();
        }
        for (Cat kitty: cats) {
            System.out.println(kitty.getName() + " наелся: " + kitty.isSatiety());
        }
        plate.info();
        plate.addFood(50);
    }

}
