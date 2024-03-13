package practice;

public class GarbageCollection {
    public static void main(String[] args) {
        String a = new String("Good");
        String b = new String("Bad");
        String c = new String("Normal");
        String d, e;

        a = null;
        d = c;
        c = null;

        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        // java: variable e might not have been initialized
        // System.out.println(e); -> null
    }
}
