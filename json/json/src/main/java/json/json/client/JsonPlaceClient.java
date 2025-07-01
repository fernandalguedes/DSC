package json.json.client;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import json.json.dto.Post;

@FeignClient(name = "jsonPlaceholder", url = "https://jsonplaceholder.typicode.com")
public interface JsonPlaceClient {

    @GetMapping("/posts")
    List<Post> listarPosts();

    @GetMapping("/posts/{id}")
    Post buscarPorId(@PathVariable("id") Long id);
}



