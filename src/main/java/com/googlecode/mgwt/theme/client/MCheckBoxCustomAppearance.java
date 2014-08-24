/*
 * Copyright 2014 Katharina Fahnenbruck
 */
package com.googlecode.mgwt.theme.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;

import com.googlecode.mgwt.ui.client.widget.input.checkbox.MCheckBoxAbstractAppearance;

public class MCheckBoxCustomAppearance extends MCheckBoxAbstractAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends CheckBoxCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/input/checkbox/checkbox.css", "css/checkbox.css"})
    Css css();
  }

  @Override
  public CheckBoxCss css() {
    return Resources.INSTANCE.css();
  }
}
