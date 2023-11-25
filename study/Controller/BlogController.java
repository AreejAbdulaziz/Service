package com.example.study.Controller;

import com.example.study.Model.Blog;
import com.example.study.Service.BlogService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/blog")
@RequiredArgsConstructor

public class BlogController {
    private final BlogService blogService;
    @GetMapping("/get")
    public ResponseEntity display(){
        ArrayList<Blog>blogs=blogService.displayBlogs();
        return ResponseEntity.status(HttpStatus.OK).body(blogs);
    }
    @PostMapping("/add")
    public ResponseEntity addBlog(@RequestBody@Valid Blog blog, Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        blogService.addBlog(blog);
        return ResponseEntity.status(HttpStatus.OK).body("blog added");
    }
    @PutMapping("/update/{id}")
    public ResponseEntity updateBlog(@PathVariable String id,@RequestBody@Valid Blog blog,Errors errors){
        if(errors.hasErrors()){
            String message=errors.getFieldError().getDefaultMessage();
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(message);
        }
        boolean isFound=blogService.updateBlog(id,blog);
        if(isFound){
           return ResponseEntity.status(HttpStatus.OK).body("blog updated");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
    @DeleteMapping("/delete/{id}")
    public ResponseEntity deleteBlog(@PathVariable String id){
        boolean isDeleted=blogService.deleteBlog(id);
        if(isDeleted){
           return ResponseEntity.status(HttpStatus.OK).body("blog deleted");
        }
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("wrong id");
    }
}
