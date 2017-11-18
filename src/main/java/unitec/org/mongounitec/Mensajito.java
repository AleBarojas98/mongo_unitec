/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package unitec.org.mongounitec;

import org.springframework.data.annotation.Id;


public class Mensajito {
    @Id
    private String Id; 
    private String titulo; 
    private String cuerpo; 

    public String getId() {
        return Id;
    }

    public void setId(String Id) {
        this.Id = Id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCuerpo() {
        return cuerpo;
    }

    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }

    public Mensajito() {
    }

    public Mensajito(String Id) {
        this.Id = Id;
    }

    public Mensajito(String titulo, String cuerpo) {
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }

    public Mensajito(String Id, String titulo, String cuerpo) {
        this.Id = Id;
        this.titulo = titulo;
        this.cuerpo = cuerpo;
    }
    
    
}
