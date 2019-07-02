package com.wangyue.http.parser;

import com.wangyue.http.vo.SpecialInfo;
import org.dom4j.Element;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;


@Component
public class SpecialInfoParser extends BaseParser {

    /**
     * 遍历当前节点元素下面的所有(元素的)子节点
     *<?xml version="1.0" encoding="utf-8"?>
     *
     * <SpecialTable>
     *   <Table1>
     *     <DepartmentID>23</DepartmentID>
     *     <DepartmentNO>A</DepartmentNO>
     *     <DepartmentName>水利与环境学院</DepartmentName>
     *     <SpecialID>10</SpecialID>
     *     <SpecialNO>081101</SpecialNO>
     *     <SpecialName>水利水电工程</SpecialName>
     *   </Table1>
     * @param rootNode
     * @return
     */
    public List<SpecialInfo> listNodes(Element rootNode) {
        List<SpecialInfo> specialInfoList = new ArrayList<>();
        Iterator it = rootNode.elementIterator();
        while (it.hasNext()) {
            Element table = (Element) it.next();
            SpecialInfo specialInfoData = new SpecialInfo();
            Iterator itt = table.elementIterator();

            while (itt.hasNext()) {
                Element tableChild = (Element) itt.next();

                if (tableChild.getName().equals("DepartmentID")) {
                    specialInfoData.setDepartmentID(tableChild.getText());
                } else if (tableChild.getName().equals("DepartmentNO")) {
                    specialInfoData.setDepartmentNO(tableChild.getText());
                } else if (tableChild.getName().equals("DepartmentName")) {
                    specialInfoData.setDepartmentName(tableChild.getText());
                } else if (tableChild.getName().equals("SpecialID")) {
                    specialInfoData.setSpecialID(tableChild.getText());
                } else if (tableChild.getName().equals("SpecialNO")) {
                    specialInfoData.setSpecialNO(tableChild.getText());
                } else if (tableChild.getName().equals("SpecialName")) {
                    specialInfoData.setSpecialName(tableChild.getText());
                }
            }
            specialInfoList.add(specialInfoData);
        }

        return specialInfoList;
    }

}
