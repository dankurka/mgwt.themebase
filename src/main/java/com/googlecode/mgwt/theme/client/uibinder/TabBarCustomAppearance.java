package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarAppearance;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabBarButtonBase;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel;
import com.googlecode.mgwt.ui.client.widget.tabbar.TabPanel.TabBar;

public class TabBarCustomAppearance implements TabBarAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
    Resources.INSTANCE.barCss().ensureInjected();
  }

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/tabbar/tabbar.css", "../css/tabbar.css"})
    TabBarCss barCss();
    @Source({"com/googlecode/mgwt/ui/client/widget/tabbar/tabbar-button.css", "../css/tabbar-button.css"})
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

  @UiTemplate("TabPanelAbstractAppearance.ui.xml")
  interface PanelBinder extends UiBinder<Widget, TabPanel> {}

  @UiTemplate("TabBarAbstractAppearance.ui.xml")
  interface BarBinder extends UiBinder<Widget, TabPanel.TabBar> {}

  @UiTemplate("TabBarButtonBaseAppearance.ui.xml")
  interface ButtonBinder extends UiBinder<Element, TabBarButtonBase> {}

  private static final PanelBinder UI_BINDER_PANEL = GWT.create(PanelBinder.class);

  private static final ButtonBinder UI_BINDER = GWT.create(ButtonBinder.class);

  private static final BarBinder UI_BINDER_BAR = GWT.create(BarBinder.class);

  @Override
  public UiBinder<? extends Element, TabBarButtonBase> uiBinder() {
    return UI_BINDER;
  }

  @Override
  public UiBinder<Widget, TabPanel> panelBinder() {
    return UI_BINDER_PANEL;
  }

  @Override
  public UiBinder<Widget, TabBar> barBinder() {
    return UI_BINDER_BAR;
  }
}
