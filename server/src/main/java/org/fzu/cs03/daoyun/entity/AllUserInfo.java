package org.fzu.cs03.daoyun.entity;

/**
 * @description:
 * @author: Mu.xx
 * @date: 2020/4/15 14:46
 */


/**
 * @description: 该实体描述了返回一个用户所有允许被查看的信息
 * @author: Mu.xx
 * @date: 2020/4/15 14:46
 * @param: null
 * @return:
 */
public class AllUserInfo {
    private Long userId;
    private Long roleId;
    private String userName;
    private String nickName;
    private String studentId;
    private String phone;
    private String email;
    private String school,education,major;
    private String birthDate;
    private String address,city,province,nation;
    private Integer experience,coin;
    private String profilePhotoUrl;
    private String college;

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getProfilePhotoUrl() {
        return profilePhotoUrl;
    }

    public void setProfilePhotoUrl(String profilePhotoUrl) {
        this.profilePhotoUrl = profilePhotoUrl;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public void setExperience(Integer experience) {
        this.experience = experience;
    }

    public void setCoin(Integer coin) {
        this.coin = coin;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getRoleId() {
        return roleId;
    }

    public String getUserName() {
        return userName;
    }

    public String getNickName() {
        return nickName;
    }

    public String getStudentId() {
        return studentId;
    }

    public String getPhone() {
        return phone;
    }

    public String getEmail() {
        return email;
    }

    public String getSchool() {
        return school;
    }

    public String getEducation() {
        return education;
    }

    public String getMajor() {
        return major;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getCity() {
        return city;
    }

    public String getProvince() {
        return province;
    }

    public String getNation() {
        return nation;
    }

    public Integer getExperience() {
        return experience;
    }

    public Integer getCoin() {
        return coin;
    }
}
