package pl.ms.SafeDriving.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import pl.ms.SafeDriving.model.User;
import pl.ms.SafeDriving.service.UserService;

import javax.validation.Valid;

@Controller
@RequestMapping("/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping(value = "/dashboard")
    public ModelAndView home(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserEmail(auth.getName());
        modelAndView.setViewName("dashboard");
        return modelAndView;
    }

    @GetMapping(value = "/edit")
    public ModelAndView userEditView(){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        User user = userService.findByUserEmail(auth.getName());
        modelAndView.addObject("user", user);
        modelAndView.setViewName("userEdit");
        return modelAndView;
    }

    @PostMapping(value = "/edit")
    public ModelAndView userEditForm(@Valid User user, BindingResult bindingResult){
        ModelAndView modelAndView = new ModelAndView();
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        user = userService.findByUserEmail(auth.getName());
        user.setFirstName(user.getFirstName());
        user.setLastName(user.getLastName());
        user.setBirthdate(user.getBirthdate());
        user.setAddress(user.getAddress());
        user.setOccupation(user.getOccupation());
        userService.saveUser(user);
        modelAndView.addObject("successMessage", "User has been edited successfully");
        modelAndView.setViewName("userEdit");
        return modelAndView;
    }

}
