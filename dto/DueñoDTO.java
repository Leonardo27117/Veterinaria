package veterinaria.dto;

import java.util.Date;

public class DueñoDTO {
    private int id;
    private String nombreCompleto;
    private String email;
    private int direccionId;

    public DueñoDTO(){

    }

    public DueñoDTO(int id, String nombreCompleto, String email, int direccionId){
        this.id = id;
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.direccionId = direccionId;
    }

    public DueñoDTO(String nombreCompleto, String email, int direccionId){
        this.nombreCompleto = nombreCompleto;
        this.email = email;
        this.direccionId = direccionId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombreCompleto() {
        return nombreCompleto;
    }

    public void setNombreCompleto(String nombreCompleto) {
        this.nombreCompleto = nombreCompleto;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getDireccionId() {
        return direccionId;
    }

    public void setDireccionId(int direccionId) {
        this.direccionId = direccionId;
    }
}