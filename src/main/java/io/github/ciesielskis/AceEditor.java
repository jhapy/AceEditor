package io.github.ciesielskis;

import com.vaadin.flow.component.*;
import com.vaadin.flow.component.dependency.CssImport;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.dependency.NpmPackage;
import com.vaadin.flow.shared.Registration;

@Tag("ace-widget")
@SuppressWarnings("serial")
@NpmPackage(value="ace-builds", version="1.4.12")
@JsModule("./@granite-elements/ace-widget/ace-widget.js")
@CssImport(value = "./styles/styles.css")
public class AceEditor extends AbstractSinglePropertyField<AceEditor, String> implements HasSize, HasStyle, Focusable<AceEditor> {

    private String oldValue;

    public AceEditor() {
        super("value", "", false);
    }

    /**
     * Sets the theme of the editor.
     */
    public void setTheme(AceTheme theme) {
        getElement().setAttribute("theme", "ace/theme/" + theme);
    }

    /**
     * Sets the mode of the editor.
     */
    public void setMode(AceMode mode) {
        getElement().setAttribute("mode", "ace/mode/" + mode);
    }

    /**
     * Sets font-size for the editor in pixels.
     */
    public void setFontSize(int fontSize) {
        getElement().setAttribute("font-size", fontSize + "px");
    }

    /**
     * Sets softtabs for the editor.
     */
    public void setSoftTabs(boolean softTabs) {
        getElement().setAttribute("softtabs", softTabs);
    }

    /**
     * Sets tab-size for the editor.
     */
    public void setTabSize(int tabSize) {
        getElement().setAttribute("tab-size", String.valueOf(tabSize));
    }

    /**
     * Sets readonly for the editor.
     */
    public void setReadOnly(boolean readOnly) {
        getElement().setAttribute("readonly", readOnly);
    }

    /**
     * Sets wrap for the editor.
     */
    public void setWrap(Boolean wrap) {
        getElement().setAttribute("wrap", wrap);
    }

    //TODO: autoComplete

    /**
     * Sets minlines for the editor.
     */
    public void setMinLines(int minLines) {
        getElement().setAttribute("minlines", String.valueOf(minLines));
    }

    /**
     * Sets maxlines for the editor.
     */
    public void setMaxLines(int maxLines) {
        getElement().setAttribute("maxlines", String.valueOf(maxLines));
    }

    /**
     * Sets initialFocus for the editor.
     */
    public void setInitialFocus(Boolean initialFocus) {
        getElement().setAttribute("initialFocus", initialFocus);
    }

    /**
     * Sets placeholder for the editor.
     */
    public void setPlaceholder(String placeholder) {
        getElement().setAttribute("placeholder", placeholder);
    }

    /**
     * Returns the current value of the editor.
     */
    @Synchronize(value = "editor-content", property = "editorValue")
    public String getValue() {
        return getElement().getProperty("editorValue");
    }

    /**
     * Sets value for the editor.
     */
    public void setValue(String value) {
        getElement().setProperty("value", value);
    }

    @Override
    public Registration addValueChangeListener(ValueChangeListener<? super ComponentValueChangeEvent<AceEditor, String>> listener) {
        oldValue = getValue();

        getElement().addEventListener("editor-content", e -> {
            listener.valueChanged(new ComponentValueChangeEvent<>(this, this, oldValue, true));
            oldValue = getValue();
        });

        return super.addValueChangeListener(listener);
    }


}
