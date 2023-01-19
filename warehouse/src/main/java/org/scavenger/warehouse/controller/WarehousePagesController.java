package org.scavenger.warehouse.controller;

import org.scavenger.warehouse.common.annotation.Authenticate;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/warehouse")
public class WarehousePagesController {

    @Authenticate
    @GetMapping("/main")
    @ResponseBody
    public String getMainPage() {
        return "homepage";
    }
}
