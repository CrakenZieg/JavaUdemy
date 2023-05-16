
package mx.com.gm.sga.service;

import java.util.ArrayList;
import java.util.List;
import javax.ejb.Stateless;
import mx.com.gm.sga.domain.Persona;

@Stateless

public class PersonaServiceImpl implements PersonaServiceRemote{

    @Override
    public List<Persona> listarPersonas() {
//creamos la lista y, por ahora, agregamos algunos valores (despues agregamos la DDBB)
        List<Persona> personas = new ArrayList<>();
        personas.add(new Persona(1,"Mau1","Gato1","Mau1@mail.com","123456"));       
        personas.add(new Persona(2,"Mau2","Gato2","Mau2@mail.com","234561"));       
        personas.add(new Persona(3,"Mau3","Gato3","Mau3@mail.com","345612"));
        personas.add(new Persona(4,"Mau4","Gato4","Mau4@mail.com","456123"));
        personas.add(new Persona(5,"Mau5","Gato5","Mau5@mail.com","561234"));
        personas.add(new Persona(6,"Mau6","Gato6","Mau6@mail.com","612345"));
        return personas;
    }

    @Override
    public Persona encontrarPersonaPorId(Persona persona) {
        return null;
    }

    @Override
    public Persona encontrarPersonaPorEmail(Persona persona) {
        return null;
    }

    @Override
    public void registrarPersona(Persona persona) {

    }

    @Override
    public void modificarPersona(Persona persona) {

    }

    @Override
    public void aliminarPersona(Persona persona) {

    }
    
}
