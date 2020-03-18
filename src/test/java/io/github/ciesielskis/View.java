package io.github.ciesielskis;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.Route;

@Route("")
public class View extends Div {

    public View() {
        AceEditor aceEditor = new AceEditor();

        aceEditor.setTheme(AceTheme.eclipse);
        aceEditor.setMode(AceMode.xml);
        aceEditor.setFontSize(14);
        aceEditor.setSoftTabs(false);
        aceEditor.setTabSize(4);
        aceEditor.setWidth("1000px");
        aceEditor.setHeight("500px");

        aceEditor.addValueChangeListener(e -> {
            System.out.println("Value change new: " + e.getValue());
            System.out.println("Value change old: " + e.getOldValue());
        });

        add(aceEditor);
    }
}
