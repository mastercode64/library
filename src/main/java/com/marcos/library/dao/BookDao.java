package com.marcos.library.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.marcos.library.model.Book;

@Repository
public interface BookDao extends JpaRepository<Book, Long>{

}
