package org.szcloud.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.szcloud.model.Book;
import org.szcloud.service.BookService;


/**
 * 控制层
 */
@Controller  
@RequestMapping("/book")  
public class BookController {  
  
	@Autowired
    private BookService bookService;  
    
    
    @RequestMapping(value="add")  
    public ModelAndView add(Book book){  
        System.out.println("bookname:"+book.getName());  
        System.out.println("author:"+book.getAuthor());  
        bookService.add(book);  
        return new ModelAndView("redirect:/main.jsp");  
    }  
    @RequestMapping(params = "method=update")  
    public String update(Book book) {  
        bookService.update(book);  
        return "success";  
    }  
    public BookService getBookService() {  
        return bookService;  
    }  
    @Resource  
    public void setBookService(BookService bookService) {  
        this.bookService = bookService;  
    }  
    
    @RequestMapping(value="test")  
    public ModelAndView test(Book book){  
        System.out.println("bookname:"+book.getName());  
        System.out.println("author:"+book.getAuthor());  
        ModelAndView mv = new ModelAndView("redirect:/main.jsp");
        mv.addObject("name",book.getName());
        mv.addObject("author",book.getAuthor());
        return mv;  
    }  
    
    /**
     * JSON数据返回测试
     * 单条数据
     * ResponseBody
     */
    @RequestMapping(value="getBookById/{bookId}", method=RequestMethod.GET)
    public @ResponseBody Book getBookById(@PathVariable Integer bookId){
    	Book book = bookService.getBookById(bookId);
    	return book;
    }
    
    /**
     * JSON数据返回测试
     * 单条数据
     * ResponseEntity
     */
    @RequestMapping(value="getBookById2/{bookId}", method=RequestMethod.GET)
    public ResponseEntity<Book> getBookById2(@PathVariable Integer bookId){
    	Book book = bookService.getBookById(bookId);
    	return new ResponseEntity<Book>(book, HttpStatus.OK);
    }
    
    
    /**
     * JSON数据返回测试
     * 多条数据
     * ResponseBody
     */
    @RequestMapping(value="getBookList", method=RequestMethod.GET)
    public @ResponseBody List<Book> getBookList(){
    	List<Book> books = bookService.getBookList();
    	return books;
    }
    
    /**
     * JSON数据返回测试
     * 多条数据
     * ResponseEntity
     */
    @RequestMapping(value="getBookList2", method=RequestMethod.GET)
    public ResponseEntity<List<Book>> getBookList2(){
    	List<Book> book = bookService.getBookList();
    	return new ResponseEntity<List<Book>>(book, HttpStatus.OK);
    }
    

}