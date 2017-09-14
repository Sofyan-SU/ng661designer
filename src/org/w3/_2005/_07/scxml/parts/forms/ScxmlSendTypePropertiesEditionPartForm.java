/**
 * Copyright (c) 2015, 2017 Airbus.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.w3._2005._07.scxml.parts.forms;

// Start of user code for imports
import java.util.ArrayList;
import java.util.List;

import org.eclipse.emf.ecore.EObject;
import org.eclipse.emf.ecore.EReference;
import org.eclipse.emf.eef.runtime.api.component.IPropertiesEditionComponent;
import org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart;
import org.eclipse.emf.eef.runtime.impl.notify.PropertiesEditionEvent;
import org.eclipse.emf.eef.runtime.ui.parts.PartComposer;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.BindingCompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionSequence;
import org.eclipse.emf.eef.runtime.ui.parts.sequence.CompositionStep;
import org.eclipse.emf.eef.runtime.ui.utils.EditingUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.FormUtils;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable;
import org.eclipse.emf.eef.runtime.ui.widgets.ReferencesTable.ReferencesTableListener;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableContentProvider;
import org.eclipse.emf.eef.runtime.ui.widgets.referencestable.ReferencesTableSettings;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.viewers.ViewerFilter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.events.FocusAdapter;
import org.eclipse.swt.events.FocusEvent;
import org.eclipse.swt.events.KeyAdapter;
import org.eclipse.swt.events.KeyEvent;
import org.eclipse.swt.events.SelectionAdapter;
import org.eclipse.swt.events.SelectionEvent;
import org.eclipse.swt.layout.GridData;
import org.eclipse.swt.layout.GridLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Text;
import org.eclipse.ui.forms.widgets.Form;
import org.eclipse.ui.forms.widgets.FormToolkit;
import org.eclipse.ui.forms.widgets.ScrolledForm;
import org.eclipse.ui.forms.widgets.Section;
import org.eclipse.ui.views.properties.tabbed.ISection;
import org.w3._2005._07.scxml.parts.ScxmlSendTypePropertiesEditionPart;
import org.w3._2005._07.scxml.parts.ScxmlViewsRepository;
import org.w3._2005._07.scxml.providers.ScxmlMessages;

import org.polarsys.ng661designer.eef.parts.DefaultValueSectionPropertiesEditionPart;

// End of user code

/**
 * 
 * 
 */
public class ScxmlSendTypePropertiesEditionPartForm extends DefaultValueSectionPropertiesEditionPart implements IFormPropertiesEditionPart, ScxmlSendTypePropertiesEditionPart {

	protected Text event;
	protected ReferencesTable param;
	protected List<ViewerFilter> paramBusinessFilters = new ArrayList<ViewerFilter>();
	protected List<ViewerFilter> paramFilters = new ArrayList<ViewerFilter>();



	/**
	 * For {@link ISection} use only.
	 */
	public ScxmlSendTypePropertiesEditionPartForm() { super(); }

	/**
	 * Default constructor
	 * @param editionComponent the {@link IPropertiesEditionComponent} that manage this part
	 * 
	 */
	public ScxmlSendTypePropertiesEditionPartForm(IPropertiesEditionComponent editionComponent) {
		super(editionComponent);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createFigure(org.eclipse.swt.widgets.Composite, org.eclipse.ui.forms.widgets.FormToolkit)
	 * 
	 */
	public Composite createFigure(final Composite parent, final FormToolkit widgetFactory) {
		ScrolledForm scrolledForm = widgetFactory.createScrolledForm(parent);
		Form form = scrolledForm.getForm();
		view = form.getBody();
		GridLayout layout = new GridLayout();
		layout.numColumns = 3;
		view.setLayout(layout);
		createControls(widgetFactory, view);
		return scrolledForm;
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.parts.IFormPropertiesEditionPart#
	 *  createControls(org.eclipse.ui.forms.widgets.FormToolkit, org.eclipse.swt.widgets.Composite)
	 * 
	 */
	public void createControls(final FormToolkit widgetFactory, Composite view) {
		CompositionSequence scxmlSendTypeStep = new BindingCompositionSequence(propertiesEditionComponent);
		CompositionStep propertiesStep = scxmlSendTypeStep.addStep(ScxmlViewsRepository.ScxmlSendType.Properties.class);
		propertiesStep.addStep(ScxmlViewsRepository.ScxmlSendType.Properties.event);
		propertiesStep.addStep(ScxmlViewsRepository.ScxmlSendType.Properties.param);
		
		
		composer = new PartComposer(scxmlSendTypeStep) {

			@Override
			public Composite addToPart(Composite parent, Object key) {
				if (key == ScxmlViewsRepository.ScxmlSendType.Properties.class) {
					return createPropertiesGroup(widgetFactory, parent);
				}
				if (key == ScxmlViewsRepository.ScxmlSendType.Properties.event) {
					return createEventText(widgetFactory, parent);
				}
				if (key == ScxmlViewsRepository.ScxmlSendType.Properties.param) {
					return createParamTableComposition(widgetFactory, parent);
				}
				return parent;
			}
		};
		composer.compose(view);
	}
	/**
	 * 
	 */
	protected Composite createPropertiesGroup(FormToolkit widgetFactory, final Composite parent) {
		Section propertiesSection = widgetFactory.createSection(parent, Section.TITLE_BAR | Section.TWISTIE | Section.EXPANDED);
		propertiesSection.setText(ScxmlMessages.ScxmlSendTypePropertiesEditionPart_PropertiesGroupLabel);
		GridData propertiesSectionData = new GridData(GridData.FILL_HORIZONTAL);
		propertiesSectionData.horizontalSpan = 3;
		propertiesSection.setLayoutData(propertiesSectionData);
		Composite propertiesGroup = widgetFactory.createComposite(propertiesSection);
		GridLayout propertiesGroupLayout = new GridLayout();
		propertiesGroupLayout.numColumns = 3;
		propertiesGroup.setLayout(propertiesGroupLayout);
		propertiesSection.setClient(propertiesGroup);
		return propertiesGroup;
	}

	
	protected Composite createEventText(FormToolkit widgetFactory, Composite parent) {
		createDescription(parent, ScxmlViewsRepository.ScxmlSendType.Properties.event, ScxmlMessages.ScxmlSendTypePropertiesEditionPart_EventLabel);
		event = widgetFactory.createText(parent, ""); //$NON-NLS-1$
		event.setData(FormToolkit.KEY_DRAW_BORDER, FormToolkit.TEXT_BORDER);
		widgetFactory.paintBordersFor(parent);
		GridData eventData = new GridData(GridData.FILL_HORIZONTAL);
		event.setLayoutData(eventData);
		event.addFocusListener(new FocusAdapter() {
			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusLost(org.eclipse.swt.events.FocusEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void focusLost(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(
							ScxmlSendTypePropertiesEditionPartForm.this,
							ScxmlViewsRepository.ScxmlSendType.Properties.event,
							PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, event.getText()));
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ScxmlSendTypePropertiesEditionPartForm.this,
									ScxmlViewsRepository.ScxmlSendType.Properties.event,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_LOST,
									null, event.getText()));
				}
			}

			/**
			 * @see org.eclipse.swt.events.FocusAdapter#focusGained(org.eclipse.swt.events.FocusEvent)
			 */
			@Override
			public void focusGained(FocusEvent e) {
				if (propertiesEditionComponent != null) {
					propertiesEditionComponent
							.firePropertiesChanged(new PropertiesEditionEvent(
									ScxmlSendTypePropertiesEditionPartForm.this,
									null,
									PropertiesEditionEvent.FOCUS_CHANGED, PropertiesEditionEvent.FOCUS_GAINED,
									null, null));
				}
			}
		});
		event.addKeyListener(new KeyAdapter() {
			/**
			 * @see org.eclipse.swt.events.KeyAdapter#keyPressed(org.eclipse.swt.events.KeyEvent)
			 * 
			 */
			@Override
			@SuppressWarnings("synthetic-access")
			public void keyPressed(KeyEvent e) {
				if (e.character == SWT.CR) {
					if (propertiesEditionComponent != null)
						propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScxmlSendTypePropertiesEditionPartForm.this, ScxmlViewsRepository.ScxmlSendType.Properties.event, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.SET, null, event.getText()));
				}
			}
		});
		EditingUtils.setID(event, ScxmlViewsRepository.ScxmlSendType.Properties.event);
		EditingUtils.setEEFtype(event, "eef::Text"); //$NON-NLS-1$
		FormUtils.createHelpButton(widgetFactory, parent, propertiesEditionComponent.getHelpContent(ScxmlViewsRepository.ScxmlSendType.Properties.event, ScxmlViewsRepository.FORM_KIND), null); //$NON-NLS-1$
		// Start of user code for createEventText

		// End of user code
		return parent;
	}

	/**
	 * @param container
	 * 
	 */
	protected Composite createParamTableComposition(FormToolkit widgetFactory, Composite parent) {
		this.param = new ReferencesTable(getDescription(ScxmlViewsRepository.ScxmlSendType.Properties.param, ScxmlMessages.ScxmlSendTypePropertiesEditionPart_ParamLabel), new ReferencesTableListener() {
			public void handleAdd() {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScxmlSendTypePropertiesEditionPartForm.this, ScxmlViewsRepository.ScxmlSendType.Properties.param, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.ADD, null, null));
				param.refresh();
			}
			public void handleEdit(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScxmlSendTypePropertiesEditionPartForm.this, ScxmlViewsRepository.ScxmlSendType.Properties.param, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.EDIT, null, element));
				param.refresh();
			}
			public void handleMove(EObject element, int oldIndex, int newIndex) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScxmlSendTypePropertiesEditionPartForm.this, ScxmlViewsRepository.ScxmlSendType.Properties.param, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.MOVE, element, newIndex));
				param.refresh();
			}
			public void handleRemove(EObject element) {
				propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScxmlSendTypePropertiesEditionPartForm.this, ScxmlViewsRepository.ScxmlSendType.Properties.param, PropertiesEditionEvent.COMMIT, PropertiesEditionEvent.REMOVE, null, element));
				param.refresh();
			}
			public void navigateTo(EObject element) { }
		});
		for (ViewerFilter filter : this.paramFilters) {
			this.param.addFilter(filter);
		}
		this.param.setHelpText(propertiesEditionComponent.getHelpContent(ScxmlViewsRepository.ScxmlSendType.Properties.param, ScxmlViewsRepository.FORM_KIND));
		this.param.createControls(parent, widgetFactory);
		this.param.addSelectionListener(new SelectionAdapter() {
			
			public void widgetSelected(SelectionEvent e) {
				if (e.item != null && e.item.getData() instanceof EObject) {
					propertiesEditionComponent.firePropertiesChanged(new PropertiesEditionEvent(ScxmlSendTypePropertiesEditionPartForm.this, ScxmlViewsRepository.ScxmlSendType.Properties.param, PropertiesEditionEvent.CHANGE, PropertiesEditionEvent.SELECTION_CHANGED, null, e.item.getData()));
				}
			}
			
		});
		GridData paramData = new GridData(GridData.FILL_HORIZONTAL);
		paramData.horizontalSpan = 3;
		this.param.setLayoutData(paramData);
		this.param.setLowerBound(0);
		this.param.setUpperBound(-1);
		param.setID(ScxmlViewsRepository.ScxmlSendType.Properties.param);
		param.setEEFType("eef::AdvancedTableComposition"); //$NON-NLS-1$
		// Start of user code for createParamTableComposition

		// End of user code
		return parent;
	}


	/**
	 * {@inheritDoc}
	 * 
	 * @see org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionListener#firePropertiesChanged(org.eclipse.emf.eef.runtime.api.notify.IPropertiesEditionEvent)
	 * 
	 */
	public void firePropertiesChanged(IPropertiesEditionEvent event) {
		// Start of user code for tab synchronization
		
		// End of user code
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.w3._2005._07.scxml.parts.ScxmlSendTypePropertiesEditionPart#getEvent()
	 * 
	 */
	public String getEvent() {
		return event.getText();
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.w3._2005._07.scxml.parts.ScxmlSendTypePropertiesEditionPart#setEvent(String newValue)
	 * 
	 */
	public void setEvent(String newValue) {
		boolean eefElementEditorDefaultValueState = isDefault(ScxmlViewsRepository.ScxmlSendType.Properties.event, newValue);
		if (eefElementEditorDefaultValueState) {
			event.setFont(JFaceResources.getFontRegistry().getItalic(JFaceResources.DEFAULT_FONT));
		} else {
			event.setFont(JFaceResources.getFontRegistry().defaultFont());
		}
		if (newValue != null) {
			event.setText(newValue);
		} else {
			event.setText(""); //$NON-NLS-1$
		}
		boolean eefElementEditorReadOnlyState = isReadOnly(ScxmlViewsRepository.ScxmlSendType.Properties.event);
		if (eefElementEditorReadOnlyState && event.isEnabled()) {
			event.setEnabled(false);
			event.setToolTipText(ScxmlMessages.ScxmlSendType_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !event.isEnabled()) {
			event.setEnabled(true);
		}	
		
	}



	/**
	 * {@inheritDoc}
	 * 
	 * @see org.w3._2005._07.scxml.parts.ScxmlSendTypePropertiesEditionPart#initParam(EObject current, EReference containingFeature, EReference feature)
	 */
	public void initParam(ReferencesTableSettings settings) {
		if (current.eResource() != null && current.eResource().getResourceSet() != null)
			this.resourceSet = current.eResource().getResourceSet();
		ReferencesTableContentProvider contentProvider = new ReferencesTableContentProvider();
		param.setContentProvider(contentProvider);
		param.setInput(settings);
		boolean eefElementEditorReadOnlyState = isReadOnly(ScxmlViewsRepository.ScxmlSendType.Properties.param);
		if (eefElementEditorReadOnlyState && param.isEnabled()) {
			param.setEnabled(false);
			param.setToolTipText(ScxmlMessages.ScxmlSendType_ReadOnly);
		} else if (!eefElementEditorReadOnlyState && !param.isEnabled()) {
			param.setEnabled(true);
		}	
		
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.w3._2005._07.scxml.parts.ScxmlSendTypePropertiesEditionPart#updateParam()
	 * 
	 */
	public void updateParam() {
	param.refresh();
}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.w3._2005._07.scxml.parts.ScxmlSendTypePropertiesEditionPart#addFilterParam(ViewerFilter filter)
	 * 
	 */
	public void addFilterToParam(ViewerFilter filter) {
		paramFilters.add(filter);
		if (this.param != null) {
			this.param.addFilter(filter);
		}
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.w3._2005._07.scxml.parts.ScxmlSendTypePropertiesEditionPart#addBusinessFilterParam(ViewerFilter filter)
	 * 
	 */
	public void addBusinessFilterToParam(ViewerFilter filter) {
		paramBusinessFilters.add(filter);
	}

	/**
	 * {@inheritDoc}
	 * 
	 * @see org.w3._2005._07.scxml.parts.ScxmlSendTypePropertiesEditionPart#isContainedInParamTable(EObject element)
	 * 
	 */
	public boolean isContainedInParamTable(EObject element) {
		return ((ReferencesTableSettings)param.getInput()).contains(element);
	}






	/**
	 * {@inheritDoc}
	 *
	 * @see org.eclipse.emf.eef.runtime.api.parts.IPropertiesEditionPart#getTitle()
	 * 
	 */
	public String getTitle() {
		return ScxmlMessages.ScxmlSendType_Part_Title;
	}

	// Start of user code additional methods
	
	// End of user code


}
