/**
 * IHelloWorldLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package org.eredlab.g4.esb.webservice.client;

public class IHelloWorldLocator extends org.apache.axis.client.Service implements org.eredlab.g4.esb.webservice.client.IHelloWorld {

    public IHelloWorldLocator() {
    }


    public IHelloWorldLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public IHelloWorldLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for IHelloWorldHttpPort
    private java.lang.String IHelloWorldHttpPort_address = "http://localhost/webservicehello/HelloWorldService.ws";

    public java.lang.String getIHelloWorldHttpPortAddress() {
        return IHelloWorldHttpPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String IHelloWorldHttpPortWSDDServiceName = "IHelloWorldHttpPort";

    public java.lang.String getIHelloWorldHttpPortWSDDServiceName() {
        return IHelloWorldHttpPortWSDDServiceName;
    }

    public void setIHelloWorldHttpPortWSDDServiceName(java.lang.String name) {
        IHelloWorldHttpPortWSDDServiceName = name;
    }

    public org.eredlab.g4.esb.webservice.client.IHelloWorldPortType getIHelloWorldHttpPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(IHelloWorldHttpPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getIHelloWorldHttpPort(endpoint);
    }

    public org.eredlab.g4.esb.webservice.client.IHelloWorldPortType getIHelloWorldHttpPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            org.eredlab.g4.esb.webservice.client.IHelloWorldHttpBindingStub _stub = new org.eredlab.g4.esb.webservice.client.IHelloWorldHttpBindingStub(portAddress, this);
            _stub.setPortName(getIHelloWorldHttpPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setIHelloWorldHttpPortEndpointAddress(java.lang.String address) {
        IHelloWorldHttpPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (org.eredlab.g4.esb.webservice.client.IHelloWorldPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                org.eredlab.g4.esb.webservice.client.IHelloWorldHttpBindingStub _stub = new org.eredlab.g4.esb.webservice.client.IHelloWorldHttpBindingStub(new java.net.URL(IHelloWorldHttpPort_address), this);
                _stub.setPortName(getIHelloWorldHttpPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("IHelloWorldHttpPort".equals(inputPortName)) {
            return getIHelloWorldHttpPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://webservice", "IHelloWorld");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://webservice", "IHelloWorldHttpPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("IHelloWorldHttpPort".equals(portName)) {
            setIHelloWorldHttpPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
