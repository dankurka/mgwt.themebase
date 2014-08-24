/*
 * Copyright 2014 Daniel Kurka
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not
 * use this file except in compliance with the License. You may obtain a copy of
 * the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS, WITHOUT
 * WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied. See the
 * License for the specific language governing permissions and limitations under
 * the License.
 */
package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

import com.googlecode.mgwt.ui.client.widget.button.ImageButton;
import com.googlecode.mgwt.ui.client.widget.button.ImageButtonAppearance;

public class ImageButtonCustomAppearance implements ImageButtonAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends ImageButtonCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/button/imagebutton.css", "../css/imagebutton.css"})
    Css css();
  }

  @Override
  public ImageButtonCss css() {
    return Resources.INSTANCE.css();
  }

  @UiTemplate("ImageButtonAbstractAppearance.ui.xml")
  interface Binder extends UiBinder<Element, ImageButton> {
  }

  private static final Binder UI_BINDER = GWT.create(Binder.class);

  @Override
  public UiBinder<Element, ImageButton> uiBinder() {
    return UI_BINDER;
  }
}
