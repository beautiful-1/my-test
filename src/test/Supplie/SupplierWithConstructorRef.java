package test.Supplie;
import java.util.Random;
import java.util.function.Supplier;

/**
 * @author LZN
 * @Title SupplierWithConstructorRef
 * @ProjectName pattern
 * @Description 我们可以使用没有参数的构造函数来实例化Supplier，即默认构造函数。
 * <p>
 * 找到Book类的构造函数参考。
 * <p>
 * Book::new
 * @date 2022-11-16 15:53
 **/
public class SupplierWithConstructorRef {
    public static void main(String[] args) {
        Supplier<Random> s1 = Random::new;
        Random random = s1.get();
        System.out.println(random.nextInt(10));

        Supplier<Book> s2 = Book::new;
        Book book = s2.get();
        System.out.println(book.getBookName());
    }


    static class Book {
        private String bookName = "Mahabharat";

        public Book() {
        }

        public Book(String bookName) {
            this.bookName = bookName;
        }

        public String getBookName() {
            return bookName;
        }
    }
}
