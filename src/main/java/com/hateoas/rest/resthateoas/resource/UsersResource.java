package com.hateoas.rest.resthateoas.resource;

import com.hateoas.rest.resthateoas.model.Users;
import org.springframework.boot.SpringApplication;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.MediaTypes;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.Arrays;
import java.util.List;

//
@RestController
@RequestMapping("/rest/sales")
public class UsersResource {

//  POST request handler
    @PostMapping ("/add/{name}/{revenue}")
    void insertProduct (@PathVariable String name, long revenue){
        methods.insertOperation(name, revenue);
    }

//  GET request handler
    @GetMapping(value = "/product/{name}", produces = MediaTypes.HAL_JSON_VALUE)
    ResultSet getter (@PathVariable String name){
        return methods.returnSearch(name);
    }

    @GetMapping(value = "/hateoas/all", produces = MediaTypes.HAL_JSON_VALUE)
    public List<Users> getHateOASAll(){
        Users user1 = new Users("one", 100L);
        Link link = WebMvcLinkBuilder.linkTo(UsersResource.class)
                .slash(user1.getName()).withSelfRel();
        user1.add(link);
        return Arrays.asList(user1);
    }




    @GetMapping("/all")
    public List<Users> getAll(){
        Users user1 = new Users("one", 100L);
        Users user2 = new Users("two", 1022L);
        Users user3 = new Users("three", 400L);
        Users user4 = new Users("four", 1420L);
        return Arrays.asList(user1, user2, user3, user4);
    }



    public static void main (String[] args){
        SpringApplication.run(UsersResource.class, args);
    }
}
