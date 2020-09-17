package cl.pipe.util;

import com.itextpdf.html2pdf.HtmlConverter;
import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Component;

import java.io.*;
import java.nio.charset.StandardCharsets;
import org.springframework.util.StreamUtils;

@Component
public class Tools {

    @Value("classpath:templates/Permiso.html")
    private Resource archivo1Res;

    public byte [] convertToPdf(String htmlBody) throws IOException {
        InputStream inputStreamHtml = IOUtils.toInputStream(htmlBody, StandardCharsets.UTF_8);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(inputStreamHtml, outputStream);
        return outputStream.toByteArray();
    }

    public String getStringFromHtml() throws IOException {
        return getStringDesdeResource(archivo1Res);
    }

    private String getStringDesdeResource(Resource resource) throws IOException {
        return StreamUtils.copyToString(resource.getInputStream(), StandardCharsets.UTF_8);
    }
}
