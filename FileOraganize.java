import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.StringTokenizer;
import java.util.*;

public class FileOraganize {
	public static void size(Gui guiFrame) throws IOException {
		String address = guiFrame.address();
		File folder = new File(address);
		File files[] = folder.listFiles();
		File sizeMFolder = new File("C:\\SizeFileOraganize\\MegaByte");
		File sizeKFolder = new File("C:\\SizeFileOraganize\\KiloByte");
		File sizeBFolder = new File("C:\\SizeFileOraganize\\Byte");
			
		for(int i=0; i<files.length; i++) {
			if(files[i].length()>=1048576) {//바이트 비교해서 메가 바이트 단위로 비교
				boolean directoryCreated = sizeMFolder.mkdirs();
				File newFile = new File(sizeMFolder,files[i].getName());
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(files[i].length()>=1024) {//바이트 비교해서 킬로 바이트 단위로 비교
				boolean directoryCreated = sizeKFolder.mkdirs();
				File newFile = new File(sizeKFolder,files[i].getName());
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			if(files[i].length()<1024) {//바이트 비교해서 바이트 단위로 비교
				boolean directoryCreated = sizeBFolder.mkdirs();
				File newFile = new File(sizeBFolder,files[i].getName());
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
		}
	}
	public static void importance(Gui guiFrame) throws IOException {
		String address = guiFrame.address();
		File folder = new File(address);
		File files[] = folder.listFiles();

		File import1Folder = new File("C:\\ImportanceFileOraganize\\1");
		File import2Folder = new File("C:\\ImportanceFileOraganize\\2");
		File import3Folder = new File("C:\\ImportanceFileOraganize\\3");
		File import4Folder = new File("C:\\ImportanceFileOraganize\\4");
		File import5Folder = new File("C:\\ImportanceFileOraganize\\5");
		File import6Folder = new File("C:\\ImportanceFileOraganize\\6");
		File importfFolder = new File("C:\\ImportanceFileOraganize\\Final");
		File importOFolder = new File("C:\\ImportanceFileOraganize\\Original");
		
		for(int i=0; i<files.length; i++) {
			
			if(files[i].isDirectory() == true) {
				continue;	//폴더인지 구분해서 차단하기
			}
			
			String fileName = files[i].getName();
			if(!fileName.contains("[") && !fileName.contains("(") && !fileName.contains("_")) {
				boolean directoryCreated = importOFolder.mkdirs();
				File newFile = new File(importOFolder,fileName);
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
				continue;
			}
			
			StringTokenizer st = new StringTokenizer(fileName,"[/(/_");
			List<String> tokens = new ArrayList<String>();
			while(st.hasMoreTokens()) {
				tokens.add(st.nextToken());
			}
			int lt = tokens.size() -1;
			String ip = tokens.get(lt);
			String io = tokens.get(tokens.size()-2);

			if (!ip.contains("1") && !ip.contains("2") && !ip.contains("3") && !ip.contains("4") && !ip.contains("5") && !ip.contains("6") && !ip.contains("Final")) {
				if(io.contains("1") || io.contains("2") || io.contains("3") || io.contains("4") || io.contains("5") || io.contains("6") || io.contains("Final")) {
					ip = io;
				}
			}

			if(ip.contains("1")) {
				boolean directoryCreated = import1Folder.mkdirs();
				File newFile = new File(import1Folder,fileName);
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(ip.contains("2")) {
				boolean directoryCreated = import2Folder.mkdirs();
				File newFile = new File(import2Folder,fileName);
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(ip.contains("3")) {
				boolean directoryCreated = import3Folder.mkdirs();
				File newFile = new File(import3Folder,fileName);
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(ip.contains("4")) {
				boolean directoryCreated = import4Folder.mkdirs();
				File newFile = new File(import4Folder,fileName);
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(ip.contains("5")) {
				boolean directoryCreated = import5Folder.mkdirs();
				File newFile = new File(import5Folder,fileName);
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(ip.contains("6")) {
				boolean directoryCreated = import6Folder.mkdirs();
				File newFile = new File(import6Folder,fileName);
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			else if(ip.contains("Final")) {
				boolean directoryCreated = importfFolder.mkdirs();
				File newFile = new File(importfFolder,fileName);
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
			
			else {
				boolean directoryCreated = importOFolder.mkdirs();
				File newFile = new File(importOFolder,fileName);
				try {
					files[i].renameTo(newFile);
				} catch(Exception e) {
					e.printStackTrace();
				}
			}
		}
	}
}
