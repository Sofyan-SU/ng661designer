/**
 * Copyright (c) 2015, 2017 Airbus.
 * All rights reserved. This program and the accompanying materials
 * are made available under the terms of the Eclipse Public License v1.0
 * which accompanies this distribution, and is available at
 * http://www.eclipse.org/legal/epl-v10.html
 * Contributors:
 *     Obeo - initial API and implementation
 */
package org.w3._2005._07.scxml.provider;

import java.util.ArrayList;
import java.util.Collection;

import org.eclipse.emf.common.notify.Adapter;
import org.eclipse.emf.common.notify.Notification;
import org.eclipse.emf.common.notify.Notifier;
import org.eclipse.emf.edit.provider.ChangeNotifier;
import org.eclipse.emf.edit.provider.ComposeableAdapterFactory;
import org.eclipse.emf.edit.provider.ComposedAdapterFactory;
import org.eclipse.emf.edit.provider.IChangeNotifier;
import org.eclipse.emf.edit.provider.IDisposable;
import org.eclipse.emf.edit.provider.IEditingDomainItemProvider;
import org.eclipse.emf.edit.provider.IItemLabelProvider;
import org.eclipse.emf.edit.provider.IItemPropertySource;
import org.eclipse.emf.edit.provider.INotifyChangedListener;
import org.eclipse.emf.edit.provider.IStructuredItemContentProvider;
import org.eclipse.emf.edit.provider.ITreeItemContentProvider;
import org.w3._2005._07.scxml.util.ScxmlAdapterFactory;

/**
 * This is the factory that is used to provide the interfaces needed to support Viewers.
 * The adapters generated by this factory convert EMF adapter notifications into calls to {@link #fireNotifyChanged fireNotifyChanged}.
 * The adapters also support Eclipse property sheets.
 * Note that most of the adapters are shared among multiple instances.
 * <!-- begin-user-doc -->
 * <!-- end-user-doc -->
 * @generated
 */
public class ScxmlItemProviderAdapterFactory extends ScxmlAdapterFactory implements ComposeableAdapterFactory, IChangeNotifier, IDisposable {
	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public static final String copyright = "Copyright (c) 2015, 2016 Airbus.\nAll rights reserved. This program and the accompanying materials\nare made available under the terms of the Eclipse Public License v1.0\nwhich accompanies this distribution, and is available at\nhttp://www.eclipse.org/legal/epl-v10.html\nContributors:\n    Obeo - initial API and implementation";

	/**
	 * This keeps track of the root adapter factory that delegates to this adapter factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ComposedAdapterFactory parentAdapterFactory;

	/**
	 * This is used to implement {@link org.eclipse.emf.edit.provider.IChangeNotifier}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected IChangeNotifier changeNotifier = new ChangeNotifier();

	/**
	 * This keeps track of all the supported types checked by {@link #isFactoryForType isFactoryForType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected Collection<Object> supportedTypes = new ArrayList<Object>();

	/**
	 * This constructs an instance.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ScxmlItemProviderAdapterFactory() {
		supportedTypes.add(IEditingDomainItemProvider.class);
		supportedTypes.add(IStructuredItemContentProvider.class);
		supportedTypes.add(ITreeItemContentProvider.class);
		supportedTypes.add(IItemLabelProvider.class);
		supportedTypes.add(IItemPropertySource.class);
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.w3._2005._07.scxml.ScxmlOnexecuteType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScxmlOnexecuteTypeItemProvider scxmlOnexecuteTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.w3._2005._07.scxml.ScxmlOnexecuteType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScxmlOnexecuteTypeAdapter() {
		if (scxmlOnexecuteTypeItemProvider == null) {
			scxmlOnexecuteTypeItemProvider = new ScxmlOnexecuteTypeItemProvider(this);
		}

		return scxmlOnexecuteTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.w3._2005._07.scxml.ScxmlParamType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScxmlParamTypeItemProvider scxmlParamTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.w3._2005._07.scxml.ScxmlParamType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScxmlParamTypeAdapter() {
		if (scxmlParamTypeItemProvider == null) {
			scxmlParamTypeItemProvider = new ScxmlParamTypeItemProvider(this);
		}

		return scxmlParamTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.w3._2005._07.scxml.ScxmlScriptType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScxmlScriptTypeItemProvider scxmlScriptTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.w3._2005._07.scxml.ScxmlScriptType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScxmlScriptTypeAdapter() {
		if (scxmlScriptTypeItemProvider == null) {
			scxmlScriptTypeItemProvider = new ScxmlScriptTypeItemProvider(this);
		}

		return scxmlScriptTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.w3._2005._07.scxml.ScxmlScxmlType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScxmlScxmlTypeItemProvider scxmlScxmlTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.w3._2005._07.scxml.ScxmlScxmlType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScxmlScxmlTypeAdapter() {
		if (scxmlScxmlTypeItemProvider == null) {
			scxmlScxmlTypeItemProvider = new ScxmlScxmlTypeItemProvider(this);
		}

		return scxmlScxmlTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.w3._2005._07.scxml.ScxmlSendType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScxmlSendTypeItemProvider scxmlSendTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.w3._2005._07.scxml.ScxmlSendType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScxmlSendTypeAdapter() {
		if (scxmlSendTypeItemProvider == null) {
			scxmlSendTypeItemProvider = new ScxmlSendTypeItemProvider(this);
		}

		return scxmlSendTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.w3._2005._07.scxml.ScxmlStateType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScxmlStateTypeItemProvider scxmlStateTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.w3._2005._07.scxml.ScxmlStateType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScxmlStateTypeAdapter() {
		if (scxmlStateTypeItemProvider == null) {
			scxmlStateTypeItemProvider = new ScxmlStateTypeItemProvider(this);
		}

		return scxmlStateTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.w3._2005._07.scxml.ScxmlTransitionType} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected ScxmlTransitionTypeItemProvider scxmlTransitionTypeItemProvider;

	/**
	 * This creates an adapter for a {@link org.w3._2005._07.scxml.ScxmlTransitionType}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createScxmlTransitionTypeAdapter() {
		if (scxmlTransitionTypeItemProvider == null) {
			scxmlTransitionTypeItemProvider = new ScxmlTransitionTypeItemProvider(this);
		}

		return scxmlTransitionTypeItemProvider;
	}

	/**
	 * This keeps track of the one adapter used for all {@link org.w3._2005._07.scxml.DocumentRoot} instances.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	protected DocumentRootItemProvider documentRootItemProvider;

	/**
	 * This creates an adapter for a {@link org.w3._2005._07.scxml.DocumentRoot}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter createDocumentRootAdapter() {
		if (documentRootItemProvider == null) {
			documentRootItemProvider = new DocumentRootItemProvider(this);
		}

		return documentRootItemProvider;
	}

	/**
	 * This returns the root adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public ComposeableAdapterFactory getRootAdapterFactory() {
		return parentAdapterFactory == null ? this : parentAdapterFactory.getRootAdapterFactory();
	}

	/**
	 * This sets the composed adapter factory that contains this factory.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void setParentAdapterFactory(ComposedAdapterFactory parentAdapterFactory) {
		this.parentAdapterFactory = parentAdapterFactory;
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public boolean isFactoryForType(Object type) {
		return supportedTypes.contains(type) || super.isFactoryForType(type);
	}

	/**
	 * This implementation substitutes the factory itself as the key for the adapter.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Adapter adapt(Notifier notifier, Object type) {
		return super.adapt(notifier, this);
	}

	/**
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	@Override
	public Object adapt(Object object, Object type) {
		if (isFactoryForType(type)) {
			Object adapter = super.adapt(object, type);
			if (!(type instanceof Class<?>) || (((Class<?>)type).isInstance(adapter))) {
				return adapter;
			}
		}

		return null;
	}

	/**
	 * This adds a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void addListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.addListener(notifyChangedListener);
	}

	/**
	 * This removes a listener.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void removeListener(INotifyChangedListener notifyChangedListener) {
		changeNotifier.removeListener(notifyChangedListener);
	}

	/**
	 * This delegates to {@link #changeNotifier} and to {@link #parentAdapterFactory}.
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void fireNotifyChanged(Notification notification) {
		changeNotifier.fireNotifyChanged(notification);

		if (parentAdapterFactory != null) {
			parentAdapterFactory.fireNotifyChanged(notification);
		}
	}

	/**
	 * This disposes all of the item providers created by this factory. 
	 * <!-- begin-user-doc -->
	 * <!-- end-user-doc -->
	 * @generated
	 */
	public void dispose() {
		if (scxmlOnexecuteTypeItemProvider != null) scxmlOnexecuteTypeItemProvider.dispose();
		if (scxmlParamTypeItemProvider != null) scxmlParamTypeItemProvider.dispose();
		if (scxmlScriptTypeItemProvider != null) scxmlScriptTypeItemProvider.dispose();
		if (scxmlScxmlTypeItemProvider != null) scxmlScxmlTypeItemProvider.dispose();
		if (scxmlSendTypeItemProvider != null) scxmlSendTypeItemProvider.dispose();
		if (scxmlStateTypeItemProvider != null) scxmlStateTypeItemProvider.dispose();
		if (scxmlTransitionTypeItemProvider != null) scxmlTransitionTypeItemProvider.dispose();
		if (documentRootItemProvider != null) documentRootItemProvider.dispose();
	}

}
