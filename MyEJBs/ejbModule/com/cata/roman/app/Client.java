package com.cata.roman.app;

import javax.naming.Context;
import javax.naming.NamingException;

import com.cata.roman.ejb.HelloWorldBean;
import com.cata.roman.ejb.HelloWorldBeanRemoteInterface;

public class Client {

	public static void main(String[] args) {

		HelloWorldBeanRemoteInterface bean = doLookUp();
		
		System.out.println(bean.sayHello());
	}

	private static HelloWorldBeanRemoteInterface doLookUp() {
		Context context = null;
		HelloWorldBeanRemoteInterface bean = null;
		
		try {
			context = ClientUtility.getInitialContext();
			String lookupName = getLookupName();
			
			bean = (HelloWorldBeanRemoteInterface) context.lookup(lookupName);
		} catch (NamingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return bean;
	}

	private static String getLookupName() {
		 
        // The EJB bean implementation class name
        String beanName = HelloWorldBean.class.getSimpleName();
 
        // Fully qualified remote interface name
        final String interfaceName = HelloWorldBeanRemoteInterface.class.getName();
 
        String appName = "MyEJBsEAR";
		String moduleName = "MyEJBs";
		
		// Create a look up string name
        String name = "ejb:" + appName + "/" + moduleName + "/" + beanName + "!" + interfaceName;

        return name;
	}

}
