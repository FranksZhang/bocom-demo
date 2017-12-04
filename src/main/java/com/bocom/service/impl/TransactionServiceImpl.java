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
                return "错误信息1";
            }
            List childrens = root.getChildren();
            if(childrens == null || childrens.size() != 1){
                return "错误信息2";
            }
            Element temp = null;
            temp = (Element)childrens.get(0);
            if(!temp.getName().equals("body")){
                return "错误信息3";
            }
            List grandChildrens = temp.getChildren();
            if(grandChildrens == null || grandChildrens.size() != 1){
                return "错误信息4";
            }
            temp = (Element)grandChildrens.get(0);
            String targetAccount = temp.getValue();
            if(!temp.getName().equals("acno") || temp.getChildren().size() != 0 || targetAccount == null || targetAccount.trim().equals("")){
                return "错误信息5";
            }

            List<TransactionDetail> results = tranactionMapper.selectByAccount(targetAccount);//得到交易明细数据的List

            Element resultRoot = new Element("ap");
            Document resultDoc = new Document(resultRoot);

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
        }catch (JDOMException e){
            //dosomething
        }catch (IOException e2){
            //dosomething
        }
        return "错误信息6";
    }
}
