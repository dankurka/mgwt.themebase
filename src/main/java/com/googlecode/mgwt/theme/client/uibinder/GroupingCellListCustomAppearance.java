package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.DataResource;
import com.google.gwt.safehtml.client.SafeHtmlTemplates;
import com.google.gwt.safehtml.shared.SafeHtml;

import com.googlecode.mgwt.ui.client.widget.list.celllist.GroupingCellList.HeaderTemplate;
import com.googlecode.mgwt.ui.client.widget.list.celllist.GroupingCellListAppearance;

public class GroupingCellListCustomAppearance extends CellListCustomAppearance implements GroupingCellListAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
  }

  interface Css extends CellListCss {}
  interface CssGroup extends GroupingListCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({
        "com/googlecode/mgwt/ui/client/widget/list/celllist/celllist.css", "../css/celllist.css"})
    Css css();

    @Source({
        "com/googlecode/mgwt/ui/client/widget/list/celllist/grouping-celllist.css",
        "../css/grouping-celllist.css"})
    CssGroup groupCss();

    @Source("com/googlecode/mgwt/ui/client/widget/list/celllist/arrow.png")
    DataResource listArrow();
  }

  @Override
  public CellListCss css() {
    return Resources.INSTANCE.css();
  }

  @Override
  public GroupingListCss groupCss() {
    return Resources.INSTANCE.groupCss();
  }

  interface Template extends SafeHtmlTemplates, HeaderTemplate {
    @SafeHtmlTemplates.Template("<li class=\"{1}\" >{0}</li>")
    SafeHtml li(SafeHtml cellContents, String classes);

  }

  private static final Template LI_TEMPLATE = GWT.create(Template.class);

  @Override
  public HeaderTemplate getHeaderTemplate() {
    return LI_TEMPLATE;
  }
}
