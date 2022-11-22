package test.Supplie;


import java.util.Random;
import java.util.function.Supplier;

/**
 * @author LZN
 * @Title SupplierWithLambda
 * @ProjectName pattern
 * @Description
 * @date 2022-11-16 15:44
 **/
public class SupplierWithLambda {
    public static void main(String[] args) {
        Supplier<String> s1 = () -> "Hello World!";
        System.out.println(s1.get());

        Random random = new Random();
        Supplier<Integer> s2 = () -> random.nextInt(10);
        System.out.println(s2.get());
        System.out.println(s2.get());
    }
}

