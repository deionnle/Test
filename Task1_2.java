class Dwarf {
    String name = "Гном";
    int price;
    int protection;
    int damage;
    int health;
    int speed;
    String feature;
}

class WoodElf {
    String name = "Лесной эльф";
    int price;
    int protection;
    int damage;
    int health;
    int speed;
    String feature;
}

class Unicorn {
    String name = "Единорог";
    int price;
    int protection;
    int damage;
    int health;
    int speed;
    String feature;
}

public class Task1_2 {
    public static void main(String[] args) {
        Dwarf my_dwarf;
        WoodElf my_woodelf;
        Unicorn my_unicorn;

        my_dwarf = new Dwarf();
        my_woodelf = new WoodElf();
        my_unicorn = new Unicorn();


        my_dwarf.price = 120;
        my_dwarf.protection = 7;
        my_dwarf.damage = 4;
        my_dwarf.health = 20;
        my_dwarf.speed = 3;
        my_dwarf.feature = "Второй по величине показатель здоровья";

        my_woodelf.price = 200;
        my_woodelf.protection = 5;
        my_woodelf.damage = 5;
        my_woodelf.health = 15;
        my_woodelf.speed = 6;
        my_woodelf.feature = "Дальнобойная атака";

        my_unicorn.price = 850;
        my_unicorn.protection = 14;
        my_unicorn.damage = 22;
        my_unicorn.health = 90;
        my_unicorn.speed = 7;
        my_unicorn.feature = "Ослепляющий удар";

        System.out.println("Характеристики существа " + my_dwarf.name);
        System.out.println("Стоимость: " + my_dwarf.price);
        System.out.println("Защита: " + my_dwarf.protection);
        System.out.println("Урон: " + my_dwarf.damage);
        System.out.println("Здоровье: " + my_dwarf.health);
        System.out.println("Скорость: " + my_dwarf.speed);
        System.out.println("Особенность: " + my_dwarf.feature);
        System.out.println();
        System.out.println("Характеристики существа " + my_woodelf.name);
        System.out.println("Стоимость: " + my_woodelf.price);
        System.out.println("Защита: " + my_woodelf.protection);
        System.out.println("Урон: " + my_woodelf.damage);
        System.out.println("Здоровье: " + my_woodelf.health);
        System.out.println("Скорость: " + my_woodelf.speed);
        System.out.println("Особенность: " + my_woodelf.feature);
        System.out.println();
        System.out.println("Характеристики существа " + my_unicorn.name);
        System.out.println("Стоимость: " + my_unicorn.price);
        System.out.println("Защита: " + my_unicorn.protection);
        System.out.println("Урон: " + my_unicorn.damage);
        System.out.println("Здоровье: " + my_unicorn.health);
        System.out.println("Скорость: " + my_unicorn.speed);
        System.out.println("Особенность: " + my_unicorn.feature);
    }
}
