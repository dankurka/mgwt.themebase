package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.ui.client.widget.list.widgetlist.WidgetList;
import com.googlecode.mgwt.ui.client.widget.list.widgetlist.WidgetList.WidgetListEntry;
import com.googlecode.mgwt.ui.client.widget.list.widgetlist.WidgetListAppearance;

public class WidgetListCustomAppearance implements WidgetListAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends WidgetListCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/list/widgetlist/widgetlist.css", "../css/widgetlist.css"})
    Css css();
  }

  @Override
  public WidgetListCss css() {
    return Resources.INSTANCE.css();
  }

  @UiTemplate("WidgetListAbstractAppearance.ui.xml")
  interface Binder extends UiBinder<Widget, WidgetList> {
  }

  private static final Binder UI_BINDER = GWT.create(Binder.class);

  @UiTemplate("WidgetListEntryAbstractAppearance.ui.xml")
  interface BinderEntry extends UiBinder<Widget, WidgetListEntry> {
  }

  private static final BinderEntry UI_BINDER_ENTRY = GWT.create(BinderEntry.class);

  @Override
  public UiBinder<Widget, WidgetList> uiBinder() {
    return UI_BINDER;
  }

  @Override
  public UiBinder<Widget, WidgetListEntry> uiBinderEntry() {
    return UI_BINDER_ENTRY;
  }
}
