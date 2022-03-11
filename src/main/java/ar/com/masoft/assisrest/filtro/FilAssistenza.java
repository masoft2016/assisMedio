/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ar.com.masoft.assisrest.filtro;

import ar.com.masoft.assisrest.Distrito;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.util.LinkedMultiValueMap;

/**
 *
 * @author magug
 */
@Data
@Builder
@AllArgsConstructor
public class FilAssistenza {
     private String nombre;     
     private Integer titular;     // Null o 0 indica que no filtra     
     private Integer tipo;// Null o 0 indica que no filtra     
     private Integer estado; // Null o 0 indica que no filtra     
     private Integer distrito;  // Null o 0 indica que no filtra     
     private Integer ciudad;  // Null o 0 indica que no filtra
     private boolean filFecha;
     
     @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
     private Date desde;
     @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
     private Date hasta;
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
        
        if (titular != null){
            map.put("titular", titular.toString());
        }
        if (tipo != null){
            map.put("tipo", tipo.toString());
        }
         if (estado != null){
            map.put("estado", estado.toString());
        }
        if (distrito != null){
            map.put("distrito", distrito.toString());
        }
        
        if (ciudad != null){
            map.put("ciudad", ciudad.toString());
        }
        map.put("filFecha", Boolean.toString(filFecha));
        if (filFecha){
            
            Format form=new SimpleDateFormat("yyyy-MM-dd HH:mm");
            map.put("desde", form.format(desde));
            map.put("hasta", form.format(hasta));
        }
        ret.setAll(map);
        return ret;
        
    }
}
