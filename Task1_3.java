public class Task1_3 {
    public static void main(String[] args) {
        Unicorn unicorn;
        Unicorn unicorn2;

        unicorn = new Unicorn();

        unicorn.price = 850;
        unicorn.protection = 14;
        unicorn.damage = 22;
        unicorn.health = 90;
        unicorn.speed = 7;
        unicorn.feature = "Ослепляющий удар";

        unicorn2 = unicorn;

        unicorn2.price = 900;
        unicorn2.protection = 16;
        unicorn2.damage = 25;
        unicorn2.health = 100;
        unicorn2.speed = 10;
        unicorn2.feature = "Аура сопротивления магии";

        System.out.println("Характеристики существа " + unicorn.name);
        System.out.println("Стоимость: " + unicorn.price);
        System.out.println("Защита: " + unicorn.protection);
        System.out.println("Урон: " + unicorn.damage);
        System.out.println("Здоровье: " + unicorn.health);
        System.out.println("Скорость: " + unicorn.speed);
        System.out.println("Особенность: " + unicorn.feature);
        System.out.println();
        System.out.println("Характеристики существа " + unicorn2.name);
        System.out.println("Стоимость: " + unicorn2.price);
        System.out.println("Защита: " + unicorn2.protection);
        System.out.println("Урон: " + unicorn2.damage);
        System.out.println("Здоровье: " + unicorn2.health);
        System.out.println("Скорость: " + unicorn2.speed);
        System.out.println("Особенность: " + unicorn2.feature);
    }
}