package com.misiontic.reto3.controller;

import com.misiontic.reto3.entities.Category;
import com.misiontic.reto3.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/Category")
public class CategoryController {


    @Autowired
    private CategoryService categoryService;

    @GetMapping("/all")
    public List<Category> getCategories(){
        return categoryService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Category> getCategory(@PathVariable("id") int catId){
        return categoryService.getCategory(catId);
    }

    @PostMapping("/save")
    public Category save(@RequestBody Category b){
        return categoryService.save(b);
    }

    @PutMapping("/update")
    public Category update(@RequestBody Category b){
        return categoryService.update(b);
    }

    @DeleteMapping("/{id}")
    public boolean delete(@PathVariable("id") int catId){
        return categoryService.deleteCategory(catId);
    }

}
