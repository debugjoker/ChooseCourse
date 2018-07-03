package me.debugjoker.web;

import me.debugjoker.dto.ChooseResult;
import me.debugjoker.dto.CourseExecution;
import me.debugjoker.dto.Exposer;
import me.debugjoker.entity.Course;
import me.debugjoker.entity.User;
import me.debugjoker.enums.CourseStateEnum;
import me.debugjoker.exception.ChooseCloseException;
import me.debugjoker.exception.RepeatChooseException;
import me.debugjoker.service.CourseService;
import me.debugjoker.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.PrintWriter;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/course")
public class CourseController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private CourseService courseService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model,HttpServletRequest request,HttpServletResponse resp) throws Exception{
        String studentId = request.getParameter("studentId");
        //如果session中有studentID
        if (!"".equals(studentId)){
            List<Course> courseList = courseService.getCourseList();
            model.addAttribute("list", courseList);
            return "list";
        }else {
            return "forward:/time/now";
        }

    }


    @RequestMapping(value = "/{courseId}/detail", method = RequestMethod.GET)
    public String detail(@PathVariable("courseId") Long courseId, Model model,HttpSession session) {
        if (courseId == null) {
            return "redirect:/course/list";
        }
        Course course = courseService.queryCourseById(courseId);
        if (course == null) {
            return "forward:/course/list";
        }

        Long studentId = (Long) session.getAttribute("studentId");
        if (studentId == null){
            return "redirect:/index";
        }

        model.addAttribute("course", course);

        return "detail";
    }

    @RequestMapping(value = "/{courseId}/exposer",
            method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ChooseResult<Exposer> exposer(@PathVariable("courseId") Long courseId) {
        ChooseResult<Exposer> result;
        try {
            Exposer exposer = courseService.exportCourseUrl(courseId);
            result = new ChooseResult<Exposer>(true, exposer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new ChooseResult<Exposer>(false, e.getMessage());
        }

        return result;
    }

    @RequestMapping(value = "/{courseId}/{md5}/execution",
            method = RequestMethod.POST, produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public ChooseResult<CourseExecution> execute(@PathVariable("courseId") Long courseId,
                                                 @PathVariable("md5") String md5,
                                                 @CookieValue(value = "studentId",required = false) Long studentId,HttpSession session) {
        studentId = (Long)session.getAttribute("studentId");
        ChooseResult<CourseExecution> result;
        if (studentId == null){
            return new ChooseResult<CourseExecution>(false,"未登录");
        }
        try {
            CourseExecution execution = courseService.executeCourseChoose(courseId,studentId,md5);
            return new ChooseResult<CourseExecution>(true,execution);
        }catch (RepeatChooseException e){
            CourseExecution execution = new CourseExecution(courseId,CourseStateEnum.REPEAT_CHOOSE);
            return new ChooseResult<CourseExecution>(false,execution);
        }catch (ChooseCloseException e){
            CourseExecution execution = new CourseExecution(courseId,CourseStateEnum.END);
            return new ChooseResult<CourseExecution>(false,execution);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            CourseExecution execution = new CourseExecution(courseId,CourseStateEnum.INNER_ERROR);
            return new ChooseResult<CourseExecution>(false,execution);
        }
    }

    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    @ResponseBody
    public ChooseResult<Long> time(){
        Date nowTime = new Date();
        return new ChooseResult<Long>(true,nowTime.getTime());
    }


}
