package com.web.controller;

import com.web.dao.admin.AdminDao;
import com.web.dao.admin.AdminDaoImple;
import com.web.dao.bloodBanks.BloodBankDao;
import com.web.dao.bloodBanks.BloodBankDaoImple;
import com.web.model.Admin;
import com.web.model.BloodBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    String adminUri = "Blood_Bank/adminview?email=anas%40gmail.com&password=anas123&Submit=Submit+Query";

    @Autowired
    private AdminDao adminDao;

    Admin admin;

    @Autowired
    private BloodBankDaoImple bloodBankDaoImple;

    @RequestMapping("/")
    public String showHome() {
        return "index";
    }


    @RequestMapping("/admin")
    public String adminLoginForm() {
        return "adminLoginForm";
    }

    // Show all banks
    @RequestMapping(value = "/adminValidate", method = RequestMethod.POST)
    public String bankList(@RequestParam String email, @RequestParam String password, ModelMap model) {
        System.out.println(email);
        admin = adminDao.get(email);
        if (email.equalsIgnoreCase(admin.getAdminEmail())) {
            if (password.equalsIgnoreCase(admin.getAdminPassword())) {
                return "redirect:/bankList";
            } else {
                model.addAttribute("msg", "Password incorrect");
                return "error";
            }
        } else {
            model.addAttribute("msg", "Email incorrect");
            return "error";
        }
    }

    // Bank List
    @RequestMapping("bankList")
    public String bankList(ModelMap model) {
        model.put("name", admin.getAdminName());
        model.put("list", bloodBankDaoImple.getBanks());
        return "bankList";
    }

    //Bank Details view page
    @RequestMapping("bloodBankDetailes/{bankId}")
    public String showBankDetails(@PathVariable("bankId") int bankId, ModelMap modelMap) {
        modelMap.put("bloodBankObj", bloodBankDaoImple.findById(bankId));
        return "bloodBankDetails";
    }

    //delete bank
    @RequestMapping(value = "bloodBankDelete/{bankId}")
    public String deleteBank(@PathVariable("bankId") int bankId) {
        bloodBankDaoImple.delete(bankId);
        return "redirect:/bankList";
    }

    //Update bank Form
    @RequestMapping(value = "bloodBankUpdate/{bankId}")
    public String updateBank(@ModelAttribute("BloodBank") BloodBank bloodBank, @PathVariable("bankId") int bankId) {
        BloodBank byId = bloodBankDaoImple.findById(bankId);
        bloodBank.setBankId(byId.getBankId());
        bloodBank.setBankName(byId.getBankName());
        bloodBank.setBankAddress(byId.getBankAddress());
        bloodBank.setGroupAPosUnit(byId.getGroupAPosUnit());
        bloodBank.setGroupBPosUnit(byId.getGroupBPosUnit());
        bloodBank.setGroupOPosUnit(byId.getGroupOPosUnit());
        bloodBank.setGroupABPosUnit(byId.getGroupABPosUnit());
        bloodBank.setGroupANegUnit(byId.getGroupANegUnit());
        bloodBank.setGroupBNegUnit(byId.getGroupBNegUnit());
        bloodBank.setGroupBNegUnit(byId.getGroupBNegUnit());
        bloodBank.setGroupONegUnit(byId.getGroupONegUnit());
        bloodBank.setGroupABNegUnit(byId.getGroupABNegUnit());
        return "updateBloodBankForm";
    }
    // submit update data form
    @RequestMapping(value = "/bloodBankUpdate/updateDataSubmit")
    public String  updateDataSubmit(@ModelAttribute("BloodBank") BloodBank bloodBank, BindingResult result) {
        if (result.hasErrors()){
            System.out.println("Error in biniding");
            return "error";
        }
        bloodBankDaoImple.saveOrUpdate(bloodBank);
        return "redirect:/bankList";
    }

    // add new Blood Bank Form
    @RequestMapping("addNewBloodBankForm")
    public String addNewBloodBankForm(@ModelAttribute("BloodBank")BloodBank bloodBank){
        return "addNewBloodBankForm";
    }

    // add new blood bank submit
    @PostMapping("addNewBloodBankSubmit")
    public String addNewBloodBankSubmit(@ModelAttribute("BloodBank") BloodBank bloodBank){
        bloodBankDaoImple.addNewBloodBank(bloodBank);
        return "redirect:/bankList";
    }

}
