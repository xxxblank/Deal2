package com.school.schooldeal.sign.model;

import android.content.Context;

import com.school.schooldeal.commen.util.Util;
import com.school.schooldeal.model.Apartment;
import com.school.schooldeal.model.School;

import cn.bmob.v3.BmobUser;

/**
 * Created by U-nookia on 2016/12/22.
 * 用户bean
 */

public class StudentUser extends BmobUser{
    private int creditScore;   //信用分
    private int sex;   //性别
    private String schoolNumber;  //学号
    private School school;          //学校编号
    private Apartment apartment;       //公寓编号
    private boolean isStudent;
    private String imgUrl;  //头像url
    private String bedroom; //房间号

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public StudentUser() {
    }

    public StudentUser(Context context, String name, String password,
                       Apartment apartment, School school, String schoolNumber,
                       String phone, String email, int sex,String bedroom) {
        setUsername(name);
        setPassword(password);
        setApartment(apartment);
        setSchool(school);
        setSchoolNumber(schoolNumber);
        setMobilePhoneNumber(phone);
        setEmail(email);
        setSex(sex);
        setImgUrl(Util.defaultHeadImg);
        setBedroom(bedroom);
    }

    public boolean isStudent() {
        return isStudent;
    }
    public void setStudent(boolean student) {
        isStudent = student;
    }

    public Apartment getApartment() {
        return apartment;
    }

    public void setApartment(Apartment apartment) {
        this.apartment = apartment;
    }

    public int getCreditScore() {
        return creditScore;
    }

    public void setCreditScore(int creditScore) {
        this.creditScore = creditScore;
    }

    public School getSchool() {
        return school;
    }

    public void setSchool(School school) {
        this.school = school;
    }

    public String getSchoolNumber() {
        return schoolNumber;
    }

    public void setSchoolNumber(String schoolNumber) {
        this.schoolNumber = schoolNumber;
    }

    public int getSex() {
        return sex;
    }

    public void setSex(int sex) {
        this.sex = sex;
    }

    public String getBedroom() {
        return bedroom;
    }

    public void setBedroom(String bedroom) {
        this.bedroom = bedroom;
    }

    @Override
    public String toString() {
        return "StudentUser{" +
                "creditScore=" + creditScore +
                ", sex=" + sex +
                ", schoolNumber='" + schoolNumber + '\'' +
                ", school=" + school +
                ", apartment=" + apartment +
                ", isStudent=" + isStudent +
                ", imgUrl='" + imgUrl + '\'' +
                ", bedroom='" + bedroom + '\'' +
                '}';
    }
}
