package practica.basica;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.regex.*;

public class ReferenceCyclic {

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
    A one = new A();
    B two = new B();

    // Make the objects refer to each other (creates a circular reference)
    one.setB(two);
    two.setA(one);

    // Throw away the references from the main method; the two objects are
    // still referring to each other
    one = null;
    two = null;
    
//        ReferenceCyclic r = new ReferenceCyclic();
//        r.run();
    }

    void run(){
        A a = new A();
        B b = new B(a);
        a.setB(b);

    }
class A {
private B b;

public void setB(B b) {
    this.b = b;
}
}

class B {
private A a;

public void setA(A a) {
    this.a = a;
}
}


}
