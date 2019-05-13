package com.exa.api.controller

import com.exa.api.entity.Category
import com.exa.api.service.CategoryService
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*
import java.util.*;
import javax.validation.Valid;

@RestController
@RequestMapping("/categories")
class CategoryController{
   @Autowired
   private final CategoryService CategoryService

   @GetMapping("")
   public List<Category> findAll(){
      return CategoryService.findAll()
   }

   @PostMapping("")
   public ResponseEntity<Category> createCategory (@Valid @RequestBody Category category) {
      return ResponseEntity.ok(CategoryService.createCategory(category));
   }

   @PutMapping("")
   public ResponseEntity<Category> updateCategory (@Valid @RequestBody Category category,
      @PathVariable(value= "id") Integer id) {
         return ResponseEntity.ok(CategoryService.updateCategory(category, id));
   }

   @DeleteMapping("")
   public ResponseEntity<?> deleteCategory(@PathVariable(value= "id") Integer id) {
      Map<String,String> response = new HashMap<String,String>();
      if(CategoryService.deleteCategory(id)) {
         response.put("status", "success");
         response.put("message", "Kategori berhasil di hapus");
         return ResponseEntity.ok(response);
      } else {
         response.put("status", "error");
         response.put("message", "Kategori gagal di hapus");
         return ResponseEntity.status(500).body(response);
      }
   }
}