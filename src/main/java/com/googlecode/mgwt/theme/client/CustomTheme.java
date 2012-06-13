package com.googlecode.mgwt.theme.client;

import com.google.gwt.core.client.GWT;
import com.googlecode.mgwt.ui.client.MGWT;
import com.googlecode.mgwt.ui.client.theme.MGWTClientBundle;
import com.googlecode.mgwt.ui.client.theme.MGWTTheme;

public class CustomTheme implements MGWTTheme {
	private MGWTClientBundle bundle;

	public CustomTheme() {
		// instantiate the right theme!
		if (MGWT.getOsDetection().isAndroidPhone()) {
			bundle = GWT.create(CustomBundleAndroid.class);
		}

		if (MGWT.getOsDetection().isAndroidTablet()) {
			bundle = GWT.create(CustomBundleAndroidTablet.class);
		}

		if (MGWT.getOsDetection().isIPhone()) {
			if (MGWT.getOsDetection().isRetina()) {
				bundle = GWT.create(CustomBundleRetina.class);
			} else {
				bundle = GWT.create(CustomBundleIPhone.class);
			}
		}

		if (MGWT.getOsDetection().isIPad()) {
			if (MGWT.getOsDetection().isIPadRetina()) {
				bundle = GWT.create(CustomBundleIpadRetina.class);
			} else {
				bundle = GWT.create(CustomBundleIpad.class);
			}

		}

		if (MGWT.getOsDetection().isBlackBerry()) {
			bundle = GWT.create(CustomBundleBlackberry.class);
		}

		if (MGWT.getOsDetection().isDesktop()) {
			bundle = GWT.create(CustomBundleDesktop.class);
		}
	}

	@Override
	public MGWTClientBundle getMGWTClientBundle() {
		return bundle;
	}

}
