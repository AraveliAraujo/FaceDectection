package Controller;

import Dao.RestDao;
import java.io.IOException;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import lombok.Data;
import modelo.modelo;

@Data
@Named(value = "restController")
@SessionScoped
public class RestController implements Serializable {

    private String urlImage;
    private String resultado;
    private RestDao dao = new RestDao();
    modelo modelo = new modelo();

    public void consultar() throws Exception {
        try {
            modelo = dao.consultar(urlImage);
            modelo.setLINK(urlImage);
        } catch (IOException e) {
            throw e;
        }
    }

}
