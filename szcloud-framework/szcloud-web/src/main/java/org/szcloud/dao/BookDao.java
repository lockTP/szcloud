package org.szcloud.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;
import org.szcloud.model.Book;


/**
 *  数据访问层
 *  数据库操作应该在这一层完成
 */
@Component  
public class BookDao {  
  
    //模拟数据库操作  
    public void add(Book book){  
        System.out.print("Add");  
    }  
    public void update(Book book){  
        System.out.print("Update");  
    }  
    public Book getBookById(Integer id){
    	if (id == 123) {
			return new Book(123, "测试书名123", "作者");
		}else{
			return null;
		}
    }
    
    public List<Book> getBookList(){
    	List<Book> books = new ArrayList<Book>();
    	books.add(new Book(1, "浪潮之巅","吴军"));
    	books.add(new Book(2, "数学之美","吴军"));
    	books.add(new Book(3, "文明之光","吴军"));
    	books.add(new Book(4, "大学之路","吴军"));
    	books.add(new Book(5, "硅谷之谜","吴军"));
		return books;
    }
    
} 