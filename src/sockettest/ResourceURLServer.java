package sockettest;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

import util.GetUrlDownload;

/**
 * * java访问URL并下载文件 *
 * 
 * @author 13盒子
 * */
public class ResourceURLServer implements Runnable {
	public static void getURLResource(String ourputFile, String urlStr)
			throws Exception {

		FileWriter fw = new FileWriter(ourputFile);
		PrintWriter pw = new PrintWriter(fw);
		URL url = new URL(urlStr);    
        HttpURLConnection conn = (HttpURLConnection)url.openConnection();    
        //设置超时间为3秒  
        conn.setConnectTimeout(3*1000);  
        //防止屏蔽程序抓取而返回403错误  
        conn.setRequestProperty("User-Agent", "Mozilla/4.0 (compatible; MSIE 5.0; Windows NT; DigExt)");
        InputStream content = conn.getInputStream();
		BufferedReader in = new BufferedReader(new InputStreamReader(content));
		String line;

		while ((line = in.readLine()) != null) {
			pw.println(line);
		}
		pw.close();
		fw.close();
	}

	public void run() {
		try {
			System.out.println("begin");
			//getURLResource("test.csv","http://data.phishtank.com/data/c37346148e2efb10d429f24fa6bc67de3569bf3f9808937d104545d2dcbf462f/online-valid.csv");
			System.out.println("end");
			//写个注释代码就长了
			GetUrlDownload w = new GetUrlDownload();
			//w.update();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}