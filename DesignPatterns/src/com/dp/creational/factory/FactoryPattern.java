/**
 * 
 */
package com.dp.creational.factory;

/**
 * @author Suresh Sadanala
 *
 */
public class FactoryPattern {
	/**
	 * 
	 * Factory design pattern summary is available notes under resource folder
	 */
	public static void main(String[] args) {
		OperatingSystemFactory operatingSystemFactory = new OperatingSystemFactory();
		OS andriodOS = operatingSystemFactory.getOSInstance("Andriod");
		if (andriodOS != null) {
			andriodOS.specification();
		} else {
			System.out.println(" this OS is not recognized ........");
		}
		andriodOS.specification();
		OS iOS = operatingSystemFactory.getOSInstance("IOS");
		if (iOS != null) {
			iOS.specification();
		} else {
			System.out.println(" this OS is not recognized ........");
		}
		OS windowsOS = operatingSystemFactory.getOSInstance("Windows");
		if (windowsOS != null) {
			windowsOS.specification();
		} else {
			System.out.println(" this OS is not recognized ........");
		}
		OS linuxOS = operatingSystemFactory.getOSInstance("Linux");
		if (linuxOS != null) {
			linuxOS.specification();
		} else {
			System.out.println(" this OS is not recognized ........");
		}
	}

}
