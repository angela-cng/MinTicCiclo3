package com.misiontic.reto3.service;

import com.misiontic.reto3.entities.Category;
import com.misiontic.reto3.repository.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> getAll(){
        return categoryRepository.getAll();
    }

    public Optional<Category> getCategory(int id){
        return categoryRepository.getCategory(id);
    }

    public Category save(Category b){
        if(b.getId()==null){
            return categoryRepository.save(b);
        }else{
            Optional<Category> e= categoryRepository.getCategory(b.getId());
            if(e.isEmpty()){
                return categoryRepository.save(b);
            }else{
                return b;
            }
        }
    }

    public Category update(Category b){
        if(b.getId()!=null){
            Optional<Category> q= categoryRepository.getCategory(b.getId());
            if(!q.isEmpty()){
                if (b.getName()!=null){
                    q.get().setName(b.getName());
                }
                if(b.getDescription()!=null){
                    q.get().setDescription(b.getDescription());
                }
                categoryRepository.save(q.get());
                return q.get();
            }else{
                return b;
            }
        }else{
            return b;
        }

    }

    public boolean deleteCategory(int id){
        Boolean flag=false;
        Optional<Category> b= categoryRepository.getCategory(id);
        if(b.isPresent()){
            categoryRepository.delete(b.get());
            flag=true;
        }
        return flag;
    }
}
