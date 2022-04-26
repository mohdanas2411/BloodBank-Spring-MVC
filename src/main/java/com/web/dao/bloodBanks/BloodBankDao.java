package com.web.dao.bloodBanks;

import com.web.model.Admin;
import com.web.model.BloodBank;
import org.springframework.stereotype.Component;

import java.util.List;
public interface BloodBankDao {
    public void saveOrUpdate(BloodBank bldbnk);

    public void delete(int bloodBankId);

    public BloodBank findById(int bankId);

    public List<BloodBank> getBanks();

    public void addNewBloodBank(BloodBank bloodBank);

}
