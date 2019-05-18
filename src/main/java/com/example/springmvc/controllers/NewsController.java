package com.example.springmvc.controllers;

import com.example.springmvc.Utils.FakeUtils;
import com.example.springmvc.models.News;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by nhs3108 on 16/03/2017.
 */
@RestController
@RequestMapping(value = "/news")
public class NewsController {
    @RequestMapping(method = RequestMethod.GET)


    public List<News> news(HttpServletRequest request) {
        return FakeUtils.getAllNews();
    }
}
