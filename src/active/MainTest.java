package active;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.net.UnknownHostException;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.SearchDao;
import ui.ProgressBar;
import util.DbUtil;


public class MainTest {
	
	public static List getSuspiciousRecordSet() throws Exception {
	// TODO Auto-generated method stub
	DbUtil dbUtil = new DbUtil();
	List list = new ArrayList();  
	ResultSet rs=SearchDao.Search(dbUtil.getCon(), "0", "urlblack");
    while (rs.next()) {  
    	 String url= rs.getString("url");
          list.add(url);
    }
    return list;
}

	
	
	public static void main(String[] args) {
		 ProgressBar app=new ProgressBar();
		 //System.exit(0);
//		DownLoadImg img = new DownLoadImg();
//		DownLoadHTML html = new DownLoadHTML();
//		try {
//			List list=getSuspiciousRecordSet();
//			for(int i=0;i<list.size();i++)
//			{
//				String startUrl=list.get(i).toString();
//				img.start(startUrl);
//			    html.start(startUrl);
//			 }
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	
		
//		String htmlurl="http://www.baidu.com/";
//		URL url;
//		String temp;
//		StringBuffer sb = new StringBuffer();
//		try {
//		url = new URL(htmlurl);
//		
//		URLConnection connection = url.openConnection();
//		connection.setConnectTimeout(10);
//		connection.setReadTimeout(10);
//		BufferedReader in = new BufferedReader(new InputStreamReader(
//				url.openStream(), "utf-8"));// 读取网页内容
//		while ((temp = in.readLine()) != null ) {
//			// System.out.println("while in getonehtml1 for loop");
//			sb.append(temp);
//			sb.append("\r\n");
//		}
//		in.close();
//		System.out.println( sb.toString());
//		} catch (Exception e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
	}

}
