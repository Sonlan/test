package song.basis.extendstest;

/**
 * Created by Song on 2017/2/15.
 */
public class B extends A {
    public B(String id){
        super(id);
    }

    public static void main(String [] args){
        String str1 = "abc";
        String str2 = "a"+"bc";
        String str3 = "abc";
        String str4 = new String("abc");
        String str5 = "a"+new String("bc");
        Byte b = 127,a=127;
        System.out.printf("%x,%x",(++b),a);
        /*System.out.println("str1 == str2 ? "+(str1 == str2));
        System.out.println("str1 == str3 ? "+(str1 == str3));
        System.out.println("str1 == str4 ? "+(str1 == str4));
        System.out.println("str1 == str5 ? "+(str1 == str5));*/
    }
}
