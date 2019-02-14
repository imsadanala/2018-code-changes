package com.custom.annotations;

public class CustomAnnotationsSample {

	public static void main(String[] args) {
		Nokia nokia = new Nokia("Black", 5.5);
		// System.out.println(nokia.toString());
		// to get annotated values
		@SuppressWarnings("rawtypes")
		Class nokiaObject = nokia.getClass();
		@SuppressWarnings("unchecked")
		SmartPhone smartPhone = (SmartPhone) nokiaObject.getAnnotation(SmartPhone.class);
		System.out.println(nokia.toString() + " osType " + smartPhone.osType() + " osVersion " + smartPhone.osVersion());
	}
}

@SmartPhone(osType = "Microsoft")
class Nokia {
	double screenSize;
	String color;

	public Nokia() {
		super();
	}

	public Nokia(String color, double screenSize) {
		this.color = color;
		this.screenSize = screenSize;
	}

	@Override
	public String toString() {
		return "Nokia [screenSize=" + screenSize + ", color=" + color + "]";
	}

}
