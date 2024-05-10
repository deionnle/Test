package Task3;

class Id {
    protected String name; // имя/название
    protected int fraction; // Фракция: 1 - Замок 2 - Оплот, 3 - Башня, 4 - Инферно

    Id (String n, int f)  {
        this.name = n;
        this.fraction = f;
    }
}

class Heroes extends Id {
    private double level; // уровень
    private double experience; //опыт
    private int magic; // очки заклинаний
    private int morale; // боевой дух

    Heroes(String n, int f, double l, double e, int m, int mor) {
        super(n, f); // вызов конструктора Id
        this.level = l;
        this.experience = e;
        this.magic = m;
        this.morale = mor;
    }

    // восстанавливает максимальный запас очков заклинаний
    protected void magicWell() {
        this.magic = 50;
    }

    // Получает опыт
    protected void getExperience(double new_experience) {
        this.experience += new_experience;
        levelUp(); // сразу добавляем опыт в уровень персонажа
    }

    // Повышает уровень
    protected void levelUp() {
        this.level += this.experience / 10000;
    }

    // Побеждает в сражении, получает опыт и боевой дух, повышается уровень
    protected void win() {
        this.getExperience(20000);
        this.morale = 100;
        this.levelUp();
    }

    // Метод печати из класса т.к. поля приватные
    protected void print() {
        System.out.println("Характеристики героя: " + this.name);
        System.out.println("Фракция: " + this.fraction);
        System.out.println("Уровень: " + this.level);
        System.out.println("Опыт: " + this.experience);
        System.out.println("Очки заклинаний: " + this.magic);
        System.out.println("Боевой дух отряда: " + this.morale);
        System.out.println();
    }
}

class Cities extends Id {
    private int level; // 1 - Управа, 2 - Форт, 3 - Цитадель, 4 - Замок
    private int money; // казна города

    Cities(String n, int f, int l, int m) {
        super(n, f); // вызов конструктора Id
        this.level = l;
        this.money = m;
    }

    // Улучшаем город
    protected void levelUp() {
        if(this.level < 5) {
            this.level += 1;
            this.money -= 5000;
        }
    }

    // Город захвачен после осады
    protected void cityLost() {
        this.level -= 1;
    }

    // Метод печати из класса т.к. поля приватные
    protected void print() {
        System.out.println("Характеристики города: " + this.name);
        System.out.println("Фракция: " + this.fraction);
        System.out.println("Уровень: " + this.level);
        System.out.println("Казна: " + this.money);
        System.out.println();
    }
}

class Units extends Id {
    private int price;
    private int attack;
    private int protection;
    private int damage;
    private int health;

    Units(String n, int f, int p, int a, int pro, int d, int h) {
        super(n, f); // вызов конструктора Id
        this.price = p;
        this.attack = a;
        this.protection = pro;
        this.damage = d;
        this.health = h;
    }

    // Получает урон в бою
    protected void Damage(int new_damage) {
        if (new_damage > (this.health + this.protection)) {
            this.health = 0;
        } else if (this.health > 0 && new_damage > this.protection) {
            this.health -= (new_damage - this.protection);
        }
    }

    // хилится героем или палаткой
    protected void heal() {
        if (this.health > 0 && this.health <= 80) {
            this.health += 10;
        }
    }

    // Метод печати из класса т.к. поля приватные
    protected void print() {
        System.out.println("Характеристики юнита: " + this.name);
        System.out.println("Фракция: " + this.fraction);
        System.out.println("Стоимость: " + this.price);
        System.out.println("Атака: " + this.attack);
        System.out.println("Защита: " + this.protection);
        System.out.println("Урон: " + this.damage);
        System.out.println("Здоровье: " + this.health);
    }
}

public class Task5 {
    public static void main(String[] args) {

        Heroes Gelo = new Heroes("Гело", 2, 1.0, 900.0, 30, 80);

        Gelo.magicWell(); // восстанавливает очки у волшебного колодца
        Gelo.getExperience(1500); // получает очки опыта
        Gelo.win(); // побеждает в битве
        Gelo.print(); // вывожу хар-ки героя


        Cities Forest = new Cities("Форест", 2, 2, 15000);

        Forest.levelUp(); // улучшаем город
        Forest.levelUp(); // еще раз, до максимума
        Forest.cityLost(); // враг захватил и разрушил город во время осады
        Forest.print(); // вывожу хар-ки города

        Units Unicorn = new Units("Единорог", 2, 850, 15, 14, 22, 90);

        Unicorn.Damage(50); // получает урон в бою
        Unicorn.Damage(30); // еще урон
        Unicorn.heal(); // лечится
        Unicorn.print(); // вывожу хар-ки существа
    }
}