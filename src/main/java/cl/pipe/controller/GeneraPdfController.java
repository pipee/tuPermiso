package cl.pipe.controller;

import java.io.IOException;

import cl.pipe.service.IServicioGenera;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GeneraPdfController {

	@Autowired
	private IServicioGenera iServicioGenera;

	@CrossOrigin
	@GetMapping("getpdf")
	public ResponseEntity getPdf(
		@RequestParam(value = "codPermiso") Integer codPermiso
	) {
		byte[] byteArrayInputStream = null;
		try {
			byteArrayInputStream = iServicioGenera.generaByteArray(codPermiso);
			return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment;filename=Test.pdf")
					.contentType(MediaType.APPLICATION_PDF).contentLength(byteArrayInputStream.length)
					.body(byteArrayInputStream);
		} catch (IOException e) {
			e.printStackTrace();
			return new ResponseEntity(HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
