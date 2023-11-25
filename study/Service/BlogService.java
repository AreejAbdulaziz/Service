package com.example.study.Service;

import com.example.study.Model.Blog;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class BlogService {
    ArrayList<Blog>blogs=new ArrayList<>();
    public ArrayList<Blog>displayBlogs(){
        return blogs;
    }
    public void addBlog(Blog blog){
        blogs.add(blog);
    }
    public boolean updateBlog(String id,Blog blog){
        for(int i=0;i<blogs.size();i++){
            if(blogs.get(i).getId().equals(id)){
                blogs.set(i,blog);
                return true;
            }
        } return false;
    }
    public boolean deleteBlog(String id){
        for(int i=0;i<blogs.size();i++){
            if(blogs.get(i).getId().equals(id)){
                blogs.remove(i);
                return true;
            }
        } return false;
    }
}
