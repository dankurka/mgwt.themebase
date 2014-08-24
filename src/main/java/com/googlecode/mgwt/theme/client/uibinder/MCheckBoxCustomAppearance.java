/*
 * Copyright 2014 Katharina Fahnenbruck
 */
package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

import com.googlecode.mgwt.ui.client.widget.input.checkbox.MCheckBox;
import com.googlecode.mgwt.ui.client.widget.input.checkbox.MCheckBoxAppearance;

public class MCheckBoxCustomAppearance implements MCheckBoxAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends CheckBoxCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/input/checkbox/checkbox.css", "../css/checkbox.css"})
    Css css();
  }

  @Override
  public CheckBoxCss css() {
    return Resources.INSTANCE.css();
  }

  @UiTemplate("MCheckBoxBaseAppearance.ui.xml")
  interface SliderBinder extends UiBinder<Element, MCheckBox> {
  }

  private static final SliderBinder UI_BINDER = GWT.create(SliderBinder.class);

  @Override
  public UiBinder<? extends Element, MCheckBox> uiBinder() {
    return UI_BINDER;
  }
}
