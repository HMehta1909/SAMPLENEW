package com.capg.SpringDemo4.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capg.SpringDemo4.Model.Book;

@Repository
public interface IBookRepo extends JpaRepository<Book,Integer>{

}
