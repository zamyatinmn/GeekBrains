package Lesson7;

public class Plate {
    private int food = 100;

    public Plate() {
    }

    public void info(){
        System.out.println("Еды в тарелке: " + food);
    }

    /**
     * Метод позволяющий добавить необходимое количество еды в тарелку.
     * @param food какое количство еды добавить
     */
    public void addFood(int food){
        if (food < 0){
            System.out.println("Нельзя положить отрицательное количество еды");
            return;
        }
        this.food += food;
        System.out.println("Добавили еды: " + food + ". Теперь еды в тарелке: " + this.food);
    }

    /**
     * Метод возвращающий true, если удалось поесть из тарелки
     * @param food количество еды
     * @return true/false
     */
    public boolean getFood(int food){
        if (food <= this.food) {
            this.food -= food;
            return true;
        }
        return false;
    }
}
