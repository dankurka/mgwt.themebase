package com.googlecode.mgwt.theme.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;

import com.googlecode.mgwt.ui.client.widget.progress.ProgressIndicatorAbstractAppearance;

public class ProgressIndicatorCustomAppearance extends ProgressIndicatorAbstractAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends ProgressIndicatorCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({ "com/googlecode/mgwt/ui/client/widget/progress/progressindicator.css", "css/progressindicator.css" })
    Css css();
  }

  @Override
  public ProgressIndicatorCss css() {
    return Resources.INSTANCE.css();
  }
}
