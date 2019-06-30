package com.wangyue.vo;

import java.io.File;
import java.net.URL;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import javax.xml.transform.sax.SAXResult;
import java.net.URL;
import java.util.Iterator;
import java.util.List;

public class Department implements IXMLBean {

    String id;
    String bmh;
    String departmentName;
    String departmentNo;

    @Override
    public Object getBen(String name) {
        return null;
    }

    public Department(String xmlPath) {
        // 创建saxReader对象
        SAXReader reader = new SAXReader();
        // 通过read方法读取一个文件 转换成Document对象
        Document document = null;
        try {
            document = reader.read(new File(xmlPath));
            //获取根节点元素对象
            Element node = document.getRootElement();
            //遍历所有的元素节点

            Element departmentTableNode = node.element("DepartmentTable");

            listNodes(node);

        } catch (DocumentException e) {
            e.printStackTrace();
        }


    }
    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     *
     * @param node
     */
    public void listNodes(Element node) {
        System.out.println("当前节点的名称：" + node.getName());
        // 获取当前节点的所有属性节点
        List<Attribute> list = node.attributes();

        if (!(node.getTextTrim().equals(""))) {
            System.out.println("文本内容：" + node.getText());
        }

        // 当前节点下面子节点迭代器
        Iterator<Element> it = node.elementIterator();
        // 遍历
        while (it.hasNext()) {
            // 获取某个子节点对象
            Element e = it.next();
            // 对子节点进行遍历
            if (e.getName().equals("Table1")){
                Department d = new Department();
                listNodes(e);
            }
        }
    }

}
