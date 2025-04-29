package veterinaria.dao;

import veterinaria.dto.MascotaDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class MascotaDAO extends ConexionBD {
    private final static String SQL_INSERT = "INSERT INTO mascota(especie, raza, color, tamaño, fecha_nacimiento, dueño_id) VALUES(?, ?, ?, ?, ?, ?)";
    private final static String SQL_UPDATE = "UPDATE mascota SET especie=?, raza=?, color=?, tamaño=?, fecha_nacimiento=?, dueño_id=? WHERE id=?";
    private final static String SQL_DELETE = "DELETE FROM mascota WHERE id=?";
    private final static String SQL_SELECT = "SELECT * FROM mascota WHERE id=?";
    private final static String SQL_SELECT_ALL = "SELECT * FROM mascota";
    private final static String SQL_SELECT_BY_DUEÑO = "SELECT * FROM mascota WHERE dueño_id=?";

    public MascotaDAO() {
        super();
    }

    public void agregar(MascotaDTO dto) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getEspecie());
            ps.setString(2, dto.getRaza());
            ps.setString(3, dto.getColor());
            ps.setString(4, dto.getTamaño());
            ps.setDate(5, new java.sql.Date(dto.getFechaNacimiento().getTime()));
            ps.setInt(6, dto.getDueñoId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al agregar mascota: " + e.getMessage());
        } finally {
            cerrar(ps);
        }
    }

    public void actualizar(MascotaDTO dto) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getEspecie());
            ps.setString(2, dto.getRaza());
            ps.setString(3, dto.getColor());
            ps.setString(4, dto.getTamaño());
            ps.setDate(5, new java.sql.Date(dto.getFechaNacimiento().getTime()));
            ps.setInt(6, dto.getDueñoId());
            ps.setInt(7, dto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar mascota: " + e.getMessage());
        } finally {
            cerrar(ps);
        }
    }

    public void eliminar(MascotaDTO dto) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al eliminar mascota: " + e.getMessage());
        } finally {
            cerrar(ps);
        }
    }

    public MascotaDTO buscar(MascotaDTO dto) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        MascotaDTO mascota = null;
        
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getId());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                mascota = new MascotaDTO();
                mascota.setId(rs.getInt("id"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColor(rs.getString("color"));
                mascota.setTamaño(rs.getString("tamaño"));
                mascota.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                mascota.setDueñoId(rs.getInt("dueño_id"));
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar mascota: " + e.getMessage());
        } finally {
            cerrar(rs);
            cerrar(ps);
        }
        
        return mascota;
    }

    public List<MascotaDTO> listarTodos() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MascotaDTO> lista = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                MascotaDTO mascota = new MascotaDTO();
                mascota.setId(rs.getInt("id"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColor(rs.getString("color"));
                mascota.setTamaño(rs.getString("tamaño"));
                mascota.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                mascota.setDueñoId(rs.getInt("dueño_id"));
                lista.add(mascota);
            }
        } catch (SQLException e) {
            throw new Exception("Error al listar mascotas: " + e.getMessage());
        } finally {
            cerrar(rs);
            cerrar(ps);
        }
        
        return lista;
    }

    public List<MascotaDTO> listarPorDueño(int dueñoId) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<MascotaDTO> lista = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement(SQL_SELECT_BY_DUEÑO);
            ps.setInt(1, dueñoId);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                MascotaDTO mascota = new MascotaDTO();
                mascota.setId(rs.getInt("id"));
                mascota.setEspecie(rs.getString("especie"));
                mascota.setRaza(rs.getString("raza"));
                mascota.setColor(rs.getString("color"));
                mascota.setTamaño(rs.getString("tamaño"));
                mascota.setFechaNacimiento(rs.getDate("fecha_nacimiento"));
                mascota.setDueñoId(rs.getInt("dueño_id"));
                lista.add(mascota);
            }
        } catch (SQLException e) {
            throw new Exception("Error al listar mascotas por dueño: " + e.getMessage());
        } finally {
            cerrar(rs);
            cerrar(ps);
        }
        
        return lista;
    }
}