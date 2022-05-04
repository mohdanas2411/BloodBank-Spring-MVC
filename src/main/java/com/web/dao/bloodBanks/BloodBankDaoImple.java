package com.web.dao.bloodBanks;

import com.web.model.BloodBank;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.PreparedStatementSetter;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

@Repository
public class BloodBankDaoImple implements BloodBankDao {


    //injecting dataSource in jdbcTemplate via @Autovired

    private JdbcTemplate jdbcTemplate;

    //or

    @Autowired//injecting dataSource in jdbcTemplate via conctructor
    public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }


    @Override
    public BloodBank findById(int bankId) {
        String sql = "SELECT * FROM bloodBanks where bankId = "+bankId;
        List<BloodBank> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(BloodBank.class));
    return list.get(0);
    }

    @Override
    public void saveOrUpdate(BloodBank bloodBank) {
        String sql = "UPDATE bloodBanks SET bankName = ?, bankAddress= ?, groupABNegUnit = ?, groupABPosUnit = ?,  groupANegUnit = ?, groupAPosUnit = ?,  groupBNegUnit = ?, groupBPosUnit = ?,  groupONegUnit = ?, groupOPosUnit = ? WHERE bankId = "+bloodBank.getBankId();

        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,bloodBank.getBankName());
                ps.setString(2,bloodBank.getBankAddress());
                ps.setInt(3,bloodBank.getGroupABNegUnit());
                ps.setInt(4,bloodBank.getGroupABPosUnit());
                ps.setInt(5,bloodBank.getGroupANegUnit());
                ps.setInt(6,bloodBank.getGroupAPosUnit());
                ps.setInt(7,bloodBank.getGroupBNegUnit());
                ps.setInt(8,bloodBank.getGroupBPosUnit());
                ps.setInt(9,bloodBank.getGroupONegUnit());
                ps.setInt(10,bloodBank.getGroupOPosUnit());
            }
        });
    }

    @Override
    public void delete(int bankId) {
        String sql = "DELETE FROM bloodBanks where bankId = "+bankId;
        jdbcTemplate.update(sql);
    }

    @Override
    public void addNewBloodBank(BloodBank bloodBank) {
        String sql = "INSERT INTO bloodBanks (bankName,bankAddress,groupABNegUnit,groupABPosUnit,groupANegUnit,groupAPosUnit, groupBNegUnit, groupBPosUnit, groupONegUnit, groupOPosUnit) VALUES (?,?,?,?,?,?,?,?,?,?)";
        jdbcTemplate.update(sql, new PreparedStatementSetter() {
            @Override
            public void setValues(PreparedStatement ps) throws SQLException {
                ps.setString(1,bloodBank.getBankName());
                ps.setString(2,bloodBank.getBankAddress());
                ps.setInt(3,bloodBank.getGroupABNegUnit());
                ps.setInt(4,bloodBank.getGroupABPosUnit());
                ps.setInt(5,bloodBank.getGroupANegUnit());
                ps.setInt(6,bloodBank.getGroupAPosUnit());
                ps.setInt(7,bloodBank.getGroupBNegUnit());
                ps.setInt(8,bloodBank.getGroupBPosUnit());
                ps.setInt(9,bloodBank.getGroupONegUnit());
                ps.setInt(10,bloodBank.getGroupOPosUnit());
            }
        });
    }

    @Override
    public List<BloodBank> getBanks() {
        String sql = "SELECT * FROM bloodBanks";
        List<BloodBank> list = jdbcTemplate.query(sql, new BeanPropertyRowMapper(BloodBank.class));
        return list;
    }
//    @Override
//    public List<BloodBank> getBanks() {
//        String sql = "SELECT * FROM bloodBank";
//        return jdbcTemplate.query(sql, new ResultSetExtractor<List<BloodBank>>() {
//            @Override
//            public List<BloodBank> extractData(ResultSet rs) throws SQLException, DataAccessException {
//                BloodBank bloodBank = new BloodBank();
//                bloodBank.setBankid((rs.getInt("bankId"));
//                bloodBank.setBankName(rs.getString("bankName"));
//                bloodBank.setBankAddress(rs.getString("bankAddress"));
//                bloodBank.setBloodGroupABNegUnit(rs.getInt("groupABNeg"));
//                bloodBank.setBloodGroupABPosUnit(rs.getInt("groupABPos"));
//                bloodBank.setBloodGroupANegUnit(rs.getInt("groupANeg"));
//                bloodBank.setBloodGroupAPosUnit(rs.getInt("groupAPos"));
//                bloodBank.setBloodGroupBNegUnit(rs.getInt("groupBNeg"));
//                bloodBank.setBloodGroupBPosUnit(rs.getInt("groupBPos"));
//                bloodBank.setBloodGroupONegUnit(rs.getInt("groupONeg"));
//                bloodBank.setBloodGroupOPosUnit(rs.getInt("groupOPos"));
//
//                return (List<BloodBank>) bloodBank;
//            }
//        });
//        return null;
//    }


        //or we can also use BeanPropertyRowMapper
//        public Admin get(int contactId) {
//            String sql = "SELECT * FROM Contact WHERE id=" + contactId;
//            return jdbcTemplate.queryForObject(sql, BeanPropertyRowMapper.newInstance(Admin.class));
//        }

}
