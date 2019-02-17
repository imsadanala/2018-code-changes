package com.dp.creational.factory;

/**
 * 
 * @author Suresh Sadanala
 *
 */
public class OperatingSystemFactory {

	public OS getOSInstance(String osName) {
		OS operatingSystem = null;
		if (osName != null && osName.length() > 0) {
			switch (osName) {
			case "andriod":
			case "Andriod":
				operatingSystem = new AndiodOS();
				break;
			case "windows":
			case "Windows":
				operatingSystem = new WindowsOS();
				break;
			case "IOS":
			case "iOS":
				operatingSystem = new IOS();
				break;
			default:
				break;
			}
		}
		return operatingSystem;
	}

}
