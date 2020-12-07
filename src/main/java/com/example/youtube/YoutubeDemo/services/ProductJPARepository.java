package com.example.youtube.YoutubeDemo.services;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.youtube.YoutubeDemo.entities.Product;

public interface ProductJPARepository extends JpaRepository<Product, Integer>{

}
