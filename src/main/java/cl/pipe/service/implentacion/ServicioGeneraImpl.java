package cl.pipe.service.implentacion;

import cl.pipe.service.IServicioGenera;
import cl.pipe.util.Tools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class ServicioGeneraImpl implements IServicioGenera {

    @Autowired
    private Tools tools;

    @Override
    public byte[] generaByteArray(Integer codPermiso) throws IOException {
        String htmlBody = tools.getStringFromHtml();
        return tools.convertToPdf(htmlBody);
    }
}
