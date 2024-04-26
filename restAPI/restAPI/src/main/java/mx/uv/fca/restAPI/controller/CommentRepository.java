package mx.uv.fca.restAPI.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CommentRepository {
    @Autowired
    private MongoTemplate template;

}