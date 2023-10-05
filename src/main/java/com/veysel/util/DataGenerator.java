package com.veysel.util;

import com.veysel.controller.KitapController;
import com.veysel.controller.UserController;
import com.veysel.controller.YazarController;

public class DataGenerator {

KitapController kitapController;
UserController userController;
YazarController yazarController;

    public DataGenerator() {
        this.kitapController=new KitapController();
        this.userController=new UserController();
        this.yazarController=new YazarController();
    }
}
