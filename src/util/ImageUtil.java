package util;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;

import java.util.Base64;

import javax.sql.rowset.serial.SerialBlob;
import javax.sql.rowset.serial.SerialException;

public class ImageUtil {
public static String blobToString(byte[] images) throws IOException {
//	InputStream is = image.getBinaryStream();
//	ByteArrayOutputStream outStream = new ByteArrayOutputStream();
//	byte[] buffer = new byte[4096];
//	int b = -1;
//	while((b = is.read(buffer)) != -1) {
//		outStream.write(buffer, 0, b);
//	}
//	byte[] imageBytes = outStream.toByteArray();
	String baseImage = Base64.getEncoder().encodeToString(images);
	return baseImage;
	}

public static Blob saveImage(File file) throws IOException, SerialException, SQLException {
	byte[] byteImages = new byte[(int) file.length()];
	FileInputStream fileStream = new FileInputStream(file);
	fileStream.read(byteImages);
	Blob blob = new SerialBlob(byteImages);
	fileStream.close();
	return blob;
}

public static byte[] getBytesFromInputStream(InputStream is) throws IOException {
	ByteArrayOutputStream buffer = new ByteArrayOutputStream();
	int nRead;
	byte[] data = new byte[16384];

	while ((nRead = is.read(data, 0, data.length)) != -1) {
	  buffer.write(data, 0, nRead);
	}
	return buffer.toByteArray();
}

}
