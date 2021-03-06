package org.lunifera.example.vaadin.databinding.samples;

import java.util.Date;

import org.eclipse.core.databinding.DataBindingContext;
import org.eclipse.core.databinding.UpdateValueStrategy;
import org.lunifera.runtime.web.vaadin.databinding.VaadinObservables;

import com.vaadin.data.util.ObjectProperty;
import com.vaadin.ui.AbsoluteLayout;
import com.vaadin.ui.CheckBox;
import com.vaadin.ui.CssLayout;
import com.vaadin.ui.DateField;
import com.vaadin.ui.Label;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.TextField;

public class ValueBindings extends CssLayout {

	private AbsoluteLayout layout;
	private TextField text1;
	private TextField text2;
	private DataBindingContext dbc;
	private CheckBox checkbox1;
	private CheckBox checkbox2;
	private TextArea area1;
	private TextArea area2;
	private DateField date1;
	private DateField date2;
	private TextField text3;
	private Label label3;
	private CheckBox readonly;
	private CheckBox enabled;

	public ValueBindings() {
		setSizeFull();
		init();
	}

	public void init() {

		dbc = new DataBindingContext();

		layout = new AbsoluteLayout();
		layout.setSizeFull();
		addComponent(layout);

		readonly = new CheckBox("Readonly");
		readonly.setImmediate(true);
		enabled = new CheckBox("Enabled");
		enabled.setValue(true);
		enabled.setImmediate(true);
		layout.addComponent(readonly, "top:25px;left:800px");
		layout.addComponent(enabled, "top:25px;left:900px");

		// Text fields
		text1 = new TextField();
		text1.setNullRepresentation("");
		text1.setImmediate(true);
		text1.setPropertyDataSource(new ObjectProperty<String>(null,
				String.class));
		text2 = new TextField();
		text2.setNullRepresentation("");
		text2.setImmediate(true);
		text2.setPropertyDataSource(new ObjectProperty<String>(null,
				String.class));

		layout.addComponent(text1, "top:50px;left:50px");
		layout.addComponent(text2, "top:50px;left:500px");

		dbc.bindValue(VaadinObservables.observeValue(text1),
				VaadinObservables.observeValue(text2));

		// bind readonly and enabled
		dbc.bindValue(VaadinObservables.observeReadonly(text2),
				VaadinObservables.observeValue(readonly));
		dbc.bindValue(VaadinObservables.observeEnabled(text2),
				VaadinObservables.observeValue(enabled));

		// Checkboxes

		checkbox1 = new CheckBox();
		checkbox1.setImmediate(true);
		checkbox1.setPropertyDataSource(new ObjectProperty<Boolean>(false));
		checkbox2 = new CheckBox();
		checkbox2.setImmediate(true);
		checkbox2.setPropertyDataSource(new ObjectProperty<Boolean>(false));
		layout.addComponent(checkbox1, "top:100px;left:50px");
		layout.addComponent(checkbox2, "top:100px;left:500px");

		dbc.bindValue(VaadinObservables.observeValue(checkbox1),
				VaadinObservables.observeValue(checkbox2));

		// bind readonly and enabled
		dbc.bindValue(VaadinObservables.observeReadonly(checkbox2),
				VaadinObservables.observeValue(readonly));
		dbc.bindValue(VaadinObservables.observeEnabled(checkbox2),
				VaadinObservables.observeValue(enabled));

		// Textareas

		area1 = new TextArea();
		area1.setNullRepresentation("");
		area1.setImmediate(true);
		area1.setPropertyDataSource(new ObjectProperty<String>(null,
				String.class));
		area2 = new TextArea();
		area2.setNullRepresentation("");
		area2.setImmediate(true);
		area2.setPropertyDataSource(new ObjectProperty<String>(null,
				String.class));
		layout.addComponent(area1, "top:150px;left:50px");
		layout.addComponent(area2, "top:150px;left:500px");

		dbc.bindValue(VaadinObservables.observeValue(area1),
				VaadinObservables.observeValue(area2));

		// bind readonly and enabled
		dbc.bindValue(VaadinObservables.observeReadonly(area2),
				VaadinObservables.observeValue(readonly));
		dbc.bindValue(VaadinObservables.observeEnabled(area2),
				VaadinObservables.observeValue(enabled));

		// Date fields

		date1 = new DateField();
		date1.setImmediate(true);
		date1.setPropertyDataSource(new ObjectProperty<Date>(null, Date.class));
		date2 = new DateField();
		date2.setImmediate(true);
		date2.setPropertyDataSource(new ObjectProperty<Date>(null, Date.class));
		layout.addComponent(date1, "top:250px;left:50px");
		layout.addComponent(date2, "top:250px;left:500px");

		dbc.bindValue(VaadinObservables.observeValue(date1),
				VaadinObservables.observeValue(date2));

		// bind readonly and enabled
		dbc.bindValue(VaadinObservables.observeReadonly(date2),
				VaadinObservables.observeValue(readonly));
		dbc.bindValue(VaadinObservables.observeEnabled(date2),
				VaadinObservables.observeValue(enabled));

		// Textfield to label

		text3 = new TextField();
		text3.setImmediate(true);
		text3.setNullRepresentation("");
		text3.setPropertyDataSource(new ObjectProperty<String>(null,
				String.class));
		label3 = new Label();
		label3.setImmediate(true);
		layout.addComponent(text3, "top:300px;left:50px");
		layout.addComponent(label3, "top:300px;left:500px");

		dbc.bindValue(VaadinObservables.observeValue(text3), VaadinObservables
				.observeValue(label3), new UpdateValueStrategy(),
				new UpdateValueStrategy(UpdateValueStrategy.POLICY_NEVER));

	}

	// protected static class ValueBean()

}
