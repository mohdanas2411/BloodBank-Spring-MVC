package com.web.controller;

import com.web.dao.bloodBanks.BloodBankDaoImple;
import com.web.model.BloodBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

@Controller
public class BloodBankController {

    @Autowired
    private BloodBankDaoImple bloodBankDaoImple;

    // Bank List
    @GetMapping("bankList")
    public String bankList(ModelMap model) {
        model.put("list", bloodBankDaoImple.getBanks());
        return "bankList";
    }

    //Bank Details view page
    @GetMapping("bloodBankDetailes/{bankId}")
    public String showBankDetails(@PathVariable("bankId") int bankId, ModelMap modelMap) {
        modelMap.put("bloodBankObj", bloodBankDaoImple.findById(bankId));
        return "bloodBankDetails";
    }

    //delete bank
    @GetMapping("bloodBankDelete/{bankId}")
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
    public String  updateDataSubmit(@ModelAttribute("BloodBank") BloodBank bloodBank, BindingResult result, Model model) {
        if (result.hasErrors()){
            System.out.println("Error in biniding");
            model.addAttribute("msg","Mismatch data type");
            model.addAttribute("redirectTo","/Blood_Bank/bankList");
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
