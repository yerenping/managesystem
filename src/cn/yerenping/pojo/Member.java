package cn.yerenping.pojo;

import java.io.Serializable;
import java.util.Objects;

/**
 * @Auther: 叶仁平 wwww.yerenping.cn
 * @Date: 2019/12/14
 * @Description: cn.yerenping.pojo
 * @version: 1.0
 */
public class Member implements Serializable{

    /**
     * 编号
     */
    private int mid;

    /**
     * 姓名
     */
    private String name;

    /**
     * 性别
     */
    private char sex;

    /**
     * 手机号
     */
    private String phoneCode;

    /**
     * 地址
     */
    private String addr;

    /**
     * Email邮箱
     */
    private String email;


    public Member() {

    }

    public Member(int mid, String name, char sex, String phoneCode, String addr, String email) {
        this.mid = mid;
        this.name = name;
        this.sex = sex;
        this.phoneCode = phoneCode;
        this.addr = addr;
        this.email = email;
    }

    public int getMid() {
        return mid;
    }

    public void setMid(int mid) {
        this.mid = mid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public char getSex() {
        return sex;
    }

    public void setSex(char sex) {
        this.sex = sex;
    }

    public String getPhoneCode() {
        return phoneCode;
    }

    public void setPhoneCode(String phoneCode) {
        this.phoneCode = phoneCode;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Member)) return false;

        Member member = (Member) o;

        if (mid != member.mid) return false;
        if (sex != member.sex) return false;
        if (name != null ? !name.equals(member.name) : member.name != null) return false;
        if (phoneCode != null ? !phoneCode.equals(member.phoneCode) : member.phoneCode != null) return false;
        if (addr != null ? !addr.equals(member.addr) : member.addr != null) return false;
        return email != null ? email.equals(member.email) : member.email == null;
    }

    @Override
    public int hashCode() {
        int result = mid;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (int) sex;
        result = 31 * result + (phoneCode != null ? phoneCode.hashCode() : 0);
        result = 31 * result + (addr != null ? addr.hashCode() : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Member{" +
                "mid=" + mid +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", phoneCode='" + phoneCode + '\'' +
                ", addr='" + addr + '\'' +
                ", email='" + email + '\'' +
                '}';
    }
}
