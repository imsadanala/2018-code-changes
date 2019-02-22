package com.custom.annotations;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

public class CustomAnnotationsSample {

	public static void main(String[] args) {

		Nokia nokia = new Nokia("Black", 5.5);

		// Here we get the class level annotation
		SmartPhone smartPhone = (SmartPhone) Nokia.class.getAnnotation(SmartPhone.class);
		System.out.println(" Class specific values are :");
		System.out.println(nokia.toString() + " osType " + smartPhone.osType() + " osVersion " + smartPhone.osVersion());

		// We get method level annotations
		Method[] declaredMethods = Nokia.class.getDeclaredMethods();
		System.out.println(" All method level values are :");
		if (declaredMethods != null) {
			Arrays.stream(declaredMethods).filter(smartPhoneM -> smartPhoneM.getAnnotation(SmartPhone.class) != null)
					.map(smartPhoneM -> smartPhoneM.getAnnotation(SmartPhone.class))
					.map(message -> message.sendMessage()).forEach(System.out::println);
		}

		// We get field level annotations, as per our example we have only one field level variable i.e. buildVersion others will be empty
		Field[] declaredFields = Nokia.class.getDeclaredFields();
		if (declaredFields != null) {
			System.out.println(" All field level values are :");
			Arrays.stream(declaredFields)
					.filter(smartPhoneFields -> smartPhoneFields.getAnnotation(SmartPhone.class) != null)
					.map(smartPhoneField -> smartPhoneField.getAnnotation(SmartPhone.class))
					.map(buildversion -> buildversion.buildNumber())
					.forEach(buildVersion -> System.out.println(" buildVersion is " + buildVersion));

		}
	}
}

@SmartPhone(osType = "Microsoft")
class Nokia {
	double screenSize;
	String color;
	@SmartPhone(buildNumber = "GHTYgdgd435YY")
	String builString;

	public Nokia() {
		super();
	}

	public Nokia(String color, double screenSize) {
		this.color = color;
		this.screenSize = screenSize;
	}

	@SmartPhone(sendMessage = " Message send by Nokia phone")
	public void sendMessage() {
		// TODO message logic
		System.out.println(" Defualt message will send ");
	}

	@Override
	public String toString() {
		return "Nokia [screenSize=" + screenSize + ", color=" + color + "]";
	}

}
