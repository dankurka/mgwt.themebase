package com.googlecode.mgwt.theme.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;

import com.googlecode.mgwt.ui.client.widget.panel.PanelAbstractAppearance;

public class PanelCustomAppearance extends PanelAbstractAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends PanelCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/panel/panel.css", "css/panel.css"})
    Css css();
  }

  @Override
  public PanelCss css() {
    return Resources.INSTANCE.css();
  }
}
