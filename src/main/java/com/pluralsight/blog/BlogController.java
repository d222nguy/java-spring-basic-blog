package com.pluralsight.blog;

import com.pluralsight.blog.data.PostRepository;
import com.pluralsight.blog.model.Post;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import java.util.List;
@Controller
public class BlogController {
    public BlogController(PostRepository pr){
        this.postRepository = pr;
    }
    @RequestMapping("/") //to route requests to this method
    public String listPosts(ModelMap mm){

        mm.put("title", "Blog Post 1");
        List<Post> allPosts = this.postRepository.getAllPosts();
        mm.put("posts", (Object) allPosts);
        return "home";
    }
    @RequestMapping("/post/{id}")
    public String postDetails(@PathVariable Long id, ModelMap modelMap){
        modelMap.put("post", this.postRepository.findById(id));
        return "post-details";
    }
    private PostRepository postRepository;
}
