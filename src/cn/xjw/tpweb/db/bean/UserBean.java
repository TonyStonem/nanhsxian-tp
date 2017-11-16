package cn.xjw.tpweb.db.bean;

/**
 * Created by xjw on 2017/11/16 10:56
 * Email : 1521975316@qq.com
 */
public class UserBean {

    private int id;//主键ID
    private String loginID;
    private String address;
    private String details;
    private String loginDate;
    private String phone;
    private String pswd;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPswd() {
        return pswd;
    }

    public void setPswd(String pswd) {
        this.pswd = pswd;
    }

    @Override
    public int hashCode() {
        return this.id;
    }

    public UserBean() {
    }

    public UserBean(String loginID, String address, String details, String loginDate, String phone, String pswd) {
        this.loginID = loginID;
        this.address = address;
        this.details = details;
        this.loginDate = loginDate;
        this.phone = phone;
        this.pswd = pswd;
    }

    @Override
    public String toString() {
        return "loginID>" + loginID + ";pswd>" + pswd+ ";loginDate>" + loginDate;
    }
}
