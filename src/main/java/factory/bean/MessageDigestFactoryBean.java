package factory.bean;

import java.security.MessageDigest;

import org.springframework.beans.factory.FactoryBean;
import org.springframework.beans.factory.InitializingBean;

public class MessageDigestFactoryBean implements FactoryBean<MessageDigest>, InitializingBean {

	private String algorithmName = "MD5";
	private MessageDigest messageDigest = null;

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println(algorithmName);
		messageDigest = MessageDigest.getInstance(algorithmName);
	}

	@Override
	public MessageDigest getObject() throws Exception {
		// TODO Auto-generated method stub
		return messageDigest;
	}

	@Override
	public Class<MessageDigest> getObjectType() {
		// TODO Auto-generated method stub
		return MessageDigest.class;
	}

	@Override
	public boolean isSingleton() {
		// TODO Auto-generated method stub
		return true;
	}

	public void setAlgorithmName(String algorithmName) {
		this.algorithmName = algorithmName;
	}
}
