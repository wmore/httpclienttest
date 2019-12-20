package com.wangyue.http;

import com.wangyue.Constants;
import org.springframework.stereotype.Component;

@Component
public class SanXiaUrlUtils {

    String userName;
    String passWD;
    String baseUrl ;

    public SanXiaUrlUtils() {
        userName = Constants.SANXIA_USERNAME;
        passWD = Constants.SANXIA_PASSWD;
        baseUrl = Constants.SANXIA_BASEURL;
    }

    private String getUrl(String funName) {
        return this.baseUrl + "/" + funName +"?userName=" + this.userName + "&passWD=" + this.passWD;
    }

    /**
     * 获取单位信息
     * @return
     */
    public String getDepartment(){
        String url = getUrl("GetDepartment");
        return HttpClientUtils.getInstance().get(url);
    }

    /**
     * 按年级获取学生信息
     * @return
     */
    public String getStudent(String grade){
        String url = getUrl("GetStudent") + "&Grade=" + grade;
        return HttpClientUtils.getInstance().get(url);
    }

    /**
     *获取学校专业信息
     * @return
     */
    public String getSpecialInfo(){
        String url = getUrl("GetSpecialInfo");
        return HttpClientUtils.getInstance().get(url);
    }

    /**
     * 获取学校班级信息
     * @param grade
     * @return
     */
    public String getClassInfo(String grade){
        String url = getUrl("GetClassInfo") + "&Grade=" + grade;
        return HttpClientUtils.getInstance().get(url);
    }

    /**
     * 获取教师信息
     * @return
     */
    public String getTeacher(){
        String url = getUrl("GetTeacher");
        return HttpClientUtils.getInstance().get(url);
    }

    /**
     * 获取课程信息
     * @return
     */
    public String getCourse(){
        String url = getUrl("GetCourse");
        return HttpClientUtils.getInstance().get(url);
    }

}
