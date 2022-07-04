package com.sg.booktracker;

import com.sg.booktracker.controller.BookController;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 *
 * @author Kyle David Rudy
 */
public class App {
//    public static void main(String[] args) {
//        UserIO io = new UserIOConsoleImpl();
//        BookView view = new BookView(io);
//
//        BookDao dao = new BookDaoMemoryImpl();
//        BookService service = new BookService(dao);
//
//        BookController controller = new BookController(service, view);
//        controller.run();
//    }
    public static void main(String[] args) {
        AnnotationConfigApplicationContext appContext = new AnnotationConfigApplicationContext();
        appContext.scan("com.sg.booktracker");
        appContext.refresh();

//        We can then ask for our BookController so we can start
//        the program. Since we didn't set any IDs for our classes
//        when we annotated them, their default IDs are their names
//        converted to camel-case, in this situation bookController for BookController.
//        Once we have that class we can run it and everything should work.
        BookController controller = appContext.getBean("bookController", BookController.class);
        controller.run();
    }
}
