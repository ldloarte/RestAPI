package com.demo.apirestful.RestAPI.demo;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class demoController {
//
//    @Autowired
//    private DatosService datosService;

    @PostMapping(value = "demo")
    public String welcome()
    {
        return "Welcome from secure";
    }
//
//    @RequestMapping("/")
//    @ResponseBody
//    public List<Datos> datosList(){
//        return datosService.listaDatos();
//    }
//
//    @PostMapping("/createDatos")
//    public Datos saveDatos(@RequestBody Datos datos){
//        return DatosService.saveDatos(datos);
//    }
}
