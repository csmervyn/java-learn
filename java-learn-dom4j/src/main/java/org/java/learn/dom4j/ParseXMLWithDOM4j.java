package org.java.learn.dom4j;

import java.io.File;
import java.util.Iterator;
import java.util.List;

import org.dom4j.Attribute;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class ParseXMLWithDOM4j {
	Logger logger = LoggerFactory.getLogger(ParseXMLWithDOM4j.class);
	
	@Test
	public void parse(){
		//1.创建SAXReader对象
		SAXReader reader = new SAXReader();
		
		String path = "src"+File.separator+"main"+File.separator+"resources"+File.separator+"mailInformation.xml";
		File file = new File(path);
		//2.读取XML文件获取Document对象
		Document document = null;
		try {
			document = reader.read(file);
		} catch (DocumentException e) {
			logger.debug("XML文件没有找到");
			e.printStackTrace();
		}
		if(document != null){
			//3.获取根节点元素对象
			Element root = document.getRootElement();
			//4.遍历所有节点
			listNodes(root);
		}

	}
	
	/**
	  * listNodes(遍历当前节点的属性和值以及该节点下的所有节点)
	  *
	  * @Title: listNodes
	  * @Description: 遍历当前节点的属性和值以及该节点下的所有节点
	  * @param @param node  
	  * @return void
	  * @throws
	  */
	public void listNodes(Element node){
		//获取节点的名称
		System.out.println("当前节点的名称：" + node.getName());
		//获得当前节点的所有属性
		List<Attribute> attributes = node.attributes();
		//遍历当前节点的所有属性
		if(attributes != null && !attributes.isEmpty()){
			for(Attribute attribute : attributes){
				System.out.println("属性" + attribute.getName() + ":" + attribute.getValue());
			}
		}
		//输出当前节点的内容Element.getTextTrim()获得当前节点的内容
		if(!node.getTextTrim().equals("")){
			System.out.println(node.getName() + ":" + node.getText());
		}
		
		//递归遍历当前节点的所有子节点
		Iterator<Element> iter = node.elementIterator();
		if(iter != null && iter.hasNext()){
			while(iter.hasNext()){
				Element e = iter.next();
				listNodes(e);
			}
		}
	}
}
