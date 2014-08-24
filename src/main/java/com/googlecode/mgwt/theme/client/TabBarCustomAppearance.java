package com.googlecode.mgwt.theme.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;

import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAbstractAppearance;

public class TabBarCustomAppearance extends TabBarAbstractAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
    Resources.INSTANCE.barCss().ensureInjected();
  }

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/tabbar/tabbar.css", "css/tabbar.css"})
    TabBarCss barCss();
    @Source({"com/googlecode/mgwt/ui/client/widget/tabbar/tabbar-button.css", "css/tabbar-button.css"})
    TabBarButtonCss css();
  }

  @Override
  public TabBarButtonCss css() {
    return Resources.INSTANCE.css();
  }

  @Override
  public TabBarCss barCss() {
    return Resources.INSTANCE.barCss();
  }
}
