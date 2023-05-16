package com.itwst.controller;

import com.itwst.domain.Stu;
import com.itwst.domain.Stu2_Score;
import com.itwst.domain.Stu_Score;
import com.itwst.service.StuService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import java.util.List;

/**
 * name:Mir_Wang
 * Auther:1063383540@qq.com
 */
@Controller
public class StuController {
    @Resource
    private StuService service;

    @RequestMapping("/outLogin")
    public String outLogin(HttpServletRequest request){
        HttpSession session = request.getSession();
        session.removeAttribute("username");
        return "index";
    }

    @RequestMapping("/selAll")
    public String selAll(Model model){
        List<Stu> stuList = service.findAll();
        int size = stuList.size();
        if (stuList.isEmpty()){
            System.out.println("null");
            return "article";
        }else {
            System.out.println(stuList);
            model.addAttribute("stuList",stuList);
            model.addAttribute("size",size);
            return "article";
        }
    }

    @RequestMapping("/addStu")
    private String addStu(Model model,Stu stu){
        service.addStu(stu);
        Stu_Score likeStu = service.selByLikeName(stu.getName());
        Stu2_Score wenkeStu = service.selByWenkeName(stu.getName());
        if (stu.getMajor().equals("理科")){
            if (likeStu==null){
                model.addAttribute("name",stu.getName());
                return "addLike";
            }else {
                return "article";
            }
        }else {
            if (wenkeStu==null){
                model.addAttribute("name",stu.getName());
                return "addWenke";
            }else {
                return "article";
            }
        }
    }

    @RequestMapping("/addLikeScore")
    private String addLikeScore(String name,Integer chinese,Integer math,Integer english,Integer physics,Integer chemistry,Integer biology,Model model){
        service.addLikeStuScore(name,chinese,math,english,physics,chemistry,biology);
        List<Stu> stuList = service.selByName(name);
        if (stuList.isEmpty()){
            model.addAttribute("name",name);
            return "add";
        }else {
            System.out.println("null");
            return "article";
        }
    }
    @RequestMapping("/addWenkeScore")
    private String addWenkeScore(Model model,String name,Integer chinese,Integer math,Integer english,Integer politics,Integer history,Integer geography){
        service.addWenkeStuScore(name,chinese,math,english,politics,history,geography);
        List<Stu> stuList = service.selByName(name);
        if (stuList.isEmpty()){
            model.addAttribute("name",name);
            return "add";
        }else {
            System.out.println("null");
            return "article";
        }
    }

    @RequestMapping("/delete")
    private String delete(String id){
        System.out.println(id);
        service.delete(id);
        return "article";
    }

    @RequestMapping("/deleteByName")
    private String deleteByName(String name){
        System.out.println(name);
        service.deleteByName(name);
        return "likepage";
    }

    @RequestMapping("/deleteByWenkeName")
    private String deleteByWenkeName(String name){
        System.out.println(name);
        service.deleteByWenKeName(name);
        return "wenkePage";
    }


    @RequestMapping("/deleteWorkerSome")
    private String deleteWorkerSome(HttpServletRequest request){
        String uid = request.getParameter("id");
        System.out.println(uid);
        String[] ids = uid.split(",");
        ArrayList<String> idList = new ArrayList<>();
        int rows=-1;
        for (int i = 0; i < ids.length; i++) {
            idList.add(ids[i]);
            rows = service.deleteWorkerSome(idList);
        }
        if (rows>0){
            System.out.println(rows+"行受响应");
        }else {
            System.out.println("删除失败");
        }
        return "article";
    }

    @RequestMapping("/deleteWorkerSomeByName")
    private String deleteWorkerSomeByName(HttpServletRequest request){
        String uname = request.getParameter("name");
        System.out.println(uname);
        String[] names = uname.split(",");
        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            nameList.add(names[i]);
            service.deleteWorkerSomeByName(nameList);
        }
        return "likepage";
    }

    @RequestMapping("/deleteWorkerSomeByWenKeName")
    private String deleteWorkerSomeByWenKeName(HttpServletRequest request){
        String uname = request.getParameter("name");
        System.out.println(uname);
        String[] names = uname.split(",");
        ArrayList<String> nameList = new ArrayList<>();
        for (int i = 0; i < names.length; i++) {
            nameList.add(names[i]);
            service.deleteWorkerSomeByWenKeName(nameList);
        }
        return "wenkePage";
    }

    @RequestMapping("/editUpdate")
    private String editUpdate(Integer id,Model model){
        Stu stu = service.selById(id);
        if (stu!=null){
            model.addAttribute("stu",stu);
            return "update-article";
        }else {
            return "article";
        }
    }

    @RequestMapping("/updateStu")
    private String updateStu(Stu stu){
        service.updateStu(stu);
        return "article";
    }

    @RequestMapping(value = "/updateLike",method = RequestMethod.POST)
    private String updateLike(Integer id,String name,Integer chinese,Integer math,Integer english,Integer physics,Integer chemistry,Integer biology){
        Stu_Score stu = new Stu_Score(id, name, chinese, math, english, physics, chemistry, biology);
        System.out.println(stu);
        service.updateLike(stu);
        return "likepage";
    }

    @RequestMapping("/updateWenke")
    private String updateWenke(Stu2_Score stu){
        service.updateWenke(stu);
        System.out.println(stu);
        return "wenkePage";
    }

    @RequestMapping("/editUpdateByName")
    private String editUpdateByName(String name,Model model){
        Stu_Score stu = service.selByLikeName(name);
        if (stu!=null){
            model.addAttribute("stusc",stu);
            return "update-like";
        }else {
            return "likepage";
        }
    }

    @RequestMapping("/editUpdateByWenName")
    private String editUpdateByWenName(String name,Model model){
        Stu2_Score stu = service.selByWenkeName(name);
        if (stu!=null){
            model.addAttribute("stu",stu);
            return "update-wenke";
        }else {
            return "wenkePage";
        }
    }

    @RequestMapping(value = "/selByName",method = RequestMethod.POST)
    private String selByName(String name,Model model){
        System.out.println(name);
        List<Stu> stuList = service.selByName(name);
        model.addAttribute("stuList",stuList);
        System.out.println(stuList);
        return "comment";
    }

    @RequestMapping(value = "/selById",method = RequestMethod.POST)
    private String selById(Integer id,Model model){
        System.out.println(id);
        Stu stuList = service.selById(id);
        model.addAttribute("stuList",stuList);
        System.out.println(stuList);
        return "comment";
    }

    @RequestMapping(value = "/selBySex",method = RequestMethod.POST)
    private String selBySex(String sex,Model model){
        System.out.println(sex);
        List<Stu> stuList = service.selBySex(sex);
        model.addAttribute("stuList",stuList);
        System.out.println(stuList);
        return "comment";
    }

    @RequestMapping(value = "/selByAge",method = RequestMethod.POST)
    private String selByAge(Integer age,Model model){
        System.out.println(age);
        List<Stu> stuList = service.selByAge(age);
        model.addAttribute("stuList",stuList);
        System.out.println(stuList);
        return "comment";
    }

    @RequestMapping(value = "/selByScore",method = RequestMethod.POST)
    private String selByScore(String address,Model model){
        System.out.println(address);
        List<Stu> stuList = service.selByScore(address);
        model.addAttribute("stuList",stuList);
        System.out.println(stuList);
        return "comment";
    }

    @RequestMapping(value = "/selByTel",method = RequestMethod.POST)
    private String selByTel(String tel,Model model){
        System.out.println(tel);
        List<Stu> stuList = service.selByTel(tel);
        model.addAttribute("stuList",stuList);
        System.out.println(stuList);
        return "comment";
    }

    @RequestMapping(value = "/selByClassId",method = RequestMethod.POST)
    private String selByClassId(String classid,Model model){
        System.out.println(classid);
        List<Stu> stuList = service.selByClassId(classid);
        model.addAttribute("stuList",stuList);
        System.out.println(stuList);
        return "comment";
    }

    @RequestMapping(value = "/selByMajor",method = RequestMethod.POST)
    private String selByMajor(String major,Model model){
        System.out.println(major);
        List<Stu> stuList = service.selByMajor(major);
        model.addAttribute("stuList",stuList);
        System.out.println(stuList);
        return "comment";
    }

    @RequestMapping("/selMajorStu1")
    public String selMajorStu1(Model model){
        List<Stu_Score> stuList = service.selByMajorScore();
        if (stuList.isEmpty()){
            return "article";
        }else {
            model.addAttribute("stuScore",stuList);
            return "likepage";
        }
    }

    @RequestMapping("/selMajorStu2")
    public String selMajorStu2(Model model){
        List<Stu2_Score> stuList = service.selByMajorScore2();
        if (stuList.isEmpty()){
            return "article";
        }else {
            model.addAttribute("stuScore2",stuList);
            return "wenkePage";
        }
    }



}
