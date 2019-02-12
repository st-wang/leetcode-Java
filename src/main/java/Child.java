public class Child extends Parent {
    static {
        System.out.println("static in child");
    }

    Child() {
        System.out.println("constructor in child");
    }

    void print(Child c) {
        System.out.println("child");
    }

    void print(Parent p) {
        System.out.println("parent in child");
    }
}
