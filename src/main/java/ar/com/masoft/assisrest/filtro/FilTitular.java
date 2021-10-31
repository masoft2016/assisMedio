/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.masoft.assisrest.filtro;

import ar.com.masoft.assisrest.Distrito;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.util.LinkedMultiValueMap;

/**
 *
 * @author magug
 */
@Data
@Builder
@AllArgsConstructor
public class FilTitular {
     private String nombre;     
     private Integer distrito;  // Null o 0 indica que no filtra     
     private Integer ciudad;  // Null o 0 indica que no filtra
     public LinkedMultiValueMap<String, String> getMultiValueMap() {
        LinkedMultiValueMap<String, String> ret  = new LinkedMultiValueMap<>();
        Map map = new HashMap<String, String>();
        /*map.put("tipo", this.tipo.name());
        map.put("incluyeBloqueados", Boolean.toString(incluyeBloqueados)); 
        map.put("soloProblemasArba", Boolean.toString(soloProblemasArba)); 
        if (filGeo != null){
            map.put("filGeo", Integer.toString(filGeo));
        }
        if (filGrupo != null){
            map.put("filGrupo", Integer.toString(filGrupo));
        }
        if (filCanal != null){
            map.put("filCanal", Integer.toString(filCanal));
        }
        if (filLispre != null){
            map.put("filLispre", Integer.toString(filLispre));
        }*/
        map.put("nombre", nombre);
        
        if (distrito != null){
            map.put("distrito", distrito.toString());
        }
        
        if (ciudad != null){
            map.put("ciudad", ciudad.toString());
        }
        ret.setAll(map);
        return ret;
        
    }
}
