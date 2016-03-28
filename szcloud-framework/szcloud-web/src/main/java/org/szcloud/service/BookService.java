package org.szcloud.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.szcloud.dao.BookDao;
import org.szcloud.model.Book;


/**
 * 业务层
 * 业务逻辑操作应该在这里完成 
 */
@Service
public class BookService {  
  
    private BookDao bookDao;  
  
    public BookDao getBookDao() {  
        return bookDao;  
    }  
  
    @Resource  
    public void setBookDao(BookDao bookDao) {  
        this.bookDao = bookDao;  
    }  
    
    public void add(Book book){  
        bookDao.add(book);  
    }  
    public void update(Book book){  
        bookDao.update(book);  
    }  
    
    public Book getBookById(Integer id){
    	return bookDao.getBookById(id);
    }
    
    public List<Book> getBookList(){
    	return bookDao.getBookList();
    }
      
} 