package pl.ms.SafeDriving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.ms.SafeDriving.service.UserService;

@Controller
public class ForumController {

    @Autowired
    private UserService userService;


    @GetMapping(value = "/forum")
    public ModelAndView forum(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("forum/forumMain");
        return modelAndView;
    }
}
