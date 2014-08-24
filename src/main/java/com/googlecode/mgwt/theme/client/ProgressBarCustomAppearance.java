package com.googlecode.mgwt.theme.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;

import com.googlecode.mgwt.ui.client.widget.progress.ProgressBarAbstractAppearance;

public class ProgressBarCustomAppearance extends ProgressBarAbstractAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends ProgressBarCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/progress/progressbar.css", "css/progressbar.css"})
    Css css();
  }

  @Override
  public ProgressBarCss css() {
    return Resources.INSTANCE.css();
  }
}
