package br.edu.unp.blog.backend.resources;

import br.edu.unp.blog.backend.datasource.repositories.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/posts")
public class PostResource {

    @Autowired
    private PostRepository postRepository;

    @GetMapping("/")
    public String hello(){
        return "HelloWorld carai!";
    }
}
