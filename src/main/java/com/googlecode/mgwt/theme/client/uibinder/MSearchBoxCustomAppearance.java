/*
 * Copyright 2014 Daniel Kurka
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
import com.google.gwt.resources.client.ImageResource;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.ui.client.widget.input.search.MSearchBox;
import com.googlecode.mgwt.ui.client.widget.input.search.MSearchBox.MSearchBoxButton;
import com.googlecode.mgwt.ui.client.widget.input.search.MSearchBoxAppearance;

public class MSearchBoxCustomAppearance implements MSearchBoxAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends MSearchBoxCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/input/search/searchbox.css", "../css/searchbox.css"})
    Css css();

    @Source("com/googlecode/mgwt/ui/client/widget/input/search/search_mdpi.png")
    ImageResource searchImage();

    @Source("com/googlecode/mgwt/ui/client/widget/input/search/clear_mdpi.png")
    ImageResource searchClearImage();
  }

  @Override
  public MSearchBoxCss css() {
    return Resources.INSTANCE.css();
  }

  @UiTemplate("MSearchBoxAbstractAppearance.ui.xml")
  interface Binder extends UiBinder<Widget, MSearchBox> {
  }

  private static final Binder UI_BINDER = GWT.create(Binder.class);

  @UiTemplate("MSearchBoxButtonAbstractAppearance.ui.xml")
  interface ButtonBinder extends UiBinder<Element, MSearchBoxButton> {
  }

  private static final ButtonBinder UI_BINDER_BUTTON = GWT.create(ButtonBinder.class);

  @Override
  public UiBinder<Element, MSearchBoxButton> uiBinder() {
    return UI_BINDER_BUTTON;
  }

  @Override
  public UiBinder<Widget, MSearchBox> uiBinderBox() {
    return UI_BINDER;
  }
}
