package com.ffd.userservice.common.handler;

import com.ffd.common.util.AesUtil;
import org.apache.ibatis.type.JdbcType;
import org.apache.ibatis.type.TypeHandler;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AesTypeHandler implements TypeHandler<String> {

    AesUtil aesUtil;

    public AesTypeHandler(){
        aesUtil = new AesUtil();
    }

    /* (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#setParameter(java.sql.PreparedStatement, int, java.lang.Object, org.apache.ibatis.type.JdbcType)
     */
    @Override
    public void setParameter(PreparedStatement ps, int i, String parameter, JdbcType jdbcType) throws SQLException {
        try {
            parameter = aesUtil.encrypt(parameter);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        ps.setString(i, parameter);
    }

    /* (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, java.lang.String)
     */
    @Override
    public String getResult(ResultSet rs, String columnName) throws SQLException {
        String value = rs.getString(columnName);
        try {
            value = aesUtil.decrypt(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    /* (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.ResultSet, int)
     */
    @Override
    public String getResult(ResultSet rs, int columnIndex) throws SQLException {
        String value = rs.getString(columnIndex);
        try {
            value = aesUtil.decrypt(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return value;
    }

    /* (non-Javadoc)
     * @see org.apache.ibatis.type.TypeHandler#getResult(java.sql.CallableStatement, int)
     */
    @Override
    public String getResult(CallableStatement cs, int columnIndex) throws SQLException {
        String value = cs.getString(columnIndex);
        try {
            value = aesUtil.decrypt(value);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return value;
    }
}
