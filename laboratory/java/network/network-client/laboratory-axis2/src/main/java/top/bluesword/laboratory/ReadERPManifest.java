package top.bluesword.laboratory;

import org.apache.axis2.databinding.ADBException;

public class ReadERPManifest implements org.apache.axis2.databinding.ADBBean {

    public static final javax.xml.namespace.QName MY_QNAME =
        new javax.xml.namespace.QName("http://tempuri.org/", "ReadERPManifest", "ns1");

    /** field for XML */
    protected String localXML;

    /*  This tracker boolean wil be used to detect whether the user called the set method
     *   for this attribute. It will be used to determine whether to include this field
     *   in the serialized XML
     */
    protected boolean localXMLTracker = false;

    /**
     * Auto generated setter method
     *
     * @param param XML
     */
    public void setXML(String param) {
      localXMLTracker = param != null;

      this.localXML = param;
    }

    @Override
    public org.apache.axiom.om.OMElement getOMElement(
        final javax.xml.namespace.QName parentQName, final org.apache.axiom.om.OMFactory factory)
        throws ADBException {

      return factory.createOMElement(
          new org.apache.axis2.databinding.ADBDataSource(this, MY_QNAME));
    }

    @Override
    public void serialize(
        final javax.xml.namespace.QName parentQName, javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException, ADBException {
      serialize(parentQName, xmlWriter, false);
    }

    @Override
    public void serialize(
        final javax.xml.namespace.QName parentQName,
        javax.xml.stream.XMLStreamWriter xmlWriter,
        boolean serializeType)
        throws javax.xml.stream.XMLStreamException, ADBException {

      String prefix;
      String namespace;

      prefix = parentQName.getPrefix();
      namespace = parentQName.getNamespaceURI();
      writeStartElement(prefix, namespace, parentQName.getLocalPart(), xmlWriter);

      if (serializeType) {

        String namespacePrefix = registerPrefix(xmlWriter, "http://tempuri.org/");
        if ((namespacePrefix != null) && (namespacePrefix.trim().length() > 0)) {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              namespacePrefix + ":ReadERPManifest",
              xmlWriter);
        } else {
          writeAttribute(
              "xsi",
              "http://www.w3.org/2001/XMLSchema-instance",
              "type",
              "ReadERPManifest",
              xmlWriter);
        }
      }
      if (localXMLTracker) {
        namespace = "http://tempuri.org/";
        writeStartElement(null, namespace, "XML", xmlWriter);

        if (localXML == null) {
          // write the nil attribute

          throw new ADBException("XML cannot be null!!");

        } else {

          xmlWriter.writeCharacters(localXML);
        }

        xmlWriter.writeEndElement();
      }
      xmlWriter.writeEndElement();
    }

    private static String generatePrefix(String namespace) {
      if ("http://tempuri.org/".equals(namespace)) {
        return "ns1";
      }
      return org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
    }

    /** Utility method to write an element start tag. */
    private void writeStartElement(
        String prefix,
        String namespace,
        String localPart,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeStartElement(writerPrefix, localPart, namespace);
      } else {
        if (namespace.length() == 0) {
          prefix = "";
        } else if (prefix == null) {
          prefix = generatePrefix(namespace);
        }

        xmlWriter.writeStartElement(prefix, localPart, namespace);
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
    }

    /** Util method to write an attribute with the ns prefix */
    private void writeAttribute(
        String prefix,
        String namespace,
        String attName,
        String attValue,
        javax.xml.stream.XMLStreamWriter xmlWriter)
        throws javax.xml.stream.XMLStreamException {
      String writerPrefix = xmlWriter.getPrefix(namespace);
      if (writerPrefix != null) {
        xmlWriter.writeAttribute(writerPrefix, namespace, attName, attValue);
      } else {
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
        xmlWriter.writeAttribute(prefix, namespace, attName, attValue);
      }
    }

    /** Register a namespace prefix */
    private String registerPrefix(
        javax.xml.stream.XMLStreamWriter xmlWriter, String namespace)
        throws javax.xml.stream.XMLStreamException {
      String prefix = xmlWriter.getPrefix(namespace);
      if (prefix == null) {
        prefix = generatePrefix(namespace);
        javax.xml.namespace.NamespaceContext nsContext = xmlWriter.getNamespaceContext();
        while (true) {
          String uri = nsContext.getNamespaceURI(prefix);
          if (uri == null || uri.length() == 0) {
            break;
          }
          prefix = org.apache.axis2.databinding.utils.BeanUtil.getUniquePrefix();
        }
        xmlWriter.writeNamespace(prefix, namespace);
        xmlWriter.setPrefix(prefix, namespace);
      }
      return prefix;
    }

  }