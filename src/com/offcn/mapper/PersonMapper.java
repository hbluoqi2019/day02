package com.offcn.mapper;

import com.offcn.pojo.Person;

import java.util.List;

public interface PersonMapper {

    List<Person> findAll();
    Person findById(int id);
}
