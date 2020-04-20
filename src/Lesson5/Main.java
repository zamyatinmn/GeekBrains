package Lesson5;

public class Main {

    public static void main(String[] args) {
        Staff id1 = new Staff("Пупкин Василий Батькович", "Начальник", "vasya@mail.ru", "89998887766", 100000, 40);
        id1.info();
        Staff id2 = new Staff("Валера");
        id2.info();
        Staff id3 = new Staff();
        id3.info();

        System.out.println();

        Staff[] department = new Staff[5];
        department[0] = new Staff("Ivanov Ivan", "Engineer", "ivivan@mailbox.com", "892312312", 30000, 30);
        department[1] = new Staff("Петров Петр", "Монтажник", "petr@mail.ru", "89251485622", 20000, 23);
        department[2] = new Staff("Сидоров Сидор", "Уборщик", "@mail.ru", "89632541201", 15000, 52);
        department[3] = new Staff("Иннокентий", "Охранник", "security@mail.ru", "89785964256", 17000, 49);
        department[4] = new Staff("Копейкина Любовь", "Бухгалтер", "money@mail.ru", "89998765432", 200000, 33);

        for (Staff employee : department) {
            if(employee.getAge() > 40){
                employee.info();
            }
        }
        
    }
}
