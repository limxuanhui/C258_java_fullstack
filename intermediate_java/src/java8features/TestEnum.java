package java8features;
/* Created by limxuanhui on 21/6/22 */

enum MyDays{
    SUNDAY, MONDAY, TUESDAY, WEDNESDAY,
    THURSDAY, FRIDAY, SATURDAY
}

enum CoffeeSize {
    SMALL(100),
    MEDIUM(200),
    LARGE(300);

    private final int quantity;

    CoffeeSize(int quantity) {
        this.quantity = quantity;
    }

    public String toString() {
        return "" + quantity;
    }
}

class MoonBucks {
    int price;
    String name;
    CoffeeSize size;
}

public class TestEnum {
    public static void main(String[] args) {
        MyDays day1 = MyDays.SUNDAY;
        System.out.println(day1);

        MoonBucks moonBucks = new MoonBucks();
        moonBucks.name = "Moon Bucks Signature";
        moonBucks.price = 20;
        moonBucks.size = CoffeeSize.LARGE;

        System.out.println(moonBucks);
        System.out.println(moonBucks.size);
    }
}
