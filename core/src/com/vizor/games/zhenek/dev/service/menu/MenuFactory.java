package com.vizor.games.zhenek.dev.service.menu;

import com.vizor.games.zhenek.dev.service.menu.impl.MenuServiceImpl;

public class MenuFactory {

    private static MenuFactory instance = new MenuFactory();

    public static MenuFactory getInstance() {
        if(instance == null){
            instance = new MenuFactory();
        }
        return instance;
    }

    private MenuService menuService = new MenuServiceImpl();

    public MenuService getMenuService() {
        return menuService;
    }
}
