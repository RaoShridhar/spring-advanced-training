package com.asseco.aha.training.spring_advanced.core.scope;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.asseco.aha.training.spring_advanced.core.scope.ScopeApplication;
import com.asseco.aha.training.spring_advanced.core.scope.TokenBean;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = ScopeApplication.class)
public class ProxyModeTest {

	@Autowired
	@Qualifier("beanSingleton")
	private TokenBean bean;

	@Test
	public void contextLoads() {
		Assert.assertNotEquals(bean.getToken(), bean.getToken());
		// Assert.assertNotEquals(bean.toString(), bean.toString());
	}
}