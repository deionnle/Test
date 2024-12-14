package Task2;

class Heroes {
    String name; // имя героя
    int fraction; // 1 - Замок 2 - Оплот, 3 - Башня, 4 - Инферно
    double level; // уровень
    double experience; //опыт
    int magic; // очки заклинаний
    int morale; // боевой дух

    Heroes(String n, int f, double l, double e, int m, int mor)
    {
        this.name = n;
        this.fraction = f;
        this.level = l;
        this.experience = e;
        this.magic = m;
        this.morale = mor;
    }

    // восстанавливает максимальный запас очков заклинаний
    void magicWell() {
        this.magic = 50;
    }

    // Получает опыт
    void getExperience(double new_experience) {
        this.experience += new_experience;
        levelUp(); // сразу добавляем опыт в уровень персонажа
    }

    // Повышает уровень
    void levelUp() {
        this.level += this.experience / 10000;
    }

    // Побеждает в сражении, получает опыт и боевой дух, повышается уровень
    void win() {
        this.getExperience(20000);
        this.morale = 100;
        this.levelUp();
    }

    // Метод-фабрика для создания героя Гело
    static Heroes createGelo() {
        Heroes hero = new Heroes("Гело", 2, 1.0, 900.0, 30, 80);
        hero.magicWell(); // Восстановление очков заклинаний после создания
        return hero;
    }
}

class Cities {
    String name; // название города
    int fraction; // 1 - Замок 2 - Оплот, 3 - Башня, 4 - Инферно
    int level; // 1 - Управа, 2 - Форт, 3 - Цитадель, 4 - Замок
    int money; // казна города

    Cities(String n, int f, int l, int m)
    {
        this.name = n;
        this.fraction = f;
        this.level = l;
        this.money = m;
    }

    // Улучшаем город
    void levelUp() {
        if(this.level < 5) {
            this.level += 1;
            this.money -= 5000;
        }
    }

    // Город захвачен после осады
    void cityLost() {
        this.level -= 1;
    }

    // метод-фабрика для создания города Форест
    static Cities createForest() {
        Cities city = new Cities("Форест", 2, 2, 15000);
        city.levelUp(); // Улучшаем город после создания
        return city;
    }
}

class Units {
    String name;
    int price;
    int attack;
    int protection;
    int damage;
    int health;

    Units(String n, int p, int a, int pro, int d, int h) {
        this.name = n;
        this.price = p;
        this.attack = a;
        this.protection = pro;
        this.damage = d;
        this.health = h;
    }

    // Получает урон в бою
    void getDamage(int new_damage) {
        this.health -= new_damage;
    }

    // хилится героем или палаткой
    void heal() {
        if (this.health <= 80) {
            this.health += 10;
        }
    }

    // метод-фабрика для создания юнита Единорог
    static Units createUnicorn() {
        Units unit = new Units("Единорог", 850, 15, 14, 22, 90);
        unit.heal(); // Лечение юнита после создания
        return unit;
    }
}

public class Task2 {
    public static void main(String[] args) {

        // Использование методов-фабрик для создания объектов
        Heroes Gelo = Heroes.createGelo();
        Cities Forest = Cities.createForest();
        Units Unicorn = Units.createUnicorn();

        Gelo.magicWell(); // восстанавливает очки у волшебного колодца
        Gelo.getExperience(1500); // получает очки опыта
        Gelo.win(); // побеждает в битве

        System.out.println("Характеристики героя: " + Gelo.name);
        System.out.println("Фракция: " + Gelo.fraction);
        System.out.println("Уровень: " + Gelo.level);
        System.out.println("Опыт: " + Gelo.experience);
        System.out.println("Очки заклинаний: " + Gelo.magic);
        System.out.println("Боевой дух отряда: " + Gelo.morale);
        System.out.println();

        Forest.levelUp(); // улучшаем город
        Forest.levelUp(); // еще раз, до максимума
        Forest.cityLost(); // враг захватил и разрушил город во время осады

        System.out.println("Характеристики города: " + Forest.name);
        System.out.println("Фракция: " + Forest.fraction);
        System.out.println("Уровень: " + Forest.level);
        System.out.println("Казна: " + Forest.money);
        System.out.println();

        Unicorn.getDamage(30); // получает урон в бою
        Unicorn.getDamage(20); // еще урон
        Unicorn.heal(); // лечится

        System.out.println("Характеристики юнита: " + Unicorn.name);
        System.out.println("Стоимость: " + Unicorn.price);
        System.out.println("Атака: " + Unicorn.attack);
        System.out.println("Защита: " + Unicorn.protection);
        System.out.println("Урон: " + Unicorn.damage);
        System.out.println("Здоровье: " + Unicorn.health);
    }
}