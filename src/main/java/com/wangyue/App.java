package com.wangyue;


import com.wangyue.vo.Department;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        String filePath = "/Users/wangyue/zhuozhi/documents/GetDepartment.xml";
        Department department = new Department(filePath);
    }
}
