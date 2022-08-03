package top.bluesword.laboratory;


import org.apache.axiom.om.OMAbstractFactory;
import org.apache.axiom.soap.SOAPEnvelope;
import org.apache.axiom.soap.SOAPFactory;
import org.apache.axis2.AxisFault;
import org.apache.axis2.addressing.EndpointReference;
import org.apache.axis2.client.OperationClient;
import org.apache.axis2.client.ServiceClient;
import org.apache.axis2.context.MessageContext;
import org.apache.axis2.databinding.ADBException;
import org.apache.axis2.description.*;
import org.apache.axis2.wsdl.WSDLConstants;

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
        // creating the Service with a unique name
        AxisService service = new AxisService("TransPortOrderService"+System.currentTimeMillis());
        RobustOutOnlyAxisOperation robustoutoonlyOperation = new RobustOutOnlyAxisOperation(ServiceClient.ANON_ROBUST_OUT_ONLY_OP);
        service.addOperation(robustoutoonlyOperation);
        OutOnlyAxisOperation outOnlyOperation = new OutOnlyAxisOperation(ServiceClient.ANON_OUT_ONLY_OP);
        service.addOperation(outOnlyOperation);
        OutInAxisOperation outInOperation = new OutInAxisOperation(ServiceClient.ANON_OUT_IN_OP);
        service.addOperation(outInOperation);

        // creating the operations
        AxisOperation operation;
        operation = new OutInAxisOperation();

        operation.setName(new QName("http://tempuri.org/", "readERPManifest"));
        service.addOperation(operation);

        ServiceClient serviceClient = new ServiceClient(null,service);

        serviceClient
                .getOptions()
                .setTo(new EndpointReference("https://glws.foxconn.com/CustomerServices/TransPortOrderService.asmx"));
        serviceClient.getOptions().setUseSeparateListener(false);

        serviceClient
                .getOptions()
                .setSoapVersionURI(org.apache.axiom.soap.SOAP12Constants.SOAP_ENVELOPE_NAMESPACE_URI);

        ReadERPManifest readERPManifest = new ReadERPManifest();
        String param = "<?xml version=\"1.0\" encoding=\"UTF-8\"?><TxControl>  <processId>6EBF8BFE004F4D5D8D54C79E45274817</processId>  <senderId>IDEAS2</senderId>  <receiverId>TBU</receiverId>  <msgType>TRANSPORT_ORDER_DETAIL_SYNC</msgType>  <docType></docType>  <docId>875F3676B9AF400E986A52D1C063E9E8</docId>  <msgCatg>XML</msgCatg>  <encoding>PLAIN</encoding>  <charset>UTF-8</charset>  <version>2.0</version>  <docDT>20220223094950</docDT><txData><orderList><orderInfo><orderCode>TP2220223003082</orderCode><balanceCode>EPD5-TJ</balanceCode><balanceLegalCode>BF2170S87</balanceLegalCode><loadingNo>3500799746</loadingNo><creator/><remark/></orderInfo></orderList></txData></TxControl>";
        readERPManifest.setXML(param);

        MessageContext messageContext = new MessageContext();
        OperationClient operationClient = serviceClient.createClient(operation.getName());
        operationClient.getOptions().setAction("http://tempuri.org/ReadERPManifest");
        operationClient.getOptions().setExceptionToBeThrownOnSOAPFault(true);
        operationClient.getOptions().setProperty(WSDL2Constants.ATTR_WHTTP_QUERY_PARAMETER_SEPARATOR, "&");
        SOAPEnvelope env;
        try {
            SOAPFactory factory = OMAbstractFactory.getSOAP12Factory();
            env = factory.getDefaultEnvelope();
            env.getBody().addChild(readERPManifest.getOMElement(ReadERPManifest.MY_QNAME, factory));
        } catch (ADBException e) {
            throw AxisFault.makeFault(e);
        }
        // adding SOAP soap_headers
        serviceClient.addHeadersToEnvelope(env);
        // set the message context with that soap envelope
        messageContext.setEnvelope(env);

        // add the message contxt to the operation client
        operationClient.addMessageContext(messageContext);

        // execute the operation client
        operationClient.execute(true);

        MessageContext returnMessageContext = operationClient.getMessageContext(WSDLConstants.MESSAGE_LABEL_IN_VALUE);
        SOAPEnvelope returnEnv = returnMessageContext.getEnvelope();
        returnEnv.buildWithAttachments();

        return returnEnv.getBody().getFirstElement().getFirstElement().getText();
    }

}
