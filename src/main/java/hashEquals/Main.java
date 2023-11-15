package hash;

import java.util.HashSet;
import java.util.Set;

public class Main {
    public static void main(String[] args) {
        MyClass m1 = new MyClass(12L, "name");
        MyClass m2 = new MyClass(12L, "name");
        if (m1.equals(m2)) {
            System.out.println("OK");
            System.out.println(m1.hashCode());
            System.out.println(m2.hashCode());
        }

        Set<MyClass> set = new HashSet<>();
        set.add(m1);
        set.add(m2);
        System.out.println(set.size());
    }
}