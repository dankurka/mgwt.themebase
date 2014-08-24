package com.googlecode.mgwt.theme.client.uibinder;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.dom.client.Element;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiTemplate;
import com.google.gwt.user.client.ui.Widget;

import com.googlecode.mgwt.ui.client.widget.dialog.panel.DialogButton;
import com.googlecode.mgwt.ui.client.widget.dialog.panel.DialogPanel;
import com.googlecode.mgwt.ui.client.widget.dialog.panel.DialogPanelAppearance;

public class DialogPanelCustomAppearance implements DialogPanelAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
    Resources.INSTANCE.cssPanel().ensureInjected();
    Resources.INSTANCE.overlay().ensureInjected();
  }

  interface CssButton extends DialogButtonCss {}

  interface CssDialog extends DialogCss {}

  interface OverlayCss extends DialogOverlayCss{}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/dialog/panel/dialog-button.css", "../css/dialog-button.css"})
    CssButton css();

    @Source({"com/googlecode/mgwt/ui/client/widget/dialog/panel/dialog.css", "../css/dialog.css"})
    CssDialog cssPanel();

    @Source({"com/googlecode/mgwt/ui/client/widget/dialog/overlay/dialog-overlay.css", "../css/dialog-overlay.css"})
    OverlayCss overlay();
  }

  @Override
  public DialogCss dialogCss() {
    return Resources.INSTANCE.cssPanel();
  }

  @Override
  public DialogButtonCss css() {
    return Resources.INSTANCE.css();
  }

  @Override
  public DialogOverlayCss overlayCss() {
    return Resources.INSTANCE.overlay();
  }

  @UiTemplate("ButtonAbstractAppearance.ui.xml")
  interface Binder extends UiBinder<Element, DialogButton> {
  }

  private static final Binder UI_BINDER = GWT.create(Binder.class);

  @UiTemplate("DialogPanelAbstractAppearance.ui.xml")
  interface DialogBinder extends UiBinder<Widget, DialogPanel> {
  }

  private static final DialogBinder UI_DIALOG_BINDER = GWT.create(DialogBinder.class);

  @Override
  public UiBinder<Element, DialogButton> uiBinder() {
    return UI_BINDER;
  }

  @Override
  public UiBinder<Widget, DialogPanel> dialogBinder() {
    return UI_DIALOG_BINDER;
  }
}
