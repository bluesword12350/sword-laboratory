package top.bluesword.laboratory;

import org.apache.axis.client.Call;
import org.apache.axis.client.Service;
import org.apache.axis.encoding.XMLType;

import javax.xml.namespace.QName;
import javax.xml.rpc.ParameterMode;
import javax.xml.rpc.ServiceException;
import java.net.MalformedURLException;
import java.net.URL;
import java.nio.charset.StandardCharsets;
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
    public static String sendWebServiceRequest() throws RemoteException, ServiceException, MalformedURLException {
        Object[] paramValues;
        Service service = new Service();
        Call call = (Call) service.createCall();
        call.setEncodingStyle(StandardCharsets.UTF_8.toString());
        call.setTargetEndpointAddress(new URL("https://glws.foxconn.com/CustomerServices/TransPortOrderService.asmx"));
        QName xml = new QName("http://tempuri.org/", "XML");
        call.addParameter(xml, XMLType.XSD_STRING, ParameterMode.IN);
        paramValues = new Object[]{"<?xml version=\"1.0\" encoding=\"UTF-8\"?><TxControl>  <processId>6EBF8BFE004F4D5D8D54C79E45274817</processId>  <senderId>IDEAS2</senderId>  <receiverId>TBU</receiverId>  <msgType>TRANSPORT_ORDER_DETAIL_SYNC</msgType>  <docType></docType>  <docId>875F3676B9AF400E986A52D1C063E9E8</docId>  <msgCatg>XML</msgCatg>  <encoding>PLAIN</encoding>  <charset>UTF-8</charset>  <version>2.0</version>  <docDT>20220223094950</docDT>  <ref1></ref1>  <ref2></ref2>  <ref3></ref3>  <ref4></ref4>  <ref5></ref5>  <txData>    <orderList>      <orderInfo>        <orderCode>TP2220223003082</orderCode>        <balanceCode>EPD5-TJ</balanceCode>        <balanceLegalCode>BF2170S87</balanceLegalCode>        <loadingNo>3500799746</loadingNo>        <creator>admin</creator>        <remark>CU</remark>      </orderInfo>    </orderList>  </txData></TxControl>"};
        call.setUseSOAPAction(true);
        call.setSOAPActionURI("http://tempuri.org/ReadERPManifest");
        // 设置返回格式
        call.setReturnType(XMLType.XSD_STRING);
        // 设置调用的方法
        call.setOperationName(new QName("http://tempuri.org/","ReadERPManifest"));
        return (String) call.invoke(paramValues);
    }
}
