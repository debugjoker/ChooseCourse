package me.debugjoker.web;

import me.debugjoker.entity.Course;
import me.debugjoker.entity.User;
import me.debugjoker.service.CourseService;
import me.debugjoker.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Controller
@SessionAttributes(value = {"userList","thisUser","courseList","thisCourse"})
@RequestMapping("/admin")
public class CMSController {

    @Autowired
    private UserService userService;

    @Autowired
    private CourseService courseService;

    @RequestMapping("user/list")
    public String checkLogin(HttpServletRequest request,Model model){
        String isAdmin = request.getParameter("admin");
        if (isAdmin != null && isAdmin.trim().length() != 0){
            List<User> userList = userService.queryAll();
            model.addAttribute("userList",userList);
            return "cms_User";//跳转到后台界面
        }else{
            System.out.println("come in the error page!");
            return "redirect:/index";
        }
    }

    @RequestMapping(value = "user/showlist",method = RequestMethod.GET)
    public String showList(HttpServletRequest request,Model model){
        List<User> userList = userService.queryAll();
        model.addAttribute("userList",userList);
        return "cms_User";//跳转到后台界面
    }

    @RequestMapping(value = "user/add",method = RequestMethod.POST)
    public String addUser(User user,Map<String,Object> map){
        int result = userService.addUser(user.getStudentId(),user.getStudentName(),
                user.getStudentClassName(),user.getStudentPassword());
        System.out.println("user = " + user);
        if (result <= 0){
            //用户名已注册
            map.put("warning","该学号已被注册");
            return "cms_User";
        }else {
            //注册成功
            return "redirect:/admin/user/showlist";
        }
    }


    @RequestMapping(value = "{userId}/delete",method = RequestMethod.DELETE)
    public String deleteUser(@PathVariable("userId")Long userId){
        int result =  userService.deleteUser(userId);
        if (result >= 0){
            System.out.println("删除成功！");
        }
        return "redirect:/admin/user/showlist";
    }

    //通过ID获取用户信息传值回显
    @RequestMapping(value = "{userId}/detail",method = RequestMethod.GET)
    public String getUserInfo(@PathVariable("userId")Long userId,Model model){
        User user = userService.infoUser(userId);
        model.addAttribute("thisUser",user);
        return "cms_UserChange";
    }

    //修改用户信息
    @RequestMapping(value = "{userId}/update",method = RequestMethod.PUT)
    public String changeUserInfo(User user){
//        System.out.println("changeUser = " + user);
        int result = userService.changeUser(user.getStudentId(),user.getStudentName(),user.getStudentClassName(),user.getStudentPassword());
        return "redirect:/admin/user/showlist";
    }

    //查询所有课程信息
    @RequestMapping(value = "course/list",method = RequestMethod.GET)
    public String getCourseList(Model model){
        List<Course> courseList = courseService.getCourseList();
        model.addAttribute("courseList",courseList);
        return "cms_Course";
    }

    //删除课程
    @RequestMapping(value = "course/{courseId}/delete",method = RequestMethod.DELETE)
    public String deleteCourse(@PathVariable("courseId") Long courseId){
        courseService.deleteCourseById(courseId);
        return "redirect:/admin/course/list";
    }

    //选课详情
    @RequestMapping(value = "course/{courseId}/chooseDetail")
    public String queryChooseCourseDetail(@PathVariable("courseId")long courseId,Model model){
        List<User> userList = courseService.queryChooseCourseDetail(courseId);
        model.addAttribute("chooseList",userList);
        return "cms_ChooseDetail";
    }

    @RequestMapping(value = "course/add",method = RequestMethod.POST)
    public String addCourse(@RequestParam String courseName, @RequestParam int courseNumber, @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")Date startTime, @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")Date endTime){
        String start_Time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime);
        String end_Time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endTime);
        courseService.addCourse(courseName,courseNumber,start_Time,end_Time);
//        System.out.println("start_Time = " + start_Time + end_Time);
        return "redirect:/admin/course/list";
    }

    //通过ID获取课程信息传值回显
    @RequestMapping( value = "course/{courseId}/detail" ,method = RequestMethod.GET)
    public String getCourseInfo(@PathVariable long courseId,Model model){
        Course course = courseService.queryCourseById(courseId);
        model.addAttribute("thisCourse",course);
        return "cms_CourseChange";
    }

    @RequestMapping(value = "course/{courseId}/update",method = RequestMethod.PUT)
    public String changeCourseInfo(@RequestParam String courseName, @RequestParam int courseNumber,
                                   @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")Date startTime,
                                   @DateTimeFormat(pattern = "yyyy/MM/dd HH:mm:ss")Date endTime,
                                   @PathVariable("courseId")long courseId){
        String start_Time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTime);
        String end_Time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(endTime);
        courseService.changeCourseInfo(courseName,courseNumber,start_Time,end_Time,courseId);
        return "redirect:/admin/course/list";
    }

}
