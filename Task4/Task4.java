package Task4;
import java.util.Random;

class Heroes {
    private String name; // имя
    protected int fraction; // Фракция: 1 - Замок 2 - Оплот, 3 - Башня, 4 - Инферно
    protected double level; // уровень
    protected double experience; //опыт
    protected int magic; // очки заклинаний
    protected int morale; // боевой дух
    protected String type;
    protected int attack;
    protected int protection;

    Heroes(String n, int f, double l) {
        this.name = n;
        this.fraction = f;
        this.level = l;
    }

    // восстанавливает максимальный запас очков заклинаний
    protected void magicWell(String mag) {
        if (mag == "Маг") {
            this.magic = 150;
        } else {
            this.magic = 50;
        }
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

    // Побеждает в сражении, получает опыт и боевой дух, повышается уровень, тратит манну
    protected void win() {
        this.getExperience(20000);
        this.morale += 10;
        this.levelUp();
        this.magic -= 50;
    }

    protected void foo() {
        System.out.println("Герои");
    }

    protected void print() {
        System.out.println("Характеристики героя: " + this.name);
        System.out.println("Тип война: " + this.type);
        System.out.println("Фракция: " + this.fraction);
        System.out.println("Уровень: " + this.level);
        System.out.println("Опыт: " + this.experience);
        System.out.println("Атака: " + this.attack);
        System.out.println("Защита: " + this.protection);
        System.out.println("Очки заклинаний: " + this.magic);
        System.out.println("Боевой дух отряда: " + this.morale);
        System.out.println();
    }
}

class Might extends Heroes {
    private Helmet helmet;
    private Shield shield;

    Might(String n, int f, double l, Helmet helmet, Shield shield) {
        super(n, f, l);
        this.experience = 3000;
        this.magic = 50;
        this.morale = 90;
        this.type = "Воин";
        this.attack = 60;
        this.protection = 40;
        this.helmet = helmet;
        this.shield = shield;
    }

    protected void useArtefact(Helmet helmet) {
        this.magic += helmet.magicHelmet;
        this.protection += helmet.protectionHelmet;
    }

    protected void useArtefact(Shield shield) {
        this.protection += shield.protectionShield;
        if (this.morale + shield.moraleShield > 100) {
            this.morale = 100;
        } else {
            this.morale += shield.protectionShield;
        }
    }

    protected void foo() {
        System.out.println("Мечник");
    }
}

class Magic extends Heroes {
    private Axe axe;
    private Shield shield;

    Magic(String n, int f, double l, Axe axe, Shield shield) {
        super(n, f, l);
        this.experience = 1000;
        this.magic = 150;
        this.morale = 60;
        this.type = "Маг";
        this.attack = 30;
        this.protection = 70;
        this.axe = axe;
        this.shield = shield;
    }

    protected void useArtefact(Axe axe) {
        this.attack += axe.attackAxe;
        this.protection += axe.protectionAxe;
    }

    protected void useArtefact(Shield shield) {
        this.protection += shield.protectionShield;
        if (this.morale + shield.moraleShield > 100) {
            this.morale = 100;
        } else {
            this.morale += shield.protectionShield;
        }
    }

    protected void foo() {
        System.out.println("Маг");
    }

    protected String ad_hoc(String name, String type) {
        return name + " " + type;
    }

    protected int ad_hoc(int attack, int protection) {
        return attack + protection;
    }
}

class Artefacts {
    private String name; // название

    public Artefacts(String nam) {
        this.name = nam;
    }
}

class Axe extends Artefacts {
    protected int attackAxe;
    protected int protectionAxe;

    public Axe(String nam) {
        super(nam);
        this.attackAxe = 15;
        this.protectionAxe = -5;
    }
}

class Shield extends Artefacts {
    protected int protectionShield;
    protected int moraleShield;

    public Shield(String nam) {
        super(nam);
        this.protectionShield = 20;
        this.moraleShield = 20;
    }
}

class Helmet extends Artefacts {
    protected int protectionHelmet;
    protected int magicHelmet;

    public Helmet(String nam) {
        super(nam);
        this.protectionHelmet = 10;
        this.magicHelmet = 50;
    }
}

class Cities {
    private String name;
    private int fraction;
    private int level; // 1 - Управа, 2 - Форт, 3 - Цитадель, 4 - Замок
    private int money; // казна города

    Cities(String n, int f, int l, int m) {
        this.name = n;
        this.fraction = f;
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

class Units {
    private String name;
    private int fraction;
    private int price;
    private int attack;
    private int protection;
    private int damage;
    private int health;

    Units(String n, int f, int p, int a, int pro, int d, int h) {
        this.name = n;
        this.fraction = f;
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
        System.out.println();
    }
}

public class Task4 {
    public static void main(String[] args) {

        Axe axe = new Axe("Секира кентавра");
        Shield shield = new Shield("Щит львиной храбрости");
        Helmet helmet = new Helmet("Шлем белого единорога");

        Might Gelo = new Might("Гело", 2, 1.0, helmet, shield);
        Gelo.getExperience(1500); // получает очки опыта
        Gelo.win(); // побеждает в битве
        Gelo.magicWell("Воин"); // восстанавливает манну

        Gelo.useArtefact(helmet); // использует артефакт шлем
        Gelo.useArtefact(shield); // использует артефакт щит
        Gelo.print();

        Magic Aeris = new Magic("Аэрис", 2, 1.0, axe, shield);
        Aeris.getExperience(15000); // получает очки опыта
        Aeris.win(); // побеждает в битве
        Aeris.magicWell("Маг"); // восстанавливает манну

        Aeris.useArtefact(axe); // использует артефакт секира
        Aeris.useArtefact(shield); // использует артефакт щит
        Aeris.print();

        Cities Forest = new Cities("Форест", 2, 2, 15000);

        Forest.levelUp(); // улучшаем город
        Forest.levelUp(); // еще раз, до максимума
        Forest.cityLost(); // враг захватил и разрушил город во время осады
        Forest.print();

        Units Unicorn = new Units("Единорог", 2, 850, 15, 14, 22, 90);

        Unicorn.Damage(50); // получает урон в бою
        Unicorn.Damage(30); // еще урон
        Unicorn.heal(); // лечится
        Unicorn.print();

        // 4.2 Вызов метода foo() из массива hero
        Heroes [] hero = new Heroes[500];
        Might Ivor = new Might("Ивор", 2, 1.0, helmet, shield);
        Magic Gem = new Magic("Джем", 2, 1.0, axe, shield);
        Random random = new Random();
        for (int i = 0; i < hero.length; i ++) {
            int n = random.nextInt(2);
            if (n == 0) {
                hero[i] = Ivor;
            } else {
                hero[i] = Gem;
            }
            hero[i].foo();
        }
        // автоматически вызывается метод соответствующего объекту класса

        // 4.3 ad hoc полиморфизм
        System.out.println(Aeris.ad_hoc("Джем", "Маг"));
        System.out.println(Aeris.ad_hoc(50,100));
    }
}
