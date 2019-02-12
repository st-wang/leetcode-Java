public class Parent {
    static {
        System.out.println("static in parent");
    }

    Parent() {
        System.out.println("constructor in parent");
    }

    void print(Parent p) {
        System.out.println("parent");
    }
}
