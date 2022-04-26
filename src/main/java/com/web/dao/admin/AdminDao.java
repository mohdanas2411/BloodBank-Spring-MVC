package com.web.dao.admin;

import com.web.model.Admin;

import java.util.List;

public interface AdminDao {
    public void saveOrUpdate(Admin admin);

    public void delete(int adminId);

    public Admin get(String adEmail);
}
