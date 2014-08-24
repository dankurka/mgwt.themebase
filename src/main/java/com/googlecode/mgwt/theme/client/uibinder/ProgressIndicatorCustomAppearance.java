package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

import com.googlecode.mgwt.ui.client.widget.progress.ProgressIndicator;
import com.googlecode.mgwt.ui.client.widget.progress.ProgressIndicatorAppearance;

public class ProgressIndicatorCustomAppearance implements ProgressIndicatorAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends ProgressIndicatorCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({ "com/googlecode/mgwt/ui/client/widget/progress/progressindicator.css", "../css/progressindicator.css" })
    Css css();
  }

  @Override
  public ProgressIndicatorCss css() {
    return Resources.INSTANCE.css();
  }

  @UiTemplate("ProgressIndicatorBaseAppearance.ui.xml")
  interface Binder extends UiBinder<Element, ProgressIndicator> {
  }

  private static final Binder UI_BINDER = GWT.create(Binder.class);

  @Override
  public UiBinder<? extends Element, ProgressIndicator> uiBinder() {
    return UI_BINDER;
  }
}
