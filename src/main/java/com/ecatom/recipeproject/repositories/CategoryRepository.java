package com.ecatom.recipeproject.repositories;

import com.ecatom.recipeproject.domain.Category;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category , Long> {
    Optional<Category> findByName(String name); //https://www.tutorialspoint.com/java8/java8_optional_class.htm
}
