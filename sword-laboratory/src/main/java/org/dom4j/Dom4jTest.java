package org.dom4j;

import org.junit.jupiter.api.Test;

import java.util.Iterator;

class Dom4jTest {

	@Test
	void createDocumentTest(){
		Document document = DocumentHelper.createDocument();
		Element xml = document.addElement("xml");
		xml.addElement("ToUserName").addCDATA("1");
		System.out.println(xml.asXML());
	}

	@Test
	void parseText() throws DocumentException {
		String xml = "<xml>"
        		+ "<ToUserName><![CDATA[gh_5294ad2f8048]]></ToUserName>"
        		+ "<FromUserName><![CDATA[oJ5GI1qDrzpEzJoMKkVqGox1VXL8]]></FromUserName>"
        		+ "<CreateTime>1518333946</CreateTime>"
        		+ "<MsgType><![CDATA[text]]></MsgType>"
        		+ "<Content><![CDATA[6]]></Content>"
        		+ "<MsgId>6521194642938057968</MsgId>"
    		+ "</xml>";
        Document parseText = DocumentHelper.parseText(xml);
        Element rootElement = parseText.getRootElement();
        System.out.println(rootElement.elementText("ToUserName1"));
        for (Iterator<Element> elementIterator = rootElement.elementIterator();elementIterator.hasNext();) {
        	Element next = elementIterator.next();
        	System.out.println(next.getName()+":"+next.getText());
		}
	}
}
