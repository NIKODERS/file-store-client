package nikheel.rh.fsc.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import nikheel.rh.fsc.exception.FSCRuntimeException;

public class ChecksumCalculator {

	public static String calculateChecksum(byte[] data) {
		try {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(data);
			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				hexString.append(Integer.toHexString(0xff & b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException e) {
			throw new FSCRuntimeException("Error calculating checksum", e);
		}
	}

	public static String calculateChecksum(File file) {
		try (FileInputStream fis = new FileInputStream(file)) {
			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] byteArray = new byte[1024];
			int bytesCount;
			while ((bytesCount = fis.read(byteArray)) != -1) {
				digest.update(byteArray, 0, bytesCount);
			}
			byte[] hash = digest.digest();
			StringBuilder hexString = new StringBuilder();
			for (byte b : hash) {
				hexString.append(Integer.toHexString(0xff & b));
			}
			return hexString.toString();
		} catch (NoSuchAlgorithmException | IOException e) {
			throw new FSCRuntimeException("Error calculating checksum", e);
		}
	}

	public static String calculateChecksum(String filename) throws IOException, NoSuchAlgorithmException {
		MessageDigest digest = MessageDigest.getInstance("SHA-256");
		byte[] fileBytes = Files.readAllBytes(new File(filename).toPath());
		byte[] hashBytes = digest.digest(fileBytes);
		StringBuilder sb = new StringBuilder();
		for (byte b : hashBytes) {
			sb.append(String.format("%02x", b));
		}
		return sb.toString();
	}
}
