package com.conurets.hcm.mapper;

import com.conurets.hcm.base.dto.request.AddMenuRequestDTO;
import com.conurets.hcm.base.dto.request.AddParentMenuRequestDTO;
import com.conurets.hcm.base.dto.request.UpdateMenuRequestDTO;
import com.conurets.hcm.base.dto.request.UpdateParentMenuRequestDTO;
import com.conurets.hcm.base.dto.response.MenuResponseDTO;
import com.conurets.hcm.base.dto.response.ParentMenuResponseDTO;
import com.conurets.hcm.base.exception.HCMException;
import com.conurets.hcm.base.util.HCMConstants;
import com.conurets.hcm.base.util.HCMHelper;
import com.conurets.hcm.base.util.HCMUtil;
import com.conurets.hcm.persistence.entity.Menu;
import com.conurets.hcm.persistence.entity.Privilege;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

/**
 * @author MSA
 * @version 1.0
 */

@Slf4j
@Component
public class MenuMapper extends BaseMapper {
    /**
     * Add parent menu
     *
     * @param model
     * @throws HCMException
     */
    public Menu addParentMenu(AddParentMenuRequestDTO model) throws HCMException {
        Menu parentMenu = new Menu();
        parentMenu.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));
        parentMenu.setMenuName(model.getParentMenuName());
        parentMenu.setMenuCssClass(model.getParentMenuCssClass());
        parentMenu.setMenuHref(model.getParentMenuHref());
        parentMenu.setMenuIcon(model.getParentMenuIcon());
        parentMenu.setMenuSequence(model.getParentMenuSequence());
        parentMenu.setStatus(model.getStatus());

        addAuditingInformation(parentMenu);

        return parentMenu;
    }

    /**
     * Update parent menu
     *
     * @param model
     * @throws HCMException
     */
    public Menu updateParentMenu(UpdateParentMenuRequestDTO model) throws HCMException {
        Menu parentMenu = getDaoFactory().getMenuDAO().findById(model.getParentMenuId());

        if (parentMenu == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        parentMenu.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));
        parentMenu.setMenuName(model.getParentMenuName());
        parentMenu.setMenuCssClass(model.getParentMenuCssClass());
        parentMenu.setMenuHref(model.getParentMenuHref());
        parentMenu.setMenuIcon(model.getParentMenuIcon());
        parentMenu.setMenuSequence(model.getParentMenuSequence());
        parentMenu.setStatus(model.getStatus());

        addAuditingInformation(parentMenu);

        return parentMenu;
    }

    /**
     * Delete parent menu
     *
     * @param id
     * @throws HCMException
     */
    public Menu deleteParentMenu(long id) throws HCMException {
        Menu parentMenu = getDaoFactory().getMenuDAO().findById(id);

        if (parentMenu == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        parentMenu.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(parentMenu);

        return parentMenu;
    }


    /**
     * Find parent menu
     *
     * @param menu
     * @return
     * @throws HCMException
     */
    public ParentMenuResponseDTO findParentMenu(Menu menu) throws HCMException {
        ParentMenuResponseDTO parentMenuResponseDTO = new ParentMenuResponseDTO();
        parentMenuResponseDTO.setOrganizationName(menu.getOrganization().getName());
        parentMenuResponseDTO.setParentMenuId(menu.getId());
        parentMenuResponseDTO.setParentMenuName(menu.getMenuName());
        parentMenuResponseDTO.setStatus(HCMUtil.getStatus(menu.getStatus()));

        return parentMenuResponseDTO;
    }

    /**
     * Add menu
     *
     * @param model
     * @throws HCMException
     */
    public Menu addMenu(AddMenuRequestDTO model) throws HCMException {
        Menu menu = new Menu();

        Menu parentMenu = getDaoFactory().getMenuDAO().findById(model.getParentMenuId());

        if (parentMenu == null) {
            HCMHelper.handleResultNotFound(101, "Invalid parent menu id");
        }

        Privilege privilege = getDaoFactory().getPrivilegeDAO().findById(model.getPrivilegeId());

        if (privilege == null) {
            HCMHelper.handleResultNotFound(101, "Invalid privilege id");
        }

        menu.setParentMenu(parentMenu);
        menu.setPrivilege(privilege);
        menu.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));
        menu.setMenuName(model.getMenuName());
        menu.setMenuCssClass(model.getMenuCssClass());
        menu.setMenuHref(model.getMenuHref());
        menu.setMenuIcon(model.getMenuIcon());
        menu.setMenuSequence(model.getMenuSequence());
        menu.setStatus(model.getStatus());

        addAuditingInformation(menu);

        return menu;
    }

    /**
     * Update menu
     *
     * @param model
     * @throws HCMException
     */
    public Menu updateMenu(UpdateMenuRequestDTO model) throws HCMException {
        Menu menu = getDaoFactory().getMenuDAO().findById(model.getMenuId());

        if (menu == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        menu.setParentMenu(getDaoFactory().getMenuDAO().findById(model.getParentMenuId()));
        menu.setPrivilege(getDaoFactory().getPrivilegeDAO().findById(model.getPrivilegeId()));
        menu.setOrganization(getDaoFactory().getOrganizationDAO().findById(model.getOrganizationId()));
        menu.setMenuName(model.getMenuName());
        menu.setMenuCssClass(model.getMenuCssClass());
        menu.setMenuHref(model.getMenuHref());
        menu.setMenuIcon(model.getMenuIcon());
        menu.setMenuSequence(model.getMenuSequence());
        menu.setStatus(model.getStatus());

        addAuditingInformation(menu);

        return menu;
    }

    /**
     * Delete menu
     *
     * @param id
     * @throws HCMException
     */
    public Menu deleteMenu(long id) throws HCMException {
        Menu menu = getDaoFactory().getMenuDAO().findById(id);

        if (menu == null) {
            HCMHelper.handleResultNotFound(101, "No result found");
        }

        menu.setStatus(HCMConstants.Common.STATUS_CODE_DELETE);

        addAuditingInformation(menu);

        return menu;
    }

    /**
     * Find menu
     *
     * @param menu
     * @return
     * @throws HCMException
     */
    public MenuResponseDTO findMenu(Menu menu) throws HCMException {
        MenuResponseDTO menuResponseDTO = new MenuResponseDTO();
        menuResponseDTO.setParentMenuId(menu.getParentMenu().getId());
        menuResponseDTO.setParentMenuName(menu.getParentMenu().getMenuName());
        menuResponseDTO.setMenuId(menu.getId());
        menuResponseDTO.setMenuName(menu.getMenuName());
        menuResponseDTO.setMenuCssClass(menu.getMenuCssClass());
        menuResponseDTO.setMenuHref(menu.getMenuHref());
        menuResponseDTO.setMenuIcon(menu.getMenuIcon());
        menuResponseDTO.setMenuSequence(menu.getMenuSequence());
        menuResponseDTO.setStatus(HCMUtil.getStatus(menu.getStatus()));

        return menuResponseDTO;
    }
}