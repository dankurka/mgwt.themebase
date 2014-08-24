package com.googlecode.mgwt.theme.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;

import com.googlecode.mgwt.ui.client.widget.main.MainResourceDefaultAppearance;

public class MainResourceCustomAppearance extends MainResourceDefaultAppearance {

  interface Css extends MainCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/main/main.css", "css/main.css"})
    Css css();
  }

  @Override
  public MainCss css() {
    return Resources.INSTANCE.css();
  }
}
