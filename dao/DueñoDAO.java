package veterinaria.dao;

import veterinaria.dto.DueñoDTO;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DueñoDAO extends ConexionBD {
    private final static String SQL_INSERT = "INSERT INTO dueño(nombre_completo, direccion_id) VALUES(?, ?)";
    private final static String SQL_UPDATE = "UPDATE dueño SET nombre_completo=?, direccion_id=? WHERE id=?";
    private final static String SQL_DELETE = "DELETE FROM dueño WHERE id=?";
    private final static String SQL_SELECT = "SELECT * FROM dueño WHERE id=?";
    private final static String SQL_SELECT_ALL = "SELECT * FROM dueño";

    public DueñoDAO() {
        super();
    }

    public void agregar(DueñoDTO dto) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_INSERT);
            ps.setString(1, dto.getNombreCompleto());
            ps.setInt(2, dto.getDireccionId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al agregar dueño: " + e.getMessage());
        } finally {
            cerrar(ps);
        }

    }

    public void actualizar(DueñoDTO dto) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_UPDATE);
            ps.setString(1, dto.getNombreCompleto());
            ps.setInt(2, dto.getDireccionId());
            ps.setInt(3, dto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al actualizar dueño: " + e.getMessage());
        } finally {
            cerrar(ps);
        }
    }

    public void eliminar(DueñoDTO dto) throws Exception {
        PreparedStatement ps = null;
        try {
            ps = conn.prepareStatement(SQL_DELETE);
            ps.setInt(1, dto.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new Exception("Error al eliminar dueño: " + e.getMessage());
        } finally {
            cerrar(ps);
        }
    }

    public DueñoDTO buscar(DueñoDTO dto) throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        DueñoDTO dueño = null;
        
        try {
            ps = conn.prepareStatement(SQL_SELECT);
            ps.setInt(1, dto.getId());
            rs = ps.executeQuery();
            
            if (rs.next()) {
                dueño = new DueñoDTO();
                dueño.setId(rs.getInt("id"));
                dueño.setNombreCompleto(rs.getString("nombre_completo"));
                dueño.setDireccionId(rs.getInt("direccion_id"));
            }
        } catch (SQLException e) {
            throw new Exception("Error al buscar dueño: " + e.getMessage());
        } finally {
            cerrar(rs);
            cerrar(ps);
        }
        
        return dueño;
    }

    public List<DueñoDTO> listarTodos() throws Exception {
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<DueñoDTO> lista = new ArrayList<>();
        
        try {
            ps = conn.prepareStatement(SQL_SELECT_ALL);
            rs = ps.executeQuery();
            
            while (rs.next()) {
                DueñoDTO dueño = new DueñoDTO();
                dueño.setId(rs.getInt("id"));
                dueño.setNombreCompleto(rs.getString("nombre_completo"));
                dueño.setDireccionId(rs.getInt("direccion_id"));
                lista.add(dueño);
            }
        } catch (SQLException e) {
            throw new Exception("Error al listar dueños: " + e.getMessage());
        } finally {
            cerrar(rs);
            cerrar(ps);
        }
        
        return lista;
    }
}