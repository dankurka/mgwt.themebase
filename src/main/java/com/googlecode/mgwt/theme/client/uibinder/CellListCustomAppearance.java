package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;

import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellList.EntryTemplate;
import com.googlecode.mgwt.ui.client.widget.list.celllist.CellListAppearance;

public class CellListCustomAppearance implements CellListAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends CellListCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({
        "com/googlecode/mgwt/ui/client/widget/list/celllist/celllist.css", "../css/celllist.css"})
    Css css();

    @Source("com/googlecode/mgwt/ui/client/widget/list/celllist/arrow.png")
    DataResource listArrow();
  }

  @Override
  public CellListCss css() {
    return Resources.INSTANCE.css();
  }

  /**
   * the li template instance
   */
  private static final Template LI_TEMPLATE = GWT.create(Template.class);

  @UiTemplate("CellListBaseAppearance.ui.xml")
  interface Binder extends UiBinder<Element, CellList<?>> {
  }

  private static final Binder UI_BINDER = GWT.create(Binder.class);

  @Override
  public UiBinder<? extends Element, CellList<?>> uiBinder() {
    return UI_BINDER;
  }

  public interface Template extends EntryTemplate, SafeHtmlTemplates {
    @Override
    @SafeHtmlTemplates.Template("<li __idx=\"{0}\" class=\"{1}\">{2}</li>")
    SafeHtml li(int idx, String classes, SafeHtml cellContents);
  }

  @Override
  public EntryTemplate getEntryTemplate() {
    return LI_TEMPLATE;
  }
}
