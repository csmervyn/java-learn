package org.github.mervyn.webservices_cxf;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlSeeAlso;
import javax.xml.ws.RequestWrapper;
import javax.xml.ws.ResponseWrapper;

/**
 * This class was generated by Apache CXF 3.1.4
 * 2016-01-14T17:15:10.405+08:00
 * Generated source version: 3.1.4
 * 
 */
@WebService(targetNamespace = "http://webServices_CXF.mervyn.github.org/", name = "HelloWS")
@XmlSeeAlso({ObjectFactory.class})
public interface HelloWS {

    @WebMethod
    @RequestWrapper(localName = "sayHello", targetNamespace = "http://webServices_CXF.mervyn.github.org/", className = "org.github.mervyn.webservices_cxf.SayHello")
    @ResponseWrapper(localName = "sayHelloResponse", targetNamespace = "http://webServices_CXF.mervyn.github.org/", className = "org.github.mervyn.webservices_cxf.SayHelloResponse")
    @WebResult(name = "return", targetNamespace = "")
    public java.lang.String sayHello(
        @WebParam(name = "arg0", targetNamespace = "")
        java.lang.String arg0
    );
}
