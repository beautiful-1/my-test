package test.Supplie;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * @author LZN
 * @Title ConsumerAndThen2
 * @ProjectName pattern
 * @Description
 * @date 2022-11-16 15:38
 **/
public class ConsumerAndThen2 {
    public static void main(String[] args) {
        List<Integer> list = Arrays.asList(12, 13, 14, 15, 16, 17);

        Consumer<List<Integer>> oddNumConsumer = MyNumber::printOddNum;

        Consumer<List<Integer>> evenNumConsumer = MyNumber::printEvenNum;

        Consumer<List<Integer>> taskFinishConsumer = MyNumber::taskFinishMsg;

        oddNumConsumer.andThen(evenNumConsumer).andThen(taskFinishConsumer).accept(list);
    }
}

class MyNumber {
    static void printOddNum(List<Integer> myNumbers) {
        System.out.println("--- odd numbers ---");
        myNumbers.forEach(n -> {
            if (n % 2 == 1) {
                System.out.print(n + " ");
            }
        });
    }

    static void printEvenNum(List<Integer> myNumbers) {
        System.out.println("\n--- even numbers ---");
        myNumbers.forEach(n -> {
            if (n % 2 == 0) {
                System.out.print(n + " ");
            }
        });
    }

    static void taskFinishMsg(List<Integer> myNumbers) {
        System.out.println("\nTotal " + myNumbers.size() + " number processed.");
    }
}
