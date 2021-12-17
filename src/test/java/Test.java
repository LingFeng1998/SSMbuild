import com.java.pojo.Books;
import com.java.service.BooksService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @author lingfeng
 * @date 2021-12-17
 */
public class Test {
    @org.junit.Test
    public void test(){
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
        BooksService booksServiceImpl = (BooksService) context.getBean("BooksServiceImpl");
        for (Books books : booksServiceImpl.queryAllBook()) {
            System.out.println(books);
        }
    }
}
