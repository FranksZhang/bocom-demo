package com.bocom.service.impl;

import com.alibaba.fastjson.JSON;
import com.bocom.dao.TranactionMapper;
import com.bocom.service.TransactionService;
import com.bocom.vo.TransactionDetail;
import org.jdom.Document;
import org.jdom.Element;
import org.jdom.JDOMException;
import org.jdom.input.SAXBuilder;
import org.jdom.output.Format;
import org.jdom.output.XMLOutputter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.xml.sax.InputSource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.StringReader;
import java.util.List;

@Service
public class TransactionServiceImpl implements TransactionService{

    @Autowired
    private TranactionMapper tranactionMapper;

    public String getDealDetailByAccount(String account){
        StringReader reader = new StringReader(account);
        InputSource source = new InputSource(reader);
        SAXBuilder sb = new SAXBuilder();
        try{
            Document doc = sb.build(source);
            Element root = doc.getRootElement();
            if(!root.getName().equals("ap")){//根元素不是ap的时候
                throw new JDOMException();
            }
            List childrens = root.getChildren();
            if(childrens == null || childrens.size() != 2){
                throw new JDOMException();
            }
            Element temp = null;
            temp = (Element)childrens.get(1);
            if(!temp.getName().equals("body")){
                throw new JDOMException();
            }
            List grandChildrens = temp.getChildren();
            if(grandChildrens == null || grandChildrens.size() != 1){
                throw new JDOMException();
            }
            temp = (Element)grandChildrens.get(0);
            String targetAccount = temp.getValue();
            if(!temp.getName().equals("acno") || temp.getChildren().size() != 0 || targetAccount == null || targetAccount.trim().equals("")){
                throw new JDOMException();
            }

            List<TransactionDetail> results = tranactionMapper.selectByAccount(targetAccount);//得到交易明细数据的List

            Element resultRoot = new Element("ap");
            Document resultDoc = new Document(resultRoot);

            resultRoot.addContent(getHead("success", "成功", "0000", ""));

            Element children = new Element("body");
            Element grandChildren1 = new Element("serial_record");
            Element grandChildren2 = new Element("field_num");
            Element grandChildren3 = new Element("record_num");
            Element grandChildren4 = new Element("file_flag");
            Element grandChildren5 = new Element("filename");

            children.addContent(grandChildren1);
            children.addContent(grandChildren2);
            children.addContent(grandChildren3);
            children.addContent(grandChildren4);
            children.addContent(grandChildren5);
            resultRoot.addContent(children);

            grandChildren5.addContent("");
            grandChildren4.addContent("0");
            grandChildren3.addContent(String.valueOf(results.size()));
            grandChildren2.addContent("24");

            StringBuilder recordString = new StringBuilder();
            recordString.append("状态|" +
                            "交易日期|" +
                    "交易时间|" +
                    "业务类型|" +
                    "流水号|" +
                    "流水序号|" +
                    "账号|" +
                    "户名|" +
                    "收支标志|" +
                    "币种|" +
                    "交易金额|" +
                    "余额|" +
                    "可用余额|" +
                    "对方账号|" +
                    "对方户名|" +
                    "对方地址|");
            recordString.append("对方开户行行号|" +
                    "对方开户行行名|" +
                    "票据种类|" +
                    "票据号码|" +
                    "票据名称|" +
                    "票据签发日期|" +
                    "附言|" +
                    "备注|");
            for(TransactionDetail t : results){
                recordString.append(t.getTrstatus() + "|").append(t.getTrdate() + "|")
                        .append(t.getTrtime() + "|").append(t.getTrtype() + "|")
                        .append(t.getTrserial() + "|").append(t.getTrserialnum() + "|")
                        .append(t.getTraccount() + "|").append(t.getTrname() + "|")
                        .append(t.getTrmark() + "|").append(t.getTrcurrency() + "|")
                        .append(t.getTramount() + "|").append(t.getTrbalance() + "|")
                        .append(t.getTrbalanceAva() + "|").append(t.getTraccountTo() + "|")
                        .append(t.getTrnameTo() + "|").append(t.getTraddressTo() + "|")
                        .append(t.getTrbodTo() + "|").append(t.getTrbodnameTo() + "|")
                        .append(t.getTrbillType() + "|").append(t.getTrbillNum() + "|")
                        .append(t.getTrbillName() + "|").append(t.getTrbillSignDate() + "|")
                        .append(t.getTrpostscript() + "|").append(t.getTrremark() + "|");
            }

            grandChildren1.addContent(recordString.toString());

            Format format = Format.getCompactFormat();
            format.setEncoding("utf-8");
            format.setIndent(" ");
            XMLOutputter xmlOut = new XMLOutputter(format);
            ByteArrayOutputStream byteRsp = new ByteArrayOutputStream();
            xmlOut.output(resultDoc, byteRsp);
            String finalString = byteRsp.toString("utf-8");
            return finalString.substring(39);
        }catch (Exception e){
            Element resultRoot = new Element("ap");
            Document resultDoc = new Document(resultRoot);
            resultRoot.addContent(getHead("failed", "查询失败", "0001", "参数不正确"));
            Format format = Format.getCompactFormat();
            format.setEncoding("utf-8");
            format.setIndent(" ");
            XMLOutputter xmlOut = new XMLOutputter(format);
            ByteArrayOutputStream byteRsp = new ByteArrayOutputStream();

            try {
                xmlOut.output(resultDoc, byteRsp);
                String finalString = byteRsp.toString("utf-8");
                return finalString.substring(39);
            }catch (IOException e3){
                e3.printStackTrace();
            }
        }
        return "";
    }

    private Element getHead(String ans_code, String ans_info, String particular_code, String particular_info){
        Element headerChildren = new Element("head");
        Element headerGrandChildren1 = new Element("tr_code");
        Element headerGrandChildren2 = new Element("corp_no");
        Element headerGrandChildren3 = new Element("req_no");
        Element headerGrandChildren4 = new Element("serial_no");
        Element headerGrandChildren5 = new Element("ans_no");
        Element headerGrandChildren6 = new Element("next_no");
        Element headerGrandChildren7 = new Element("tr_acdt");
        Element headerGrandChildren8 = new Element("tr_time");
        Element headerGrandChildren9 = new Element("ans_code");
        Element headerGrandChildren10 = new Element("ans_info");
        Element headerGrandChildren11 = new Element("particular_code");
        Element headerGrandChildren12 = new Element("particular_info");
        Element headerGrandChildren13 = new Element("atom_tr_count");
        Element headerGrandChildren14 = new Element("reserved");

        headerChildren.addContent(headerGrandChildren1);
        headerGrandChildren1.addContent("交易码");
        headerChildren.addContent(headerGrandChildren2);
        headerGrandChildren2.addContent("企业代码");
        headerChildren.addContent(headerGrandChildren3);
        headerGrandChildren3.addContent("发起方序号");
        headerChildren.addContent(headerGrandChildren4);
        headerGrandChildren4.addContent("交易序号");
        headerChildren.addContent(headerGrandChildren5);
        headerGrandChildren5.addContent("应答流水号");
        headerChildren.addContent(headerGrandChildren6);
        headerGrandChildren6.addContent("下笔交易序号");
        headerChildren.addContent(headerGrandChildren7);
        headerGrandChildren7.addContent("交易日期");
        headerChildren.addContent(headerGrandChildren8);
        headerGrandChildren8.addContent("时间");
        headerChildren.addContent(headerGrandChildren9);
        headerGrandChildren9.addContent(ans_code);
        headerChildren.addContent(headerGrandChildren10);
        headerGrandChildren10.addContent(ans_info);
        headerChildren.addContent(headerGrandChildren11);
        headerGrandChildren11.addContent(particular_code);
        headerChildren.addContent(headerGrandChildren12);
        headerGrandChildren12.addContent(particular_info);
        headerChildren.addContent(headerGrandChildren13);
        headerGrandChildren13.addContent("原子交易数");
        headerChildren.addContent(headerGrandChildren14);
        headerGrandChildren14.addContent("保留字段");
        return headerChildren;
    }
}
