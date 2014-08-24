package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

import com.googlecode.mgwt.ui.client.widget.progress.ProgressBar;
import com.googlecode.mgwt.ui.client.widget.progress.ProgressBarAppearance;

public class ProgressBarCustomAppearance implements ProgressBarAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends ProgressBarCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/progress/progressbar.css", "../css/progressbar.css"})
    Css css();
  }

  @Override
  public ProgressBarCss css() {
    return Resources.INSTANCE.css();
  }

  @UiTemplate("ProgressBarBaseAppearance.ui.xml")
  interface Binder extends UiBinder<Element, ProgressBar> {
  }

  private static final Binder UI_BINDER = GWT.create(Binder.class);

  @Override
  public UiBinder<? extends Element, ProgressBar> uiBinder() {
    return UI_BINDER;
  }
}
