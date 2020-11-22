package example.test.web;

import example.test.model.Course;
import example.test.model.Statistic;
import example.test.service.CourseService;
import example.test.service.StatisticService;
import example.test.service.ThemaService;
import org.apache.tomcat.util.net.openssl.ciphers.Authentication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.*;

@Controller
public class StatisticController {
    @Autowired
    private CourseService courseService;

    @Autowired
    private ThemaService themaService;

    @Autowired
    private StatisticService statisticService;

    @GetMapping("/{course}/statistic")
    public String courseStat(@PathVariable("course") String course,
                             Model model) {
        Course courseForStat = courseService.findByCourse(course);
        model.addAttribute("statList", statisticService.findByIdCourse(courseForStat.getId()));
        model.addAttribute("course",course);
        model.addAttribute("courseName", courseForStat.getCourseName());
        return "statistic";
    }


}

