package edu.citytech.cst.project.webcontroller;

import edu.citytech.cst.project.service.CustomerPurchaseService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/purchases/makeup")
public class CustomerPurchasesWebController {

    @GetMapping("/{mode}/{task}")
    public Map<String,Object> getData(@PathVariable String mode, @PathVariable String task){
        Map<String,Object> map = CustomerPurchaseService.task(mode, task);
        return  map;
    }

    @GetMapping("/moreinfo")
    public Map<String,String> getMoreInfo(){
        Map<String,String> map = new HashMap<>();
        map.put("name","Dillon");
        map.put("email","Dillon1john");
        return map;
    }
}
