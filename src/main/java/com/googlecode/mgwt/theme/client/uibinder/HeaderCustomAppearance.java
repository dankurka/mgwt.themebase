package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.ui.client.widget.header.HeaderAppearance;
import com.googlecode.mgwt.ui.client.widget.header.HeaderPanel;
import com.googlecode.mgwt.ui.client.widget.header.HeaderTitle;

public class HeaderCustomAppearance implements HeaderAppearance {

  static {
    Resources.INSTANCE.cssPanel().ensureInjected();
  }

  interface CssPanel extends HeaderPanelCss {}
  interface CssTitle extends HeaderTitleCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/header/header.css", "../css/header.css"})
    CssPanel cssPanel();

    @Source({
        "com/googlecode/mgwt/ui/client/widget/header/header-title.css", "../css/header-title.css"})
    CssTitle cssTitle();
  }

  @Override
  public HeaderPanelCss cssPanel() {
    return Resources.INSTANCE.cssPanel();
  }

  @Override
  public HeaderTitleCss cssTitle() {
    return Resources.INSTANCE.cssTitle();
  }

  @UiTemplate("HeaderPanelAbstractAppearance.ui.xml")
  interface BinderPanel extends UiBinder<Widget, HeaderPanel> {
  }

  private static final BinderPanel UI_BINDER_PANEL = GWT.create(BinderPanel.class);

  @UiTemplate("HeaderTitleAbstractAppearance.ui.xml")
  interface BinderTitle extends UiBinder<Element, HeaderTitle> {
  }

  private static final BinderTitle UI_BINDER_TITLE = GWT.create(BinderTitle.class);

  @Override
  public UiBinder<Widget, HeaderPanel> panelBinder() {
    return UI_BINDER_PANEL;
  }

  @Override
  public UiBinder<? extends Element, HeaderTitle> uiBinderTitle() {
    return UI_BINDER_TITLE;
  }
}
