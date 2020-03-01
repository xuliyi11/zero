package com.controller.ep;

import com.domain.Ep;
import com.service.EpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EpController {

    @Autowired
    private EpService epService;

    @RequestMapping("/insert")
    @ResponseBody
    public int insert( @RequestParam long shopId){

        List<String> list = new ArrayList<>();
        list.add("xiaoxu");
        list.add("xiaoming");
        list.add("xiaohong");

        Ep ep = new Ep();

        
        return epService.insert(ep);
    }

}
