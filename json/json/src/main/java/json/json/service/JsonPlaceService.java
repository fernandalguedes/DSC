package json.json.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import json.json.client.JsonPlaceClient;
import json.json.dto.Post;

@Service
public class JsonPlaceService {
    @Autowired
    private JsonPlaceClient jsonPlaceClient;

    public Post buscarPorID(Long id) {
        return jsonPlaceClient.buscarPorId(id);
    }
    public List<Post> listarPosts(){
          return jsonPlaceClient.listarPosts();
    }

}
