

package unitec.org.mongounitec;

import com.fasterxml.jackson.databind.ObjectMapper;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author rapid
 */
@RestController
@RequestMapping("/mensaje")
@CrossOrigin
public class ControladorMensajito{
    
    @Autowired RepositorioMensajito repoMensa;
  //  aqui a contnuacion van las 5 operaciones basicas con la entidad mensaje
    
        //Metodo GET:Buscar todos
   @RequestMapping(value="/mensajito", method=RequestMethod.GET,
           headers = {"Accept=application/json"}) 
   public ArrayList<Mensajito> obtenerTodos()throws Exception{
           return (ArrayList<Mensajito>) repoMensa.findAll();
   }
    
   //Metodo GET:Buscar por ID
   @RequestMapping(value="/mensajito/(id)", method=RequestMethod.GET,
           headers ={"Accept=application/json"})
   public Mensajito obtenerporId(@PathVariable String id) 
           throws Exception{
       return repoMensa.findOne(id);
       
         }
   //METODO POST:guardar version para clientes variables
   
   @RequestMapping(value="/mensajito/(titulo)/(cuerpo)",method=RequestMethod.POST,
           headers = {"Accept=application/json"})
   public Estatus guardarMensajito(@PathVariable String Titulo,
           @PathVariable String cuerpo) throws Exception{
       repoMensa.save(new Mensajito(Titulo,cuerpo));
       Estatus estatus=new Estatus();
       estatus.setSuccess(true);
       return estatus; 
       
   }
   
   //Metodo POST: guardar, pero es una version mas pura y efectiva 
   
   @RequestMapping(value="/mensajito", method=RequestMethod.POST,
           headers=("Accept=application/json"))
   
   public Estatus guardarMensajitoMejorado (@RequestBody String json)
           throws Exception {
       //Transformamos el json a objeto java 
       
       ObjectMapper maper=new ObjectMapper(); 
       Mensajito mensa=maper.readValue(json, Mensajito.class); 
       repoMensa.save(mensa); 
       Estatus es=new Estatus(); 
       es.setSuccess(true);
       return es; 
       
       
   }
   
}
