package veterinaria.dto;

import java.util.Date;

public class MascotaDTO {
    private int id;
    private String especie;
    private String raza;
    private String color;
    private String tamaño;
    private Date fechaNacimiento;
    private int dueñoId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEspecie() {
        return especie;
    }

    public void setEspecie(String especie) {
        this.especie = especie;
    }

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTamaño() {
        return tamaño;
    }

    public void setTamaño(String tamaño) {
        this.tamaño = tamaño;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public int getDueñoId() {
        return dueñoId;
    }

    public void setDueñoId(int dueñoId) {
        this.dueñoId = dueñoId;
    }
}