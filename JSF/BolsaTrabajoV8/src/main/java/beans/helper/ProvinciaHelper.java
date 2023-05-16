
package beans.helper;

import beans.model.Provincia;
import jakarta.enterprise.context.RequestScoped;
import jakarta.faces.model.SelectItem;
import jakarta.inject.Named;
import java.util.ArrayList;
import java.util.List;

@RequestScoped
@Named
public class ProvinciaHelper {
//creamos el aaray de provincias, mockeando un DDBB
    public List<Provincia> getProvincias(){
        List<Provincia> provincias = new ArrayList<>();
        
        int provinciaId = 1;
        Provincia provincia = new Provincia(provinciaId++, "Provincia de Buenos Aires", 8000);
        provincias.add(provincia);
        provincia = new Provincia(provinciaId++, "Provincia de La Pampa", 8001);
        provincias.add(provincia);
        provincia = new Provincia(provinciaId++, "Provincia de Río Negro", 8002);
        provincias.add(provincia);
        
        return provincias;
        
    }
//recuperamos el id de la provincia por nombre
    public int getProvinciaIdPorNombre(String nombreProvincia){
        int provinciaId = 0;
        List<Provincia> provincias = this.getProvincias();
        
        for(Provincia provincia:provincias){
            if(provincia.getNombreProvincia().equals(nombreProvincia)){
                provinciaId = provincia.getProvinciaId();
                break;
            }
        }
        return provinciaId;
    }
//recuperamos el id de la provincia por el codigo postal
    public int getProvinciaIdPorCP(int codigoPostal){
        int provinciaId = 0;
        List<Provincia> provincias = this.getProvincias();
        
        for(Provincia provincia:provincias){
            if(provincia.getCodigoPostal() == codigoPostal){
                provinciaId = provincia.getProvinciaId();
                break;
            }
        }
        return provinciaId;
    }
//devolvemos una lista de las provincias en formato selectItem
    public List<SelectItem> getSelectItems(){
        List<SelectItem> selectItems = new ArrayList<>();
        List<Provincia> provincias = this.getProvincias();
        for(Provincia provincia:provincias){
            SelectItem selectItem = new SelectItem(provincia.getProvinciaId(), provincia.getNombreProvincia());
            selectItems.add(selectItem);
        }
        return selectItems;
        
    }
    
}
