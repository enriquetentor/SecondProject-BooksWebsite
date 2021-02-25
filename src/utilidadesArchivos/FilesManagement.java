package utilidadesArchivos;

import java.io.File;
import java.io.IOException;

import org.springframework.util.FileCopyUtils;
import org.springframework.web.multipart.MultipartFile;

import modelo.Book;

public class FilesManagement {

	public static void guardarPortadaLibro(Book l, String rutaReal) {
		MultipartFile archivo = l.getPortada();
		String nombreArchivo = l.getId() + ".jpg";

		// vamos a crear una carpeta de subidas en la ruta real (si no existe)
		String rutaSubidas = rutaReal + "/subidas";
		File fileRutaSubidas = new File(rutaSubidas);
		if (!fileRutaSubidas.exists()) {
			fileRutaSubidas.mkdirs();
		}

		try {
			byte[] infoPortada = archivo.getBytes();
			if (infoPortada.length > 0) {
				String ruta = fileRutaSubidas + "/" + nombreArchivo;
				FileCopyUtils.copy(infoPortada, new File(ruta));
				System.out.println("archivo subido en: " + ruta);
			}
		} catch (IOException e1) {
			System.out.println("no pude obtener info de la imagen");
			e1.printStackTrace();
		}

	}

}
