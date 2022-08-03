package top.bluesword.laboratory;


import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.om.OMElement;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.Options;
import org.apache.axis2.client.ServiceClient;

import javax.xml.namespace.QName;
import java.rmi.RemoteException;

/**
 * WebService 接口调用工具
 *
 * @author x.su
 * @version 1.0
 * @date 2022/05/16 上午4:07
 */
public class WebServiceUtil {

    /**
     * WebService 接口请求
     * @return 请求结果(XML)
     */
    public static String request() throws RemoteException {
        final String namespaceUrl = "http://tempuri.org/";
        final String param = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><TxControl>  <processId>6EBF8BFE004F4D5D8D54C79E45274817</processId>  <senderId>IDEAS2</senderId>  <receiverId>TBU</receiverId>  <msgType>TRANSPORT_ORDER_DETAIL_SYNC</msgType>  <docType></docType>  <docId>875F3676B9AF400E986A52D1C063E9E8</docId>  <msgCatg>XML</msgCatg>  <encoding>PLAIN</encoding>  <charset>UTF-8</charset>  <version>2.0</version>  <docDT>20220223094950</docDT><txData><orderList><orderInfo><orderCode>TP2220223003082</orderCode><balanceCode>EPD5-TJ</balanceCode><balanceLegalCode>BF2170S87</balanceLegalCode><loadingNo>3500799746</loadingNo><creator/><remark/></orderInfo></orderList></txData></TxControl>";
        final String address = "https://glws.foxconn.com/CustomerServices/TransPortOrderService.asmx";

        ServiceClient serviceClient = new ServiceClient();
        Options options = serviceClient.getOptions();
        options.setTo(new EndpointReference(address));
        options.setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);

        OMElement omElement;
        SOAPFactory factory = OMAbstractFactory.getSOAP12Factory();
        omElement = factory.createOMElement(new QName(namespaceUrl, "ReadERPManifest"));
        OMElement xml = factory.createOMElement(new QName(namespaceUrl, "XML"));
        xml.setText(param);
        omElement.addChild(xml);
        return serviceClient.sendReceive(omElement).getFirstElement().getText();
    }

}
