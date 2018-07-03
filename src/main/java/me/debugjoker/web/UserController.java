package me.debugjoker.web;

import me.debugjoker.entity.User;
import me.debugjoker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
@RequestMapping
@SessionAttributes(value = {"studentId","warning","admin"})
public class UserController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private UserService userService;

    @RequestMapping("/index")
    public ModelAndView index(){
        try {
            ModelAndView modelAndView = new ModelAndView("login");
            return modelAndView;
        }catch (Exception e){
            logger.error(e.getMessage(), e);
            return null;
        }
    }

    @RequestMapping(value = "/user/login",method = RequestMethod.POST)
    public String login(@RequestParam("studentId")long studentId,
                        @RequestParam("studentPassWord")String passWord,Map<String,Object> map){

        User user = userService.infoUser(studentId);
        //密码验证
        if (passWord.equals(user.getStudentPassword()) && user.isIdentity()){
            map.put("studentId",user.getStudentId());
            return "redirect:/course/list";
        }else if (passWord.equals(user.getStudentPassword()) && !user.isIdentity()){
            map.put("admin",user.getStudentName());
            return "redirect:/admin/user/list";
        } else{
            map.put("error","用户名或密码错误");
            return "forward:/index";
        }
    }

    @RequestMapping(value = "/user/login" , method = RequestMethod.GET)
    public String getLogin(){
        return "redirect:/index";
    }

    //跳转到登录界面
    @RequestMapping(value = "/user/register",method = RequestMethod.GET)
    public String getRegister(){
        return "register";
    }

    //注册逻辑
    @RequestMapping(value = "/user/register",method = RequestMethod.POST)
    public String register(User user,Map<String,Object> map){

        int result = userService.addUser(user.getStudentId(),user.getStudentName(),
                user.getStudentClassName(),user.getStudentPassword());
        if (result <= 0){
            //用户名已注册
            map.put("warning","该学号已被注册");
            return "redirect:/user/register";

        }else {
            //注册成功
            return "redirect:/index";
        }
    }



}
