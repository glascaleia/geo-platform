/*
 *
 *    geo-platform
 *    Rich webgis framework
 *    http://geo-platform.org
 *   ====================================================================
 *
 *   Copyright (C) 2008-2025 geoSDI Group (CNR IMAA - Potenza - ITALY).
 *
 *   This program is free software: you can redistribute it and/or modify it
 *   under the terms of the GNU General Public License as published by
 *   the Free Software Foundation, either version 3 of the License, or
 *   (at your option) any later version. This program is distributed in the
 *   hope that it will be useful, but WITHOUT ANY WARRANTY; without
 *   even the implied warranty of MERCHANTABILITY or FITNESS FOR
 *   A PARTICULAR PURPOSE. See the GNU General Public License
 *   for more details. You should have received a copy of the GNU General
 *   Public License along with this program. If not, see http://www.gnu.org/licenses/
 *
 *   ====================================================================
 *
 *   Linking this library statically or dynamically with other modules is
 *   making a combined work based on this library. Thus, the terms and
 *   conditions of the GNU General Public License cover the whole combination.
 *
 *   As a special exception, the copyright holders of this library give you permission
 *   to link this library with independent modules to produce an executable, regardless
 *   of the license terms of these independent modules, and to copy and distribute
 *   the resulting executable under terms of your choice, provided that you also meet,
 *   for each linked independent module, the terms and conditions of the license of
 *   that module. An independent module is a module which is not derived from or
 *   based on this library. If you modify this library, you may extend this exception
 *   to your version of the library, but you are not obligated to do so. If you do not
 *   wish to do so, delete this exception statement from your version.
 */
package org.geosdi.geoplatform.gui.client.widget;

import com.extjs.gxt.ui.client.Style;
import com.extjs.gxt.ui.client.Style.ButtonArrowAlign;
import com.extjs.gxt.ui.client.event.*;
import com.extjs.gxt.ui.client.store.ListStore;
import com.extjs.gxt.ui.client.store.Record;
import com.extjs.gxt.ui.client.store.StoreEvent;
import com.extjs.gxt.ui.client.store.StoreListener;
import com.extjs.gxt.ui.client.util.IconHelper;
import com.extjs.gxt.ui.client.widget.ContentPanel;
import com.extjs.gxt.ui.client.widget.Dialog;
import com.extjs.gxt.ui.client.widget.button.Button;
import com.extjs.gxt.ui.client.widget.button.SplitButton;
import com.extjs.gxt.ui.client.widget.form.ComboBox;
import com.extjs.gxt.ui.client.widget.form.ComboBox.TriggerAction;
import com.extjs.gxt.ui.client.widget.form.SimpleComboBox;
import com.extjs.gxt.ui.client.widget.form.SimpleComboValue;
import com.extjs.gxt.ui.client.widget.grid.*;
import com.extjs.gxt.ui.client.widget.layout.FitLayout;
import com.extjs.gxt.ui.client.widget.layout.FlowLayout;
import com.extjs.gxt.ui.client.widget.menu.Menu;
import com.extjs.gxt.ui.client.widget.menu.MenuItem;
import com.extjs.gxt.ui.client.widget.tips.ToolTipConfig;
import com.extjs.gxt.ui.client.widget.toolbar.FillToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.SeparatorToolItem;
import com.extjs.gxt.ui.client.widget.toolbar.ToolBar;
import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.google.gwt.user.client.ui.AbstractImagePrototype;
import org.geosdi.geoplatform.gui.action.menu.MenuActionRegistar;
import org.geosdi.geoplatform.gui.action.menu.MenuBaseAction;
import org.geosdi.geoplatform.gui.client.BasicWidgetResources;
import org.geosdi.geoplatform.gui.client.command.role.crud.SaveRoleRequest;
import org.geosdi.geoplatform.gui.client.command.role.crud.SaveRoleResponse;
import org.geosdi.geoplatform.gui.client.command.role.permission.GetRolePermissionRequest;
import org.geosdi.geoplatform.gui.client.command.role.permission.GetRolePermissionResponse;
import org.geosdi.geoplatform.gui.client.command.role.permission.crud.UpdateRolePermissionRequest;
import org.geosdi.geoplatform.gui.client.command.role.permission.crud.UpdateRolePermissionResponse;
import org.geosdi.geoplatform.gui.client.config.BasicGinInjector;
import org.geosdi.geoplatform.gui.client.i18n.UserModuleConstants;
import org.geosdi.geoplatform.gui.client.i18n.UserModuleMessages;
import org.geosdi.geoplatform.gui.client.i18n.buttons.ButtonsConstants;
import org.geosdi.geoplatform.gui.client.i18n.windows.WindowsConstants;
import org.geosdi.geoplatform.gui.client.model.GuiComponentDetail;
import org.geosdi.geoplatform.gui.client.model.GuiComponentDetail.GuiComponentDetailKeyValue;
import org.geosdi.geoplatform.gui.client.model.GuiPermission;
import org.geosdi.geoplatform.gui.client.widget.SearchStatus.EnumSearchStatus;
import org.geosdi.geoplatform.gui.client.widget.grid.renderer.GPGridCellRenderer;
import org.geosdi.geoplatform.gui.command.api.ClientCommandDispatcher;
import org.geosdi.geoplatform.gui.command.api.GPClientCommand;
import org.geosdi.geoplatform.gui.configuration.action.GeoPlatformAction;
import org.geosdi.geoplatform.gui.configuration.message.GeoPlatformMessage;
import org.geosdi.geoplatform.gui.global.security.GPAccountLogged;
import org.geosdi.geoplatform.gui.shared.GPRole;

import java.util.*;

/**
 * @author Vincenzo Monteverde <vincenzo.monteverde@geosdi.org>
 */
public class ManageRolesWidget extends GeoPlatformWindow {

    private String role;
    private List<String> roles;
    private List<String> guiComponentIDs;
    private List<GuiComponentDetail> guiComponents;
    //
    private ContentPanel mainPanel;
    private SplitButton allPermissionsButton;
    private Button copyPermissionsButton;
    private Menu copyPermissionsMenu;
    private SearchStatus searchStatus;
    private Button resetButton;
    private Button saveButton;
    //
    private ListStore<GuiComponentDetail> store;
    private EditorGrid<GuiComponentDetail> grid;
    private SimpleComboBox<String> rolesComboBox;
    //    private AbstractImagePrototype defaultImage = IconHelper.createPath("geoportal/gp-images/error.png");
    private AbstractImagePrototype defaultImage = IconHelper.createPath(""); // Empty icon

    public ManageRolesWidget() {
        super(true);
    }

    public void setRoles(List<String> roles) {
        this.roles = roles;
    }

    public void setGuiComponentIDs(List<String> guiComponentIDs) {
        this.guiComponentIDs = guiComponentIDs;
        Collections.sort(guiComponentIDs);

        this.guiComponents = new ArrayList<GuiComponentDetail>(guiComponentIDs.size());
        for (String componentId : guiComponentIDs) {
            GuiComponentDetail gc = this.createGuiComponentDetail(componentId);
            guiComponents.add(gc);
        }
    }

    public List<String> getGuiComponentIDs() {
        return guiComponentIDs;
    }

    @Override
    public void initSize() {
        super.setSize(600, 500);
    }

    @Override
    public void setWindowProperties() {
        super.setHeadingHtml(UserModuleConstants.INSTANCE.ManageRolesWidget_headingText());
        super.setResizable(false);
        super.setLayout(new FlowLayout());
        super.setModal(true);
        super.setCollapsible(false);
        super.setPlain(true);
    }

    @Override
    public void addComponent() {
        this.createMainPanel();
        this.createToolbar();
        this.createStore();
        this.createEditorGrid();
        this.createButtons();
    }

    private void createMainPanel() {
        mainPanel = new ContentPanel();
        mainPanel.setHeadingHtml(UserModuleConstants.INSTANCE.ManageRolesWidget_rolePermissionsText());
        mainPanel.setIcon(AbstractImagePrototype.create(BasicWidgetResources.ICONS.role()));
        mainPanel.setFrame(true);
        mainPanel.setSize(585, 430);
        mainPanel.setLayout(new FitLayout());

        super.add(mainPanel);
    }

    private void createToolbar() {
        ToolBar toolbar = new ToolBar();

        rolesComboBox = new SimpleComboBox<String>() {

            @Override
            protected void onSelect(SimpleComboValue<String> model, int index) {
                super.onSelect(model, index);
                role = model.getValue();
                loadPermissions();
            }
        };
        rolesComboBox.setEmptyText(UserModuleConstants.INSTANCE.ManageRolesWidget_rolePermissionsText());
        rolesComboBox.setToolTip(new ToolTipConfig(rolesComboBox.getEmptyText(),
                UserModuleConstants.INSTANCE.ManageRolesWidget_rolePermissionsTooltipText()));
        rolesComboBox.setMaxHeight(150);
        rolesComboBox.setEditable(false);
        rolesComboBox.setTypeAhead(true);
        rolesComboBox.setTriggerAction(TriggerAction.ALL);
        toolbar.add(rolesComboBox);

        allPermissionsButton = new SplitButton(UserModuleConstants.INSTANCE.ManageRolesWidget_allPermissionsToText());
        allPermissionsButton.setToolTip(new ToolTipConfig(allPermissionsButton.getHtml(),
                UserModuleConstants.INSTANCE.ManageRolesWidget_rolePermissionsToASinglePermissionText()));
        allPermissionsButton.setArrowAlign(ButtonArrowAlign.BOTTOM);
        allPermissionsButton.setMenu(this.createPermissionsMenu());
        toolbar.add(allPermissionsButton);

        copyPermissionsButton = new Button(UserModuleConstants.INSTANCE.ManageRolesWidget_copyPermissionsText());
        copyPermissionsButton.setToolTip(new ToolTipConfig(copyPermissionsButton.getHtml(),
                UserModuleConstants.INSTANCE.ManageRolesWidget_copyPermissionsTooltipText()));
        copyPermissionsButton.setArrowAlign(ButtonArrowAlign.BOTTOM);
        copyPermissionsButton.setMenu(this.createRolesMenu());
        toolbar.add(copyPermissionsButton);

        this.disableModifyButtons();

        toolbar.add(new FillToolItem());
        toolbar.add(new SeparatorToolItem());
        Button newRoleButton = new Button(UserModuleConstants.INSTANCE.ManageRolesWidget_newRoleText(),
                new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        createNewRole();
                    }
                });
        newRoleButton.setToolTip(new ToolTipConfig(newRoleButton.getHtml(),
                UserModuleConstants.INSTANCE.ManageRolesWidget_newRoleTooltipText()));
        toolbar.add(newRoleButton);

        mainPanel.setTopComponent(toolbar);
    }

    private void createStore() {
        store = new ListStore<GuiComponentDetail>();
        store.addStoreListener(new StoreListener<GuiComponentDetail>() {

            @Override
            public void storeClear(StoreEvent<GuiComponentDetail> se) {
                disableGridButtons();
            }

            @Override
            public void storeUpdate(StoreEvent<GuiComponentDetail> se) {
                enableGridButtons();
            }
        });
    }

    private void createEditorGrid() {
        grid = new EditorGrid<GuiComponentDetail>(store, this.prepareColumnModel());
        grid.setBorders(true);
        grid.setStripeRows(true);
        grid.setAutoExpandColumn(GuiComponentDetailKeyValue.COMPONENT_ID.toString());

        mainPanel.add(grid);
    }

    private void createButtons() {
        searchStatus = new SearchStatus();
        searchStatus.setAutoWidth(true);

        ContentPanel cp = new ContentPanel();
        cp.setWidth(310);
        cp.setHeaderVisible(false);
        cp.add(searchStatus);

        super.getButtonBar().add(cp);

        super.setButtonAlign(Style.HorizontalAlignment.RIGHT);

        resetButton = new Button(ButtonsConstants.INSTANCE.resetText(),
                AbstractImagePrototype.create(BasicWidgetResources.ICONS.delete()),
                new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        grid.stopEditing(true);
                        store.rejectChanges();
                        disableGridButtons();
                    }
                });
        super.addButton(resetButton);

        saveButton = new Button(ButtonsConstants.INSTANCE.saveText(),
                AbstractImagePrototype.create(BasicWidgetResources.ICONS.done()), new SelectionListener<ButtonEvent>() {

            @Override
            public void componentSelected(ButtonEvent ce) {
                savePermissions();
            }
        });
        super.addButton(saveButton);

        this.disableGridButtons();

        Button close = new Button(ButtonsConstants.INSTANCE.closeText(),
                AbstractImagePrototype.create(BasicWidgetResources.ICONS.cancel()),
                new SelectionListener<ButtonEvent>() {

                    @Override
                    public void componentSelected(ButtonEvent ce) {
                        hide();
                    }
                });
        super.addButton(close);
    }

    private ColumnModel prepareColumnModel() {
        List<ColumnConfig> configs = Lists.<ColumnConfig>newArrayList();

        ColumnConfig iconColumn = new ColumnConfig();
        iconColumn.setId("icon");
        iconColumn.setHeaderHtml(UserModuleConstants.INSTANCE.ManageRolesWidget_iconText());
        iconColumn.setWidth(35);
        iconColumn.setFixed(true);
        iconColumn.setResizable(false);
        iconColumn.setSortable(false);
        iconColumn.setRenderer(new GPGridCellRenderer<GuiComponentDetail>() {

            @Override
            public Object render(GuiComponentDetail model, String property, ColumnData config, int rowIndex,
                    int colIndex, ListStore<GuiComponentDetail> store, Grid<GuiComponentDetail> grid) {
                Button button = new Button();
                button.setIcon(model.getImage());
                button.setAutoWidth(true);
                return button;
            }
        });
        configs.add(iconColumn);

        ColumnConfig idColumn = new ColumnConfig();
        idColumn.setId(GuiComponentDetailKeyValue.COMPONENT_ID.toString());
        idColumn.setHeaderHtml(UserModuleConstants.INSTANCE.ManageRolesWidget_componentIDText());
        idColumn.setFixed(true);
        configs.add(idColumn);

        final SimpleComboBox<GuiPermission> permissionComboBox = new SimpleComboBox<GuiPermission>();
        permissionComboBox.setEditable(false);
        permissionComboBox.setTriggerAction(ComboBox.TriggerAction.ALL);
        permissionComboBox.add(Arrays.asList(GuiPermission.values()));
        CellEditor comboEditor = new CellEditor(permissionComboBox) {

            @Override
            public Object preProcessValue(Object value) {
                if (value == null) {
                    return value;
                }
                return permissionComboBox.findModel((GuiPermission) value);
            }

            @Override
            public Object postProcessValue(Object value) {
                if (value == null) {
                    return value;
                }
                return ((SimpleComboValue<GuiPermission>) value).getValue();
            }
        };
        GridCellRenderer<GuiComponentDetail> rendererPermission = new GridCellRenderer<GuiComponentDetail>() {

            @Override
            public Object render(GuiComponentDetail model, String property, ColumnData config, int rowIndex,
                    int colIndex, ListStore<GuiComponentDetail> store, Grid<GuiComponentDetail> grid) {
                GuiPermission permission = model.getPermission();
                return "<span style='color:" + permission.toStringColor() + "'>" + permission + "</span>";
            }
        };
        ColumnConfig permissionColumn = new ColumnConfig();
        permissionColumn.setId(GuiComponentDetailKeyValue.PERMISSION.toString());
        permissionColumn.setHeaderHtml(UserModuleConstants.INSTANCE.ManageRolesWidget_permissionsText());
        permissionColumn.setWidth(150);
        permissionColumn.setFixed(true);
        permissionColumn.setEditor(comboEditor);
        permissionColumn.setRenderer(rendererPermission);
        configs.add(permissionColumn);

        return new ColumnModel(configs);
    }

    private void loadPermissions() {
        mask(UserModuleMessages.INSTANCE.retrievingRolePermissionsMessage(role));
        final GetRolePermissionRequest getRolePermissionRequest = new GetRolePermissionRequest();
        getRolePermissionRequest.setRole(role);
        getRolePermissionRequest.setOrganization(GPAccountLogged.getInstance().getOrganization());
        ClientCommandDispatcher.getInstance().execute(new GPClientCommand<GetRolePermissionResponse>() {

            {
                super.setCommandRequest(getRolePermissionRequest);
            }

            /**
             * @param response
             */
            @Override
            public void onCommandSuccess(GetRolePermissionResponse response) {
                HashMap<String, Boolean> result = response.getResult();
                grid.stopEditing(true);
                ManageRolesWidget.this.store.removeAll();
                for (GuiComponentDetail gc : guiComponents) {
                    Boolean booleanPermission = result.get(gc.getComponentId());
                    gc.setPermission(GuiPermission.fromBoolean(booleanPermission));
                    ManageRolesWidget.this.store.add(gc);
                }

                // Iff for ADMIN role, we will remove MANAGE_ROLES
                // i.e. MANAGE_ROLES will not be modified for a ADMIN role
                if (role.equals(GPRole.ADMIN.getRole())) {
                    for (GuiComponentDetail gc : guiComponents) {
                        if (gc.getComponentId().equals("manageRoles")) {
                            ManageRolesWidget.this.store.remove(gc);
                            break;
                        }
                    }
                }
                setSearchStatus(EnumSearchStatus.STATUS_SEARCH,
                        UserModuleMessages.INSTANCE.rolePermissionsSuccesfullyRetrievedMessage(role));
                enableModifyButtons();
                ManageRolesWidget.this.unmask();
            }

            /**
             * @param exception
             */
            @Override
            public void onCommandFailure(Throwable exception) {
                setSearchStatus(EnumSearchStatus.STATUS_SEARCH_ERROR,
                        UserModuleMessages.INSTANCE.errorRetrievingRolePermissionsMessage(role));
            }
        });
    }

    private void savePermissions() {
        grid.stopEditing(true);
        List<Record> modifiedElements = store.getModifiedRecords();
        final HashMap<String, Boolean> permissionMap = Maps.<String, Boolean>newHashMapWithExpectedSize(
                modifiedElements.size());
        for (Record record : modifiedElements) {
            String componentId = record.get(GuiComponentDetailKeyValue.COMPONENT_ID.toString()).toString();
            GuiPermission permission = (GuiPermission) record.get(GuiComponentDetailKeyValue.PERMISSION.toString());
            permissionMap.put(componentId, permission.toBoolean());
        }

        mask(UserModuleMessages.INSTANCE.savingRolePermissionsMessage(role));
        final UpdateRolePermissionRequest updateRolePermissionRequest = new UpdateRolePermissionRequest();
        updateRolePermissionRequest.setRole(role);
        updateRolePermissionRequest.setOrganization(GPAccountLogged.getInstance().getOrganization());
        updateRolePermissionRequest.setPermissionMap(permissionMap);
        ClientCommandDispatcher.getInstance().execute(new GPClientCommand<UpdateRolePermissionResponse>() {

            {
                super.setCommandRequest(updateRolePermissionRequest);
            }

            /**
             * @param response
             */
            @Override
            public void onCommandSuccess(UpdateRolePermissionResponse response) {
                store.commitChanges();
                disableGridButtons();
                setSearchStatus(EnumSearchStatus.STATUS_SEARCH,
                        UserModuleMessages.INSTANCE.permissionsRoleSuccesfullySavedMessage(role));
                unmask();
            }

            /**
             * @param exception
             */
            @Override
            public void onCommandFailure(Throwable exception) {
                setSearchStatus(EnumSearchStatus.STATUS_SEARCH_ERROR,
                        UserModuleMessages.INSTANCE.errorSavingRolePermissionsMessage(role));
            }
        });
    }

    private void createNewRole() {
        GeoPlatformMessage.promptMessage(UserModuleConstants.INSTANCE.ManageRolesWidget_newRoleText(),
                UserModuleConstants.INSTANCE.ManageRolesWidget_enterNewRoleNameText(), new Listener<MessageBoxEvent>() {

                    @Override
                    public void handleEvent(MessageBoxEvent be) {
                        if (Dialog.CANCEL.equals(be.getButtonClicked().getItemId())) {
                            return;
                        }

                        String roleName = be.getValue().trim();
                        for (String r : roles) {
                            if (r.equalsIgnoreCase(roleName)) {
                                GeoPlatformMessage.errorMessage(WindowsConstants.INSTANCE.errorTitleText(),
                                        UserModuleConstants.INSTANCE.ManageRolesWidget_roleNameAlreadyExistsText());
                                setSearchStatus(EnumSearchStatus.STATUS_NO_SEARCH,
                                        UserModuleMessages.INSTANCE.roleNameAlreadyExistsMessage(roleName));
                                return;
                            }
                        }
                        role = roleName;
                        saveNewRole();
                    }
                });
    }

    private void saveNewRole() {
        mask(UserModuleMessages.INSTANCE.savingNewRoleMessage(role));
        final SaveRoleRequest saveRoleRequest = new SaveRoleRequest();
        saveRoleRequest.setRole(role);
        saveRoleRequest.setOrganization(GPAccountLogged.getInstance().getOrganization());
        ClientCommandDispatcher.getInstance().execute(new GPClientCommand<SaveRoleResponse>() {

            {
                super.setCommandRequest(saveRoleRequest);
            }

            /**
             * @param response
             */
            @Override
            public void onCommandSuccess(SaveRoleResponse response) {
                // Set default permission NONE for all permissions
                store.removeAll();
                for (GuiComponentDetail gc : guiComponents) {
                    gc.setPermission(GuiPermission.NONE);
                    store.add(gc);
                }
                roles.add(role);
                rolesComboBox.add(role);
                rolesComboBox.setSimpleValue(role);
                addRoleMenuItem(role);
                setSearchStatus(EnumSearchStatus.STATUS_SEARCH,
                        UserModuleMessages.INSTANCE.newRoleCreatedMessage(role));
                enableModifyButtons();
                unmask();
            }

            /**
             * @param exception
             */
            @Override
            public void onCommandFailure(Throwable exception) {
                setSearchStatus(EnumSearchStatus.STATUS_SEARCH_ERROR,
                        UserModuleMessages.INSTANCE.errorSavingNewRoleMessage(role));
            }
        });
    }

    private GuiComponentDetail createGuiComponentDetail(String componentId) {
        GuiComponentDetail gc = new GuiComponentDetail();
        gc.setComponentId(componentId);

        //        gc.setDescription(action.get....()); // TODO Manage description
        // TODO Manage icon
        MenuActionRegistar menuRegistar = BasicGinInjector.MainInjector.getInstance().getMenuActionRegistar();
        GeoPlatformAction action = menuRegistar.get(componentId);
        if (action != null) {
            if (action instanceof MenuBaseAction) {
                AbstractImagePrototype image = ((MenuBaseAction) action).getImage();
                if (image != null) {
                    gc.setImage(image);
                }
                //          }else{
                //              action = ToolbarActionRegistar.get(entry.getKey(), null)
            }
        }
        if (gc.getImage() == null) {
            gc.setImage(defaultImage);
        }

        return gc;
    }

    private Menu createPermissionsMenu() {
        Menu permissionMenu = new Menu();
        for (final GuiPermission permission : GuiPermission.values()) {
            MenuItem permissionItem = new MenuItem(permission.toString());
            permissionItem.addSelectionListener(new SelectionListener() {

                @Override
                public void componentSelected(ComponentEvent ce) {
                    // Set selected permission for all permissions
                    for (GuiComponentDetail gc : guiComponents) {
                        Record r = store.getRecord(gc);
                        r.set(GuiComponentDetailKeyValue.PERMISSION.toString(), permission);
                    }

                    setSearchStatus(EnumSearchStatus.STATUS_SEARCH,
                            UserModuleMessages.INSTANCE.permissionsValueSettedMessage(permission.toString()));
                }
            });
            permissionMenu.add(permissionItem);
        }
        return permissionMenu;
    }

    private Menu createRolesMenu() {
        this.copyPermissionsMenu = new Menu();
        this.copyPermissionsMenu.setMaxHeight(150);
        for (String roleIth : this.roles) {
            this.addRoleMenuItem(roleIth);
        }
        return this.copyPermissionsMenu;
    }

    private void addRoleMenuItem(final String roleItem) {
        MenuItem item = new MenuItem(roleItem);
        item.addSelectionListener(new SelectionListener() {

            @Override
            public void componentSelected(ComponentEvent ce) {
                searchStatus.setBusy(UserModuleMessages.INSTANCE.retrievingPermissionsRoleMessage(roleItem));
                final GetRolePermissionRequest getRolePermissionRequest = new GetRolePermissionRequest();
                getRolePermissionRequest.setRole(roleItem);
                getRolePermissionRequest.setOrganization(GPAccountLogged.getInstance().getOrganization());
                ClientCommandDispatcher.getInstance().execute(new GPClientCommand<GetRolePermissionResponse>() {

                    {
                        super.setCommandRequest(getRolePermissionRequest);
                    }

                    /**
                     * @param response
                     */
                    @Override
                    public void onCommandSuccess(GetRolePermissionResponse response) {
                        HashMap<String, Boolean> result = response.getResult();
                        grid.stopEditing(true);
                        // Copy permissions from selected role
                        for (GuiComponentDetail gc : guiComponents) {
                            Record r = store.getRecord(gc);
                            Boolean booleanPermission = result.get(gc.getComponentId());
                            r.set(GuiComponentDetailKeyValue.PERMISSION.toString(),
                                    GuiPermission.fromBoolean(booleanPermission));
                        }
                        setSearchStatus(EnumSearchStatus.STATUS_SEARCH,
                                UserModuleMessages.INSTANCE.permissionsRoleCopiedToMessage(roleItem, role));
                    }

                    /**
                     * @param exception
                     */
                    @Override
                    public void onCommandFailure(Throwable exception) {
                        setSearchStatus(EnumSearchStatus.STATUS_SEARCH_ERROR,
                                UserModuleMessages.INSTANCE.errorRetrievingRolePermissionsMessage(roleItem));
                    }
                });
            }
        });
        this.copyPermissionsMenu.add(item);
    }

    private void disableModifyButtons() {
        allPermissionsButton.disable();
        copyPermissionsButton.disable();
    }

    private void enableModifyButtons() {
        allPermissionsButton.enable();
        copyPermissionsButton.enable();
    }

    private void disableGridButtons() {
        resetButton.disable();
        saveButton.disable();
    }

    private void enableGridButtons() {
        resetButton.enable();
        saveButton.enable();
    }

    private void setSearchStatus(Enum status, String message) {
        if (status == null) {
            searchStatus.setIconStyle(null);
        } else {
            searchStatus.setIconStyle(status.toString());
        }
        searchStatus.setText(message);
    }

    @Override
    public void show() {
        super.show();
        rolesComboBox.removeAll();
        rolesComboBox.add(this.roles);
        copyPermissionsMenu.removeAll();
        for (String roleIth : this.roles) {
            this.addRoleMenuItem(roleIth);
        }
        this.setSearchStatus(EnumSearchStatus.STATUS_NO_SEARCH,
                UserModuleConstants.INSTANCE.ManageRolesWidget_statusSelectOrCreateRoleText());
    }

    @Override
    public void hide() {
        if (store.getModifiedRecords().isEmpty()) {
            super.hide();
        } else {
            GeoPlatformMessage.confirmMessage(WindowsConstants.INSTANCE.warningTitleText(),
                    UserModuleConstants.INSTANCE.ManageRolesWidget_unsavedPermissionsWarningText(),
                    new Listener<MessageBoxEvent>() {

                        @Override
                        public void handleEvent(MessageBoxEvent be) {
                            if (Dialog.YES.equals(be.getButtonClicked().getItemId())) {
                                ManageRolesWidget.super.hide();
                            }
                        }
                    });
        }
    }

    @Override
    public void reset() {
        role = null;
        store.removeAll();
        rolesComboBox.reset();
        disableModifyButtons();
        setSearchStatus(null, "");
    }
}
