package com.cata.roman.ejb;

import javax.ejb.Remote;

/**
 * The remote interface of the {@link HelloWorldBean}.
 * @author Catalin
 *
 */
@Remote
public interface HelloWorldBeanRemoteInterface {

	public String sayHello();
}
