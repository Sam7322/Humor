import java.io.*;
import java.net.*;

public class WebCrawl {

	public static void main(String[] args) {
		String url = "https://www.reddit.com/r/cleanjokes";
		/*for(int instances=0;instances<10;instances++){
		url=nextPage(url,instances);
		System.out.println(url);
		}*/
		

//Testing the push settings with this comment
//final test commitpush to assure that this bullshit will be worth the waste of time.
		//whywhywhywhy is this so bs
		//why
		getContents(url);
	
		
		//	for (int i = 100; i <= 500; i += 100) {
			//String webpageHTML = getURL(url);
			//System.out.println(webpageHTML);

		//	String[] split = webpageHTML.split("view more:&#32;<a href=\"");
				//		for (int j = 1; j < split.length; j++) {
				//url = split[j].split("\" rel=\"nofollow next\" >")[0];
				//System.out.println(url);
				
			//	You could call another getURL at this point in order to load this URL
			// eg:
				// String webpageHTML2 = getURL(url);
				// System.out.println(webpageHTML2);
				
			//}
	
						

		}
	//}
	
	
	public static String nextPage(String url, int instances){
			String webpageHTML = getURL(url);
			
			if(instances==0){
				String[] split = webpageHTML.split("view more:&#32;<a href=\"");
			for (int j = 1; j < split.length; j++) {
	url = split[j].split("\" rel=\"nofollow next\" >")[0];
			}
			
			}else{
				String[] split = webpageHTML.split("prev</a><span class=\"separator\"></span><a href=\"");
				for (int j = 1; j < split.length; j++) {
		url = split[j].split("\" rel=\"nofollow next\" >")[0];
			}		
		}	
		return url;
	}

	public static void getContents(String url){
		String webpageHTML = getURL(url);
		
		String[] split = webpageHTML.split("data-url=\"");
		for (int j = 1; j < split.length; j++) {
url = split[j].split("\" data-domain=\"self.cleanjokes\" data-rank=\"1\" ><p class=\"parent\"></p><span class=\"rank\">1</span>")[0];
		}
		System.out.println(url);
	}
	
	public static String getURL(String url2) {
		try {
			Thread.sleep(2000);
		} catch (Exception e) {
			System.out.println(e);
		}
		String str = "";
		try {
			URL url = new URL(url2);
			URLConnection con = url.openConnection();
			Reader r = new InputStreamReader(con.getInputStream(), "UTF-8");
			StringBuilder buf = new StringBuilder();
			while (true) {
				int ch = r.read();
				if (ch < 0)
					break;
				buf.append((char) ch);
			}

			str = buf.toString();

		} catch (Exception e) {
			System.out.println(e);
		}

		return str;
	}

}
