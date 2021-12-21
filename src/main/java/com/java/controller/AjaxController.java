package com.java.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.java.pojo.Books;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lingfeng
 * @date 2021-12-21
 */
@RestController
public class AjaxController {

    @RequestMapping("/a1")

    public String ajax1(String name ) throws IOException {
        if ("admin".equals(name)){
            return "对";
        }else{
            return "错";
        }
    }

    @RequestMapping("/allBook")
    public List<Books>  AllBooks(){
        List<Books> list = new ArrayList<Books>();
        list.add(new Books(1,"aa",2,"ss"));
        list.add(new Books(2,"bb",2,"ee"));
        list.add(new Books(3,"cc",2,"rr"));
        return list; //
    }

}
