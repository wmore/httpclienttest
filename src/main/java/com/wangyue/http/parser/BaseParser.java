package com.wangyue.http.parser;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.File;

public class BaseParser {

    public Element initDepartmentFromString(String xmlStr) {
        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        Document document = null;
        try {
            document = DocumentHelper.parseText(xmlStr);
            //获取根节点元素对象
            Element node = document.getRootElement();
            //遍历所有的元素节点
            return node;
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }

    public Element initDepartmentFromXmlFile(String xmlPath) {
        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        Document document = null;
        try {
            document = reader.read(new File(xmlPath));
            //获取根节点元素对象
            Element node = document.getRootElement();
            //遍历所有的元素节点
            return node;
        } catch (DocumentException e) {
            e.printStackTrace();
        }

        return null;
    }

}
