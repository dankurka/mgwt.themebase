package com.googlecode.mgwt.theme.client;

import com.google.gwt.core.shared.GWT;
import com.google.gwt.resources.client.ClientBundle;

import com.googlecode.mgwt.ui.client.widget.dialog.panel.DialogPanelAbstractAppearance;

public class DialogPanelCustomAppearance extends DialogPanelAbstractAppearance {

  static {
    Resources.INSTANCE.css().ensureInjected();
    Resources.INSTANCE.cssPanel().ensureInjected();
  }

  interface CssButton extends DialogButtonCss {}

  interface CssDialog extends DialogCss {}

  interface Resources extends ClientBundle {

    Resources INSTANCE = GWT.create(Resources.class);

    @Source({"com/googlecode/mgwt/ui/client/widget/dialog/panel/dialog-button.css", "css/dialog-button.css"})
    CssButton css();

    @Source({"com/googlecode/mgwt/ui/client/widget/dialog/panel/dialog.css", "css/dialog.css"})
    CssDialog cssPanel();
  }

  @Override
  public DialogCss dialogCss() {
    return Resources.INSTANCE.cssPanel();
  }

  @Override
  public DialogButtonCss css() {
    return Resources.INSTANCE.css();
  }
}
