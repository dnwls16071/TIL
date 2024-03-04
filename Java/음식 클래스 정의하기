public class FoodTest {
    public static void main(String[] args) {

        Food chicken = new Food("치킨", 18000);
        Food pizza = new Food("피자", 28000);
        Food sushi = new Food("초밥세트", 22000);

        Food[] foods = { chicken, pizza, sushi };

        for (int i = 0; i < foods.length; i++) {
            System.out.println(foods[i].toString());
        }
    }
}
class Food {

    String name;
    int price;

    public Food(String name, int price) {
        this.name = name;
        this.price = price;
    }
    public String toString() {
        return String.format("Food { name: %s, price: %d원 }", name, price);
    }
}
