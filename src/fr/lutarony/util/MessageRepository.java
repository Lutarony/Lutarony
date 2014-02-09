package fr.lutarony.util;

import java.util.Locale;
import java.util.ResourceBundle;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

@ManagedBean(name = "messageRepository")
@ApplicationScoped
public class MessageRepository {

	private ResourceBundle resourceBundle;

	public MessageRepository() {
		init();
	}

	public void init() {
		createResourceBundleFR();
	}

	public void createResourceBundleFR() {
		resourceBundle = ResourceBundle.getBundle("message_fr", Locale.FRENCH,
				Thread.currentThread().getContextClassLoader());
	}

	public void createResourceBundleEN() {
		resourceBundle = ResourceBundle.getBundle("message_en", Locale.ENGLISH,
				Thread.currentThread().getContextClassLoader());
	}

	public ResourceBundle getResourceBundle() {
		return resourceBundle;
	}

	public void setResourceBundle(ResourceBundle resourceBundle) {
		this.resourceBundle = resourceBundle;
	}

}
