package cl.pipe.service;

import java.io.IOException;

public interface IServicioGenera {

    byte[] generaByteArray(Integer codPermiso) throws IOException;
}
