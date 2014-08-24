package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.ui.client.widget.panel.Panel;
import com.googlecode.mgwt.ui.client.widget.panel.PanelAppearance;

public class PanelCustomAppearance implements PanelAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends PanelCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/panel/panel.css", "../css/panel.css"})
    Css css();
  }

  @Override
  public PanelCss css() {
    return Resources.INSTANCE.css();
  }

  @UiTemplate("PanelBaseAppearance.ui.xml")
  interface Binder extends UiBinder<Widget, Panel> {
  }

  private static final Binder UI_BINDER = GWT.create(Binder.class);

  @Override
  public UiBinder<Widget, Panel> uiBinder() {
    return UI_BINDER;
  }
}
