package com.example.demo.models;


import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.fasterxml.jackson.annotation.JsonFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double price;
    
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate cDate;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate uDate;

    @OneToMany(mappedBy = "product", cascade = CascadeType.ALL)
    private List<Review> reviews ;

    
}

