package com.cert.chortke.confg;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "userconf")
public class UserProperties {

	private String userSecurity;

	public String getUserSecurity() {
		return userSecurity;
	}

	public void setUserSecurity(String userSecurity) {
		this.userSecurity = userSecurity;
	}

}
