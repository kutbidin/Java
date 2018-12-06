package test;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {

public static StringBuilder logMessage;
	// opens the designated log file and adds new log
public Logger() {
	logMessage=new StringBuilder();
}
	public static void Log(String s) {
		try {
			SimpleDateFormat ft = new SimpleDateFormat("yyyyMMdd");
			String fileSeparator = System.getProperty("file.separator");
			String logname;
			Date d = new Date();
			logname = "APP_" + ft.format(d) + ".log";

			String logFile = "logs" + fileSeparator + logname;
			File logg=new File(logFile);
			if(!logg.exists())logg.createNewFile();
			FileOutputStream fos = new FileOutputStream(logFile);
			fos.write(s.getBytes());
			fos.flush();
			fos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
