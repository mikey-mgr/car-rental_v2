package com.Mike.Proj.init;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;

import com.Mike.Proj.model.Category;
import com.Mike.Proj.repository.CategoryRepo;

public class DatabaseLoader implements CommandLineRunner{

        private final CategoryRepo categoryRepo;

    @Autowired
    public DatabaseLoader(CategoryRepo categoryRepository) {
        this.categoryRepo = categoryRepository;
    }

    @Override
    public void run(String... strings) throws Exception {
        addSampleCategories();
    }

    public void addSampleCategories() {
        List<Category> categories = Arrays.asList(
            new Category(1, "Laptop", "Get all your beloved laptops", "./assets/AppImages/Test.jpg")
        );

        for (Category category : categories) {
            categoryRepo.save(category);
        }
    }
    
}
