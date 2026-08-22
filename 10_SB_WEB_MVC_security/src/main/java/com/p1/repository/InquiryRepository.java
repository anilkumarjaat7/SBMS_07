package com.p1.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.p1.entity.Inquiry;



public interface InquiryRepository
        extends JpaRepository<Inquiry, Integer> {

    List<Inquiry> findAllByOrderByCreatedDateDesc();
}