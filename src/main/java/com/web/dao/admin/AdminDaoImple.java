package com.web.dao.admin;

import com.web.model.Admin;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImple implements AdminDao {


    //injecting dataSource in jdbcTemplate via @Autovired

    private JdbcTemplate jdbcTemplate;

    //or

    //injecting dataSource in jdbcTemplate via conctructor
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }



    @Override
    public void saveOrUpdate(Admin admin) {
        if (admin.getAdminId()>0){
            String sql = "UPDATE admin SET name=?, email=?, address=?, "
                    + "telephone=? WHERE contact_id=?";
        }

    }

    @Override
    public void delete(int adminId) {

    }

    @Override
    public Admin get(String  adEmail) {
        String sql  = "SELECT * FROM admin WHERE adminEmail =?";
        return jdbcTemplate.query(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,adEmail);
            }
        }, new ResultSetExtractor<Admin>() {
            @Override
            public Admin extractData(ResultSet rs) throws SQLException, DataAccessException {
                if (rs.next()) {
                    Admin admin = new Admin();
                    admin.setAdminId(rs.getInt("adminId"));
                    admin.setAdminName(rs.getString("adminName"));
                    admin.setAdminEmail(rs.getString("adminEmail"));
                    admin.setAdminPassword(rs.getString("adminPassword"));

                    return admin;
                }
                return new Admin();
            }
        });

        //or we can also use BeanPropertyRowMapper
//        public Admin get(int contactId) {
//            String sql = "SELECT * FROM Contact WHERE id=" + contactId;
//            return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Admin.class));
//        }

    }
}
