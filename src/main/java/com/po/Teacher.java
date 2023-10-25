package com.po;

/**
 * @Author: 孙宇鹏
 * @Date: 2023/10/23/15:29
 */
public class Teacher {
    private int tno;
    private String name;
    private String sex;
    private String birthday;
    private String prof;
    private String depart;

    public Teacher() {
    }

    public Teacher(int tno, String name, String sex, String birthday, String prof, String depart) {
        this.tno = tno;
        this.name = name;
        this.sex = sex;
        this.birthday = birthday;
        this.prof = prof;
        this.depart = depart;
    }

    public int getTno() {
        return tno;
    }

    public void setTno(int tno) {
        this.tno = tno;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getProf() {
        return prof;
    }

    public void setProf(String prof) {
        this.prof = prof;
    }

    public String getDepart() {
        return depart;
    }

    public void setDepart(String depart) {
        this.depart = depart;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "tno='" + tno + '\'' +
                ", name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", birthday='" + birthday + '\'' +
                ", prof='" + prof + '\'' +
                ", depart='" + depart + '\'' +
                '}';
    }
}
