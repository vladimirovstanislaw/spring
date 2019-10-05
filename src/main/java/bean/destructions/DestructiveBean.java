package bean.destructions;

import java.io.File;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.support.GenericXmlApplicationContext;

import sun.security.krb5.internal.crypto.Des;

public class DestructiveBean implements InitializingBean {

	private File file;
	private String filePath;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GenericXmlApplicationContext ctx=new GenericXmlApplicationContext();
		ctx.load("classpath:META-INF/spring/destructive-bean-app-context.xml");
		ctx.refresh();
		DestructiveBean bean=(DestructiveBean) ctx.getBean("destructiveBean");
		System.out.println("Calling destroy");
		ctx.destroy();
		System.out.println("Calling destroy"); 
	}

	@Override
	public void afterPropertiesSet() throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Initializing Bean");
		if (filePath == null) {
			throw new IllegalArgumentException("You must specify the filePath property of " + DestructiveBean.class);
		}
		this.file = new File(filePath);
		this.file.createNewFile();
		System.out.println("File exists: " + file.exists());
	}

	public void destroy() {
		System.out.println("Destroying Bean");
		if (!file.delete()) {
			System.err.println("ERROR: failed to delete file.");
		}
		System.out.println("File exists: " + file.exists());
	}
	public void setFilePath(String filePath) {
		this.filePath=filePath;
		
	}

}
