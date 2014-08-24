package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.ui.client.widget.form.Form;
import com.googlecode.mgwt.ui.client.widget.form.FormAppearance;
import com.googlecode.mgwt.ui.client.widget.form.FormEntry;

public class FormCustomAppearance implements FormAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends FormCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/form/form.css", "../css/form.css"})
    Css css();
  }

  @Override
  public FormCss css() {
    return Resources.INSTANCE.css();
  }

  @UiTemplate("FormAbstractAppearance.ui.xml")
  interface Binder extends UiBinder<Widget, Form> {
  }

  private static final Binder UI_BINDER = GWT.create(Binder.class);

  @UiTemplate("FormEntryAbstractAppearance.ui.xml")
  interface BinderEntry extends UiBinder<Widget, FormEntry> {
  }

  private static final BinderEntry UI_BINDER_ENTRY = GWT.create(BinderEntry.class);

  @Override
  public UiBinder<Widget, Form> uiBinder() {
    return UI_BINDER;
  }

  @Override
  public UiBinder<Widget, FormEntry> uiBinderEntry() {
    return UI_BINDER_ENTRY;
  }
}
