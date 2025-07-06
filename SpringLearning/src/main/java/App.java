import com.xl.service.BookService;
import com.xl.service.impl.BookServiceImpl;

public class App {
    public static void main(String[] args) {
        BookService bookService=new BookServiceImpl();
        bookService.save();
    }
}
