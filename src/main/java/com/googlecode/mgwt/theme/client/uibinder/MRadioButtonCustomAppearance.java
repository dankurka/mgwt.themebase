/*
 * Copyright 2013 Daniel Kurka
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

import com.googlecode.mgwt.ui.client.widget.input.radio.MRadioButton;
import com.googlecode.mgwt.ui.client.widget.input.radio.MRadioButtonAppearance;

public class MRadioButtonCustomAppearance implements MRadioButtonAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends MRadioButtonCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/input/radio/mradiobutton.css", "../css/mradiobutton.css"})
    Css css();

    @Source("com/googlecode/mgwt/ui/client/widget/input/radio/resources/check.png")
    DataResource inputCheckImage();
  }

  @Override
  public MRadioButtonCss css() {
    return Resources.INSTANCE.css();
  }

  @UiTemplate("MRadioButtonBaseAppearance.ui.xml")
  interface Binder extends UiBinder<Element, MRadioButton> {
  }

  private static final Binder UI_BINDER = GWT.create(Binder.class);

  @Override
  public UiBinder<? extends Element, MRadioButton> uiBinder() {
    return UI_BINDER;
  }
}
