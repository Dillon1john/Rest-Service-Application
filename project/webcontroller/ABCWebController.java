package edu.citytech.cst.project.webcontroller;
import edu.citytech.cst.project.service.ABCCounterService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Supplier;

@RestController
@RequestMapping("api/abc")
public class ABCWebController {

    Map<String, Supplier<List<?>>> map = new HashMap<>();

    {
        map.put("abc", ABCCounterService::countABC);
        map.put("cba",ABCCounterService::countCBA);
        map.put("123",ABCCounterService::count123);
        map.put("321",ABCCounterService::count321);
        map.put("369",ABCCounterService::count369);
        map.put("Aa",ABCCounterService::countAa);
    }

    @GetMapping
    public List<Character> getABC(){
        return ABCCounterService.countABC();
    }

    @GetMapping("/{mode}")
    public List<?> get(@PathVariable String mode){
        map.getOrDefault(mode,() -> new ArrayList<>());
        return map.get(mode).get();
    }


}
