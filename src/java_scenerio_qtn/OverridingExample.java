package java_scenerio_qtn;

public class OverridingExample {
    public static void main(String[] args) {
        new B().show();
    }
}


class A {

    A() {
        show();
    }

    void show() {
        System.out.println("A show");
    }
    protected void test() {
        System.out.println("A test");
    }
}

class B extends A {
   protected void test() {
        System.out.println("D test");
    }

    int x = 10;
    void show() {
        System.out.println("B show: " + x);
    }
}
