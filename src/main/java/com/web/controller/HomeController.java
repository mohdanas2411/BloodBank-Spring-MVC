package com.web.controller;

import com.web.dao.admin.AdminDao;
import com.web.dao.admin.AdminDaoImple;
import com.web.dao.bloodBanks.BloodBankDao;
import com.web.dao.bloodBanks.BloodBankDaoImple;
import com.web.model.Admin;
import com.web.model.BloodBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.awt.*;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes({"admin","name"})
public class HomeController {
    @Autowired
    private AdminDao adminDao;

    @RequestMapping("/")
    public String showHome(Model model) {
        model.addAttribute("admin",new Admin());
        return "index";
    }


// @ModelAttribute("admin")
//    public Admin getAddmin(){
//        return new Admin();
//    }
    @RequestMapping("/adminLogin")
    public String adminLoginForm() {
//        model.addAttribute("email",admin.getAdminEmail());
//        model.addAttribute("password",admin.getAdminPassword());
        return "adminLoginForm";
    }

    // Show all banks
//    @RequestMapping(value = "/adminValidate", method = RequestMethod.POST)
//    public String bankList(@RequestParam String adminEmail, @RequestParam String adminPassword, ModelMap model) {
//        System.out.println(adminEmail);
//        admin = adminDao.get(adminEmail);
//        if (adminEmail.equalsIgnoreCase(admin.getAdminEmail())) {
//            if (adminPassword.equalsIgnoreCase(admin.getAdminPassword())) {
//                return "redirect:/bankList";
//            } else {
//                model.addAttribute("msg", "Password incorrect");
//                return "error";
//            }
//        } else {
//            model.addAttribute("msg", "Email incorrect");
//            return "error";
//        }
//    }

    // OR

//    @PostMapping(path = "/adminValidate" , consumes = {MediaType.APPLICATION_JSON_VALUE})
//    public String bankList(@Valid @RequestBody Admin adm, ModelMap model) {
    @PostMapping(path = "/adminValidate")
    public String bankList(@ModelAttribute("admin") Admin adm, ModelMap model) {
        Admin admin = adminDao.get(adm.getAdminEmail());
        if (adm.getAdminEmail().equalsIgnoreCase(admin.getAdminEmail())) {
            if (adm.getAdminPassword().equalsIgnoreCase(admin.getAdminPassword())) {
                model.put("name", admin.getAdminName());
                return "redirect:/bankList";
            } else {
                model.addAttribute("msg", "Password incorrect");
                model.addAttribute("redirectTo","/Blood_Bank/adminLogin");
                return "error";
            }
        } else {
            model.addAttribute("msg", "Email incorrect");
            model.addAttribute("redirectTo","/Blood_Bank/adminLogin");
            return "error";
        }
    }


    @GetMapping("adminLogout")
    public String logOutAdmin(SessionStatus sessionStatus){
       //sessionStatus.setComplete();
        return "redirect:/adminLogin";
    }

}
